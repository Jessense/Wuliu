import java.util.ArrayList;
import java.util.List;

public class DeliveryList {
	private List<Delivery> list;
	
	public DeliveryList(List<Delivery> list) {
//		list = new ArrayList<Delivery>();
	}
	
	public List<Solution> makeSolution(Request request, boolean urgent, boolean abundant, long[] time_start, int[] mx) {
		//	time_start 记录了该seller分别在两个供应商处大批量优惠的开始时间，mx记录了分别在两个供应商处大批量优惠的累积计重
		List<Solution> result = new ArrayList<Solution>();
		//TODO 给出解决方案列表
		for (int i = 0; i < list.size(); i++) {
			List<MatrixNDG> roadmaps = list.get(i).getRoadmaps();
			int[] distances = new int[roadmaps.size()];
			for (int j = 0; j < roadmaps.size(); j++) {
				distances[j] = roadmaps.get(i).dijkstra(request.getStart(), request.getDestination());
				int transpeed;
				int charge;
				if (roadmaps.get(i).getSize() == 1) //如果该供应商没有该类型交通工具
					break;
				else {
					for (int k = 0; k < list.get(i).getTransportations().size(); k ++) {
						if (list.get(i).getTransportations().get(i).getType() == j) {
							transpeed = list.get(i).getTransportations().get(i).getSpeed();
							charge = list.get(i).getTransportations().get(i).getCharge();
						}
					}					
				}
				int speed = distances[j]/transpeed; //预计送达时间
				int transportation_type = j; //路线图对应交通工具种类
				int weight = request.getWeight();
				int price; //再乘上距离再除以某个常数？
				if (weight <= list.get(i).getMx()) {
					price = weight * charge * list.get(i).getP0();
				} else {
					price = list.get(i).getMx() * charge * list.get(i).getP0() + (weight - list.get(i).getMx()) * charge * list.get(i).getPX(); 
				}
				
				
				
				int seller_id = request.getSeller_id();
				int delivery_id = list.get(i).getId();
				
				int type = 0;//TODO
				
				
				char start = request.getStart();
				char destination = request.getDestination();
				
				Solution tempSolution = new Solution(seller_id, delivery_id, transportation_type, speed, type, weight, price,start, destination);
				result.add(tempSolution);
			}

		}
		return result;
	}
	
	
	public void makeOrder(Order order) {
		//将订单对应的物流供应商的运力进行相应的减少
		for (int i = 0; i < list.size(); i ++) {
			if (order.getDelivery_id() == list.get(i).getId()) {
				for (int j = 0; j < list.get(i).getTransportations().size(); j ++) {
					if (order.getTransportation_id() == list.get(i).getTransportations().get(j).getId()) {
						list.get(i).getTransportations().get(j).reduceLoad(order.getWeight());
					}
				}
			}
		}
	}
	
	public List<Delivery> getList() {
		return list;
	}
	public void setList(List<Delivery> list) {
		this.list = list;
	}
	

}

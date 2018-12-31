import java.util.ArrayList;
import java.util.List;

public class DeliveryList {
	private List<Delivery> list;
	
	public DeliveryList(List<Delivery> list) {
//		list = new ArrayList<Delivery>();
	}
	
	public List<Solution> makeSolution(Request request) {
		List<Solution> result = new ArrayList<Solution>();
		//TODO 给出解决方案列表
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getRoadmap().hasRoad(request.getStart(), request.getDestination())) {
				int seller_id = request.getSeller_id();
				int delivery_id = list.get(i).getId();
				Transportation transportation = list.get(i).getTransportations().get(0);//TODO
				int transportation_id = transportation.getId();
				int min_distance = list.get(i).getRoadmap().dijkstra(request.getStart(), request.getDestination());
				int speed = min_distance/transportation.getSpeed();
				int type = 0;//TODO
				int weight = request.getWeight();
				int price = weight * transportation.getCharge();
				char start = request.getStart();
				char destination = request.getDestination();
				
				Solution tempSolution = new Solution(seller_id, delivery_id, transportation_id, speed, type, weight, price,start, destination);
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

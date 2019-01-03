import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class DeliveryList {
	private List<Delivery> list;
	
	public DeliveryList(List<Delivery> list) {
//		list = new ArrayList<Delivery>();
	}
	
	public List<Solution> makeSolution(Request request) {
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
				
				/*简单粗暴的加急策略，直接乘了个因子，不知道后续如何加急运输*/
				if (request.getUrgent()) {
					price *= list.get(i).getUrgent_price();
					speed *= list.get(i).getUrgent_speed();
				}
				

				/*粗暴的短期大批量优惠策略，复杂度为该供应商的订单数量的平方，可通过将已完成订单移出该订单列表来优化*/
				for (int k = 0; k < list.get(i).getOrders().size(); k ++) {
					Order tempOrder = list.get(i).getOrders().get(k);
					if (tempOrder.getSeller_id() == request.getSeller_id() && tempOrder.getFlag() != -1) {
						if (tempOrder.getFlag() == 0) {
							if ((new Date()).getTime() - tempOrder.getTime_start() < list.get(i).getDuration()) {
								int accum = 0;
								for (int m = k; m < list.get(i).getOrders().size(); m ++) {
									Order tempOrder2 = list.get(i).getOrders().get(m);
									if (tempOrder2.getSeller_id() == request.getSeller_id() && tempOrder2.getFlag() == 1) {
										accum += tempOrder2.getWeight();
										if (accum > list.get(i).getEnough())
											break;
									}
								}
								if (accum >= list.get(i).getEnough()) {
									price *= list.get(i).getDiscount();
								}
							} else {
								for (int m = k; m < list.get(i).getOrders().size(); m ++) {
									Order tempOrder2 = list.get(i).getOrders().get(m);
									if (tempOrder2.getSeller_id() == request.getSeller_id() && tempOrder2.getFlag() == 1) {
										tempOrder.setFlag(-1);
									}
								}								
							}
						}
					}
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

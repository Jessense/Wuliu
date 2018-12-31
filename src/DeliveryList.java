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

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
 
public class Seller {
	private String username;
	private String password;
	private int id;
	
	private List<Order> yourOrders;	// 对应加上每个订单order的提交时间
	
	public Seller(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public boolean login(List<Seller> L, String username, String password) {
		Seller value;
		for (int i = 0; i < L.size(); i++) {
			value = L.get(i);
			if(value.getUsername() == username && value.getPassword() == password) {
				return true;
			}
		}
		return false;
	}
	
	public void register() {
		
	}
	
	public void makeRequest(Logistics sys, int type, double weight, char start, char destination, boolean urgent) {
		Request newrequest = new Request(this.id, type, weight, start, destination, urgent);
		List<Solution> solutions = new ArrayList<Solution>();
		solutions = sys.makeSolution(newrequest);
		System.out.println("---------------------------------------");
		System.out.println(solutions.size());
		for (Solution solution: solutions) {
			System.out.println("---------------");
			System.out.println(solution.getStart());
			System.out.println(solution.getDestination());
			System.out.println(solution.getSeller_id());
			System.out.println(solution.getDelivery_id());
			System.out.println(solution.getTransportation_type());
			System.out.println(solution.getPrice());
			System.out.println(solution.getSpeed());
		}
		Order order = selectSolution(solutions);
		sys.makeOrder(order);
	}
	
	public Order selectSolution(List<Solution> solutions) {
		int choose = 0;
		Solution solution = solutions.get(choose);
		int delivery_id = solution.getDelivery_id();
		int transportation_type = solution.getTransportation_type();
		double speed = solution.getSpeed();
		int status = 0;
		int type = solution.getType();
		double weight = solution.getWeight();
		double price = solution.getPrice();
		char start = solution.getStart();
		char destination = solution.getDestination();
		Boolean urgent = solution.getUrgent();
		Order order = new Order(this.id, delivery_id, transportation_type, speed,status, type, weight, price, start, destination, urgent);
		//TODO 进行选择
		return order;
	}
	public char getCurpostion(Order order, Logistics logistics) {
		char curposition;
		int delivery_id = order.getDelivery_id();
		for (int i = 0; i < logistics.getDelivers().size(); i++) {
			if(delivery_id == logistics.getDelivers().get(i).getId()) {
				int index = logistics.getDelivers().get(i).getOrders().indexOf(order);
				curposition = logistics.getDelivers().get(i).getOrders().get(index).getCurposition();
				return curposition;
			}
		}
		curposition = ' ';
		return curposition;
	}
	public int getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getUsername() {
		return username;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}

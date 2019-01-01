import java.util.ArrayList;
import java.util.List;
 
public class Seller {
	private String username;
	private String password;
	private int id;
	private boolean abundant ;	//	是否大批量
	private long [] time_start = new long[2];	//大批量计时开始时间，0表示顺丰，1表示中通
	final long wait = 7200000;	//7200000ms = 7200s = 2小时，短期大批量优惠持续时间
	private int [] mx = new int[2];		//大批量累积计重
	
	private List<Order> yourOrders;	//	对应加上每个订单order的提交时间
	
	public Seller(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public boolean login(SellerList L, String username, String password) {
		Seller value;
		for (int i = 0; i < L.getList().size(); i++) {
			value = L.getList().get(i);
			if(value.getUsername() == username && value.getPassword() == password) {
				return true;
			}
		}
		return false;
	}
	
	public void register() {
		
	}
	
	public void makeRequest(DeliveryList list, int type, int weight, char start, char destination, boolean urgent, boolean abundant) {
		Request newrequest = new Request(this.id, type, weight, start, destination);
		List<Solution> solutions = new ArrayList<Solution>();
		solutions = list.makeSolution(newrequest, urgent, this.time_start, this.mx);
		Order order = selectSolution(solutions);
		list.makeOrder(order);
	}
	
	public Order selectSolution(List<Solution> solutions) {
		int choose = 0;
		Solution solution = solutions.get(choose);
		int delivery_id = solution.getDelivery_id();
		int transportation_type = solution.getTransportation_type();
		int status = 0;
		int type = solution.getType();
		int weight = solution.getWeight();
		int price = solution.getPrice();
		char start = solution.getStart();
		char destination = solution.getDestination();
		long generatetime = solution.getGeneratetime();
		Order order = new Order(this.id, delivery_id, transportation_type, status, type, weight, price, start, destination, generatetime);
		//TODO 进行选择
		return order;
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
	public boolean geturgent() {
		return this.urgent;
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

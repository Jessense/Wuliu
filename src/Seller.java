import java.util.ArrayList;
import java.util.List;

public class Seller {
	private String username;
	private String password;
	private int id;
	
	public Seller(String username, String password) {
		
	}
	
	public void login() {
		
	}
	
	public void register() {
		
	}
	
	public void makeRequest(DeliveryList list, Request request) {
		List<Solution> solutions = new ArrayList<Solution>();
		solutions = list.makeSolution(request);
		Order order = selectSolution(solutions);
		list.makeOrder(order);
	}
	
	public Order selectSolution(List<Solution> solutions) {
		Order order = new Order();
		//TODO ½øÐÐÑ¡Ôñ
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

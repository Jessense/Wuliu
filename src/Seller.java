import java.util.ArrayList;
import java.util.List;

public class Seller {
	private String username;
	private String password;
	private int id;
	
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

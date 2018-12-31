import java.util.List;

public class Delivery {
	private int id;
 	private String username;
	private String password;
	private List<Transportation> transportations;
 	private MatrixNDG roadmap; //先只考虑type=0的交通工具的路线图；如果考虑其他交通工具，则一种交通工具对应一个roadmap
	
	public Delivery(String username, String password, List<Transportation> transportations, MatrixNDG roadmap) {
		
	}
	
	public void login() {
		
	}
	
	public void register() {
		
	}
	
	public void doOrder(Order order) {
		//TODO
		
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public List<Transportation> getTransportations() {
		return transportations;
	}
	public MatrixNDG getRoadmap() {
		return roadmap;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setTransportations(List<Transportation> transportations) {
		this.transportations = transportations;
	}
	public void setRoadmap(MatrixNDG roadmap) {
		this.roadmap = roadmap;
	}
}

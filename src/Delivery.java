import java.util.List;

import java.util.Iterator;  
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;

public class Delivery {
	private int id;
 	private String username;	//legal person name
	private String password;	
	private List<Transportation> transportations;
 	private List<MatrixNDG> roadmaps; //先只考虑type=0的交通工具的路线图；如果考虑其他交通工具，则一种交通工具对应一个roadmap
 	private int p0;		//	计费per kg
 	private int mx;		//	首重临界值
	
	private List<Order> orders; //该供应商的订单列表
 	private int urgent_price; //加急价格因子
 	private int urgent_speed; //加急速度因子
 	private int discount; //大批量折扣
 	private int enough; //大批量优惠需达到的累计重量
	private int duration; //大批量优惠时间窗口

 	
 	
	public Delivery(String username, String password, List<Transportation> transportations, MatrixNDG roadmap1, MatrixNDG roadmap2, MatrixNDG roadmap3, int p0, int mx) {
		this.username = username;
		this.password = password;
		this.transportations = transportations;
		this.roadmaps.add(roadmap1);
		this.roadmaps.add(roadmap2);
		this.roadmaps.add(roadmap3);
		this.p0 = p0;
		this.mx = mx;
	}
	
	public boolean login(DeliveryList L, String username, String password) {
		Delivery value;
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
	public int getMx() {
		return mx;
	}
	public int getP0() {
		return p0;
	}
	public MatrixNDG getRoadmap(int i) {	//	i表示想要查看的地图编号（车/火车/飞机）
		return roadmaps.get(i);
	}
	public int getUrgent_price() {
		return urgent_price;
	}
	public int getUrgent_speed() {
		return urgent_speed;
	}
	public int getDiscount() {
		return discount;
	}

	public int getDuration() {
		return duration;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public int getEnough() {
		return enough;
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
	public void setRoadmap(MatrixNDG roadmaps, int i) {	//	i表示想要改变的地图编号（车/火车/飞机）
		this.roadmaps.set(i, roadmaps);
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMx(int mx) {
		this.mx = mx;
	}
	public void setP0(int p0) {
		this.p0 = p0;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public void setUrgent_price(int urgent_price) {
		this.urgent_price = urgent_price;
	}
	public void setUrgent_speed(int urgent_speed) {
		this.urgent_speed = urgent_speed;
	}
	public void setEnough(int enough) {
		this.enough = enough;
	}	
}

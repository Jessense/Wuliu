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
 	private List<MatrixNDG> roadmaps;
 	private double p0;
 	private double mx;
	
	private List<Order> orders;
 	private double urgent_price;
 	private double urgent_speed;
 	private double discount;
 	private double enough;
	private double duration;

 	
 	
	public Delivery(String username, String password, List<Transportation> transportations, MatrixNDG roadmap1, MatrixNDG roadmap2, 
			MatrixNDG roadmap3, double p0, double mx) {
		this.username = username;
		this.password = password;
		this.transportations = transportations;
		this.roadmaps = new ArrayList<MatrixNDG>();
		this.roadmaps.add(roadmap1);
		this.roadmaps.add(roadmap2);
		this.roadmaps.add(roadmap3);
		this.p0 = p0;
		this.mx = mx;
		this.orders = new ArrayList<Order>();
	}
	
	public boolean login(List<Delivery> L, String username, String password) {
		Delivery value;
		for (int i = 0; i < L.size(); i++) {
			value = L.get(i);
			if(value.getUsername() == username && value.getPassword() == password) {
				return true;
			}
		}
		return false;
	}
	
	public Boolean register(String legalname, String ID, Delivery delivery) {
        //appcode查看地址 https://market.console.aliyun.com/imageconsole/
		String appcode = "假装有appcode";
		String url="http://1.api.apistore.cn/idcard";
		String realName = "无名氏";
		String cardNo = "360103198907277757";//瞎输的身份证号码 
		String param="realName="+realName+"&cardNo="+cardNo;


		String returnStr=aliyun.requestGet(url, param, appcode);
		System.out.println(returnStr);
		if(returnStr.substring(14, 15) == "0")
			return true;
		return false;
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
	public double getMx() {
		return mx;
	}
	public double getP0() {
		return p0;
	}

	public List<MatrixNDG> getRoadmaps() {
		return roadmaps;
	}

	public MatrixNDG getRoadmap(int i) {	
		return roadmaps.get(i);
	}
	public double getUrgent_price() {
		return urgent_price;
	}
	public double getUrgent_speed() {
		return urgent_speed;
	}
	public double getDiscount() {
		return discount;
	}

	public double getDuration() {
		return duration;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public double getEnough() {
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

	public void setRoadmaps(List<MatrixNDG> roadmaps) {
		this.roadmaps = roadmaps;
	}

	public void setRoadmap(MatrixNDG roadmaps, int i) {	//	i??????????????????/??/?????
		this.roadmaps.set(i, roadmaps);
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMx(double mx) {
		this.mx = mx;
	}
	public void setP0(double p0) {
		this.p0 = p0;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public void setUrgent_price(double urgent_price) {
		this.urgent_price = urgent_price;
	}
	public void setUrgent_speed(double urgent_speed) {
		this.urgent_speed = urgent_speed;
	}
	public void setEnough(double enough) {
		this.enough = enough;
	}	
}

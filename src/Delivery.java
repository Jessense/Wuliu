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
 	private int p0;		//	首重计费
 	private int px;		//	续重计费
 	private int mx;		//	首重临界值
 	
 	
	public Delivery(String username, String password, List<Transportation> transportations, MatrixNDG roadmap1, MatrixNDG roadmap2, MatrixNDG roadmap3, int p0, int px, int mx) {
		this.username = username;
		this.password = password;
		this.transportations = transportations;
		this.roadmaps.add(roadmap1);
		this.roadmaps.add(roadmap2);
		this.roadmaps.add(roadmap3);
		this.p0 = p0;
		this.px = px;
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
	public int getPx() {
		return px;
	}
	public MatrixNDG getRoadmap(int i) {	//	i表示想要查看的地图编号（车/火车/飞机）
		return roadmaps.get(i);
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
	public void setPx(int px) {
		this.px = px;
	}
}

public class Solution extends Request{	
	private int delivery_id;
	private double price;
	private int transportation_type;
	private double speed; //预计运输速度
	
	public Solution(int seller_id, int delivery_id, int transportation_type, double speed, int type, double weight, double price, char start, char destination, Boolean urgent) {
		// TODO Auto-generated constructor stub
		super(seller_id, type, weight, start, destination, urgent);
	}
	public double getSpeed() {
		return speed;
	}
	public int getTransportation_type() {
		return transportation_type;
	}
	public double getPrice() {
		return price;
	}
	public int getDelivery_id() {		
		return delivery_id;			
	}
	public void setDelivery_id(int delivery_id) {		
		this.delivery_id = delivery_id;			
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setTransportation_type(int transportation_type) {
		this.transportation_type = transportation_type;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}

public class Solution extends Request{	
	private int delivery_id;
	private double price;
	private int transportation_type;
	private int speed; //预计运输速度
	
	public Solution(int seller_id, int delivery_id, int transportation_type, int speed, int type, int weight, int price, char start, char destination) {
		// TODO Auto-generated constructor stub
		super(seller_id, type, weight, start, destination);
	}
	public int getSpeed() {
		return speed;
	}
	public int gettransportation_type() {
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
	public void settransportation_type(int transportation_type) {
		this.transportation_type = transportation_type;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}

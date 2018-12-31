public class Solution {
	private int seller_id;
	private int delivery_id;
	private int transportation_id;
	private int speed; //预计运输速度
	private int type; //货物种类
	private int weight;
	private int price;
	private char start;
	private char destination;
	
	public Solution(int seller_id, int delivery_id, int transportation_id, int speed, int type, int weight, int price, char start, char destination) {
		// TODO Auto-generated constructor stub
	}
	public int getDelivery_id() {
		return delivery_id;
	}
	public int getSeller_id() {
		return seller_id;
	}
	public int getSpeed() {
		return speed;
	}
	public int getTransportation_id() {
		return transportation_id;
	}
	public int getType() {
		return type;
	}
	public int getWeight() {
		return weight;
	}
	public int getPrice() {
		return price;
	}
	public char getStart() {
		return start;
	}
	public char getDestination() {
		return destination;
	}
	public void setDelivery_id(int delivery_id) {
		this.delivery_id = delivery_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setTransportation_id(int transportation_id) {
		this.transportation_id = transportation_id;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void setStart(char start) {
		this.start = start;
	}
	public void setDestination(char destination) {
		this.destination = destination;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}

public class Request {
	private int order_id;
	private int seller_id;
	private int type; //货物种类
	private int weight;
	private char start;
	private char destination;
	
	public Request(int order_id, int seller_id, int type, int weight, int start, int destination) {
		// TODO Auto-generated constructor stub
	}
	public int getOrder_id() {
		return order_id;
	}
	public int getSeller_id() {
		return seller_id;
	}
	public int getType() {
		return type;
	}
	public int getWeight() {
		return weight;
	}
	public char getStart() {
		return start;
	}
	public char getDestination() {
		return destination;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
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
	
}

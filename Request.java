import java.util.Date;

public class Request {
	private int seller_id;
	private int type; //货物种类
	private double weight;
	private char start;
	private char destination;
	private Boolean urgent;
	
	public Request(int seller_id, int type, double weight, char start, char destination, Boolean urgent) {
		// TODO Auto-generated constructor stub
		this.seller_id = seller_id;
		this.type = type;
		this.weight = weight;
		this.start = start;
		this.destination = destination;
		this.urgent = urgent;
	}
	public int getSeller_id() {
		return seller_id;
	}
	public int getType() {
		return type;
	}
	public double getWeight() {
		return weight;
	}
	public char getStart() {
		return start;
	}
	public char getDestination() {
		return destination;
	}

	public Boolean getUrgent() {
		return urgent;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public void setStart(char start) {
		this.start = start;
	}
	public void setDestination(char destination) {
		this.destination = destination;
	}

	public void setUrgent(Boolean urgent) {
		this.urgent = urgent;
	}
}

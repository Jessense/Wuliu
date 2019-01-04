import java.util.Date;

public class Request {
	private int seller_id;
	private int type; //货物种类
	private double weight;
	private char start;
	private char destination;
	private long generatetime;
	private Date time;
	
	public Request(int seller_id, int type, double weight, char start, char destination) {
		// TODO Auto-generated constructor stub
		this.seller_id = seller_id;
		this.type = type;
		this.weight = weight;
		this.start = start;
		this.destination = destination;
		this.generatetime = time.getTime();
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
	public long getGeneratetime() {
		return generatetime;
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
	
}

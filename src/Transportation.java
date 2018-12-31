
public class Transportation {
	private int id;
	private int type;
	private int load;
	private int speed;
	private int charge;
	public Transportation(int type, int load, int speed, int charge) {
		// TODO Auto-generated constructor stub
	}
	public void reduceLoad(int load) {
		this.load -= load;
	}
	public int getCharge() {
		return charge;
	}
	public int getId() {
		return id;
	}
	public int getLoad() {
		return load;
	}
	public int getSpeed() {
		return speed;
	}
	public int getType() {
		return type;
	}
	public void setCharge(int charge) {
		this.charge = charge;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setLoad(int load) {
		this.load = load;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}

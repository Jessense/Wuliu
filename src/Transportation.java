
public class Transportation {
	private int id;
	private int type;
	private int MAX_LOAD;
	private int load;
	private int speed;
	private int charge;

	public Transportation(int type, int max, int speed, int charge, int load) {
		// TODO Auto-generated constructor stub
		this.type = type;
		this.load = load;
		this.speed = speed;
		this.charge = charge;
		this.MAX_LOAD = max;
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
	public boolean addLoad(int load) {
		if(this.load + load < MAX_LOAD) {
			this.load += load;
			return true;
		}
		return false;
	}
	public boolean subLoad(int load) {
		if(this.load - load > 0) {
			this.load -= load;
			return true;
		}
		return false;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	
}

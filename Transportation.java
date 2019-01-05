
public class Transportation {
	private int id;
	private int type;
	private double MAX_LOAD;
	private double load;
	private double speed;
	private double charge;

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
	public double getCharge() {
		return charge;
	}
	public int getId() {
		return id;
	}
	public double getLoad() {
		return load;
	}
	public double getSpeed() {
		return speed;
	}
	public int getType() {
		return type;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}
	public boolean addLoad(double load) {
		if(this.load + load < MAX_LOAD) {
			this.load += load;
			return true;
		}
		return false;
	}
	public boolean subLoad(double load) {
		if(this.load - load > 0) {
			this.load -= load;
			return true;
		}
		return false;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	
}

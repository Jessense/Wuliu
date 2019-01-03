public class Order {
	private int order_id;
	private int seller_id;
	private int delivery_id;
	private int transportation_type;
	private int status; //订单状态，0: made, 1: transferring, 2: finished
	private int type; //货物种类
	private int weight;
	private int price;
	private char start;
	private char destination;
	private long generatetime;	//	订单提交时间
	
	/*计时起点：0；计时起点之后、大批量优惠区间内：1；大批量优惠区间外：-1。
	 * 卖家确认第一个订单时，设为0；之后确认订单时，若前一个订单flag=-1，则该订单flag设为0，否则flag设为1。
	 * 每提交一次Request，检查订单列表，如果flag=0的订单到现在的时间小于短期大批量窗口且达到累计重量，则该Request进行优惠；
	 * 如果flag=1的订单到现在的时间大于短期大批量窗口，则将之前全部订单flag置为-1。
	 *
	 */
	private int flag; 
	
	public Order(int seller_id, int delivery_id, int transportation_type, int status, int type, int weight, int price, char start, char destination, long generatetime) {
		// TODO Auto-generated constructor stub
		this.order_id = /*something*/;
		this.seller_id = seller_id;
		this.delivery_id = delivery_id;
		this.transportation_type = transportation_type;
		this.status = status;
		this.type = type;
		this.weight = weight;
		this.price = price;
		this.start = start;
		this.destination = destination;
		this.generatetime = generatetime;
	}
	
	public int getDelivery_id() {
		return delivery_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public int getPrice() {
		return price;
	}
	public int getSeller_id() {
		return seller_id;
	}
	public int getStatus() {
		return status;
	}
	public int getTransportation_id() {
		return transportation_type;
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
	public long getGeneratetime() {
		return generatetime;
	}
	public int getFlag() {
		return flag;
	}	
	public void setDelivery_id(int delivery_id) {
		this.delivery_id = delivery_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setTransportation_id(int transportation_type) {
		this.transportation_type = transportation_type;
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
	public void setFlag(int flag) {
		this.flag = flag;
	}	
}

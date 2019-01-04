import java.util.Date;

public class Order extends Solution{
	private int order_id;
	private int transportation_id;
	private int status; //订单状态，0: made, 1: transferring, 2: finished
	private int generatetime;
	private int delivery_id;
	
	/*计时起点：0；计时起点之后、大批量优惠区间内：1；大批量优惠区间外：-1。
	 * 卖家确认第一个订单时，设为0；之后确认订单时，若前一个订单flag=-1，则该订单flag设为0，否则flag设为1。
	 * 每提交一次Request，检查订单列表，如果flag=0的订单到现在的时间小于短期大批量窗口且达到累计重量，则该Request进行优惠；
	 * 如果flag=1的订单到现在的时间大于短期大批量窗口，则将之前全部订单flag置为-1。
	 *
	 */
	private int flag; 
	
	
	public Order(int seller_id, int transportation_type, int speed,int transportation_id, int status, int type, int weight, int price, char start, char destination) {
		// TODO Auto-generated constructor stub
		super(seller_id, transportation_type, speed, type, weight, price, start, destination);
		
	}
	
	public int getOrder_id() {
		return order_id;
	}
	public int getStatus() {
		return status;
	}
	public int getTransportation_id() {
		return transportation_id;
	}
	public int getGeneratetime() {
		return generatetime;
	}
	public int getFlag() {
		return flag;
	}
	public int getDelivery_id() {
		return delivery_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setTransportation_id(int transportation_id) {
		this.transportation_id = transportation_id;
	}
	public void setGeneratetime(int generatetime) {
		this.generatetime = generatetime;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public void setDelivery_id(int delivery_id) {
		this.delivery_id = delivery_id;
	}

}

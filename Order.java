import java.util.Date;

public class Order extends Solution{
	private int order_id;
	private int transportation_id;
	private int status; //����״̬��0: made, 1: transferring, 2: finished
	private long generatetime;
	private char curposition;
	
	/*��ʱ��㣺0����ʱ���֮�󡢴������Ż������ڣ�1���������Ż������⣺-1��
	 * ����ȷ�ϵ�һ������ʱ����Ϊ0��֮��ȷ�϶���ʱ����ǰһ������flag=-1����ö���flag��Ϊ0������flag��Ϊ1��
	 * ÿ�ύһ��Request����鶩���б����flag=0�Ķ��������ڵ�ʱ��С�ڶ��ڴ����������Ҵﵽ�ۼ����������Request�����Żݣ�
	 * ���flag=1�Ķ��������ڵ�ʱ����ڶ��ڴ��������ڣ���֮ǰȫ������flag��Ϊ-1��
	 *
	 */
	private int flag; 
	
	
	public Order(int seller_id, int delivery_id, int transportation_type, double speed, int status, int type, double weight, double price, char start, char destination, Boolean urgent) {
		// TODO Auto-generated constructor stub
		super(seller_id, delivery_id, transportation_type, speed, type, weight, price, start, destination, urgent);
		curposition = start;
		generatetime = (new Date()).getTime();
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
	public long getGeneratetime() {
		return generatetime;
	}
	public int getFlag() {
		return flag;
	}
	public char getCurposition() {
		return curposition;
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
	public void setGeneratetime(long generatetime) {
		this.generatetime = generatetime;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public void setCurposition(char curposition) {
		this.curposition = curposition;
	}
}

import src.String;

public class Test {
	public static void main(String[] args) {
		System.out.println("Hello");
	}
{//卖家信息：
	 //public Seller(String username, String password) 卖家
	 //public SellerList(List<Seller> list) 卖家列表
		String name1 = "seller1";
		String name2 = "seller2";
		String name3 = "seller3";
		String name4 = "seller4";
		String name5 = "seller5";
		String pw1 = "123one";
		String pw2 = "123two";
		String pw3 = "123three";
		String pw4 = "123four";
		String pw5 = "123five";
		//卖家还有一个id的属性但是构造函数里没体现出来，如果要加入参数的话就是注释里那些句子
		Seller seller1 = new Seller(name1, pw1);
		//Seller seller1 = new Seller(name1, pw1, 1); //1是id
		Seller seller2 = new Seller(name2, pw2);
		//Seller seller2 = new Seller(name2, pw2, 2);
		Seller seller3 = new Seller(name3, pw3);
		//Seller seller3 = new Seller(name3, pw3, 3);
		Seller seller4 = new Seller(name4, pw4);
		//Seller seller4 = new Seller(name4, pw4, 4);
		Seller seller5 = new Seller(name5, pw5); 
		//Seller seller5 = new Seller(name5, pw5, 5);
		List<Seller> slist = new ArrayList<Seller>();
		slist.add(seller1);
		slist.add(seller2);
		slist.add(seller3);
		slist.add(seller4);
		slist.add(seller5);
		SellerList sellerList = new SellerList(slist); //卖家列表
	}
	
	{//交通工具信息：
	 //public Transportation(int type, int load, int speed, int charge) 交通工具
		int truck = 1;
		int train = 2;
		int plane = 3; //工具种类
		int loadZT1 = 5000; //ZT:中通    1：汽车
		int loadZT2 = 100000; // 2：火车
		int loadZT3 = 15000; //3：飞机    
		int loadSF1 = 6000; //SF: 顺丰
		int loadSF2 = 90000;
		int loadSF3 = 16000;
		int speedZT1 = 50;
		int speedZT2 = 80;
		int speedZT3 = 1000;
		int speedSF1 = 60; 
		int speedSF2 = 100;
		int speedSF3 = 1200;
		int chargeZT1 = 5; //中通货车方式收费
		int chargeZT2 = 8;
		int chargeZT3 = 100;
		int chargeSF1 = 6; //顺丰货车方式收费
		int chargeSF2 = 10;
		int chargeSF3 = 120;		
		
		List<Transportation> transZT = new ArrayList<Transportation>();
		List<Transportation> transSF = new ArrayList<Transportation>();
		for(int i = 0; i < 10; i++)
			transZT.add(new Transportation(truck, loadZT1, speedZT1, chargeZT1));
			//transZT.add(new Transportation(i, truck, loadZT1, speedZT1, chargeZT1)); //加的那个i参数就是车号。。。我看构造函数里没这个标号
		for(int i = 0; i < 5; i++)
			transZT.add(new Transportation(train, loadZT2, speedZT2, chargeZT2));
		for(int i = 0; i < 3; i++)
			transZT.add(new Transportation(plane, loadZT3, speedZT3, chargeZT3));
		for(int i = 0; i < 10; i++)
			transSF.add(new Transportation(truck, loadSF1, speedSF1, chargeSF1));
			//transZT.add(new Transportation(i, truck, loadZT1, speedZT1, chargeZT1)); //加的那个i参数就是车号。。。我看构造函数里没这个标号
		for(int i = 0; i < 5; i++)
			transSF.add(new Transportation(train, loadSF2, speedSF2, chargeSF2));
		for(int i = 0; i < 3; i++)
			transSF.add(new Transportation(plane, loadSF3, speedSF3, chargeSF3));
		
		
 	}
	
	{//地图信息：
	 //。。。。	
	}
	
	{//供应商信息：
	 //供应商信息：int id;
	 //			  String username;
	 //			  String password;
	 //			  List<Transportation> transportations;
	 //			  MatrixNDG roadmap; //如果考虑交通工具的种类，则一种交通工具对应一个roadmap
     //设计上只放两家供应商：顺丰、中通	
	 //public Delivery(String username, String password, List<Transportation> transportations, MatrixNDG roadmap)交通工具
	 //public DeliveryList(List<Delivery> list) 供应商列表
		String SF = "ShunFeng";
		String ZT = "ZhongTong";
		String SFpw = "SF123";
		String ZTpw = "ZT123";
		List<Delivery> dl = new ArrayList<Delivery>();
		dl.add(new Delivery(SF, SFpw, transSF, roadmapSF)); //roadmapSF待设定
		dl.add(new Delivery(ZT, ZTpw, transZT, roadmapZT)); //roadmapZT待设定
		DeliveryList deliverylist = new DeliveryList(dl); //供应商列表
	}
	
	while(true){
		//信息发生器
		//public Order(int seller_id, int delivery_id, int transportation_id, int status, int type, int weight, int price) 订单
		//public Request(int order_id, int seller_id, int type, int weight) 
		final double d = Math.random(); //生成随机数（0-1的double值）
		final int i = (int)(d*1000); //转化成秒数
		Thread.sleep(i);暂停线程
		final double dd = Math.random();
		final int ii = (int)(dd*5); //随机选一个卖家发请求
		sellerList[ii].
	}
}

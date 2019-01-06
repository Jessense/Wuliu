import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		System.out.println("Hello");
/*********************************************************/
		//public Seller(String username, String password)
		//public SellerList(List<Seller> list)
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
		Seller seller1 = new Seller(name1, pw1);
		//Seller seller1 = new Seller(name1, pw1, 1); 
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
		/*********************************************************/

		//public Transportation(int type, int load, int speed, int charge)
		int truck = 1;
		int train = 2;
		int plane = 3;
		int loadZT1 = 5000;
		int loadZT2 = 100000;
		int loadZT3 = 15000;
		int loadSF1 = 6000;
		int loadSF2 = 90000;
		int loadSF3 = 16000;
		int speedZT1 = 50;
		int speedZT2 = 80;
		int speedZT3 = 1000;
		int speedSF1 = 60;
		int speedSF2 = 100;
		int speedSF3 = 1200;
		int chargeZT1 = 5;
		int chargeZT2 = 8;
		int chargeZT3 = 100;
		int chargeSF1 = 6;
		int chargeSF2 = 10;
		int chargeSF3 = 120;
		int p0SF = 3; //SF首重
		int pxSF = 5; //SF续重
		int mxSF = 2; //SF首重界限
		int p0ZT = 2;
		int pxZT = 4;
		int mxZT = 2;

		List<Transportation> transZT = new ArrayList<Transportation>();
		List<Transportation> transSF = new ArrayList<Transportation>();
		for (int i = 0; i < 10; i++)
			transZT.add(new Transportation(truck, loadZT1, speedZT1, chargeZT1, 0));
		//transZT.add(new Transportation(i, truck, loadZT1, speedZT1, chargeZT1));
		for (int i = 0; i < 5; i++)
			transZT.add(new Transportation(train, loadZT2, speedZT2, chargeZT2, 0));
		for (int i = 0; i < 3; i++)
			transZT.add(new Transportation(plane, loadZT3, speedZT3, chargeZT3, 0));
		for (int i = 0; i < 10; i++)
			transSF.add(new Transportation(truck, loadSF1, speedSF1, chargeSF1, 0));
		//transZT.add(new Transportation(i, truck, loadZT1, speedZT1, chargeZT1));
		for (int i = 0; i < 5; i++)
			transSF.add(new Transportation(train, loadSF2, speedSF2, chargeSF2, 0));
		for (int i = 0; i < 3; i++)
			transSF.add(new Transportation(plane, loadSF3, speedSF3, chargeSF3, 0));

		/*********************************************************/

		//初始化图
		char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'};
		char[][] edges = new char[][]{
				{'A', 'C'},
				{'A', 'D'},
				{'A', 'F'},
				{'B', 'C'},
				{'C', 'D'},
				{'E', 'G'},
				{'D', 'G'},
				{'I', 'J'},
				{'J', 'G'},};
		MatrixNDG roadmapSF1 = new MatrixNDG(vexs, edges);
		MatrixNDG roadmapSF2 = new MatrixNDG(vexs, edges);
		MatrixNDG roadmapSF3 = new MatrixNDG(vexs, edges);
		MatrixNDG roadmapZT1 = new MatrixNDG(vexs, edges);
		MatrixNDG roadmapZT2 = new MatrixNDG(vexs, edges);
		MatrixNDG roadmapZT3 = new MatrixNDG(vexs, edges);

		/*********************************************************/

		String SF = "ShunFeng";
		String ZT = "ZhongTong";
		String SFpw = "SF123";
		String ZTpw = "ZT123";
		List<Delivery> dl = new ArrayList<Delivery>();
		dl.add(new Delivery(SF, SFpw, transSF, roadmapSF1, roadmapSF2, roadmapSF3, p0SF, mxSF));
		dl.add(new Delivery(ZT, ZTpw, transZT, roadmapZT1, roadmapZT2, roadmapZT3, p0ZT, mxZT));
		Logistics system = new Logistics(dl, slist);

		/*********************************************************/

		for(int i = 0; i < 10; i++)
		{
			//public Order(int seller_id, int delivery_id, int transportation_id, int status, int type, int weight, int price) 璁㈠崟
			//public Request(int order_id, int seller_id, int type, int weight)
			final double d = Math.random();
			final int i = (int) (d * 1000);
			Thread.sleep(i);
			final double dd = Math.random();
			final int ii = (int) (dd * 5);
			sList[ii].makeRequest(sys, 0, dd*10, 'A', 'B", 0);
		}
		
	}
}

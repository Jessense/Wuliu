import java.util.ArrayList;
import java.util.List;

import com.sun.tools.classfile.Opcode.Set;

public class SellerList {
	List<Seller> list;
	
	public SellerList(List<Seller> list) {
//		list = new ArrayList<Seller>();
		
	}
	public List<Seller> getList() {
		return list;
	}
	public void setList(List<Seller> list) {
		this.list = list;
	}
}

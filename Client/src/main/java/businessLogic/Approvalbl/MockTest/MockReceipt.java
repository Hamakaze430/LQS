package businessLogic.Approvalbl.MockTest;

import businessLogic.Receiptsbl.Receiptsbl;
import businessLogic.Userbl.Userbl;

public class MockReceipt extends Receiptsbl {
	public MockReceipt(Userbl user) {
		super(user);
		// TODO Auto-generated constructor stub
	}
	public String getName(){
		return "南京市鼓楼营业厅寄件单";
	}
	public String getCreater(){
		return "张三";
	}

}

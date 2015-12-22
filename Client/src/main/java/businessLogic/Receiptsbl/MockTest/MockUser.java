package businessLogic.Receiptsbl.MockTest;

import businessLogic.Userbl.Userbl;

public class MockUser extends Userbl {
	public MockUser(String userID) {
		super(userID);
		// TODO Auto-generated constructor stub
	}
	public String getHallId(){
		return "025001";
	}
	public String getHallName(){
		return "南京市鼓楼营业厅";
	}
}

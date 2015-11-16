package businessLogic.Receiptsbl.MockTest;

import java.util.ArrayList;

import businessLogic.CarAndDriverbl.CarAndDriverbl;
import vo.CarVO;

public class MockCarAndDriver extends CarAndDriverbl{
	
	public ArrayList<String> findAllCarInfo(String hallId){
		
		ArrayList<String> list = new ArrayList<String>();
		String s = "025000001";
		list.add(s);
		s = "025000002";
		list.add(s);
		return list;
		
	}
}

package businessLogic.Receiptsbl.MockTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import businessLogic.Receiptsbl.Receiptsbl;
import businessLogic.Userbl.Userbl;
import businessLogicService.ReceiptsblService.ReceiptsblService;
import vo.FormType;

public class tester {
		@Test
		public void test(){
			Userbl user = new MockUser();
			ReceiptsblService bl = new Receiptsbl(user);
			ArrayList<String> list = new ArrayList<String>();
			list.add("025000001");
			list.add("025000002");
			assertEquals(list,bl.getCarInfo("025001"));
			assertEquals("025001",bl.getHallId());
			assertEquals("南京市鼓楼营业厅装车单",bl.getFormName(FormType.装车单));
		}

}

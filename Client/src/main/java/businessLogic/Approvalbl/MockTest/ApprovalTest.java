package businessLogic.Approvalbl.MockTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import businessLogic.Approvalbl.Approvalbl;
import businessLogicService.ApprovalblService.ApprovalblService;

public class ApprovalTest {
	@Test
	public void test(){
		
		ApprovalblService bl = new Approvalbl();
		String name = "南京市鼓楼营业厅寄件单";
		String creater = "张三";
		
		assertEquals(name,bl.getName());
		assertEquals(creater,bl.getCreater());
	}

}
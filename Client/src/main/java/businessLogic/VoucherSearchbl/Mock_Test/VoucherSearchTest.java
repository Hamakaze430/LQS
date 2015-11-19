package businessLogic.VoucherSearchbl.Mock_Test;


import static org.junit.Assert.*;

import org.junit.Test;

import businessLogic.Receiptsbl.Receiptsbl;

public class VoucherSearchTest {
	@Test
	public void test(){
		Receiptsbl receipts = new MockReceipts();
		
		
		assertEquals("1230000001 25.5\n1230000002 42.0\n1230000003 11.1\n",receipts.showVouchers());
		
	
		
		assertEquals(78.6,receipts.getPrice(),0);
	}

}

package data.CostBenefitdata;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import po.receipts.IncomePO;
import po.receipts.PaymentPO;

public class Test {

	public void saveMockReceipts(){
		try {
			ObjectOutputStream out=new ObjectOutputStream(
					new FileOutputStream("src/main/java/ser/receipts.ser"));
			PaymentPO p1=new PaymentPO(34567,"XXX公司付款单","jimmy","2015-11-19","12345678", "456.00", "fgh", 
					"");
			PaymentPO p2=new PaymentPO(34568,"XXX公司付款单","jimmy","2015-11-20","12345678", "456.00", "fgh", 
					"");
			List<String> list = new ArrayList<String>();
			list.add("1234567890");
			IncomePO i1=new IncomePO(34569,"XXX公司shou款单","timmy","2015-11-20","6789.50", "oop", list); 
			
			
			out.writeObject(p1);
			out.writeObject(p2);
			out.writeObject(i1);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

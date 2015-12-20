package data.CostBenefitdata;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import po.receipts.IncomePO;
import po.receipts.PaymentPO;

public class Test {

	public void saveMockReceipts(){
		try {
			ObjectOutputStream out=new ObjectOutputStream(
					new FileOutputStream("src/main/java/ser/receipts.ser"));
			PaymentPO p1=new PaymentPO("first", "tim", "2015-10-30", 
					"passed", "100.3");
			PaymentPO p2=new PaymentPO("second", "john", "2015-11-30", 
					"passed", "2000.5");
			IncomePO i1=new IncomePO("first", "tom", "2015-10-01",
					"passed", "1000.0");
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

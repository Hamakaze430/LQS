package businessLogic.Salesbl.MockTest;

import po.*;

/**
 * Created by admin on 15/11/15.
 */
public class SalesTest {

    MockReceipts receipts=new MockReceipts();

    public void testSales(){
        MockPaymentList payment=new MockPaymentList("2013/05/01", "2015/11/30", receipts);
        MockIncomeList income=new MockIncomeList("2013/05/01", "2015/11/30", receipts);

        for(int i=0;i<payment.payment.size();i++){
            System.out.println(payment.payment.get(i).getAmount());
        }

        for(int i=0;i<income.income.size();i++){
            System.out.println(income.income.get(i).getAmount());
        }
    }
}

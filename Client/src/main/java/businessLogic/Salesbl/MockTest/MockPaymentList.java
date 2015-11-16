package businessLogic.Salesbl.MockTest;

import po.receipts.PaymentPO;

import java.util.ArrayList;

/**
 * Created by admin on 15/11/16.
 */
public class MockPaymentList {

    ArrayList<PaymentPO> payment=new ArrayList<PaymentPO>();

    public MockPaymentList(String start, String end, MockReceipts mr){
        for(int i=0;i<mr.list.size();i++) {
            if (mr.list.get(i).getClass().equals(PaymentPO.class)) {
                String after[] = mr.list.get(i).getCreateDate().split("\\/");
                String s[] = start.split("\\/");
                String e[] = end.split("\\/");
                if (Integer.parseInt(after[0]) > Integer.parseInt(s[0])
                        && Integer.parseInt(after[0]) < Integer.parseInt(e[0])){
                    payment.add((PaymentPO) mr.list.get(i));
                }
                else if (Integer.parseInt(after[0]) == Integer.parseInt(s[0])){
                    if (Integer.parseInt(after[1]) > Integer.parseInt(s[1]))
                        payment.add((PaymentPO) mr.list.get(i));
                    else if (Integer.parseInt(after[1]) == Integer.parseInt(s[1])) {
                        if (Integer.parseInt(after[2]) > Integer.parseInt(s[2])) {
                            payment.add((PaymentPO) mr.list.get(i));
                        }
                    }
                }
                else if (Integer.parseInt(after[0]) == Integer.parseInt(e[0])){
                    if (Integer.parseInt(after[1]) < Integer.parseInt(e[1]))
                        payment.add((PaymentPO) mr.list.get(i));
                    else if (Integer.parseInt(after[1]) == Integer.parseInt(e[1])) {
                        if (Integer.parseInt(after[2]) < Integer.parseInt(e[2])) {
                            payment.add((PaymentPO) mr.list.get(i));
                        }
                    }
                }
            }
        }
    }
}

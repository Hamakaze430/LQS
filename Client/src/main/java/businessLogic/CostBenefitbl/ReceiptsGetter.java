package businessLogic.CostBenefitbl;

import po.receipts.*;
import java.util.*;

/**
 * Created by admin on 15/11/16.
 */
public class ReceiptsGetter {
    //receive date from CostBenefit and return the corresponding receipts to Calculator

    public ArrayList<PaymentPO> getPayment(ArrayList<PaymentPO> list, String date){
        ArrayList<PaymentPO> results=new ArrayList<PaymentPO>();
        for(int i=0;i<list.size();i++){
            String after[]=list.get(i).getCreateDate().split("\\/");
            String req[]=date.split("\\/");
            for(int j=0;j<3;j++){
                if(Integer.parseInt(after[j])<=Integer.parseInt(req[j])){
                    results.add(list.get(i));
                    break;
                }
            }
        }
        return results;
    }

    public ArrayList<IncomePO> getIncome(ArrayList<IncomePO> list, String date){
        ArrayList<IncomePO> results=new ArrayList<IncomePO>();
        for(int i=0;i<list.size();i++){
            String after[]=list.get(i).getCreateDate().split("\\/");
            String req[]=date.split("\\/");
            for(int j=0;j<3;j++){
                if(Integer.parseInt(after[j])<=Integer.parseInt(req[j])){
                    results.add(list.get(i));
                    break;
                }
            }
        }
        return results;
    }

}

package po;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by admin on 15/10/25.
 */
public class CostBenefitPO implements Serializable {
    String date;

    public double getCost(String date){
        ArrayList<ReceiptPO> receipts=new ArrayList<ReceiptPO>();
        double cost=0.0;
        //get total cost by calculating the sum from receipts saved in ArrayList
        return cost;
    }

    public double getBenefit(String date){
        ArrayList<ReceiptPO> receipts=new ArrayList<ReceiptPO>();
        double benefit=0.0;
        //get total benefit by calculating the sum from receipts saved in ArrayList
        return benefit;
    }

    public double getProfit(String date) {
        double profit;
        profit=this.getBenefit(date)-this.getCost(date);
        //get profit by subtracting the calculated cost from the total benefit
        return profit;
    }
}

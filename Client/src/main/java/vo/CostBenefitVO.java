package vo;

import po.CostBenefitPO;

/**
 * Created by admin on 15/10/25.
 */
public class CostBenefitVO {
	
	double cost;
	double benefit;
	double profit;
	
	public CostBenefitVO(CostBenefitPO po){
		this.cost=po.getTotalPayment();
		this.benefit=po.getTotalIncome();
		this.profit=po.getProfit();
	}
	
	CostBenefitVO(double cost, double benefit, double profit){
		this.cost=cost;
		this.benefit=benefit;
		this.profit=profit;
	}
	
	public double getCost(){
		return cost;
	}
	
	public double getBenefit(){
		return benefit;
	}
	
	public double getProfit(){
		return profit;
	}
}

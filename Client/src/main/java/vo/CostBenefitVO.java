package vo;

/**
 * Created by admin on 15/10/25.
 */
public class CostBenefitVO {
	
	double cost;
	double benefit;
	double profit;
	
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

package businessLogicService.CostBenefitblService;

public interface CostBenefitblService {
	
	/*
	 * 从View处获得日期，用来创建CostBenefirPO
	 * */
	public void setDate();

	
	/*
	 * 向View返回总成本
	 * */
    public String showCost();

    /*
	 * 向View返回总收益
	 * */
    public String showBenefit();

    /*
	 * 向View返回总利润
	 * */
    public String showProfit();

    public boolean getReport();

}

package businessLogicService.CostBenefitblService;

public interface CostBenefitblService {

    public String getDate(String message);

    public double showCost(String date);

    public double showBenefit(String date);

    public double showProfit(String date);

    public String getReport(String date);

    public String cancelReport();

}

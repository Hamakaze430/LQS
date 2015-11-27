package businessLogicService.CostBenefitblService;

public interface CostBenefitblService {

    public String getDate(String message);

    public int showCost(String date);

    public int showBenefit(String date);

    public int showProfit(String date);

    public String getReport(String date);

    public String cancelReport();

}

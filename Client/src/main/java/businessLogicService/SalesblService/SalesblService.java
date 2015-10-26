package businessLogicService.SalesblService;

public interface SalesblService {

    public String getStartDate();

    public String getEndDate();

    public Boolean checkDate(String start, String end);

    public String showOut(String start, String end);

    public String showIn(String start, String end);

    public String getReport(String start, String end);

    public String cancelReport();

    public void exit();
}

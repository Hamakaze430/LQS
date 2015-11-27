package po;

import java.io.Serializable;

/**
 * Created by admin on 15/10/25.
 */
public class SalesPO implements Serializable {
    String startDate;
    String endDate;
    Boolean validity;

    public SalesPO(String start, String end){
        startDate=start;
        endDate=end;
    }

    public String getStartDate(){
        return startDate;
    }

    public String getEndDate(){
        return endDate;
    }

    public Boolean check(){
        return validity;
    }
}

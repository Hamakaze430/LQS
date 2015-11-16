package businessLogic.CostBenefitbl;

import java.util.Calendar;

public class CostBenefit {
    String message;
    int cost;
    int benefit;
    int profit;
    Calculator calculator=new Calculator();

    public String getdate(String message){
        if(message.equals("get")){  //get date and pass on to calculator
            Calendar c=Calendar.getInstance();
            int year=c.get(Calendar.YEAR);
            int month=c.get(Calendar.MONTH);
            int day=c.get(Calendar.DATE);
            String date=String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day);
            return date;
        }
        else
            return null;
    }

    public int showCost(String date){

        return cost;
    }

    public int showBenefit(String date){

        return benefit;
    }

    public int showProfit(String date){

        return profit;
    }

    public String getReport(String date){

        return message;
    }

    public String cancelReport(){

        return message;
    }
}

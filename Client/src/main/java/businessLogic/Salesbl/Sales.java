package businessLogic.Salesbl;

import java.util.ArrayList;
import po.*;

public class Sales {
    String message;
    Boolean state;
    String start;
    String end;
    ArrayList<ReceiptPO> receipts=new ArrayList<ReceiptPO>();
    DateController dc=new DateController();

    public Sales(String start, String end){
        this.start=start;
        this.end=end;
    }

    public String getStartDate(){
        return dc.getStartDate();
    }

    public String getEndDate(){
        return dc.getEndDate();
    }

    public Boolean checkDate(String start, String end){

        return state;
    }

    public String showOut(String start, String end){

        return message;
    }

    public String showIn(String start, String end){

        return message;
    }

    public String cancelReport(){

        return message;
    }

    public void exit(){

    }
}

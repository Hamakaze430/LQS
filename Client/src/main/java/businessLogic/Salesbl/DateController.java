package businessLogic.Salesbl;

/**
 * Created by admin on 15/11/15.
 */
public class DateController {

    public String getStartDate(){

    }

    public String getEndDate(){

    }

    public Boolean checkDate(String start, String end){

    }

    public Boolean checkStyle(String date){
        String after[]=date.split("\\/");       //just a rough check.....
        if(Integer.parseInt(after[0])<=2999&&Integer.parseInt(after[0])>=1900
                &&Integer.parseInt(after[1])>=1&&Integer.parseInt(after[1])<=12
                &&Integer.parseInt(after[2])>=1&&Integer.parseInt(after[2])<=31){
            return true;
        }
        else
            return false;
    }

}

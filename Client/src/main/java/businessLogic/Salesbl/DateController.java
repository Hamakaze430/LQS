package businessLogic.Salesbl;

/**
 * Created by admin on 15/11/15.
 */
public class DateController {

    public String getStartDate(String input){
        if(checkStyle(input)){
            return input;
        }
        else
            return "error";
    }

    public String getEndDate(String input, String start){
        if(checkStyle(input)){
            String after[]=input.split("\\/");
            String safter[]=start.split("\\/");
            if(Integer.parseInt(after[0])>Integer.parseInt(safter[0]))
                return input;
            else{
                if(Integer.parseInt(after[1])>Integer.parseInt(safter[1]))
                    return input;
                else if(Integer.parseInt(after[2])>Integer.parseInt(safter[2]))
                    return input;
            }
        }
        else
            return "error";
        return null;
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

package businessLogic.Salesbl;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by admin on 15/11/15.
 */
public class DateController {

	public Boolean check(String start, String end){
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d1=df.parse(start);
			Date d2=df.parse(end);
			if(d1.before(d2))
				return true;
			else
				return false;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
//    public String getStartDate(String input){	
//        if(checkStyle(input)){
//            return input;
//        }
//        else
//            return "error";
//    }
//
//    public String getEndDate(String input, String start){
//        if(checkStyle(input)){
//            String after[]=input.split("\\/");
//            String safter[]=start.split("\\/");
//            if(Integer.parseInt(after[0])>Integer.parseInt(safter[0]))
//                return input;
//            else{
//                if(Integer.parseInt(after[1])>Integer.parseInt(safter[1]))
//                    return input;
//                else if(Integer.parseInt(after[2])>Integer.parseInt(safter[2]))
//                    return input;
//            }
//        }
//        else
//            return "error";
//        return null;
//    }
//
//    public Boolean checkStyle(String date){
//        String after[]=date.split("\\/");       //just a rough check.....
//        if(Integer.parseInt(after[0])<=2999&&Integer.parseInt(after[0])>=1900
//                &&Integer.parseInt(after[1])>=1&&Integer.parseInt(after[1])<=12
//                &&Integer.parseInt(after[2])>=1&&Integer.parseInt(after[2])<=31){
//            return true;
//        }
//        else
//            return false;
//    }

}

package data.DataFactory;

import Miscellaneous.Date;

public class DateHelper {

	public Boolean checkCBDate(Date toCheck, Date stan){
		if(toCheck.getYear()<stan.getYear()){
			return true;
		}
		else if(toCheck.getYear()==stan.getYear()){
			if(toCheck.getMonth()<stan.getMonth())
				return true;
			else if(toCheck.getMonth()==stan.getMonth()){
				if(toCheck.getDay()<=stan.getDay())
					return true;
				else
					return false;
			}
			else
				return false;
		}	
		else
			return false;
	}
	
}

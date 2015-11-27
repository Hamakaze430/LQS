package Miscellaneous;

public class DateImpl {

	private String year;
	private String month;
	private String day;
	
	public DateImpl(String input){	//format: "year/month/day"
		String[] after=input.split("\\/");
		this.year=after[0];
		this.month=after[1];
		this.day=after[2];
	}
	
	public String toString(){
		String m=String.format("%02d", this.getMonth());
		return String.valueOf(this.getYear())+"/"
				+m+"/"
				+String.valueOf(this.getDay());
	}
	
	private Boolean checkFormat(){
		int month=this.getMonth();
		int year=this.getYear();
		int day=this.getDay();
		if((year>1900&&year<2500)
				&&(month>=1&&month<=12)){
			if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
				if(day>=1&&day<=31)
					return true;
				else
					return false;
			}
			else if(month==4||month==6||month==9||month==11){
				if(day>=1&&day<=30)
					return true;
				else
					return false;
			}
			else{
				if(year%400==0||(year%100!=0&&year%4==0)){
					if(day>=1&&day<=29)
						return true;
					else
						return false;
				}
				else{
					if(day>=1&&day<=28)
						return true;
					else
						return false;
				}
			}
		}
		else
			return false;
	}
	
	public int getYear(){
		return Integer.parseInt(this.year);
	}
	
	public int getMonth(){
		return Integer.parseInt(this.month);
	}
	
	public int getDay(){
		return Integer.parseInt(this.day);
	}
	
}

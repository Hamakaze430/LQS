package vo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import po.CarPO;

public class CarVO extends Vector<String>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CarVO(String id, String license, String time){
		this.add(id);
		this.add(license);
		this.add(time);
	}
	
	public CarVO(CarPO po) {
		this.add(po.getID());
		this.add(po.getLicense());
		Date current = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = formatter.parse(po.getTime());
			this.add(dec(current,date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String dec(Date current, Date date) {
		long a = (current.getTime() - date.getTime())/(24*60*60*1000);
		int year = (int)a / 365;
		int day = (int)a % 365;
		if (year>0) return year+"年";
		else return day + "天";
	}

	public String getId(){
		return get(0);
	}
	public String getLicense(){
		return get(1);
	}	
	public String getTime(){
		return get(2);
	}

}

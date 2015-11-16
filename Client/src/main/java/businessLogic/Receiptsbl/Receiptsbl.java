package businessLogic.Receiptsbl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businessLogic.Receiptsbl.MockTest.MockCarAndDriver;
import businessLogic.Userbl.Userbl;
import businessLogicService.CarAndDriverblService.CarAndDriverblService;
import businessLogicService.ReceiptsblService.ReceiptsblService;
import businessLogicService.UserblService.UserblService;
import vo.FormType;

public class Receiptsbl implements ReceiptsblService {
	private UserblService user;
	private CarAndDriverblService carAndDriver;
	public Receiptsbl(Userbl user){
		carAndDriver = new MockCarAndDriver();
		this.user = user;
	}
	
	public String getName(){
		return "";
	}
	
	public String getCreater(){
		return "";
	}
	
	public String showVouchers() {
		return null;
	}
	
	public double getPrice() {
		return 0;
	}

	public String getLoadingId() {
		// TODO Auto-generated method stub
		return "00001";
	}

	public ArrayList<String> getCarInfo(String hallId) {
		return carAndDriver.findAllCarInfo(hallId);
	}
	
	public String getHallId() {
		return user.getHallId();
	}
	
	public String getFormName(FormType type){
		return user.getHallName()+type.toString();
	}
	
	public String getCurrentTime(){
		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
		return formatter.format(date);
	}
	
	public String changeDateFormat(String date){
		DateFormat formatter1 = new SimpleDateFormat("yyyy.MM.dd");
		DateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
		try {
			return formatter2.format(formatter1.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
			return null;	
		}
	}
	
}


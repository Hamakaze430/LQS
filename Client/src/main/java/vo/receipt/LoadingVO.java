/**
 * 装车单
 */
package vo.receipt;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import vo.ReceiptVO;
import vo.UserVO;

public class LoadingVO extends ReceiptVO{
	/*
	 * 装车日期、本营业厅编号（025城市编码+000鼓楼营业厅）、
	 * 汽运编号 （营业厅编号+20150921日期+00000编码 、五位数字）、
	 * 到达地（本地中转中心或者其它营业厅）、
	 * 车辆代号、监装员、押运员、本次装箱所有订单条形码号）、
	 * 运费（运费根据出发地和目的地自动生成）。
	 * Loading.Date、Loading.ID、Loading.Destination、Loading.Car、Loading.Supervisor、Loading.Driver、Loading.Order
	 */
	UserVO user;
	Date date;
	String hallId;
	String id;
	String destination;
	String carID;
	String supervisor;
	String driver;
	ArrayList<Long> order;
	double cost;
	public LoadingVO(UserVO user){
		this.user = user;
		this.date = new Date();
		this.hallId = user.getHallId();
		this.id  = "";
	}
	
	public String getDate(){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		return format.format(date);
	}
	
	public String getHallId(){
		return hallId;
	}
	
	public String getPartId(){
		return id;
	}
	
	public String getForeId(){
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		return hallId+format.format(date);
	}
	
	public String getAllId(){
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		return hallId+format.format(date)+id;
	}
	
}

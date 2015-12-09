package Miscellaneous;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import po.HallPO;
import po.UserPO;

public class IDGenerator {
	/*
	 *用户ID
	 * 025/（0营业厅/1zzzx）＋（0-6）
	 *025/  1 （）
	 * 
	 * 000
	 * 
	 * 3位城市＋2位职位＋3位营业厅or中转中心编号＋3位按顺序……
	 * 
	 * eg. 	南京市鼓楼营业厅快递员：	025 00 000 000
	 * 		南京市鼓楼营业厅业务员：	025 01 000 000
	 *      南京市中转中心仓库管理员    025 10 000 000
	 *      南京市中转中心业务员：  	025 11 000 000
	 *      财务人员：                000 01 000 000
	 *      总经理：                  000 00 000 000 
	 * */
	
	private String position;
	private String center;
	private String num;
	private int index;
	
	public enum City{
		Nanjing("南京市"), Beijing("北京市"), Shanghai("上海市"), Guangzhou("广州市");
		
		private String city;

		City(String cityName){
			city=cityName;
		}
	}
	
	
	private enum Position{
		Delivery("营业厅快递员"), HallManage("营业厅业务员"), TransferManage("中转中心业务员"), 
			Warehouse("中转中心仓库管理员");
		
		private String pos;

		Position(String position){
			pos=position;
		}
	}
	

	public String generateID(Job job, HallPO hall){
		String id="";
		/*
		 * based on jobs
		 * */
		switch(job){
		case 总经理:
			id+="00";
			break;
		case 财务人员:
			id+="00";
			break;
		case 营业厅业务员:
			id+="01";
			break;
		case 快递员:
			id+="00";
			break;
		case 中转中心业务员:
			id+="11";
			break;
		case 中转中心仓库管理员:
			id+="10";
			break;
		}
		
		/*
		 * last few numbers
		 * */
		try {
			ObjectInputStream in=new ObjectInputStream(
					new FileInputStream("src/main/java/ser/user.ser"));
			UserPO temp;
			String pre=id;	//current id, the first eight numbers
			String test="";
			int count=0;
			while((temp=(UserPO)in.readObject())!=null){
				test=temp.getID().substring(0, 8);
				if(pre.equals(test)){
					count++;
				}
			}
			count+=Integer.parseInt(test);
			id+=String.format("%03d", count);
					
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
//	public String createID(UserPO user){
//		if(user.getHall().getLocation().equals("南京市")){
//			this.city="025";
//		}
//		else if(city.equals("上海市")){
//			this.city="021";
//		}
//		else if(city.equals("北京市")){
//			this.city="010";
//		}
//		else if(city.equals("广州市")){
//			this.city="020";
//		}
//		else{
//			return "Error";
//		}
//		
//		if(position.equals("营业厅业务员")){
//			this.position="01";
//		}
//		else if(position.equals("营业厅快递员")){
//			this.position="00";
//		}
//		else if(position.equals("中转中心仓库管理员")){
//			this.position="10";
//		}
//		else if(position.equals("中转中心业务员")){
//			this.position="11";
//		}
//		else if(position.equals("财务人员")){
//			this.position="00";
//		}
//		else if(position.equals("总经理")){
//			this.position="00";
//		}
//		else{
//			return "Error";
//		}
//		
//		if(center.equals("")){
//			
//		}
//		else if(center.equals("")){
//			
//		}
//		else if(center.equals("")){
//			
//		}
//		else{
//			return "Error";
//		}
//		
//		int count=0;
//		String pre=this.city+this.position+this.center;
//		try {
//			ObjectInputStream in=new ObjectInputStream(
//					new FileInputStream("src/main/java/ser/user.ser"));
//			UserPO temp;
//			String id;
//			while((temp=(UserPO)in.readObject())!=null){
//				id=temp.getID();
//				id=id.substring(0, 8);
//				if(pre.equals(id)){
//					count++;
//				}
//			}
//			this.num=String.format("%3d", count).replace(" ", "0");;
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		this.ID=this.city+this.position+this.center+this.num;
//		return num;
//	}
//	
	
}

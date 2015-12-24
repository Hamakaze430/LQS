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
	 * 3位城市＋3位营业厅or中转中心编号＋2位职位＋3位按顺序……
	 * 
	 * eg. 	南京市鼓楼营业厅快滴员：	025 000 00 000
	 * 		南京市鼓楼营业厅业务员：	025 000 01 000
	 *      南京市中转中心仓库管理员    025 000 10 000
	 *      南京市中转中心业务员：  	025 000 11 000
	 *      财务人员：                000 000 01 000
	 *      总经理：                  000 000 00 000 
	 * */
	
	public static String generateID(Job job, String hallId){
		String id= hallId;
		/*
		 * based on jobs
		 * */
		switch(job){
		case 总经理:
			id+="00000";
			break;
		case 财务人员:
			id+="00001";
			break;
		case 营业厅业务员:
			id+="01";
			break;
		case 快递员:
			id+="00";
			break;
		case 中转中心业务员:
			id = id.substring(0, 3)+"00"+id.substring(3);
			id+="11";
			break;
		case 中转中心仓库管理员:
			id = id.substring(0, 3)+"00"+id.substring(3);
			id+="10";
			break;
		}
		
		/*
		 * last few numbers
		 * */
		UserManagerblService bl = new UserManagerbl();
		id+=String.format("%03d", bl.getCount(id));
		return id;
	}	
}

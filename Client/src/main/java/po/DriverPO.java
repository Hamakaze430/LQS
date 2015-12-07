package po;

import java.io.Serializable;
import java.util.Date;

public class DriverPO implements Serializable{
     /**
	 * 
	 */
	    private static final long serialVersionUID = 1L;
		String id; //城市编号（电话号码区号南京025）+营业厅编号（000三位数字）+000三位数字
		String name;//姓名
		Date birth;  //出生日期
		String identity; //身份证号
		String mobile; //手机
		String gender; //男/女
		Date time; //行驶证期限
		
		public DriverPO(String id, String name, Date birth, String identity, String mobile, String gender, Date time){
			this.id = id;
			this.name = name;
			this.birth = birth;
			this.identity = identity;
			this.mobile = mobile;
			this.gender = gender;
			this.time = time;
		}
		
		public String getId(){
			return id;
		}	
		public void setId(String id){
			this.id = id;
		}
		
		public String getName(){
			return name;
		}	
		public void setName(String name){
			this.name = name;
		}
		
		public Date getBirth(){
			return birth;
		}
		public void setBirth(Date birth){
			this.birth = birth;
		}
		
		public String getIdentity(){
			return identity;
		}	
		public void setIdentity(String identity){
			this.identity = identity;
		}
		
		public String getMobile(){
			return mobile;
		}
		public void setMobile(String mobile){
			this.mobile = mobile;
		}
		
		public String getGender(){
			return gender;
		}
		public void setGender(String gender){
			this.gender = gender;
		}
		
		public Date getTime(){
			return time;
		}
		public void setTime(Date time){
			this.time = time;
		}
}

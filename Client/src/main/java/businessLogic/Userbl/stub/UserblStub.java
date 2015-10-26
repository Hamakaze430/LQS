package businessLogic.Userbl.stub;

public interface UserblService _Stud implements UserblService{
	int userid;
	String userpassword;
	String userpersonalinfo;
	String usercompetence;
	
	public UserVO getUserByID(int userid){
		return new UserVO(userpassword,userpersonalinfo,usercompetence);
	}
	
	public ResultMessage addUser(int userid){
		if(receiptname == 141250064)
			return ResultMessage.Exist;
		else return ResultMessage.NotExist;
	}
	
	public String getUserPassword(int userid){
		return userpassword;
	}
	
	public String getUserPersonalInfo(int userid){
		return userpersonalinfo;
	}
	
	public String getUserCompetence(int userid){
		return usercompetence;
	}
	
	public class UserView{
		
	}
	

}

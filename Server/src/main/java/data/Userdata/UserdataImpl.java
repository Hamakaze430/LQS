package data.Userdata;

import po.UserPO;
import dataService.UserdataService.UserdataService;

import java.io.*;
import java.util.ArrayList;

public class UserdataImpl implements UserdataService{

	public UserPO getUserbyID(String ID) {
		// TODO Auto-generated method stub
		try {
			ObjectInputStream in=new ObjectInputStream(
					new FileInputStream("src/main/java/ser/user.ser"));
			UserPO temp;
			while((temp=(UserPO)in.readObject())!=null){
				if(temp.getID().equals(ID))
					return temp;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<UserPO> getAllUsers(){
		ArrayList<UserPO> list=new ArrayList<UserPO>();
		try {
			ObjectInputStream in=new ObjectInputStream(
					new FileInputStream("src/main/java/ser/user.ser"));
			UserPO temp;
			while((temp=(UserPO)in.readObject())!=null){
				list.add(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

	public UserPO getCurrentUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addUser(UserPO user) {
		// TODO Auto-generated method stub
		Object
	}

}

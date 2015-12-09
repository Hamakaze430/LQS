package data.Userdata;

import po.UserPO;
import dataService.UserdataService.UserdataService;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class UserdataImpl extends UnicastRemoteObject implements UserdataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public UserdataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	public static void main(String[] args) throws RemoteException{
//		UserdataImpl  a = new UserdataImpl();
//		UserPO po = a.getUserbyID("admin");
//		if (po == null) System.out.println("null");
//	}
	@Override
	public UserPO getUserbyID(String ID)throws RemoteException {
		// TODO Auto-generated method stub
		List<UserPO> list = getAllUsers();
		for (UserPO po : list){
			if (po.getID().equals(ID)) return po;
		}
		return null;
	}
	
	@Override
	public ArrayList<UserPO> getAllUsers()throws RemoteException{
		try {
			FileInputStream fileIn = new FileInputStream("src/main/java/ser/user.ser");
			BufferedInputStream buffered = new BufferedInputStream(fileIn);	
	        ObjectInputStream objectIn = new ObjectInputStream(buffered);  	   
	        ArrayList<UserPO> list = (ArrayList<UserPO>) objectIn.readObject();
	        return list;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return new ArrayList<UserPO>();
	}
	
	@Override
	public UserPO getCurrentUser() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean addUser(UserPO user) throws RemoteException{
		// TODO Auto-generated method stub
		try {
			List<UserPO> list = getAllUsers();
			//List<UserPO> list = new ArrayList<UserPO>();
			list.add(user);
            FileOutputStream fileOut = new FileOutputStream("src/main/java/ser/user.ser");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(list);
			objectOut.close();
            return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}

	@Override
	public boolean deleteUser(UserPO po) throws RemoteException {
		try {
			List<UserPO> list = getAllUsers();
			int index = -1;
			for (int i = 0; i < list.size(); i++){
				if (list.get(i).getID().equals(po.getID())){
					index = i;
					break;
				}
			}
			list.remove(index);
            FileOutputStream fileOut = new FileOutputStream("src/main/java/ser/user.ser");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(list);
			objectOut.close();
            return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}

	@Override
	public boolean updateUser(UserPO po) throws RemoteException {
		try {
			List<UserPO> list = getAllUsers();
			int index = -1;
			for (int i = 0; i < list.size(); i++){
				if (list.get(i).getID().equals(po.getID())){
					index = i;
					break;
				}
			}
			list.remove(index);
			list.add(po);
            FileOutputStream fileOut = new FileOutputStream("src/main/java/ser/user.ser");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(list);
			objectOut.close();
            return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
}

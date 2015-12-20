package data.Userdata;

import po.UserPO;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dataService.UserdataService.UserdataService;

public class UserdataImpl extends UnicastRemoteObject implements UserdataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public UserdataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings({ "unchecked", "resource" })
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
	
	public UserPO getCurrentUser() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean addUser(UserPO user) throws RemoteException{
		// TODO Auto-generated method stub
		try {
			addCount(user.getID());
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

	public int getCount(String id) throws RemoteException {
		File file = new File("src/main/java/ser/userIdNum.txt");
		try{
			InputStreamReader read = new InputStreamReader(new FileInputStream(file),"UTF-8");
			BufferedReader br = new BufferedReader(read);
			String s = br.readLine();
			while (s != null){
				if (s.indexOf(id) != -1){
					int ans = Integer.valueOf(s.substring(id.length()+1));
					br.close();
					return ans;
				}
				s = br.readLine();
			}
			
			br.close();
		}catch (FileNotFoundException e) {
			   e.printStackTrace();
		} catch (IOException e) {
			   e.printStackTrace();
		}
		return 0;
	}
	
	private boolean addCount(String id) {
		// TODO Auto-generated method stub
		id = id.substring(0,8);
		File file = new File("src/main/java/ser/userIdNum.txt");
		try{
			InputStreamReader read = new InputStreamReader(new FileInputStream(file),"UTF-8");
			BufferedReader br = new BufferedReader(read);
			String s = br.readLine();
			List<String> list = new ArrayList<String>();
			while (s != null){
				list.add(s);
				s = br.readLine();
			}
			br.close();
			int num = 1;
			for (String str : list){
				if (str.indexOf(id) != -1){
					list.remove(str);
					num = Integer.valueOf(str.substring(id.length()+1)) + 1;
					break;
				}
			}
			String stri = id + " " +  num;
			list.add(stri);
			OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
			for (String str : list){
				output.write(str + "\r\n");
			}
			output.close();
		}catch (FileNotFoundException e) {
			   e.printStackTrace();
		} catch (IOException e) {
			   e.printStackTrace();
		}
		return false;
	}

	public UserPO find(String known, String info) throws RemoteException {
		List<UserPO> list = getAllUsers();
		if (known.equals("id")){
			for (UserPO po : list){
				if (po.getID().equals(info)) return po;
			}
			return null;
		}
		if (known.equals("name")){
			for (UserPO po : list){
				if (po.getName().equals(info)) return po;
			}
			return null;
		}
		return null;
	}
}

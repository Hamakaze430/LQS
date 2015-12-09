package data.Userdata;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import Miscellaneous.Identity;
import dataService.UserdataService.AuthoritiesSettingDataService;
import po.AuthorityPO;

public class AuthoritiesDataServiceImpl extends UnicastRemoteObject implements AuthoritiesSettingDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthoritiesDataServiceImpl() throws RemoteException {
		super();
	}
	
//	public static void main(String[] args) throws RemoteException{
//		AuthoritiesDataServiceImpl a = new AuthoritiesDataServiceImpl();
//		Identity[] array = Identity.values();
//		for (Identity id : array){
//			a.save(new AuthorityPO(id.name(),new ArrayList<String>()));
//		}
//		String s = "管理员";
//		List<String> list = new ArrayList<String>();
//		list.add("用户管理");
//		a.save(new AuthorityPO(s,list));
//		List<String> list = a.getList("管理员");	
//		for(String s : list) System.out.println(s);
//	}

	@Override
	public List<String> getList(String identity) throws RemoteException {
		List<String> ans = new ArrayList<String>();
		try {
			FileInputStream fileIn = new FileInputStream("src/main/java/ser/authorities.ser");
			BufferedInputStream buffered = new BufferedInputStream(fileIn);	
	        ObjectInputStream objectIn = new ObjectInputStream(buffered);  	   
	        List<AuthorityPO> list = (List<AuthorityPO>) objectIn.readObject();
	        for (AuthorityPO po : list){
//	        	System.out.println(po.getIdentity());
//	        	for (String s : po.getList()) System.out.println(s);
	        	if (po.getIdentity().equals(identity)) {
	        		ans = po.getList();
	        		return ans;
	        	}
	        		
	        	
	        }
	       
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
		return ans;
	}

	@SuppressWarnings({ "unchecked", "resource" })
	@Override
	public boolean save(AuthorityPO po) throws RemoteException {
		try {
			FileInputStream fileIn = new FileInputStream("src/main/java/ser/authorities.ser");
			BufferedInputStream buffered = new BufferedInputStream(fileIn);	
	        ObjectInputStream objectIn = new ObjectInputStream(buffered);  	   
	        List<AuthorityPO> list = (List<AuthorityPO>) objectIn.readObject();
	       // System.out.println("list.size"+list.size());
	        int index = -1;
			for (int i = 0; i < list.size(); i++){
				if (list.get(i).getIdentity().equals(po.getIdentity())){
					index = i;
					break;
				}
			}
			if (index != -1) list.remove(index);
			//List<AuthorityPO> list = new ArrayList<AuthorityPO>();
			list.add(po);
            FileOutputStream fileOut = new FileOutputStream("src/main/java/ser/authorities.ser");
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
	 
}

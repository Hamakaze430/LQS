package data.Approvaldata;

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

import dataService.ApprovaldataService.ApprovaldataService;
import po.ApprovalPO;
import po.HallPO;

public class ApprovaldataImpl extends UnicastRemoteObject implements  ApprovaldataService {

	public ApprovaldataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings({ "unchecked", "resource" })
	public List<ApprovalPO> findAll() throws RemoteException {
		try {
			FileInputStream fileIn = new FileInputStream("src/main/java/ser/approval.ser");
			BufferedInputStream buffered = new BufferedInputStream(fileIn);	
	        ObjectInputStream objectIn = new ObjectInputStream(buffered);  	   
	        List<ApprovalPO> list = (List<ApprovalPO>) objectIn.readObject();
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
		return new ArrayList<ApprovalPO>();
	}
	
	public boolean insert(ApprovalPO po) throws RemoteException {
		try {
			List<ApprovalPO>  list = findAll();
			list.add(po);
            FileOutputStream fileOut = new FileOutputStream("src/main/java/ser/approval.ser");
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
	
	public boolean delete(List<Long> poList) throws RemoteException {
		try {
			List<ApprovalPO> list = findAll();
			for (long po : poList){
				int index = -1;
				for (int i = 0; i < list.size(); i++){
					if (list.get(i).getHashId()== po){
						index = i;
						break;
					}
				}
				list.remove(index);
			}
            FileOutputStream fileOut = new FileOutputStream("src/main/java/ser/approval.ser");
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
	
	public boolean delete(long id) throws RemoteException {
		try {
			List<ApprovalPO> list = findAll();
//			for (HallPO one : list){
//				if (one.equals(po))
//					list.remove(one);
//				break;
//			}
			int index = -1;
			for (int i = 0; i < list.size(); i++){
				if (list.get(i).getHashId() == id){
					index = i;
					break;
				}
			}
		//	System.out.println(index);
			list.remove(index);
            FileOutputStream fileOut = new FileOutputStream("src/main/java/ser/approval.ser");
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

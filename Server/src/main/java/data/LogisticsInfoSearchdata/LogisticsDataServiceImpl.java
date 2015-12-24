package data.LogisticsInfoSearchdata;

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

import Miscellaneous.LogisticsState;
import dataService.LogisticsInfoSearchdataService.LogisticsDataService;
import po.HallPO;
import po.LogisticsPO;

public class LogisticsDataServiceImpl extends UnicastRemoteObject implements LogisticsDataService {

	public LogisticsDataServiceImpl() throws RemoteException {
		super();
	}
	
//	public static void main(String[] args) throws RemoteException{
//		LogisticsDataServiceImpl a = new LogisticsDataServiceImpl();
//		List<String> list = new ArrayList<String>();
//		list.add("测试用例");
//		list.add(LogisticsState.收件人已收件.name());
//		list.add(LogisticsState.收件人已收件.name());
//		a.insert(new LogisticsPO("1234567890","测试",list));
//	}
	
	@SuppressWarnings({ "unchecked", "resource" })
	private List<LogisticsPO> findAll() throws RemoteException {
		try {
			FileInputStream fileIn = new FileInputStream("src/main/java/ser/logistics.ser");
			BufferedInputStream buffered = new BufferedInputStream(fileIn);	
	        ObjectInputStream objectIn = new ObjectInputStream(buffered);  	   
	        List<LogisticsPO> list = (List<LogisticsPO>) objectIn.readObject();
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
		return new ArrayList<LogisticsPO>();
	}
	public LogisticsPO find(String id) throws RemoteException {
		List<LogisticsPO>  list = findAll();
		for (LogisticsPO po : list){
			if (po.getId().equals(id)) return po;
		}
		return null;		
	}
		
	public boolean insert(LogisticsPO po) throws RemoteException {
		try {
			List<LogisticsPO> list = findAll();
			int index = -1;
			for (int i = 0; i < list.size(); i++){
				if (list.get(i).getId().equals(po.getId())){
					index = i;
					break;
				}
			}
			if (index != -1) list.remove(index);
			list.add(po);
            FileOutputStream fileOut = new FileOutputStream("src/main/java/ser/logistics.ser");
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

	public boolean addState(List<String> orders, String state) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			List<LogisticsPO> list = findAll();
			
			for (String order: orders){
				int index = -1;
				for (int i = 0; i < list.size(); i++){
					if (list.get(i).getId().equals(order)){
						index = i;
						break;
					}
				}	
				if (index != -1) {
					LogisticsPO po =list.remove(index);
					po.addState(state);
					list.add(po);
				}
			}
			
            FileOutputStream fileOut = new FileOutputStream("src/main/java/ser/logistics.ser");
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

	public boolean addState(String order, String state) throws RemoteException {
		// TODO Auto-generated method stub
		try{
			List<LogisticsPO> list = findAll();	
			int index = -1;
			for (int i = 0; i < list.size(); i++){
				if (list.get(i).getId().equals(order)){
					index = i;
					break;
				}
			}
			
			if (index != -1) {
				LogisticsPO po =list.remove(index);
				po.addState(state);
				list.add(po);
			}
			FileOutputStream fileOut = new FileOutputStream("src/main/java/ser/logistics.ser");
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

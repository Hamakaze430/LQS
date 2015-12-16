package data.Userdata;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import Miscellaneous.Place;
import dataService.UserdataService.ApartmentDataService;
import po.HallPO;
import po.LogisticsPO;

public class ApartmentDataServiceImpl extends UnicastRemoteObject implements ApartmentDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ApartmentDataServiceImpl() throws RemoteException {
		super();
	}
	
//	public static void main(String[] args) throws RemoteException{
//		ApartmentDataServiceImpl a = new ApartmentDataServiceImpl();
////		a.insert(new HallPO("南京第二中转中心","0251","南京市栖霞区"),"中转中心");
//		a.findAll("PlaceName","南京市");
//	}
	
	public List<HallPO> findAll(String known, String hallInfo) throws RemoteException {
		List<HallPO>  list = findAll();
		List<HallPO> ans = new ArrayList<HallPO>();
		if (known.equals("PlaceName")){
			for (HallPO po : list){
				if (po.getLocation().contains(hallInfo)) ans.add(po);
			}
			return ans;
		}
		return ans;
	}
	
	public HallPO find(String known, String hall) throws RemoteException {
		List<HallPO>  list = findAll();
		
		if (known.equals("Name")){
			for (HallPO po : list){
				if (po.getName().equals(hall)) return po;
			}
			return null;
		}
		if (known.equals("Id")){
			for (HallPO po : list){
				if (po.getID().equals(hall)) return po;
			}
			return null;
		}
		return null;
	}
	
	
	@SuppressWarnings({ "unchecked", "resource" })
	public List<HallPO> findAll() throws RemoteException {
		try {
			FileInputStream fileIn = new FileInputStream("src/main/java/ser/apartment.ser");
			BufferedInputStream buffered = new BufferedInputStream(fileIn);	
	        ObjectInputStream objectIn = new ObjectInputStream(buffered);  	   
	        List<HallPO> list = (List<HallPO>) objectIn.readObject();
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
		return new ArrayList<HallPO>();
	}

	public  boolean insert(HallPO po, String type) throws RemoteException {
		try {
			addNum(type,po.getLocation().substring(0, 3));
			List<HallPO>  list = findAll();
			list.add(po);
            FileOutputStream fileOut = new FileOutputStream("src/main/java/ser/apartment.ser");
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
	
	public boolean update(HallPO po) throws RemoteException {
		try {
			List<HallPO> list = findAll();
			int index = -1;
			for (int i = 0; i < list.size(); i++){
				if (list.get(i).getID().equals(po.getID())){
					index = i;
					break;
				}
			}
			list.remove(index);
			list.add(po);
            FileOutputStream fileOut = new FileOutputStream("src/main/java/ser/apartment.ser");
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
	
	public boolean delete(HallPO po) throws RemoteException {
		try {
			List<HallPO> list = findAll();
//			for (HallPO one : list){
//				if (one.equals(po))
//					list.remove(one);
//				break;
//			}
			int index = -1;
			for (int i = 0; i < list.size(); i++){
				if (list.get(i).compareTo(po)){
					index = i;
					break;
				}
			}
		//	System.out.println(index);
			list.remove(index);
            FileOutputStream fileOut = new FileOutputStream("src/main/java/ser/apartment.ser");
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

	public int getNum(String type, String place) throws RemoteException {
		String key;
		if (type.equals("公司")) key = type;
		else key = type + " " + place;
		File file = new File("src/main/java/ser/apartmentNum.txt");
		try{
			InputStreamReader read = new InputStreamReader(new FileInputStream(file),"UTF-8");
			BufferedReader br = new BufferedReader(read);
			String s = br.readLine();
			while (s != null){
				if (s.indexOf(key) != -1){
					int ans = Integer.valueOf(s.substring(key.length()+1));
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
		return -1;
	}


	private boolean addNum(String type, String place) throws RemoteException {
		String key;
		if (type.equals("公司")) key = type;
		else key = type + " " + place;
		File file = new File("src/main/java/ser/apartmentNum.txt");
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
			for (String str : list){
				if (str.indexOf(key) != -1){
					list.remove(str);
					int num = Integer.valueOf(str.substring(key.length()+1)) + 1;
					str = key + " " +  num;
					list.add(str);
					break;
				}
			}
			OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
			for (String str : list){
				output.write(str + "\r\n");
			}
			output.close();
			return true;
		}catch (FileNotFoundException e) {
			   e.printStackTrace();
		} catch (IOException e) {
			   e.printStackTrace();
		}
		return false;
	}
	
}

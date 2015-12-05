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

import dataService.UserdataService.ApartmentDataService;
import po.HallPO;

public class ApartmentDataServiceSerializableFileImpl extends UnicastRemoteObject implements ApartmentDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ApartmentDataServiceSerializableFileImpl() throws RemoteException {
		super();
	}
	
	
//	public static void main(String[] args) throws RemoteException{
//		ApartmentDataServiceSerializableFileImpl a =new ApartmentDataServiceSerializableFileImpl();
//		@SuppressWarnings("unused")
//		List <HallPO> list = a.findAll();
//	}
	
	@SuppressWarnings({ "unchecked", "resource" })
	@Override
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
		return new ArrayList<>();
	}

	@Override
	public  boolean insert(HallPO po) throws RemoteException {
		try {
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

	

}

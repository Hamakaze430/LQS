package data.CarAndDriverdata;

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
import java.util.List;

import dataService.CarAndDriverdataService.CarAndDriverdataService;
import po.CarAndDriverPO;
import po.CarPO;
import po.DriverPO;

public class CarAndDriverDataServiceImpl extends UnicastRemoteObject implements CarAndDriverdataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CarAndDriverDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean insert(String type, CarAndDriverPO po) throws RemoteException {
		try {
			List<CarAndDriverPO>  list = findAll(type);
			list.add(po);
            FileOutputStream fileOut;
            if (type.equals("car")) fileOut = new FileOutputStream("src/main/java/ser/cars.ser");
            else fileOut = new FileOutputStream("src/main/java/ser/drivers.ser");
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

	@SuppressWarnings({ "resource", "unchecked" })
	public List<CarAndDriverPO> findAll(String type) throws RemoteException {
		try {
			FileInputStream fileIn;
			if (type.equals("car")) fileIn = new FileInputStream("src/main/java/ser/cars.ser");
            else fileIn = new FileInputStream("src/main/java/ser/drivers.ser");
			BufferedInputStream buffered = new BufferedInputStream(fileIn);	
	        ObjectInputStream objectIn = new ObjectInputStream(buffered);  	   
	        List<CarAndDriverPO> list = (List<CarAndDriverPO>) objectIn.readObject();
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
		return new ArrayList<CarAndDriverPO>();
	}

	public int getCount(String type, String foreId) throws RemoteException {
		File file;
		if (type.equals("car")) file = new File("src/main/java/ser/carNum.txt");
		else file = new File("src/main/java/ser/driverNum.txt");
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
				if (str.indexOf(foreId) != -1){
					list.remove(str);
					num = Integer.valueOf(str.substring(foreId.length()+1)) + 1;
					break;
				}
			}
			String stri = foreId + " " +  num;
			list.add(stri);
			OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
			for (String str : list){
				output.write(str + "\r\n");
			}
			output.close();
			return num-1;
			
		}catch (FileNotFoundException e) {
			   e.printStackTrace();
		} catch (IOException e) {
			   e.printStackTrace();
		}
		return -1;
	}

	public boolean find(String type, String known) throws RemoteException {
		List<CarAndDriverPO>  list = findAll(type);
		if (type.equals("car")){
			for (CarAndDriverPO po: list){
				if (((CarPO)po).getID().equals(known)) return true;
			}
			return false;
		}
		if (type.equals("driver")){
			for (CarAndDriverPO po: list){
				if (((DriverPO)po).getName().equals(known)) return true;
			}
			return false;
		}
		return false;
	}

}

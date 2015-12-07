package data.LogisticsInfoSearchdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dataService.LogisticsInfoSearchdataService.LogisticsDataService;
import po.LogisticsPO;

public class LogisticsDataServiceTextFileImpl extends UnicastRemoteObject implements LogisticsDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LogisticsDataServiceTextFileImpl() throws RemoteException {
		super();
	}
//	public static void main(String[] args) throws RemoteException{
//		LogisticsDataServiceTextFileImpl aaa = new LogisticsDataServiceTextFileImpl();
//		LogisticsPO po = aaa.find("1234567890");
//	}
	public LogisticsPO find(String id) throws RemoteException{
		File file = new File("src/main/java/txt/logistics.txt");
		try{
			InputStreamReader read = new InputStreamReader(new FileInputStream(file),"UTF-8");
			BufferedReader br = new BufferedReader(read);
			String s = br.readLine();
			while (s != null){
				if (s.indexOf(id) != -1){
					String[] data = s.split("//");
					String logisticsId = data[0];
					List<String> logisticsState = new ArrayList<String>();
					for (int i = 1; i < data.length; i++){
						logisticsState.add(data[i]);
					}
					LogisticsPO logistics = new LogisticsPO(logisticsId, logisticsState);
					br.close();
					return logistics;
				}
			}
			br.close();
		}catch (FileNotFoundException e) {
			   e.printStackTrace();
		} catch (IOException e) {
			   e.printStackTrace();
		}
		return null;
	}
	
	public boolean insert(LogisticsPO po) throws RemoteException{
		File file = new File("src/main/java/txt/logistics.txt");
		try {				
			OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(file,true),"UTF-8"); 
	        output.write(po.getId());
	        output.write("//");
	        for (String str:po.getState()){
	        	output.write(str);
	        	output.write("//");
	        }
	        output.write("\r\n");
            output.close();
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
}

/**
 * 装车单
 */
package vo.receipts;

import java.util.ArrayList;

import vo.ReceiptVO;

public class LoadingVO extends ReceiptVO{
	public final String date;
	public final String hallId;
	public final String id;
	public final String destination;
	public final String carId;
	public final String supervisor;
	public final String driver;
	public final ArrayList<String> order;
	public final double cost;
	public LoadingVO(String date, String hallId, 
					 String id, String destination, 
					 String carId, String supervisor, 
					 String driver, ArrayList<String> order,
					 double cost){
		this.date = date;
		this.hallId = hallId;
		this.id = id;
		this.destination = destination;
		this.carId = carId;
		this.supervisor = supervisor;
		this.driver = driver;
		this.order = order;
		this.cost = cost;		
	}	
}

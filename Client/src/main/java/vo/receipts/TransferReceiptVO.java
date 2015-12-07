package vo.receipts;

import java.util.ArrayList;

import businessLogicService.CommodityblService.ExpressType;
import vo.OrderVO;

public class TransferReceiptVO {
	String id;
	String date;
	String to;
	String location;
	String transportID;
	String supervisor;
	double cost;
	ExpressType etype;
	
	ArrayList<OrderVO> orderList;
    
    public TransferReceiptVO(String id, String date, String to, String location, String transportID, String supervisor, ExpressType etype, ArrayList<OrderVO> list){
		
		this.id =id;
		this.date = date;
		this.to = to;
		this.location = location;
		this.transportID = transportID;
		this.supervisor = supervisor;
		this.etype = etype;
		
		orderList = list;
		
	}
    
    public String getID(){
		return this.id;
	}
	
	public String getDate(){
		return this.date;
	}
	
	public String getTo(){
		return this.to;
	}
	
	public String getLocation(){
		return this.location;
	}

    public ArrayList<OrderVO> getList(){
    	return this.orderList;
    }
    
	public String getTransportID(){
		return this.transportID;
	}
    
    public String getSupervisor(){
    	return this.supervisor;
    }
    
    public ExpressType getType(){
    	return this.etype;
    }
    
    public double getCost(){
    	return this.cost;
    }

}

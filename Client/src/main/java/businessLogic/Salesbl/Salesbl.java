package businessLogic.Salesbl;

import java.util.ArrayList;

import po.receipts.*;
import dataService.DataFactoryService.DataFactoryService;
import dataService.SalesdataService.SalesdataService;
import init.Client;
import init.RMIHelper;
import businessLogicService.SalesblService.SalesblService;
import po.*;
import vo.SalesVO;

public class Salesbl implements SalesblService{
	
	private DataFactoryService dataFactory;
	private SalesdataService salesDataImpl;
//    private String message;
//    private Boolean state;
    private String start;
    private String end;
    private ArrayList<IncomePO> income;
    private ArrayList<PaymentPO> payment; 
    
    public Salesbl(){
    	dataFactory=Client.dataFactory;
    	salesDataImpl=dataFactory.getSalesdataService();
    }
    
    public void setDate(String start, String end){
    	this.start=start;
    	this.end=end;
    }
 
    public Boolean checkDate(){
    	DateController dc=new DateController();
        return dc.check(this.start, this.end);
    }

	public boolean getReport() {
		// TODO Auto-generated method stub
		return salesDataImpl.getReport(salesDataImpl.getSales(this.start, this.end));
	}

	public SalesVO show() {
		SalesVO vo;
		if(this.checkDate()){
			SalesPO po=salesDataImpl.getSales(this.start, this.end);
			vo=new SalesVO(po);
		}
		else
			return null;
		return vo;
	}


	public void exit() {
		// TODO Auto-generated method stub
		
	}

	public void save(SalesPO po) {
		salesDataImpl.save(po);
	}

	public String cancelReport() {
		// TODO Auto-generated method stub
		return null;
	}
}

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

public class Sales implements SalesblService{
	
	private DataFactoryService dataFactory;
	private SalesdataService sales;
//    private String message;
//    private Boolean state;
    private String start;
    private String end;
    private ArrayList<IncomePO> income;
    private ArrayList<PaymentPO> payment; 
    
    public Sales(){
    	dataFactory=Client.dataFactory;
		sales=dataFactory.getSalesdataService();
    }
    
    public void setDate(String start, String end){
    	this.start=start;
    	this.end=end;
    }
 
    public Boolean checkDate(){
    	DateController dc=new DateController();
        return dc.check(this.start, this.end);
    }

	public void getReport() {
		// TODO Auto-generated method stub
		sales.getReport(sales.getSales(this.start, this.end));
	}

	public SalesVO show() {
		SalesVO vo;
		if(this.checkDate()){
			SalesPO po=sales.getSales(this.start, this.end);
			vo=new SalesVO(po);
		}
		else
			return null;
		return vo;
	}

	public String cancelReport() {
		// TODO Auto-generated method stub
		return null;
	}

	public void exit() {
		// TODO Auto-generated method stub
		
	}

	public void save(SalesPO po) {
		sales.save(po);
	}
}

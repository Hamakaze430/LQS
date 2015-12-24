package data.ReportGenerator;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import po.BankAccountPO;
import po.BillManagementPO;
import po.CarPO;
import po.CommodityPO;
import po.CostBenefitPO;
import po.DriverPO;
import po.ReceiptPO;
import po.SalesPO;
import po.UserPO;
import po.receipts.IncomePO;
import po.receipts.PaymentPO;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ReportGenerator {

	public boolean createSalesReport(SalesPO sales){
		
		ArrayList<IncomePO> income=sales.getIncomeList();
		ArrayList<PaymentPO> payment=sales.getPaymentList();
		ArrayList<ReceiptPO> receipt=sales.getAll();
		
		try {
			Date current = new Date();
			DateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
			String filename = "src/main/java/ser/sales"+formatter2.format(current)+".xls";
			WritableWorkbook workBook=Workbook.createWorkbook(
					new File(filename));
			WritableSheet sheet=workBook.createSheet("First sheet",0);
			Label type=new Label(0,0,"单据类型");
			sheet.addCell(type);
			Label date=new Label(1,0,"建单日期");
			sheet.addCell(date);
			Label creator=new Label(2,0,"建单人");
			sheet.addCell(creator);
			Label amount=new Label(3,0,"金额");
			sheet.addCell(amount);
			for(int i=0;i<receipt.size();i++){
				ReceiptPO temp=receipt.get(i);
				Label in_type=new Label(0,i+1,temp.getType());
				Label in_date=new Label(1,i+1,temp.getCreateDate());
				Label in_creator=new Label(2,i+1,temp.getCreator());
				Label in_amount=new Label(3,i+1,String.valueOf(temp.getAmount()));
				sheet.addCell(in_type);
				sheet.addCell(in_date);
				sheet.addCell(in_creator);
				sheet.addCell(in_amount);
			}
			workBook.write();
			workBook.close();
			
			return true;
		} catch (WriteException e) {
		
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean createCostBenefitReport(CostBenefitPO cb){
		try {
			Date current = new Date();
			DateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
			String filename = "src/main/java/ser/CostBenefit"+formatter2.format(current)+".xls";
			WritableWorkbook workBook=Workbook.createWorkbook(
					new File(filename));
			
			System.out.println("in creating report");

			WritableSheet sheet=workBook.createSheet("First sheet", 0);
			Label name=new Label(0,0,"项目");
			sheet.addCell(name);
			Label content=new Label(1,0,"内容");
			sheet.addCell(content);
			Label in=new Label(0,1,"总收入");
			sheet.addCell(in);
			Label out=new Label(0,2,"总支出");
			sheet.addCell(out);
			Label bene=new Label(0,3,"总利润");
			sheet.addCell(bene);
			
			Label in_data=new Label(1,1, String.valueOf(cb.getTotalIncome()));
			Label out_data=new Label(1,2, String.valueOf(cb.getTotalPayment()));
			Label bene_data=new Label(1,3, String.valueOf(cb.getProfit()));
			sheet.addCell(in_data);
			sheet.addCell(out_data);
			sheet.addCell(bene_data);
			
			workBook.write();
			workBook.close();
				
			System.out.println("report generated");
			return true;
		} catch (WriteException e){
			
			e.printStackTrace();
			return false;
			
		} catch (IOException e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean createBillReport(BillManagementPO bm){
		
		ArrayList<UserPO> users=bm.getUsers();
	    ArrayList<CarPO> carlist=bm.getCars();
	    ArrayList<DriverPO> driverlist=bm.getDrivers();
	    ArrayList<CommodityPO> commolist=bm.getCommoditys();
	    ArrayList<BankAccountPO> accountlist=bm.getAccounts();
		
		try {
			Date current = new Date();
			DateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
			String filename = "src/main/java/ser/billmanagement"+formatter2.format(current)+".xls";
			WritableWorkbook workBook=Workbook.createWorkbook(
					new File(filename));
			WritableSheet employees=workBook.createSheet("人员", 0);
			WritableSheet cars=workBook.createSheet("车辆", 1);
			WritableSheet commos=workBook.createSheet("库存", 2);
			WritableSheet accounts=workBook.createSheet("银行账户", 3);
			
			Label dep=new Label(0,0,"部门");
			Label pos=new Label(0,1,"职务");
			Label em_name=new Label(0,2,"姓名");
			employees.addCell(dep);
			employees.addCell(pos);
			employees.addCell(em_name);
			
			Label car_num=new Label(0,0,"车辆编号");
			Label car_dep=new Label(0,1,"所属部门");
			cars.addCell(car_num);
			cars.addCell(car_dep);
			
			Label comm_num=new Label(0,0,"货物编号");
			Label area=new Label(0,1,"所属区");
			Label col=new Label(0,2,"所属排");
			Label slot=new Label(0,3,"所属位");
			commos.addCell(comm_num);
			commos.addCell(area);
			commos.addCell(col);
			commos.addCell(slot);
			
			Label acc_name=new Label(0,0,"账户名");
			accounts.addCell(acc_name);
					
			for(int i=0;i<users.size();i++){
				UserPO temp=users.get(i);
				Label tmpdep=new Label(i+1,0,temp.getHallId());
				Label tmppos=new Label(i+1,1,temp.getJob());
				Label tmpname=new Label(i+1,2,temp.getName());
				employees.addCell(tmpdep);
				employees.addCell(tmppos);
				employees.addCell(tmpname);
			}
			
			for(int i=0;i<carlist.size();i++){
				CarPO temp=carlist.get(i);
				Label tmpid=new Label(i+1,0,temp.getID());
				Label tmploc=new Label(i+1,1,temp.getLocation());
				cars.addCell(tmpid);
				cars.addCell(tmploc);
			}
			
			for(int i=0;i<commolist.size();i++){
				CommodityPO temp=commolist.get(i);
				Label tmpnum=new Label(i+1,0,temp.getID());
				Label tmparea=new Label(i+1,1,temp.getLocation());
				commos.addCell(tmpnum);
				commos.addCell(tmparea);
				/*
				 * PO和界面图不一样orz
				 * */
				
			}
			return true;
		} catch(WriteException e){
			
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
			
		}
	}
	
}

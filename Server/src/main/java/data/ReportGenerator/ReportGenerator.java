package data.ReportGenerator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

	public void createSalesReport(SalesPO sales){
		
		ArrayList<IncomePO> income=sales.getIncomeList();
		ArrayList<PaymentPO> payment=sales.getPaymentList();
		ArrayList<ReceiptPO> receipt=sales.getAll();
		
		try {
			WritableWorkbook workBook=Workbook.createWorkbook(
					new File("src/ser/report.xls"));
			WritableSheet sheet=workBook.createSheet("First sheet",0);
			Label type=new Label(0,0,"但据类型");
			sheet.addCell(type);
			Label date=new Label(1,0,"建单日期");
			sheet.addCell(date);
			Label creator=new Label(2,0,"建单人");
			sheet.addCell(creator);
			Label amount=new Label(3,0,"金额");
			sheet.addCell(amount);
			
			for(int i=0;i<receipt.size();i++){
				ReceiptPO temp=income.get(i);
				Label in_type=new Label(i+1,0,temp.getType());
				Label in_date=new Label(i+1,1,temp.getCreateDate());
				Label in_creator=new Label(i+1,2,temp.getCreator());
				Label in_amount=new Label(i+1,3,String.valueOf(temp.getAmount()));
				sheet.addCell(in_type);
				sheet.addCell(in_date);
				sheet.addCell(in_creator);
				sheet.addCell(in_amount);
			}
			workBook.write();
			workBook.close();
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createCostBenefitReport(CostBenefitPO cb){
		try {
			WritableWorkbook workBook=Workbook.createWorkbook(
					new File("src/ser/costbenefit.xls"));
			WritableSheet sheet=workBook.createSheet("First sheet", 0);
			Label name=new Label(0,0,"项目");
			sheet.addCell(name);
			Label content=new Label(1,0,"内容");
			sheet.addCell(content);
			Label in=new Label(0,1,"总收入");
			sheet.addCell(in);
			Label out=new Label(0,2,"总支出");
			sheet.addCell(out);
			Label bene=new Label(0,2,"总利润");
			sheet.addCell(bene);
			
			Label in_data=new Label(1,1, String.valueOf(cb.getTotalIncome()));
			Label out_data=new Label(1,2, String.valueOf(cb.getTotalPayment()));
			Label bene_data=new Label(1,3, String.valueOf(cb.getProfit()));
			sheet.addCell(in_data);
			sheet.addCell(out_data);
			sheet.addCell(bene_data);
			
			workBook.write();
			workBook.close();
			
		} catch (WriteException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createBillReport(BillManagementPO bm){
		
		ArrayList<UserPO> users=bm.getUsers();
	    ArrayList<CarPO> carlist=bm.getCars();
	    ArrayList<DriverPO> driverlist=bm.getDrivers();
	    ArrayList<CommodityPO> commolist=bm.getCommoditys();
	    ArrayList<BankAccountPO> accountlist=bm.getAccounts();
		
		try {
			WritableWorkbook workBook=Workbook.createWorkbook(
					new File("src/ser/billmanagement.xls"));
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
				Label tmpdep=new Label(i+1,0,temp.getCenter().getName());
				Label tmppos=new Label(i+1,1,temp.getPosition());
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
			
		} catch(WriteException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

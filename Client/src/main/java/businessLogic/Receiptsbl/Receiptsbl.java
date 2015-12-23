package businessLogic.Receiptsbl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Miscellaneous.FormType;
import Miscellaneous.ReceiptState;
import businessLogic.Approvalbl.Approvalbl;
import businessLogic.BankAccountbl.BankAccountbl;
import businessLogic.CarAndDriverbl.CarAndDriverbl;
import businessLogic.LogisticsInfoSearchbl.LogisticsInfoSearchbl;
import businessLogic.Receiptsbl.MockTest.MockCarAndDriver;
import businessLogic.Userbl.Apartmentbl;
import businessLogic.Userbl.Userbl;
import businessLogicService.ApprovalblService.ApprovalblService;
import businessLogicService.BankAccountblService.BankAccountblService;
import businessLogicService.CarAndDriverblService.CarAndDriverblService;
import businessLogicService.LogisticsInfoSearchblService.LogisticsInfoSearchblService;
import businessLogicService.ReceiptsblService.ReceiptsblService;
import businessLogicService.UserblService.ApartmentblService;
import businessLogicService.UserblService.UserblService;
import dataService.DataFactoryService.DataFactory;
import dataService.DataFactoryService.DataFactoryService;
import dataService.ReceiptsdataService.ReceiptsdataService;
import init.Client;
import po.ApprovalPO;
import po.HallPO;
import po.ReceiptPO;
import po.receipts.LoadingPO;
import vo.BankAccountVO;
import vo.LogisticsVO;
import vo.ReceiptVO;
import vo.UserVO;
import vo.receipts.LoadingVO;

public class Receiptsbl implements ReceiptsblService {
	private UserblService user;
	private DataFactoryService dataFactory;
	private CarAndDriverblService carAndDriver;
	private ApartmentblService apartment;
	private ApprovalblService approval;
	private LogisticsInfoSearchblService logistics;
	private BankAccountblService account;
	
	public Receiptsbl(UserblService user){
		this.user = user;
		carAndDriver = new CarAndDriverbl();
		apartment = new Apartmentbl();
		approval = new Approvalbl();
		logistics = new LogisticsInfoSearchbl();
		dataFactory = Client.dataFactory;
		account = new BankAccountbl();
	}
	
	public List<String> getHallNameListByAddress(String string) {
		// TODO Auto-generated method stub
		return apartment.getHallNameListByAddress(string);
	}
	
	
	public String showVouchers() {
		return null;
	}
	
	public double getPrice() {
		return 0;
	}

	public String getLastId(String foreId) {
		// TODO Auto-generated method stub
		long num = dataFactory.getReceiptsdataService().getLastId(foreId);
		return String.format("%05d", num);
	}
	
	public String getHallId() {
		return user.getHallId();
	}
	
	public String getFormName(FormType type){
		return user.getHallName()+type.toString();
	}
	
	public String getCurrentTime(){
		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}
	
	public String changeDateFormat(String date){
		DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
		try {
			return formatter2.format(formatter1.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
			return null;	
		}
	}

	public String getHallPlace() {
		return user.getHallPlace();
	}

	public String getHallName() {
		return user.getHallName();
	}
	
	public boolean addReceipt(ReceiptVO vo) {
		ReceiptPO po = vo.toPO(addReceiptId());
		dataFactory.getReceiptsdataService().insert(po);
		approvalInsert(po);
		return true;
	}
	
	public ReceiptVO getReceiptById(long receiptId) {
		ReceiptPO po = dataFactory.getReceiptsdataService().find("receiptId",String.valueOf(receiptId));
		return null;
	}

	private long addReceiptId() {
		// TODO Auto-generated method stub
		return dataFactory.getReceiptsdataService().addReceiptId();
	}

	/**
	 * 单据审批相关
	 * @param vo
	 * @return
	 */
	private boolean approvalInsert(ReceiptPO po){
		return false;
//		ApprovalPO app = new ApprovalPO(po.getName(),po.getCreator(),ReceiptState.未审批,po.getReceiptId());
//		return approval.insert(app);
	}

	public boolean findCarAndDriver(String type, String known) {
		return carAndDriver.find(type,known);
	}

	public UserVO findUser(String supervisor) {
		return user.findUser("name",supervisor);
		// TODO Auto-generated method stub
	}

	public boolean findLogistics(String s) {
		LogisticsVO vo = logistics.search(s);
		if (vo == null) return false;
		return true;
	}

	public double getLoadingCost() {
		// TODO Auto-generated method stub
		return 20;
	}

	public boolean findAccount(String s) {
		BankAccountVO vo = account.find(s);
		if (vo == null) return false;
		return true;
	}


}


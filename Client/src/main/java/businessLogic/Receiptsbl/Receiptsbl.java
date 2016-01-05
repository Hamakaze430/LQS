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
import businessLogic.Strategybl.Constantbl.Constantbl;
import businessLogic.Userbl.Apartmentbl;
import businessLogic.Userbl.Userbl;
import businessLogicService.ApprovalblService.ApprovalblService;
import businessLogicService.BankAccountblService.BankAccountblService;
import businessLogicService.CarAndDriverblService.CarAndDriverblService;
import businessLogicService.LogisticsInfoSearchblService.LogisticsInfoSearchblService;
import businessLogicService.ReceiptsblService.ReceiptsblService;
import businessLogicService.StrategyblService.ConstantblService;
import businessLogicService.UserblService.ApartmentblService;
import businessLogicService.UserblService.UserblService;
import dataService.DataFactoryService.DataFactory;
import dataService.DataFactoryService.DataFactoryService;
import dataService.ReceiptsdataService.ReceiptsdataService;
import init.Client;
import po.ApprovalPO;
import po.HallPO;
import po.LogisticsPO;
import po.ReceiptPO;
import po.receipts.ArrivalPO;
import po.receipts.DeliverPO;
import po.receipts.IncomePO;
import po.receipts.LoadingPO;
import po.receipts.PaymentPO;
import po.receipts.ReceivePO;
import po.receipts.SendPO;
import po.receipts.StorageInPO;
import po.receipts.StorageOutPO;
import po.receipts.TransferPO;
import vo.BankAccountVO;
import vo.ConstantVO;
import vo.LogisticsVO;
import vo.ReceiptVO;
import vo.UserVO;
import vo.receipts.ArrivalVO;
import vo.receipts.DeliverVO;
import vo.receipts.IncomeVO;
import vo.receipts.LoadingVO;
import vo.receipts.PaymentVO;
import vo.receipts.ReceiveVO;
import vo.receipts.SendVO;
import vo.receipts.StorageInVO;
import vo.receipts.StorageOutVO;
import vo.receipts.TransferVO;

public class Receiptsbl implements ReceiptsblService {
	private UserblService user;
	private DataFactoryService dataFactory;
	private CarAndDriverblService carAndDriver;
	private ApartmentblService apartment;
	private ApprovalblService approval;
	private LogisticsInfoSearchblService logistics;
	private BankAccountblService account;
	private ConstantblService constant;
	public Receiptsbl(UserblService user){
		this.user = user;
		carAndDriver = new CarAndDriverbl();
		apartment = new Apartmentbl();
		approval = new Approvalbl();
		dataFactory = Client.dataFactory;
		logistics = new LogisticsInfoSearchbl();
		constant = new Constantbl();
	}
	public Receiptsbl(){
		dataFactory = Client.dataFactory;
		logistics = new LogisticsInfoSearchbl();
		account = new BankAccountbl();
	}
	
	public List<String> getHallNameListByAddress(String type, String string) {
		// TODO Auto-generated method stub
		return apartment.getHallNameListByAddress(type,string);
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
		if (foreId.length() == 14) return String.format("%05d", num);
		else return String.format("%07d", num);
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
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(df.format(date));
		ApprovalPO app = new ApprovalPO(po.getName(),df.format(date),ReceiptState.未审批,po.getReceiptId());
		return approval.insert(app);
//		
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

	public double getLoadingCost(double v) {
		// TODO Auto-generated method stub
		ConstantVO vo = constant.getConstant();
		return Double.parseDouble(vo.getVanCost())*30*v/1000;
	}

	public boolean findAccount(String s) {
		BankAccountVO vo = account.find(s);
		if (vo == null) return false;
		return true;
	}

	public double getTransferCost(String traffic, String hallPlace, String endPlace) {
		// TODO Auto-generated method stub
		if (traffic.equals("plane")) return 100;
		else if (traffic.equals("railway")) return 50;
		return 10;
	}

	public ReceiptVO getLoadingOrTransferVO(String id) {
		// TODO Auto-generated method stub
		ReceiptPO po = dataFactory.getReceiptsdataService().find("LoadingOrTransferId", id);
		if (po == null) return null;
		if (po.getType().equals("装车单")){
			return new LoadingVO((LoadingPO)po);
		}
		if (po.getType().equals("中转单")){
			return new TransferVO((TransferPO)po);
		}
		return null;
	}

	public String getHallName(String hallId) {
		return apartment.getName(hallId);
	}

	public double getSendCost(String expresstype, String start, String end, String weight, String volume) {
		// TODO Auto-generated method stub
		double ans= Double.max(Double.parseDouble(weight)/1000, Double.parseDouble(volume)/5000000);
		//System.out.println(ans);
		ConstantVO vo = constant.getConstant();
		if (expresstype.equals("经济快递")){ans *= Double.parseDouble(vo.getPriceLow());}
		else if (expresstype.equals("标准快递")){ans *= Double.parseDouble(vo.getPriceStandard());}
		else if (expresstype.equals("特快")){ans *= Double.parseDouble(vo.getPriceHigh());}
	//	System.out.println(ans);
		List<String> cities = vo.getCityList();
		int i = 0, j = 0;
		for (int k = 0; k < cities.size(); k++){
			if (cities.get(k).equals(start)) i = k;
			if (cities.get(k).equals(end)) j = k;
		}
		//System.out.println(i+" "+ j);
		String temp = vo.getCityDistance().get(i);
		String[] split = temp.split(" ");
		//System.out.println(split[j]);
		ans *= Double.parseDouble(split[j])/1000;
		return ans;
	}
	public boolean pass(long receiptId) {
		ReceiptPO po = dataFactory.getReceiptsdataService().find("receiptId", String.valueOf(receiptId));
		ReceiptVO vo = poToVO(po);
		String s = po.getType();
		if (s.equals("寄件单")) logistics.newLogisticsInfo(vo);
		else logistics.addState(vo);
		
		if (s.equals("入库单")){}
		if (s.equals("出库单")){}
		
		if (s.equals("收款单")){account.incMoney(((IncomeVO)vo).getAmount());}
		if (s.equals("付款单")){account.decMoney(((PaymentVO)vo).getAccount(),((PaymentVO)vo).getAmount());}
		
		return true;
	}
	/*寄件单,
	装车单,
	到达单,
	中转单,
	出库单,
	入库单,
	收款单,
	付款单,
	派件单,
	收件单,*/
	private ReceiptVO poToVO(ReceiptPO po) {
		String s = po.getType();
		if (s.equals("寄件单")) return new SendVO((SendPO)po);
		if (s.equals("装车单")) return new LoadingVO((LoadingPO)po);
		if (s.equals("到达单")) return new ArrivalVO((ArrivalPO)po);
		if (s.equals("中转单")) return new TransferVO((TransferPO)po);	
		if (s.equals("出库单")) return new StorageOutVO((StorageOutPO)po);
		if (s.equals("入库单")) return new StorageInVO((StorageInPO)po);
		if (s.equals("收款单")) return new IncomeVO((IncomePO)po);
		if (s.equals("付款单")) return new PaymentVO((PaymentPO)po);
		if (s.equals("派件单")) return new DeliverVO((DeliverPO)po);
		if (s.equals("收件单")) return new ReceiveVO((ReceivePO)po);	
		return null;
	}
	public ReceiptVO getSendVO(String s) {
		ReceiptPO po = dataFactory.getReceiptsdataService().find("send", s);
		if (po == null) return null;
		return poToVO(po);
	}


}


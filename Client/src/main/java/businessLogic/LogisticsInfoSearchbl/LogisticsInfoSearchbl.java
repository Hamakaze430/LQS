package businessLogic.LogisticsInfoSearchbl;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import businessLogic.Userbl.UserManagerbl;
import businessLogic.Userbl.Userbl;
import businessLogicService.LogisticsInfoSearchblService.LogisticsInfoSearchblService;
import businessLogicService.UserblService.UserManagerblService;
import businessLogicService.UserblService.UserblService;
import dataService.DataFactoryService.DataFactory;
import dataService.DataFactoryService.DataFactoryService;
import init.Client;
import init.RMIHelper;
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

public class LogisticsInfoSearchbl implements LogisticsInfoSearchblService {
	private DataFactoryService dataFactory;
	private UserManagerblService userbl;
	public LogisticsInfoSearchbl(){
		dataFactory = Client.dataFactory;
		userbl = new UserManagerbl();
	}
	public LogisticsVO search(String id) {		
		LogisticsPO po = dataFactory.getLogisticsDataService().find(id);
		if (po == null) return null;
		LogisticsVO vo = new LogisticsVO(po.getId(), po.getCurrentState(), po.getState());
		return vo;
	}
	public void newLogisticsInfo(ReceiptVO vo) {
		// TODO Auto-generated method stub
		UserVO creator = userbl.findUserByName(vo.getCreator());
		UserblService user = new Userbl(creator.getID());
		if (vo.getType().equals("寄件单")){
			List<String> states = new ArrayList<String>();
			String state = "【"+user.getHallPlace()+"】"+user.getHallName()+"快递员"+user.getUserName()+"已收件";
			state += "\n         "+ getTime();
			states.add(state);
			LogisticsPO po = new LogisticsPO(((SendVO)vo).getOrder(),state,states);
			dataFactory.getLogisticsDataService().insert(po);
		}
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
	public void addState(ReceiptVO vo) {
		// TODO Auto-generated method stub
		UserVO creator = userbl.findUserByName(vo.getCreator());
		UserblService user = new Userbl(creator.getID());
		String s = vo.getType();
		String state = "";
		if (s.equals("寄件单")) return;
		if (s.equals("收款单")) return;
		if (s.equals("付款单")) return;
		if (s.equals("装车单")) {
			state = "【"+user.getHallPlace()+"】"+"从"+user.getHallName()+"发出";
			addState(((LoadingVO)vo).getOrder(),state);
			return;
		}
		if (s.equals("到达单")) {
			state = "【"+user.getHallPlace()+"】"+"到达"+user.getHallName();
			addState(((ArrivalVO)vo).getOrders(),state);
			return;
		}
		if (s.equals("中转单")) {
			state = "【"+user.getHallPlace()+"】"+"从"+user.getHallName()+"发出";
			addState(((TransferVO)vo).getOrders(),state);
			return;
		}
		if (s.equals("出库单")) {
			state = "【"+user.getHallPlace()+"】"+"从"+user.getHallName()+"出库";
			addState(((StorageOutVO)vo).getId(),state);
			return;
		}
		if (s.equals("入库单")) {
			state = "【"+user.getHallPlace()+"】"+"从"+user.getHallName()+"入库";
			addState(((StorageInVO)vo).getId(),state);
			return;
		}
		if (s.equals("派件单")) {
			state = "【"+user.getHallPlace()+"】"+"快递员"+user.getUserName()+"正在派送";
			addState(((DeliverVO)vo).getOrder(),state);
			return;
		}
		if (s.equals("收件单")) {
			state = "【"+user.getHallPlace()+"】"+"收件人"+((ReceiveVO)vo).getReceiver()+"已签收";
			addState(((ReceiveVO)vo).getId(),state);
			return;
		}
		
	}
	private void addState(String order, String state) {
		// TODO Auto-generated method stub
		state += "\n         "+ getTime();
		dataFactory.getLogisticsDataService().addState(order,state);
	}
	private void addState(List<String> order, String state) {
		// TODO Auto-generated method stub
		state += "\n         "+ getTime();
		dataFactory.getLogisticsDataService().addState(order,state);
	}
	private String getTime(){
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}

}

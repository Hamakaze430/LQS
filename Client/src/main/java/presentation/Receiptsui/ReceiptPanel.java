package presentation.Receiptsui;

import javax.swing.JPanel;

import businessLogic.Receiptsbl.Receiptsbl;
import businessLogic.Userbl.Userbl;
import businessLogicService.ReceiptsblService.ReceiptsblService;
import vo.FormType;

public class ReceiptPanel extends JPanel{
	/**
	 * 
	 */	
	private static final long serialVersionUID = 1L;
	public ReceiptsblService bl;
	public ReceiptPanel(Userbl user){
		bl = new Receiptsbl(user);
		
	}
	public void newReceipt(FormType type){
		switch(type){
		case 寄件单: break;
		case 装车单: this.add(new LoadingPanel(bl));
		case 营业厅到达单: break;
		case 中转单: break;
		case 中转中心到达单: break;
		case 出库单: break;
		case 入库单: break;
		case 收款单: break;
		case 付款单: break;
		case 派件单: break;
		case 收件单: break;
		}
	}
	
}

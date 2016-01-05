package init;

import javax.swing.JOptionPane;

import businessLogic.BankAccountbl.BankAccountbl;
import businessLogic.CarAndDriverbl.CarAndDriverbl;
import businessLogic.Receiptsbl.Receiptsbl;
import businessLogic.Userbl.Userbl;
import businessLogic.Userbl.stub.UserblStub;
import businessLogicService.BankAccountblService.BankAccountblService;
import businessLogicService.UserblService.UserblService;
import dataService.DataFactoryService.DataFactory;
import dataService.DataFactoryService.DataFactoryService;
import presentation.Userui.MainPanel;
import presentation.mainui.MainFrame;
import vo.BankAccountVO;
import vo.CarVO;
import vo.DriverVO;

public class Client {
	public static MainFrame frame;
	public static DataFactoryService dataFactory;
	public static void main(String[] args){

		try {
			RMIHelper.init();
			dataFactory = new DataFactory();
			//02500001000 营业厅业务员
			//02500000000快递员
			//00000001001低级财务人员
			//00000001000高级财务人员
			//01000010000中转中心仓库
			//02500011000中转中心业务员
			//00000000000
//			BankAccountblService bank = new BankAccountbl();
//			bank.addBankAccount(new BankAccountVO ("123456","bgydvsf",1000));
			frame = new MainFrame();
			UserblService bl = new Userbl("02500011000");
			MainPanel panel = new MainPanel(bl);
			frame.add(panel);
//			frame.addWelcomePanel();
//			UserblService bl = new Userbl("00000000000");
//			MainPanel panel = new MainPanel(bl);
//			frame.add(panel);
			//frame.addWelcomePanel();
			frame.setVisible(true);
		} catch (ClientInitException e) {
			 e.printStackTrace();
	            JOptionPane.showMessageDialog(
	                    null,
	                    "Client boots fail!\nCause: " + e.getMessage(),
	                    "Fatal Error",
	                    JOptionPane.ERROR_MESSAGE
	            );
		}
	}

}

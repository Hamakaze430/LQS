package init;

import javax.swing.JOptionPane;

import businessLogic.BankAccountbl.BankAccountbl;
import businessLogic.CarAndDriverbl.CarAndDriverbl;
import businessLogic.Receiptsbl.Receiptsbl;
import businessLogic.Strategybl.Role;
import businessLogic.Strategybl.Salarybl.Salarybl;
import businessLogic.Userbl.Userbl;
import businessLogic.Userbl.stub.UserblStub;
import businessLogicService.BankAccountblService.BankAccountblService;
import businessLogicService.StrategyblService.SalaryblService;
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
			frame = new MainFrame();
			UserblService user = new Userbl("02500001000");
			MainPanel panel = new MainPanel(user);
			frame.add(panel);
//			frame.addWelcomePanel();
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

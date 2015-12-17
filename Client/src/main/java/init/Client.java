package init;

import javax.swing.JOptionPane;

import businessLogic.Userbl.Userbl;
import businessLogic.Userbl.stub.UserblStub;
import businessLogicService.UserblService.UserblService;
import dataService.DataFactoryService.DataFactory;
import dataService.DataFactoryService.DataFactoryService;
import presentation.Userui.MainPanel;
import presentation.mainui.MainFrame;

public class Client {
	public static MainFrame frame;
	public static DataFactoryService dataFactory;
	public static void main(String[] args){

		try {
			RMIHelper.init();
		//	System.out.println("Success");
			dataFactory = new DataFactory();
			frame = new MainFrame();

//			UserblService bl = new Userbl("admin");
			//UserblService bl = new Userbl("02500111000");
			UserblService bl = new Userbl("02500000000");
			MainPanel panel = new MainPanel(bl);
			frame.add(panel);
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

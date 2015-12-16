package init;

import javax.swing.JOptionPane;

import businessLogic.Userbl.Userbl;
<<<<<<< HEAD
=======
import businessLogic.Userbl.stub.UserblStub;
>>>>>>> 80a8df67e7c806ac0da4fde6635b900cda58c540
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
<<<<<<< HEAD
			UserblService bl = new Userbl("02500111000");
			MainPanel panel = new MainPanel(bl);
			frame.add(panel);
			//frame.addWelcomePanel();
=======
//			UserblService bl = new Userbl("admin");
//			MainPanel panel = new MainPanel(bl);
//			frame.add(panel);
			frame.addWelcomePanel();
>>>>>>> 80a8df67e7c806ac0da4fde6635b900cda58c540
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

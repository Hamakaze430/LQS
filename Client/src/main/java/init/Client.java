package init;

import javax.swing.JOptionPane;

import businessLogic.Userbl.Userbl;
<<<<<<< HEAD
import businessLogic.Userbl.stub.UserblStub;
=======
>>>>>>> fc0a233d8c39f59bf1df42609f97bd22e8bc1a04
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

//			UserblService bl = new Userbl("admin");
//			MainPanel panel = new MainPanel(bl);
//			frame.add(panel);
			//frame.addWelcomePanel();

=======
			UserblService bl = new Userbl("02500001000");
			//UserblService bl = new Userbl("admin");
			MainPanel panel = new MainPanel(bl);
			frame.add(panel);
		//	frame.addWelcomePanel();
>>>>>>> fc0a233d8c39f59bf1df42609f97bd22e8bc1a04
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

package init;

import javax.swing.JOptionPane;

import businessLogic.Userbl.Loginbl;
import businessLogicService.UserblService.LoginblService;
import presentation.Userui.LoginPanel;
import presentation.mainui.MainFrame;

public class Client {
	public static MainFrame frame;
	public static void main(String[] args){
<<<<<<< HEAD
		try {
			RMIHelper.init();
			System.out.println("Success");
			frame = new MainFrame();
			frame.addWelcomePanel();
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
//		frame = new MainFrame();
//		frame.addWelcomePanel();
//		frame.setVisible(true);
=======
//		try {
//			RMIHelper.init();
//			new MainFrame();
//		} catch (ClientInitException e) {
//			 e.printStackTrace();
//	            JOptionPane.showMessageDialog(
//	                    null,
//	                    "Client boots fail!\nCause: " + e.getMessage(),
//	                    "Fatal Error",
//	                    JOptionPane.ERROR_MESSAGE
//	            );
//		}
		frame = new MainFrame();
		LoginblService bl = new Loginbl();
		frame.add(new LoginPanel(bl));
		//frame.addWelcomePanel();
		frame.setVisible(true);
>>>>>>> 6628ac314f99ded4799782b5734186c50147dc20
	}
}

package init;

import javax.swing.JOptionPane;

import businessLogic.Userbl.Loginbl;
import businessLogicService.UserblService.LoginblService;
import presentation.Userui.LoginPanel;
import presentation.mainui.MainFrame;
import presentation.mainui.WelcomePanel;

public class Client {
	public static MainFrame frame;
	public static void main(String[] args){
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
		frame.add(new WelcomePanel());
		//frame.addWelcomePanel();
		frame.setVisible(true);
	}
}

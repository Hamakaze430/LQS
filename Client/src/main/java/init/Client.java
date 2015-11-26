package init;

import javax.swing.JOptionPane;

import presentation.mainui.MainFrame;

public class Client {
	public static MainFrame frame;
	public static void main(String[] args){
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
	}
}

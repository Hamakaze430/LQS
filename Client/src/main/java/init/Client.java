package init;

import javax.swing.JOptionPane;

import presentation.mainui.MainFrame;

public class Client {
	public static void main(String[] args){
		try {
			RMIHelper.init();
			new MainFrame();
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

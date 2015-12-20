package init;

import javax.swing.JOptionPane;

import businessLogic.CarAndDriverbl.CarAndDriverbl;
import businessLogic.Userbl.Userbl;
import businessLogic.Userbl.stub.UserblStub;
import businessLogicService.UserblService.UserblService;
import dataService.DataFactoryService.DataFactory;
import dataService.DataFactoryService.DataFactoryService;
import presentation.Userui.MainPanel;
import presentation.mainui.MainFrame;
import vo.CarVO;
import vo.DriverVO;

public class Client {
	public static MainFrame frame;
	public static DataFactoryService dataFactory;
	public static void main(String[] args){

		try {
			RMIHelper.init();
			dataFactory = new DataFactory();
//			DriverVO vo = new DriverVO("025000001","张三","男","2015.10.30","320582201510301111","18260065397","一年");
//			CarAndDriverbl car = new CarAndDriverbl();
//			car.addDriverInfo(vo);
			frame = new MainFrame();
<<<<<<< HEAD

			UserblService bl = new Userbl("admin");
			MainPanel panel = new MainPanel(bl);
			frame.add(panel);
=======
			UserblService bl = new Userbl("02500001000");
			MainPanel panel = new MainPanel(bl);
			frame.add(panel);
			
>>>>>>> 53bb2ae242dfc910e1ced7c53f2a8cc23ea37739
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

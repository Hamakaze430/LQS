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
			CarVO vo = new CarVO("025001000","苏A 12345","一年");
			CarAndDriverbl car = new CarAndDriverbl();
			car.addCarInfo(vo);
			frame = new MainFrame();
			UserblService bl = new Userbl("02500101000");
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

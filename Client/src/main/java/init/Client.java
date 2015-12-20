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

public class Client {
	public static MainFrame frame;
	public static DataFactoryService dataFactory;
	public static void main(String[] args){

		try {
			RMIHelper.init();
			dataFactory = new DataFactory();
			frame = new MainFrame();

			UserblService bl = new Userbl("02500001000");
			MainPanel panel = new MainPanel(bl);
			frame.add(panel);
			//frame.addWelcomePanel();
			CarAndDriverbl car = new CarAndDriverbl();
			CarVO vo = new CarVO("025000001","苏A 00000","一年");
			car.addCarInfo(vo);
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

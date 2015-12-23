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
//			CarVO vo = new CarVO("025001000","苏A 12345","一年");
//			CarAndDriverbl car = new CarAndDriverbl();
//			car.addCarInfo(vo);
//			CarVO vo = new CarVO("0250000001","苏A 00000","1年");
//			DriverVO vo = new DriverVO("025000001","张三","男","2015.10.30","320582201510301111","18260065397","一年");
//			CarAndDriverbl car = new CarAndDriverbl();
//			car.addCarInfo("2014-6-1", vo);
//			car.addDriverInfo(vo);
			//02500001000 营业厅业务员
			//02500000000快递员
			//00000001001低级财务人员
			//00000001000高级财务人员
			//01000010000中转中心仓库
			//02500011000中转中心业务员
			
			frame = new MainFrame();
			UserblService bl = new Userbl("02500001000");
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

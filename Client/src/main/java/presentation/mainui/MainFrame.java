package presentation.mainui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import businessLogic.CarAndDriverbl.CarAndDriverbl;
import businessLogic.CarAndDriverbl.stub.CarAndDriverblStub;
import businessLogic.LogisticsInfoSearchbl.stub.LogisticsInfoSearchblStub;
import businessLogic.Receiptsbl.stub.ReceiptsblStub;
import businessLogicService.CarAndDriverblService.CarAndDriverblService;
import businessLogicService.LogisticsInfoSearchblService.LogisticsInfoSearchblService;
import businessLogicService.ReceiptsblService.ReceiptsblService;
import presentation.CarAndDriverui.CarAndDriverui;
import presentation.LogisticsInfoSearchui.LogisticsInfoSearchui;
import presentation.Receiptsui.Receiptsui;
import vo.HallVO;
import vo.UserVO;

public class MainFrame extends JFrame {
		public MainFrame(){
			
			this.setSize(1024, 768);
			this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			
//			CarAndDriverblService bl = new CarAndDriverblStub();
//			CarAndDriverui panel = new CarAndDriverui(bl);
			
//			LogisticsInfoSearchblService bl = new LogisticsInfoSearchblStub();
//			LogisticsInfoSearchui panel = new LogisticsInfoSearchui(bl);
			
//			ReceiptsblService bl = new ReceiptsblStub();
//			HallVO hall = new HallVO("鼓楼营业厅","南京鼓楼","025001");
//			UserVO user = new UserVO("王飞","161250001","asdgdfhghh","营业厅业务员","营业厅业务员",hall);
//			Receiptsui panel = new Receiptsui(bl,user);
			this.add(new WelcomePanel(),BorderLayout.CENTER);
			this.setVisible(true);
		}
}


package presentation.mainui;

import javax.swing.JFrame;

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

public class mainui {
		public static void main(String args[]){
			JFrame frame = new JFrame();
			frame.setSize(1024, 768);
			frame.setLocation(200, 200);//随便写的。居中
			
//			CarAndDriverblService bl = new CarAndDriverblStub();
//			CarAndDriverui panel = new CarAndDriverui(bl);
			
//			LogisticsInfoSearchblService bl = new LogisticsInfoSearchblStub();
//			LogisticsInfoSearchui panel = new LogisticsInfoSearchui(bl);
			
			ReceiptsblService bl = new ReceiptsblStub();
			HallVO hall = new HallVO("鼓楼营业厅","南京鼓楼","025001");
			UserVO user = new UserVO("王飞","161250001","asdgdfhghh","营业厅业务员","营业厅业务员",hall);
			Receiptsui panel = new Receiptsui(bl,user);
			frame.getContentPane().add(panel);
			frame.setVisible(true);
		}
}


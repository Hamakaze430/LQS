package presentation.mainui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import presentation.Receiptsui.ReceiptPanel;
import vo.FormType;
import vo.HallVO;
import vo.UserBaseVO;

public class MainFrame extends JFrame {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public MainFrame(){
			
			this.setSize(1024, 768);
			this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			
//			CarAndDriverblService bl = new CarAndDriverblStub();
//			CarAndDriverui panel = new CarAndDriverui(bl);
			
//			LogisticsInfoSearchblService bl = new LogisticsInfoSearchblStub();
//			LogisticsInfoSearchui panel = new LogisticsInfoSearchui(bl);
			
			
			HallVO hall = new HallVO("鼓楼营业厅","南京鼓楼","025001");
			UserBaseVO user = new UserBaseVO("王飞",hall);
			ReceiptPanel panel = new ReceiptPanel(user);
			panel.newReceipt(FormType.装车单);
			//this.add(new WelcomePanel(),BorderLayout.CENTER);
			this.add(panel);
			this.setVisible(true);
		}
}


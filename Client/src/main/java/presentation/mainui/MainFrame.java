package presentation.mainui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.plaf.FontUIResource;

import Miscellaneous.FormType;
import presentation.CarAndDriverui.CarAndDriverui;
import presentation.LogisticsInfoSearchui.LogisticsPanel;
import vo.HallVO;
import vo.UserBaseVO;

public class MainFrame extends JFrame {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public MainFrame(){
			
			Font font = new Font("宋体",Font.PLAIN,20);
		    FontUIResource fontRes = new FontUIResource(font);
		    for(Enumeration keys = UIManager.getDefaults().keys(); keys.hasMoreElements();){
		        Object key = keys.nextElement();
		        Object value = UIManager.get(key);
		        if(value instanceof FontUIResource)
		            UIManager.put(key, fontRes);
		    }
			
			
			this.setSize(1024, 768);
			//this.setUndecorated(true);
			Image image = new ImageIcon("src/main/java/image/icon.png").getImage();//指定图标文件的相对路径
			this.setIconImage(image);
			this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			this.setTitle("〇一〇快递物流系统");
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			
//			CarAndDriverblService bl = new CarAndDriverblStub();
//			CarAndDriverui panel = new CarAndDriverui(bl);
			
//			LogisticsInfoSearchblService bl = new LogisticsInfoSearchblStub();
//			LogisticsInfoSearchui panel = new LogisticsInfoSearchui(bl);
			
			
//			HallVO hall = new HallVO("鼓楼营业厅","南京鼓楼","025001");
//			UserBaseVO user = new UserBaseVO("王飞",hall);
//			ReceiptPanel panel = new ReceiptPanel(user);
//			panel.newReceipt(FormType.装车单);
//			this.add(panel);
			
		}
		public void addWelcomePanel(){
			this.getContentPane().add(new WelcomePanel());
		}
}


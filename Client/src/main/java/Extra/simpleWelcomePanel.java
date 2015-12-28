package Extra;

import init.Client;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.LogisticsInfoSearchui.LogisticsPanel;
import presentation.Userui.LoginPanel;
import presentation.mainui.PictureButton;
import presentation.mainui.PictureLabel;
import presentation.mainui.WelcomePanel;


public class simpleWelcomePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton logistics;
	private JButton login;
	private Font font1;
	private Font font2;
	public simpleWelcomePanel(){
		this.setSize(1024,768);
		this.setLayout(null);
		init();
	}
	final int BUTTON_WIDTH = 140;
	final int BUTTON_HEIGHT = 30;
	final int RIGHT_PADDING = 100;
	final int BOTTOM_PADDING = 150;
	final int PADDING_HORIZATION = 30;
	private void init() {
		// TODO Auto-generated method stub
		font1 = new Font("黑体",Font.PLAIN,18);
		font2 = new Font("黑体",Font.BOLD,18);
		
		JLabel bg = new PictureLabel("src/main/java/image/3.jpg");
		bg.setBounds(0,0,this.getWidth(),this.getHeight());
		
		JLabel title = new JLabel("〇一〇快递物流系统");
		title.setFont(new Font("宋体",Font.BOLD,72));
		title.setBounds(100, 100, 800, 100);
		
		login = new JButton("用户登录");		
		login.setFont(font1);
		login.setBounds(
				this.getWidth()-RIGHT_PADDING-BUTTON_WIDTH, 
				this.getHeight()-BOTTOM_PADDING-BUTTON_HEIGHT, 
				BUTTON_WIDTH, 
				BUTTON_HEIGHT
		);
		login.setFocusPainted(false);
		login.setContentAreaFilled(false);
		login.addMouseListener(new LoginMouseListener());
		
		logistics = new JButton("物流查询");
		logistics.setFont(font1);
		logistics.setBounds(
				this.getWidth()-RIGHT_PADDING-BUTTON_WIDTH, 
				this.getHeight()-BOTTOM_PADDING-2*BUTTON_HEIGHT-PADDING_HORIZATION, 
				BUTTON_WIDTH, 
				BUTTON_HEIGHT
		);
		logistics.setFocusPainted(false);
		logistics.setContentAreaFilled(false);
		logistics.addMouseListener(new LogisticsMouseListener());
		this.add(login);
		this.add(logistics);
		this.add(title);
		this.add(bg);
		
	}
	class LoginMouseListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			simpleWelcomePanel.this.setVisible(false);
			Client.frame.add(new simpleLoginPanel());
			Client.frame.repaint();
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			login.setFont(font2);
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			login.setFont(font1);
		}

		
	}
	
	class LogisticsMouseListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			simpleWelcomePanel.this.setVisible(false);
			Client.frame.remove(simpleWelcomePanel.this);
			Client.frame.add(new LogisticsPanel());			
			Client.frame.repaint();
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			logistics.setFont(font2);
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			logistics.setFont(font1);
		}

		
	}

}

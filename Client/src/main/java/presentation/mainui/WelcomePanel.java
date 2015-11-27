package presentation.mainui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import businessLogicService.UserblService.LoginblService;
import init.Client;
import presentation.LogisticsInfoSearchui.LogisticsPanel;
import presentation.Userui.LoginPanel;

public class WelcomePanel extends JPanel {
	private JButton logistics;
	private JButton login;
	public WelcomePanel(){	
		
		this.setSize(1024,768);
		//this.setBackground(Color.BLACK);
		this.setLayout(null);
		init();
	}
	
	final int BUTTON_WIDTH = 150;
	final int BUTTON_HEIGHT = 30;
	final int RIGHT_PADDING = 100;
	final int BOTTOM_PADDING = 150;
	final int PADDING_HORIZATION = 30;
	
	private void init() {
		JLabel bg = new PictureLabel("src/main/java/image/WelcomeBG.jpg");
		bg.setBounds(0,0,this.getWidth(),this.getHeight());
		
		login = new JButton();		
		login.setBounds(
				this.getWidth()-RIGHT_PADDING-BUTTON_WIDTH, 
				this.getHeight()-BOTTOM_PADDING-BUTTON_HEIGHT, 
				BUTTON_WIDTH, 
				BUTTON_HEIGHT
		);
		LoginPanel.setIcon("src/main/java/image/login_exited.png",login);
		login.setBorder(null);
		login.setFocusPainted(false);
		login.setContentAreaFilled(false);
		login.addMouseListener(new LoginMouseListener());
		
		logistics = new JButton();
		logistics.setBounds(
				this.getWidth()-RIGHT_PADDING-BUTTON_WIDTH, 
				this.getHeight()-BOTTOM_PADDING-2*BUTTON_HEIGHT-PADDING_HORIZATION, 
				BUTTON_WIDTH, 
				BUTTON_HEIGHT
		);
		LoginPanel.setIcon("src/main/java/image/logistics_exited.png",logistics);
		logistics.setBorder(null);
		logistics.setFocusPainted(false);
		logistics.setContentAreaFilled(false);
		logistics.addMouseListener(new LogisticsMouseListener());
		this.add(login);
		this.add(logistics);
		this.add(bg);
		
		
	}
	class LoginMouseListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			WelcomePanel.this.setVisible(false);
			LoginblService bl = null;
			Client.frame.add(new LoginPanel(bl));
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
			LoginPanel.setIcon("src/main/java/image/login_entered.png",login);
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			LoginPanel.setIcon("src/main/java/image/login_exited.png",login);
		}

		
	}
	
	class LogisticsMouseListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			WelcomePanel.this.setVisible(false);
			Client.frame.remove(WelcomePanel.this);
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
			LoginPanel.setIcon("src/main/java/image/logistics_entered.png",logistics);
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			LoginPanel.setIcon("src/main/java/image/logistics_exited.png",logistics);
		}

		
	}
	
	
}

package presentation.mainui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class WelcomePanel extends JPanel {
	private JButton logistics;
	private JButton login;
	public WelcomePanel(){	
		
		this.setSize(900,600);
		this.setLayout(null);
		init();
	}
	
	final int BUTTON_WIDTH = 100;
	final int BUTTON_HEIGHT = 20;
	final int RIGHT_PADDING = 20;
	final int BOTTOM_PADDING = 15;
	final int PADDING_HORIZATION = 20;
	
	private void init() {
		logistics = new JButton("物流查询");
		login = new JButton("用户登录");
		login.setBounds(
				this.getWidth()-RIGHT_PADDING-BUTTON_WIDTH, 
				this.getHeight()-BOTTOM_PADDING-BUTTON_HEIGHT, 
				BUTTON_WIDTH, 
				BUTTON_HEIGHT
		);
		logistics.setBounds(
				this.getWidth()-RIGHT_PADDING-BUTTON_WIDTH, 
				this.getHeight()-BOTTOM_PADDING-2*BUTTON_HEIGHT-PADDING_HORIZATION, 
				BUTTON_WIDTH, 
				BUTTON_HEIGHT
		);
		login.addMouseListener(new LoginMouseListener());
		logistics.addMouseListener(new LogisticsMouseListener());
		this.add(login);
		this.add(logistics);
		
	}
	class LoginMouseListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		
	}
	
	class LogisticsMouseListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		
	}
	
}

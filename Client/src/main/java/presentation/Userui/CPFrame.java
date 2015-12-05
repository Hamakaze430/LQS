package presentation.Userui;

import init.Client;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.MatteBorder;

import presentation.mainui.PictureButton;
import presentation.mainui.PictureLabel;

public class CPFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CPFrame(){
		JLabel l = new PictureLabel("src/main/java/image/CPbg.png");
		l.setBounds(0, 0, 384, 384);
		this.setSize(384, 384);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		
		JLabel title = new JLabel(">>>>>修改密码");
		title.setBounds(8, 5, 180, 30);
		JLabel old = new JLabel("请输入原始密码(6 - 20 位)：");
		old.setBounds(10, 50, 200, 30);
		
		JPasswordField oldPassword = new JPasswordField(20);
		oldPassword.setBounds(10, 90, 200, 30);		
		oldPassword.setForeground(Color.black);
		oldPassword.setOpaque(false);
		
		
		JLabel newpassword  = new JLabel("请输入新密码(6 - 20 位)：");
		newpassword.setBounds(10, 140, 200, 30);
		
		JPasswordField newPassword = new JPasswordField(20);
		newPassword.setBounds(10, 180, 200, 30);		
		newPassword.setForeground(Color.black);
		newPassword.setOpaque(false);
		
		
		JLabel check  = new JLabel("请再次输入新密码(6 - 20 位)：");
		check.setBounds(10, 230, 220, 30);
		
		JPasswordField checkPassword = new JPasswordField(20);
		checkPassword.setBounds(10, 270, 200, 30);		
		checkPassword.setForeground(Color.black);
		checkPassword.setOpaque(false);
		
		
		JButton confirm = new JButton();
		confirm.setBounds(220, 330, 60, 30);
		PictureButton.setIcon("src/main/java/image/cpButton_unclicked.png", confirm);
		confirm.setBorder(null);
		confirm.setFocusPainted(false);
		confirm.setContentAreaFilled(false);
		confirm.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
				
				
				
				
				
				
				
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/cpButton_clicked.png", (JButton)e.getSource());
			}
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/cpButton_unclicked.png", (JButton)e.getSource());
			}
			
		});
		
		
		JButton exit = new JButton();
		exit.setBounds(300, 330, 60, 30);
		PictureButton.setIcon("src/main/java/image/cpButton2_unclicked.png", exit);
		exit.setBorder(null);
		exit.setFocusPainted(false);
		exit.setContentAreaFilled(false);
		exit.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				Client.frame.setEnabled(true);
				dispose();
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {
				PictureButton.setIcon("src/main/java/image/cpButton2_clicked.png", (JButton)e.getSource());
			}
			public void mouseExited(MouseEvent e) {
				PictureButton.setIcon("src/main/java/image/cpButton2_unclicked.png", (JButton)e.getSource());
			}
			
		});
		
		this.add(title);
		this.add(old);	
		this.add(oldPassword);
		this.add(newPassword);
		this.add(newpassword);
		this.add(checkPassword);
		this.add(check);
		this.add(confirm);
		this.add(exit);
		this.add(l);
		
		
	}

}

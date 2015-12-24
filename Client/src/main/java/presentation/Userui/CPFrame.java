package presentation.Userui;

import init.Client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.MatteBorder;

import businessLogicService.UserblService.UserblService;
import presentation.mainui.PictureButton;
import presentation.mainui.PictureLabel;

public class CPFrame extends JFrame{
	/**
	 * MainPanel下修改密码的子窗口
	 */
	private static final long serialVersionUID = 1L;
	private Font font = new Font("黑体",Font.PLAIN,13); 
	private UserblService userbl;
	private JPasswordField oldPassword;
	private JPasswordField newPassword;
	private JPasswordField checkPassword;
	
	public CPFrame(UserblService user){
		JLabel l = new PictureLabel("src/main/java/image/CPbg.png");
		l.setBounds(0, 0, 384, 384);
		this.setSize(384, 384);
		this.userbl = user;
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		
		JLabel title = new JLabel(">>>>>修改密码");
		title.setBounds(8, 5, 180, 30);
		title.setFont(font);
		JLabel old = new JLabel("请输入原始密码(6 - 20 位)：");
		old.setBounds(10, 50, 200, 30);
		old.setFont(font);
		oldPassword = new JPasswordField(20);
		oldPassword.setBounds(10, 90, 200, 30);		
		oldPassword.setForeground(Color.black);
		oldPassword.setOpaque(false);
		//oldPassword.setFont(font);
		
		JLabel newpassword  = new JLabel("请输入新密码(6 - 20 位)：");
		newpassword.setBounds(10, 140, 200, 30);
		newpassword.setFont(font);
		newPassword = new JPasswordField(20);
		newPassword.setBounds(10, 180, 200, 30);		
		newPassword.setForeground(Color.black);
		newPassword.setOpaque(false);
		//newPassword.setFont(font);
		
		
		JLabel check  = new JLabel("请再次输入新密码(6 - 20 位)：");
		check.setBounds(10, 230, 220, 30);
		check.setFont(font);
		checkPassword = new JPasswordField(20);
		checkPassword.setBounds(10, 270, 200, 30);		
		checkPassword.setForeground(Color.black);
		checkPassword.setOpaque(false);
		//checkPassword.setFont(font);
		
		JButton confirm = new JButton();
		confirm.setBounds(220, 330, 60, 30);
		PictureButton.setIcon("src/main/java/image/cpButton_unclicked.png", confirm);
		confirm.setBorder(null);
		confirm.setFocusPainted(false);
		confirm.setContentAreaFilled(false);
		confirm.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (!userbl.getUserPassword().equals(String.valueOf(oldPassword.getPassword()))){
					JOptionPane.showMessageDialog(null, "密码不正确！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!String.valueOf(newPassword.getPassword()).equals(String.valueOf(checkPassword.getPassword()))){
					JOptionPane.showMessageDialog(null, "新密码不相同！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (newPassword.getPassword().toString().length()<6){
					JOptionPane.showMessageDialog(null, "密码过短！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (newPassword.getPassword().toString().length()>20){
					JOptionPane.showMessageDialog(null, "密码过长！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				userbl.changePassword(String.valueOf(newPassword.getPassword()));
				JOptionPane.showMessageDialog(null, "密码修改成功！","", JOptionPane.INFORMATION_MESSAGE);
				oldPassword.setText("");
				newPassword.setText("");
				checkPassword.setText("");
				return;
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

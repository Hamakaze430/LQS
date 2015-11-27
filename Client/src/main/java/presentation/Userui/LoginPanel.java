package presentation.Userui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;









import presentation.mainui.PictureLabel;
import vo.LoginVO;
import businessLogic.Userbl.Loginbl;
import businessLogicService.UserblService.LoginblService;

public class LoginPanel extends JPanel{
	private LoginblService bl;
	
	private JLabel bg;
	private JLabel IDbg;
	private JLabel UserID;
	private JLabel Passwordbg;
	private JLabel Password;
	
	private JTextField id;
	private JPasswordField key;
	
	private JButton login;
	private JButton exit;
	private ImageIcon im;
	
	public LoginPanel(LoginblService bl){
		this.bl=bl;
		this.setSize(1024, 768);
		this.setLayout(null);
		im = new ImageIcon("src/main/java/image/background.jpg");
		initLoginPanel();
		this.setVisible(true);
		this.validate();
		
	}

	private void initLoginPanel() {

		IDbg = new PictureLabel("src/main/java/image/input.png");
		IDbg.setBounds(311, 200, 350, 80);

		Passwordbg = new PictureLabel("src/main/java/image/input.png");
		Passwordbg.setBounds(311, 315, 350, 80);
			
		UserID = new JLabel("用 户 名：",JLabel.LEFT);
		UserID.setForeground(Color.lightGray);
		UserID.setFont(new Font("华文细黑",Font.PLAIN,18));
		UserID.setBounds(330, 200, 130, 80);
		id = new JTextField(20);
		id.setBounds(408, 200, 230, 80);
		id.setBorder(new EmptyBorder(0,0,0,0));
		id.setOpaque(false);
		
		Password = new JLabel("密      码：",JLabel.LEFT);
		Password.setForeground(Color.lightGray);
		Password.setFont(new Font("华文细黑",Font.PLAIN,18));
		Password.setBounds(330, 312, 130, 80);
		key = new JPasswordField(20);
		key.setBounds(408, 310, 230, 80);
		key.setBorder(new EmptyBorder(0,0,0,0));
		key.setOpaque(false);
		
		login = new JButton();
		login.setBounds(590, 420, 50, 50);
		setIcon("src/main/java/image/login.png",login);
		login.setBorder(null);
		login.setFocusPainted(false);
		login.setContentAreaFilled(false);
		login.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				login();
			}
			
		});
		login.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				login.setBounds(585, 417, 60, 60);
				setIcon("src/main/java/image/login_pressed.png",login);
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				login.setBounds(585, 415, 60, 60);
				setIcon("src/main/java/image/login.png",login);
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				login.setBounds(585, 415, 60, 60);
				setIcon("src/main/java/image/login.png",login);
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				login.setBounds(590, 420, 50, 50);
				setIcon("src/main/java/image/login.png",login);
			}
			
		});
			
		exit = new JButton();
		exit.setBounds(330, 420, 50, 50);
		setIcon("src/main/java/image/exit.png",exit);
		exit.setBorder(null);
		exit.setFocusPainted(false);
		exit.setContentAreaFilled(false);
		exit.addMouseListener(null);
		exit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				exit();
			}
			
		});
		exit.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				exit.setBounds(325, 417, 60, 60);
				setIcon("src/main/java/image/exit_pressed.png",exit);
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				exit.setBounds(325, 415, 60, 60);
				setIcon("src/main/java/image/exit.png",exit);
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				exit.setBounds(325, 415, 60, 60);
				setIcon("src/main/java/image/exit.png",exit);
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				exit.setBounds(330, 420, 50, 50);
				setIcon("src/main/java/image/exit.png",exit);
			}
			
		});
		this.add(login);
		this.add(exit);
		this.add(id);
		this.add(key);
		this.add(UserID);
		this.add(Password);
		this.add(IDbg);
		this.add(Passwordbg);
		
		
	}

		
		
	protected void exit() {
		// TODO Auto-generated method stub
		
	}

	protected void login() {
		// TODO Auto-generated method stub
		String userid = id.getText();
		String word = key.getPassword().toString().trim();
		
		
	}

	protected void paintComponent(Graphics g) {  
		g.drawImage(im.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);   
	}
	
	private void setIcon(String file,JButton iconButton){
		ImageIcon icon = new ImageIcon(file);
		Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(), iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		iconButton.setIcon(icon);
	}
}

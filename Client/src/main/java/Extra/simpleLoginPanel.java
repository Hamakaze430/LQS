package Extra;

import init.Client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import presentation.Userui.MainPanel;
import presentation.mainui.PictureLabel;
import vo.UserVO;
import businessLogic.Receiptsbl.Receiptsbl;
import businessLogic.Userbl.UserManagerbl;
import businessLogic.Userbl.Userbl;
import businessLogicService.ReceiptsblService.ReceiptsblService;
import businessLogicService.UserblService.UserManagerblService;
import businessLogicService.UserblService.UserblService;

public class simpleLoginPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private UserManagerblService bl;

	private JLabel UserID;
	private JLabel Password;
	
	private JTextField id;
	private JPasswordField key;
	
	private JButton login;
	private JButton exit;
	
	private Font font1;
	private Font font2;
	public simpleLoginPanel(){
		this.setSize(1024, 768);
		this.setLayout(null);
		bl = new UserManagerbl();
		initsimpleLoginPanel();
		this.setVisible(true);
		this.validate();
		
	}
	private void initsimpleLoginPanel() {
		// TODO Auto-generated method stub
		font1 = new Font("黑体",Font.PLAIN,18);
		font2 = new Font("黑体",Font.BOLD,18);
		JLabel bg = new PictureLabel("src/main/java/image/3.jpg");
		bg.setBounds(0,0,this.getWidth(),this.getHeight());
		
		UserID = new JLabel("用 户 名：",JLabel.LEFT);
		UserID.setFont(new Font("华文细黑",Font.PLAIN,18));
		UserID.setBounds(330, 230, 130, 80);
		id = new JTextField(20);
		id.setBounds(408, 250, 230, 40);
		id.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					e.consume();
					 KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		Password = new JLabel("密      码：",JLabel.LEFT);
		Password.setFont(new Font("华文细黑",Font.PLAIN,18));
		Password.setBounds(330, 312, 130, 80);
		
		key = new JPasswordField(20);
		key.setBounds(408, 330, 230, 40);
		key.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				login();
			}			
		});	
		
		login = new JButton("登录");
		login.setFont(font1);
		login.setBounds(550, 420, 80, 40);
		login.setFocusPainted(false);
		login.setContentAreaFilled(false);
		login.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				login();
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
			
		});
			
		exit = new JButton("取消");
		exit.setFont(font1);
		exit.setBounds(408, 420, 80, 40);
		exit.setFocusPainted(false);
		exit.setContentAreaFilled(false);
		exit.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				simpleLoginPanel.this.setVisible(false);	
				Client.frame.remove(simpleLoginPanel.this);
				Client.frame.add(new simpleWelcomePanel());
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
				exit.setFont(font2);
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				exit.setFont(font1);
			}
			
		});
		this.add(login);
		this.add(exit);
		this.add(id);
		this.add(key);
		this.add(UserID);
		this.add(Password);
		this.add(bg);
	}
	
	protected boolean login() {
		// TODO Auto-generated method stub
		String Id = id.getText();
		if (id.equals("")){
			JOptionPane.showMessageDialog(null, "请输入用户名！","", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		UserVO user = bl.findUser(Id);
		if (user == null){
			JOptionPane.showMessageDialog(null, "该用户不存在！","", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (! user.getPassword().equals(String.valueOf(key.getPassword()))){
			System.out.println(user.getPassword());
			JOptionPane.showMessageDialog(null, "密码错误！","", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		simpleLoginPanel.this.setVisible(false);
		UserblService user2 = new Userbl(Id);
		ReceiptsblService bl = new Receiptsbl(user2);
		Client.frame.add(new simpleMainPanel(user2,bl));
		Client.frame.repaint();
		
		return true;
		
	}

}

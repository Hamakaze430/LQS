package presentation.BankAccountui;

import java.awt.Color;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import init.Client;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import presentation.Userui.changeOrgnization;
import presentation.mainui.PictureButton;
import presentation.mainui.PictureLabel;


public class addAccount extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public addAccount(){
		super(Client.frame,"新建银行账户",true);
//		this.bl = bl;
//		this.defaultModel = defaultModel;
		this.setSize(500, 220);
		this.setContentPane(new initPanel());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
	}
	class initPanel extends JPanel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int padding = 10;
		int interval = 150;
		int label_width = 200;
		int label_height = 30;
		int button_width = 70;
		int button_height = 30;
		JTextField number;
		JTextField name;
		JTextField account;
		JButton save;
		JButton back;
		initPanel(){
			this.setLayout(null);
			PictureLabel userbg = new PictureLabel("src/main/java/image/userBG.jpg");
			userbg.setBounds(0, 0, 500, 220);
			Font font = new Font("黑体",Font.PLAIN,16);
			
			JLabel numberLabel = new JLabel("请输入银行账号：");
			numberLabel.setFont(font);
			numberLabel.setBounds(padding, padding, label_width, label_height);
			
			number = new JTextField(20);
			number.setFont(font);
			number.setOpaque(false);
			number.setBorder(new MatteBorder(0,0,1,0,Color.black));
			number.setBounds(padding+interval, padding, label_width, label_height);
			number.addKeyListener(new KeyListener(){

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
			
			JLabel nameLabel = new JLabel("请输入账号名称：");
			nameLabel.setFont(font);
			nameLabel.setBounds(padding, padding*2+label_height, label_width, label_height);
			
			name = new JTextField(20);
			name.setFont(font);
			name.setOpaque(false);
			name.setBorder(new MatteBorder(0,0,1,0,Color.black));
			name.setBounds(padding+interval, padding*2+label_height, label_width, label_height);
			name.addKeyListener(new KeyListener(){

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
			JLabel accountLabel = new JLabel("请输入账号金额：");
			accountLabel.setFont(font);
			accountLabel.setBounds(padding, padding*3+label_height*2, label_width, label_height);
			
			account = new JTextField(20);
			account.setFont(font);
			account.setOpaque(false);
			account.setBorder(new MatteBorder(0,0,1,0,Color.black));
			account.setBounds(padding+interval, padding*3+label_height*2, label_width, label_height);
			
			save = new JButton();
			save.setFont(font);
			save.setBorder(null);
			save.setOpaque(false);
			save.setFocusPainted(false);
			save.setContentAreaFilled(false);
			save.setBounds(320, 140, button_width,button_height);
			PictureButton.setIcon("src/main/java/image/saveButton_unclicked.png",save);
			save.addMouseListener(new MouseListener(){

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
					PictureButton.setIcon("src/main/java/image/saveButton_clicked.png",save);
				}

				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					PictureButton.setIcon("src/main/java/image/saveButton_unclicked.png",save);
				}
				
			});
			back = new JButton();
			back.setFont(font);
			back.setBorder(null);
			back.setOpaque(false);
			back.setFocusPainted(false);
			back.setContentAreaFilled(false);
			back.setBounds(400, 140, button_width,button_height);
			PictureButton.setIcon("src/main/java/image/backButton_unclicked.png",back);
			back.addMouseListener(new MouseListener(){

				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					addAccount.this.dispose();
				}

				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					PictureButton.setIcon("src/main/java/image/backButton_clicked.png",back);
				}

				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					PictureButton.setIcon("src/main/java/image/backButton_unclicked.png",back);
				}
				
			});
			
			this.add(accountLabel);
			this.add(numberLabel);
			this.add(nameLabel);		
			this.add(number);
			this.add(name);
			this.add(account);
			this.add(save);
			this.add(back);
			this.add(userbg);
		}
	}
}

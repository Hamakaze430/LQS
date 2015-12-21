package presentation.CarAndDriverui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import init.Client;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import presentation.mainui.PictureButton;
import presentation.mainui.PictureLabel;
import vo.CarVO;
import businessLogicService.CarAndDriverblService.CarAndDriverblService;
import businessLogicService.UserblService.UserblService;


public class addDriver extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CarAndDriverblService bl;
	DefaultTableModel defaultModel;
	UserblService user;
	public addDriver(UserblService user,CarAndDriverblService bl, DefaultTableModel defaultModel){
		super(Client.frame,"新增司机信息",true);
		this.bl = bl;
		this.defaultModel = defaultModel;
		this.user = user;
		this.setSize(500, 250);
		this.setContentPane(new initDPanel());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
	}
	class initDPanel extends JPanel{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int padding = 10;
		int interval = 120;
		int label_width = 250;
		int label_height = 30;
		int button_width = 70;
		int button_height = 30;
		JButton save;
		JButton cancel;
		initDPanel(){
			this.setLayout(null);
			Font font = new Font("黑体",Font.PLAIN,16);
			
			PictureLabel userbg = new PictureLabel("src/main/java/image/userBG.jpg");
			userbg.setBounds(0, 0, 500, 250);
			
			save = new JButton();
			save.setFont(font);
			save.setBorder(null);
			save.setOpaque(false);
			save.setContentAreaFilled(false);
			save.setBounds(320,180,button_width,button_height);
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
			
			cancel = new JButton();
			cancel.setFont(font);
			cancel.setBorder(null);
			cancel.setOpaque(false);
			cancel.setContentAreaFilled(false);
			cancel.setBounds(400,180,button_width,button_height);
			PictureButton.setIcon("src/main/java/image/backButton_unclicked.png",cancel);
			cancel.addMouseListener(new MouseListener(){

				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					addDriver.this.dispose();
				}

				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					PictureButton.setIcon("src/main/java/image/backButton_clicked.png",cancel);
				}

				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					PictureButton.setIcon("src/main/java/image/backButton_unclicked.png",cancel);
				}
				
			});
			
			this.add(save);
			this.add(cancel);
			this.add(userbg);
		}
	}

}

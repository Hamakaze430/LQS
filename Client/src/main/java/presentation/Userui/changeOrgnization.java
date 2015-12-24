package presentation.Userui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import init.Client;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import presentation.Userui.CreatApartmentDialog.initPanel;
import presentation.mainui.PictureButton;
import presentation.mainui.PictureLabel;
import businessLogicService.UserblService.ApartmentManagerblService;

public class changeOrgnization extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public changeOrgnization(){
		super(Client.frame,"修改人员结构",true);
//		this.bl = bl;
//		this.defaultModel = defaultModel;
		this.setSize(500, 250);
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
		int interval = 200;
		int label_width = 200;
		int label_height = 30;
		int button_width = 70;
		int button_height = 30;
		JTextField name;
		JTextField notice;
		JButton save;
		JButton back;
		initPanel(){
			this.setLayout(null);
			PictureLabel userbg = new PictureLabel("src/main/java/image/userBG.jpg");
			userbg.setBounds(0, 0, 500, 250);
			Font font = new Font("黑体",Font.PLAIN,16);
			
			JLabel noticeLabel = new JLabel("您当前管理的部门为：");
			noticeLabel.setFont(font);
			noticeLabel.setBounds(padding, padding, label_width, label_height);
			
			notice = new JTextField(20);
			notice.setFont(font);
			notice.setOpaque(false);
			notice.setBorder(null);
			notice.setEditable(false);
			notice.setBounds(padding+interval, padding, label_width, label_height);
			
			JLabel nameLabel = new JLabel("请输入要修改的人员姓名：");
			nameLabel.setFont(font);
			nameLabel.setBounds(padding, padding*2+label_height, label_width, label_height);
			
			name = new JTextField(20);
			name.setFont(font);
			name.setOpaque(false);
			name.setBorder(new MatteBorder(0,0,1,0,Color.black));
			name.setBounds(padding+interval, padding*2+label_height, label_width, label_height);
			
			JLabel preLabel = new JLabel("当前所在部门：");
			preLabel.setFont(font);
			preLabel.setBounds(padding, padding*3+label_height*2, label_width, label_height);
			
			JLabel pre = new JLabel();
			pre.setFont(font);
			pre.setBounds(padding+interval, padding*3+label_height*2, label_width, label_height);
			
			JLabel nowLabel = new JLabel("请选择要转到的部门：");
			nowLabel.setFont(font);
			nowLabel.setBounds(padding, padding*4+label_height*3, label_width, label_height);
			
			JComboBox now = new JComboBox();
			now.setFont(font);
			now.setBounds(padding+interval,padding*4+label_height*3,label_width,label_height);
			now.addItem("请选择部门");
			now.setSelectedItem("请选择部门");
			
			save = new JButton();
			save.setFont(font);
			save.setBorder(null);
			save.setOpaque(false);
			save.setFocusPainted(false);
			save.setContentAreaFilled(false);
			save.setBounds(320, 180, button_width,button_height);
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
			back.setBounds(400, 180, button_width,button_height);
			PictureButton.setIcon("src/main/java/image/backButton_unclicked.png",back);
			back.addMouseListener(new MouseListener(){

				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					changeOrgnization.this.dispose();
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
			
			this.add(nameLabel);
			this.add(now);
			this.add(name);
			this.add(nowLabel);
			this.add(pre);
			this.add(preLabel);
			this.add(name);
			this.add(save);
			this.add(back);
			this.add(noticeLabel);
			this.add(notice);
			this.add(userbg);
		}
	}
}

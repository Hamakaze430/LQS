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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import presentation.mainui.PictureButton;
import presentation.mainui.PictureLabel;
import vo.CarVO;
import vo.DriverVO;
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
	private JTextField name;
	private JRadioButton male;
	private JRadioButton female;
	private JTextField year_birth;
	private JTextField month_birth;
	private JTextField day_birth;
	private JTextField year_limi;
	private JTextField month_limi;
	private JTextField day_limi;
	private JTextField identity;
	private JTextField mobile;
	private JTextField id;
	public addDriver(UserblService user,CarAndDriverblService bl, DefaultTableModel defaultModel){
		super(Client.frame,"新增司机信息",true);
		this.bl = bl;
		this.defaultModel = defaultModel;
		this.user = user;
		this.setSize(500, 350);
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
		int interval = 100;
		int label_width = 150;
		int label_height = 30;
		int button_width = 70;
		int button_height = 30;
		JButton save;
		JButton cancel;
		initDPanel(){
			this.setLayout(null);
			Font font = new Font("黑体",Font.PLAIN,16);
			
			JLabel nameLabel = new JLabel("姓    名：  ");
			nameLabel.setFont(font);
			nameLabel.setBounds(padding, padding, label_width, label_height);
			name = new JTextField(20);
			name.setFont(font);
			name.setOpaque(false);
			name.setBorder(new MatteBorder(0,0,1,0,Color.black));
			name.setBounds(padding+interval,padding,label_width,label_height);
			
			JLabel sexLabel = new JLabel("性    别： ");
			sexLabel.setFont(font);
			sexLabel.setBounds(padding, padding*2+label_height, label_width, label_height);
			
			male = new JRadioButton("男",true);
			male.setFocusPainted(false);
			male.setFont(font);
			male.setOpaque(false);
			male.setBounds(padding+interval,padding*2+label_height,button_width,button_height);
			female = new JRadioButton("女");
			female.setFocusPainted(false);
			female.setFont(font);
			female.setOpaque(false);
			female.setBounds(padding+interval+button_width,padding*2+label_height,button_width,button_height);
			
			ButtonGroup bg = new ButtonGroup();
			bg.add(male);
			bg.add(female);
			
			JLabel birthLabel = new JLabel("出生日期： ");
			birthLabel.setFont(font);
			birthLabel.setBounds(padding, padding*3+label_height*2, label_width, label_height);
			year_birth = new JTextField(20);
			year_birth.setFont(font);
			year_birth.setOpaque(false);
			year_birth.setBorder(new MatteBorder(0,0,1,0,Color.black));
			year_birth.setBounds(padding+interval,padding*3+label_height*2,40,button_height);
			
			JLabel yearLabel = new JLabel("年");
			yearLabel.setFont(font);
			yearLabel.setBounds(padding+interval+40,padding*3+label_height*2,button_width,button_height);
			
			month_birth = new JTextField(20);
			month_birth.setFont(font);
			month_birth.setOpaque(false);
			month_birth.setBorder(new MatteBorder(0,0,1,0,Color.black));
			month_birth.setBounds(padding+interval+60,padding*3+label_height*2,20,button_height);
			
			JLabel monthLabel = new JLabel("月");
			monthLabel.setFont(font);
			monthLabel.setBounds(padding+interval+80,padding*3+label_height*2,button_width,button_height);
			
			day_birth = new JTextField(20);
			day_birth.setFont(font);
			day_birth.setOpaque(false);
			day_birth.setBorder(new MatteBorder(0,0,1,0,Color.black));
			day_birth.setBounds(padding+interval+100,padding*3+label_height*2,20,button_height);
			
			JLabel dayLabel = new JLabel("日");
			dayLabel.setFont(font);
			dayLabel.setBounds(padding+interval+120,padding*3+label_height*2,button_width,button_height);
			
			JLabel identityLabel = new JLabel("身份证号：  ");
			identityLabel.setFont(font);
			identityLabel.setBounds(padding, padding*4+label_height*3, label_width, label_height);
			identity = new JTextField(20);
			identity.setFont(font);
			identity.setOpaque(false);
			identity.setBorder(new MatteBorder(0,0,1,0,Color.black));
			identity.setBounds(padding+interval, padding*4+label_height*3,label_width,label_height);
			
			JLabel mobileLabel = new JLabel("手    机：  ");
			mobileLabel.setFont(font);
			mobileLabel.setBounds(padding, padding*5+label_height*4, label_width, label_height);
			mobile = new JTextField(20);
			mobile.setFont(font);
			mobile.setOpaque(false);
			mobile.setBorder(new MatteBorder(0,0,1,0,Color.black));
			mobile.setBounds(padding+interval, padding*5+label_height*4,label_width,label_height);
			

			JLabel limiLabel = new JLabel("行驶期限至： ");
			limiLabel.setFont(font);
			limiLabel.setBounds(padding, padding*6+label_height*5, label_width, label_height);
			year_limi = new JTextField(20);
			year_limi.setFont(font);
			year_limi.setOpaque(false);
			year_limi.setBorder(new MatteBorder(0,0,1,0,Color.black));
			year_limi.setBounds(padding+interval,padding*6+label_height*5,40,button_height);
			
			JLabel yearLabel2 = new JLabel("年");
			yearLabel2.setFont(font);
			yearLabel2.setBounds(padding+interval+40,padding*6+label_height*5,button_width,button_height);
			
			month_limi = new JTextField(20);
			month_limi.setFont(font);
			month_limi.setOpaque(false);
			month_limi.setBorder(new MatteBorder(0,0,1,0,Color.black));
			month_limi.setBounds(padding+interval+60,padding*6+label_height*5,20,button_height);
			
			JLabel monthLabel2 = new JLabel("月");
			monthLabel2.setFont(font);
			monthLabel2.setBounds(padding+interval+80,padding*6+label_height*5,button_width,button_height);
			
			day_limi = new JTextField(20);
			day_limi.setFont(font);
			day_limi.setOpaque(false);
			day_limi.setBorder(new MatteBorder(0,0,1,0,Color.black));
			day_limi.setBounds(padding+interval+100,padding*6+label_height*5,20,button_height);
			
			JLabel dayLabel2 = new JLabel("日");
			dayLabel2.setFont(font);
			dayLabel2.setBounds(padding+interval+120,padding*6+label_height*5,button_width,button_height);
			
			JLabel idLabel = new JLabel("司机代号：");
			idLabel.setFont(font);
			idLabel.setBounds(padding, padding*7+label_height*6, label_width, label_height);
			
			id = new JTextField(20);
			id.setFont(font);
			id.setEditable(false);
			id.setText(user.getHallId()+bl.getLastId("driver", user.getHallId()));
			id.setOpaque(false);
			id.setBorder(null);
			id.setBounds(padding+interval,padding*7+label_height*6,label_width,label_height);
			
			PictureLabel userbg = new PictureLabel("src/main/java/image/userBG.jpg");
			userbg.setBounds(0, 0, 500, 350);
			
			save = new JButton();
			save.setFont(font);
			save.setBorder(null);
			save.setOpaque(false);
			save.setContentAreaFilled(false);
			save.setBounds(320,280,button_width,button_height);
			PictureButton.setIcon("src/main/java/image/saveButton_unclicked.png",save);
			save.addMouseListener(new MouseListener(){

				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					if (name.getText().equals("")){
						JOptionPane.showMessageDialog(null, "请输入司机姓名！","", JOptionPane.ERROR_MESSAGE);
						return;
					}
					Date current = new Date();
					int year;
					int month;
					int day;
					try{
						year = Integer.parseInt(year_birth.getText());
						month = Integer.parseInt(month_birth.getText());
						day = Integer.parseInt(day_birth.getText());
					}catch(NumberFormatException e1){
						//输入编号不是数字
						JOptionPane.showMessageDialog(null, "请输入正确的出生时间！","", JOptionPane.ERROR_MESSAGE);
						return;
					}
					String Birth = String.format("%04d", year)+String.format("%02d", month)+String.format("%02d", day);
					
					
					try{
						year = Integer.parseInt(year_limi.getText());
						month = Integer.parseInt(month_limi.getText());
						day = Integer.parseInt(day_limi.getText());
					}catch(NumberFormatException e1){
						//输入编号不是数字
						JOptionPane.showMessageDialog(null, "请输入正确的出生时间！","", JOptionPane.ERROR_MESSAGE);
						return;
					}
					String Limi = String.format("%04d", year)+String.format("%02d", month)+String.format("%02d", day);
					
					int n = JOptionPane.showConfirmDialog(null, "确定保存该司机信息?", "确认框",JOptionPane.YES_NO_OPTION);
					if (n == 1) return;
					
					
					String Name = name.getText();
					String Sex;
					if (male.isSelected()) Sex = male.getText();
					else Sex = female.getText();
					String Identity = identity.getText();
					String Mobile = mobile.getText();
					String Id = id.getText();
					
					DriverVO vo = new DriverVO(Id,Name,Sex,Birth,Identity,Mobile,Limi);
					bl.addDriverInfo(vo);
					defaultModel.addRow(vo);
					name.setText("");
					male.setSelected(true);
					year_birth.setText("");
					month_birth.setText("");
					day_birth.setText("");
					identity.setText("");
					mobile.setText("");
					year_limi.setText("");
					month_limi.setText("");
					day_limi.setText("");
					id.setText(user.getHallId()+bl.getLastId("driver", user.getHallId()));
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
			cancel.setBounds(400,280,button_width,button_height);
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
			this.add(nameLabel);
			this.add(name);
			this.add(sexLabel);
			this.add(male);
			this.add(female);
			this.add(birthLabel);
			this.add(year_birth);
			this.add(yearLabel);
			this.add(month_birth);
			this.add(monthLabel);
			this.add(day_birth);
			this.add(dayLabel);
			this.add(identityLabel);
			this.add(identity);
			this.add(mobileLabel);
			this.add(mobile);
			this.add(limiLabel);
			this.add(year_limi);
			this.add(yearLabel2);
			this.add(month_limi);
			this.add(monthLabel2);
			this.add(day_limi);
			this.add(dayLabel2);
			this.add(idLabel);
			this.add(id);
			this.add(save);
			this.add(cancel);
			this.add(userbg);
		}
	}

}

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


public class addCar extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CarAndDriverblService bl;
	DefaultTableModel defaultModel;
	UserblService user;
	JTextField license;
	JTextField id;
	public addCar(UserblService user,CarAndDriverblService bl, DefaultTableModel defaultModel){
		super(Client.frame,"新增车辆信息",true);
		this.bl = bl;
		this.defaultModel = defaultModel;
		this.user = user;
		this.setSize(500, 250);
		this.setContentPane(new initCPanel());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
	}
	class initCPanel extends JPanel{
		
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
		initCPanel(){
			this.setLayout(null);
			Font font = new Font("黑体",Font.PLAIN,16);
			JLabel licenseLabel = new JLabel("请输入车牌号：（例：苏A 00000）");
			licenseLabel.setFont(font);
			licenseLabel.setBounds(padding, padding, label_width*2, label_height);
			
			license = new JTextField(20);
			license.setFont(font);
			license.setOpaque(false);
			license.setBorder(new MatteBorder(0,0,1,0,Color.black));
			license.setBounds(padding,padding*2+label_height,label_width,label_height);
			
			JLabel idLabel = new JLabel("车辆代号：");
			idLabel.setFont(font);
			idLabel.setBounds(padding, padding*3+label_height*2, label_width*2, label_height);
			
			id = new JTextField(20);
			id.setFont(font);
			id.setEditable(false);
			id.setText(user.getHallId()+bl.getLastId("car", user.getHallId()));
			id.setOpaque(false);
			id.setBorder(null);
			id.setBounds(padding,padding*4+label_height*3,label_width,label_height);
			
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
					if (license.getText().equals("")){
						JOptionPane.showMessageDialog(null, "请输入车牌号！","", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					int n = JOptionPane.showConfirmDialog(null, "确定保存该车辆信息?", "确认框",JOptionPane.YES_NO_OPTION);
					if (n == 1) return;
					
					CarVO vo = new CarVO(id.getText(),license.getText(),"0天");
					Date date = new Date();
					DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					bl.addCarInfo(formatter.format(date),vo);
					defaultModel.addRow(vo);
					license.setText("");
					id.setText(user.getHallId()+bl.getLastId("car", user.getHallId()));
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
			cancel.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					addCar.this.dispose();
				}
				
			});
			
			this.add(license);
			this.add(licenseLabel);
			this.add(id);
			this.add(idLabel);
			this.add(save);
			this.add(cancel);
			this.add(userbg);
		}
	}

}

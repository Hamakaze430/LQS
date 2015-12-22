package presentation.Receiptsui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import presentation.Userui.ApartmentManagerPanel;
import presentation.Userui.MainPanel;
import presentation.mainui.PictureButton;
import businessLogic.Receiptsbl.Receiptsbl;
import businessLogicService.ReceiptsblService.ReceiptsblService;
import businessLogicService.UserblService.UserblService;
/**
 * 收件单
 * @author TOSHIBA
 *
 */
public class ReceivePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton back;
	JButton submit;
	int padding =10;
	int interval = 120;
	int label_width = 200;
	int label_height = 30;;
	int button_width = 70;
	int button_height = 30;
	private UserblService user;
	private ReceiptsblService bl;
	int buttonNum;
	public ReceivePanel(UserblService user,int buttonNum){
		this.user = user;
		this.buttonNum = buttonNum;
		bl = new Receiptsbl(user);
		this.setLayout(null);
		this.setOpaque(false);
		this.setBorder(null);
		init();
	}

	private void init() {
		Font font = new Font("黑体",Font.PLAIN,16);
		JLabel title = new JLabel(user.getHallName()+"收件单",JLabel.CENTER);
		title.setFont(font);
		title.setBounds(150, 10, 600, 50);
		
		JLabel idLabel = new JLabel("· 收件编号: ");
		idLabel.setFont(font);
		idLabel.setBounds(padding, padding*2+50, label_width, label_height);		
		
		JTextField id = new JTextField(20);
		id.setFont(font);
		id.setOpaque(false);
		id.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		id.setBounds(padding+interval, padding*2+50, label_width, label_height);
		
		JLabel nameLabel = new JLabel("· 收件人姓名: ");
		nameLabel.setFont(font);
		nameLabel.setBounds(padding,padding*3+50+label_height, label_width, label_height);	
		
		JTextField name = new JTextField(20);
		name.setFont(font);
		name.setOpaque(false);
		name.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		name.setBounds(padding+interval,padding*3+50+label_height, label_width, label_height);
		
		JLabel dateLabel = new JLabel("· 收件日期: ");
		dateLabel.setFont(font);
		dateLabel.setBounds(padding,padding*4+50+label_height*2, label_width, label_height);	
		
		JLabel date = new JLabel(); 
		date.setText(bl.getCurrentTime());
		date.setFont(font);
		date.setBounds(padding+interval,padding*4+50+label_height*2, label_width, label_height);		
		
		submit = new JButton();
		submit.setFont(font);
		submit.setBorder(null);
		submit.setOpaque(false);
		submit.setFocusPainted(false);
		submit.setContentAreaFilled(false);
		submit.setBounds(740, 510, button_width, button_height);
		PictureButton.setIcon("src/main/java/image/submitButton_unclicked.png",submit);
		submit.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent e) {}

			public void mouseReleased(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {
				PictureButton.setIcon("src/main/java/image/submitButton_clicked.png",submit);
			}

			public void mouseExited(MouseEvent e) {
				PictureButton.setIcon("src/main/java/image/submitButton_unclicked.png",submit);
			}			
		});		
		
		back = new JButton();
		back.setFont(font);
		back.setBorder(null);
		back.setOpaque(false);
		back.setFocusPainted(false);
		back.setContentAreaFilled(false);
		back.setBounds(820, 510, button_width, button_height);
		PictureButton.setIcon("src/main/java/image/backButton_unclicked.png",back);
		back.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				ReceivePanel.this.setVisible(false);
				MainPanel.closeButton(buttonNum);
			}

			public void mousePressed(MouseEvent e) {}

			public void mouseReleased(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {
				PictureButton.setIcon("src/main/java/image/backButton_clicked.png",back);
			}

			public void mouseExited(MouseEvent e) {
				PictureButton.setIcon("src/main/java/image/backButton_unclicked.png",back);
			}		
		});
		
		this.add(title);
		this.add(idLabel);
		this.add(id);
		this.add(nameLabel);
		this.add(name);
		this.add(dateLabel);
		this.add(date);
		this.add(submit);
		this.add(back);
	}
}

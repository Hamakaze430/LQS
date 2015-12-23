package presentation.Receiptsui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import Miscellaneous.Job;
import presentation.Userui.MainPanel;
import presentation.mainui.PictureButton;
import vo.UserVO;
import vo.receipts.DeliverVO;
import businessLogic.Receiptsbl.Receiptsbl;
import businessLogicService.ReceiptsblService.ReceiptsblService;
import businessLogicService.UserblService.UserblService;

/**
 * 派件单
 * @author TOSHIBA
 *
 */
public class DeliverPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton submit;
	JButton back;
	JTextField date,id,name;
	JLabel title;
	int padding =10;
	int interval =150;
	int label_width = 200;
	int label_height = 30;
	int button_width = 80;
	int button_height = 30;
	private ReceiptsblService bl;
	private UserblService user;
	int buttonNum;
	public DeliverPanel(UserblService user,int buttonNum){
		this.user = user;
		this.buttonNum=buttonNum;
		bl = new Receiptsbl(user);
		this.buttonNum = buttonNum;
		this.setLayout(null);
		this.setOpaque(false);
		this.setBorder(null);
		init();
	}
	
	private void init() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,16);
		title = new JLabel(user.getHallName()+"派件单",JLabel.CENTER);
		title.setFont(font);
		title.setBounds(150, 10, 600, 50);
		
		JLabel dateLabel = new JLabel("· 货物到达日期: ");
		dateLabel.setFont(font);
		dateLabel.setBounds(padding,padding+50,label_width,label_height);		
		
		date = new JTextField(20);
		date.setFont(font);
		date.setOpaque(false);
		date.setBorder(null);
		date.setBounds(padding+interval, padding+50, label_width,label_height);
		date.setText(bl.getCurrentTime());
		
		JLabel idLabel = new JLabel("· 订单条形码号: ");
		idLabel.setFont(font);
		idLabel.setBounds(padding, padding*2+label_height+50, label_width,label_height);	
		
		id = new JTextField(20);
		id.setFont(font);
		id.setOpaque(false);
		id.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		id.setBounds(padding+interval,padding*2+label_height+50, label_width,label_height);		
		
		JLabel nameLabel = new JLabel("· 派 送 员: ");
		nameLabel.setFont(font);
		nameLabel.setBounds(padding, padding*3+label_height*2+50, label_width,label_height);	
		
		name = new JTextField(20);
		name.setFont(font);
		name.setOpaque(false);
		name.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		name.setBounds(padding+interval,padding*3+label_height*2+50, label_width,label_height);
		
		submit = new JButton();
		submit.setFont(font);
		submit.setBorder(null);
		submit.setOpaque(false);
		submit.setFocusPainted(false);
		submit.setContentAreaFilled(false);
		submit.setBounds(740, 510, 70, 30);
		PictureButton.setIcon("src/main/java/image/submitButton_unclicked.png",submit);
		submit.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				String deliverer = name.getText();
				if (deliverer.equals("")){
					JOptionPane.showMessageDialog(null, "请输入派送员姓名！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				UserVO deli = bl.findUser(deliverer);
				if (!deli.getHall().equals(user.getHallName())|! deli.getJob().equals(Job.快递员.name())){
					JOptionPane.showMessageDialog(null, "本营业厅不存在对应的快递员！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String s = id.getText();
				try{
					long id = Long.parseLong(s);
				}catch(NumberFormatException e1){
					//输入编号不是数字
					JOptionPane.showMessageDialog(null, "请输入正确的快递单号！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
		 		if(! bl.findLogistics(s)){
					//System.out.println("找不到");
		 			
					JOptionPane.showMessageDialog(null, "不存在快递单号为"+s+"的货物！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
		 		
		 		int n = JOptionPane.showConfirmDialog(null, "确定提交?", "确认框",JOptionPane.YES_NO_OPTION);
				if (n == 1) {
					return;
				}
				
		 		DeliverVO vo = new DeliverVO(title.getText(), user.getUserName(), date.getText(), name.getText(), id.getText());
		 		bl.addReceipt(vo);
		 		
		 		date.setText(bl.getCurrentTime());
		 		name.setText("");
		 		id.setText("");
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
		back.setBounds(820, 510, 70, 30);
		PictureButton.setIcon("src/main/java/image/backButton_unclicked.png",back);
		back.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				DeliverPanel.this.setVisible(false);
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


	


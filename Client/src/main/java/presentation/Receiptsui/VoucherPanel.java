package presentation.Receiptsui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import Miscellaneous.Job;
import presentation.Userui.MainPanel;
import presentation.mainui.PictureButton;
import vo.UserVO;
import businessLogic.Receiptsbl.Receiptsbl;
import businessLogicService.ReceiptsblService.ReceiptsblService;
import businessLogicService.UserblService.UserblService;

/**
 * 收款单
 * @author TOSHIBA
 *
 */
public class VoucherPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton submit;
	JButton back;
	double money_double = -1;
	JTextField money;
	JTextField name;
	JTextArea orders;
	int padding =10;
	int interval =150;
	int label_width = 200;
	int label_height = 30;
	int button_width = 80;
	int button_height = 30;
	private ReceiptsblService bl;
	private UserblService user;
	private int buttonNum;
	public VoucherPanel(UserblService user, int buttonNum){
		this.user = user;
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
		JLabel title = new JLabel(user.getHallName()+"收款单",JLabel.CENTER);
		title.setFont(font);
		title.setBounds(150, 10, 600, 50);
		
		JLabel dateLabel = new JLabel("· 收款日期: ");
		dateLabel.setFont(font);
		dateLabel.setBounds(padding,padding+50,label_width,label_height);		
		
		JTextField date = new JTextField(20);
		date.setFont(font);
		date.setOpaque(false);
		date.setBorder(null);
		date.setBounds(padding+interval, padding+50, label_width,label_height);
		date.setText(bl.getCurrentTime());
		date.setEditable(false);
		
		JLabel moneyLabel = new JLabel("· 收款金额: ");
		moneyLabel.setFont(font);
		moneyLabel.setBounds(padding, padding*2+label_height+50, label_width,label_height);	
		
		money = new JTextField(20);
		money.setFont(font);
		money.setOpaque(false);
		money.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		money.setBounds(padding+interval,padding*2+label_height+50, label_width,label_height);
		
		JLabel nameLabel = new JLabel("· 收 款 员: ");
		nameLabel.setFont(font);
		nameLabel.setBounds(padding, padding*3+label_height*2+50, label_width,label_height);	
		
		name = new JTextField(20);
		name.setFont(font);
		name.setOpaque(false);
		name.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		name.setBounds(padding+interval,padding*3+label_height*2+50, label_width,label_height);
		
		JLabel order = new JLabel("· 订单条形码号：");
		order.setFont(font);
		order.setBounds(padding, padding*4+label_height*3+50, label_width, label_height);
		
		orders = new JTextArea();
		orders.setFont(font);
		orders.setLineWrap(true);
		orders.setBorder(BorderFactory.createLineBorder(Color.black));
		orders.setOpaque(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(padding+interval,padding*4+label_height*3+50, label_width*2, label_height*4);
		scrollPane.getViewport().add(orders);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		
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
				
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/submitButton_clicked.png",submit);
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/submitButton_unclicked.png",submit);
			}
			
		});
		
		submit.addActionListener(new SubmitListener());
		
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
				// TODO Auto-generated method stub
				VoucherPanel.this.setVisible(false);
				MainPanel.closeButton(buttonNum);
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
		
		this.add(title);
		this.add(moneyLabel);
		this.add(money);
		this.add(nameLabel);
		this.add(name);
		this.add(dateLabel);
		this.add(date);
		this.add(submit);
		this.add(back);
		this.add(order);
		this.add(scrollPane);
		
	}
	
	class SubmitListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String Money = money.getText();
			if (Money.equals("")){
				JOptionPane.showMessageDialog(null, "请输入收款金额！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String Name = name.getText();
			if (Name.equals("")){
				JOptionPane.showMessageDialog(null, "请输入收款员姓名！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			UserVO vo = bl.findUser(Name);
			if(vo == null ){
				//System.out.println("找不到");
				JOptionPane.showMessageDialog(null, "不存在对应的快递员！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (!vo.getHall().equals(user.getHallName())&&vo.getJob().equals(Job.快递员.name())){
				JOptionPane.showMessageDialog(null, "所填的收款员不是本营业厅的快递员！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String str = orders.getText();
			if (str.equals("")){
				JOptionPane.showMessageDialog(null, "请输入相应的快递单号！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
		 	List<String> Order = new ArrayList<String>();
		 	String[] split = str.split("\n");
		 	for (String s : split) {
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
		 		Order.add(s);
		 	}
		}
		
	}

}

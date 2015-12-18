package presentation.Receiptsui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

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
	int padding =10;
	int interval =150;
	int label_width = 200;
	int label_height = 30;
	int button_width = 80;
	int button_height = 30;
	private ReceiptsblService bl;
	private UserblService user;
	public VoucherPanel(UserblService user){
		this.user = user;
		bl = new Receiptsbl(user);
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
		
		JLabel idLabel = new JLabel("· 收款金额: ");
		idLabel.setFont(font);
		idLabel.setBounds(padding, padding*2+label_height+50, label_width,label_height);	
		
		JTextField id = new JTextField(20);
		id.setFont(font);
		id.setOpaque(false);
		id.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		id.setBounds(padding+interval,padding*2+label_height+50, label_width,label_height);
		
		
		JLabel nameLabel = new JLabel("· 收 款 员: ");
		nameLabel.setFont(font);
		nameLabel.setBounds(padding, padding*3+label_height*2+50, label_width,label_height);	
		
		JTextField name = new JTextField(20);
		name.setFont(font);
		name.setOpaque(false);
		name.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		name.setBounds(padding+interval,padding*3+label_height*2+50, label_width,label_height);
		
		JLabel order = new JLabel("· 订单条形码号：");
		order.setFont(font);
		order.setBounds(padding, padding*4+label_height*3+50, label_width, label_height);
		
		JTextArea orders = new JTextArea();
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
		
		JButton submit = new JButton("提交");
		submit.setFont(font);
		submit.setBounds(720, 510, button_width, button_height);
		
		JButton back = new JButton("返回");
		back.setFont(font);
		back.setBounds(720+button_width+padding, 510, button_width, button_height);
		
		this.add(title);
		this.add(idLabel);
		this.add(id);
		this.add(nameLabel);
		this.add(name);
		this.add(dateLabel);
		this.add(date);
		this.add(submit);
		this.add(back);
		this.add(order);
		this.add(scrollPane);
		
	}

}

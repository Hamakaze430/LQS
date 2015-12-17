package presentation.Receiptsui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import businessLogic.Receiptsbl.Receiptsbl;
import businessLogicService.ReceiptsblService.ReceiptsblService;
import businessLogicService.UserblService.UserblService;

/**
 * 寄件单
 * @author TOSHIBA
 *
 */
public class SendPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ReceiptsblService bl;
	private UserblService user;
	int padding = 10;
	int label_width = 200;
	int label_height = 30;
	int box_width = 120;
	int box_height = 30;
	int button_width = 80;
	int button_height = 30;
	JLabel text1;
	JLabel text2;
	JLabel text3;
	JPanel info;
	public SendPanel(UserblService user){
		this.user=user;
		bl = new Receiptsbl(user);
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		
		init();
		
	}

	private void init() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,16);
		JLabel title = new JLabel(user.getHallName()+"寄件单",JLabel.CENTER);
		title.setFont(font);
		title.setBounds(150, 10, 600, 30);
		
		text1 = new JLabel();
		TitledBorder tb = BorderFactory.createTitledBorder("寄件人信息");
		tb.setTitleJustification(TitledBorder.LEFT);
		text1.setBounds(padding, padding, 800, 400);
		text1.setBorder(tb);
		text1.setOpaque(false);
		
		JLabel sendernameLabel = new JLabel("· 寄件人姓名：");
		sendernameLabel.setFont(font);
		sendernameLabel.setBounds(padding, padding, label_width, label_height);
		
		text2= new JLabel();
		TitledBorder tb2 = BorderFactory.createTitledBorder("收件人信息");
		tb2.setTitleJustification(TitledBorder.LEFT);
		text2.setBounds(padding, padding+400, 800, 400);
		text2.setBorder(tb2);
		text2.setOpaque(false);
		
		text3= new JLabel();
		TitledBorder tb3 = BorderFactory.createTitledBorder("货物信息");
		tb3.setTitleJustification(TitledBorder.LEFT);
		text3.setBounds(padding, padding+800, 800, 400);
		text3.setBorder(tb3);
		text3.setOpaque(false);
		
		info = new JPanel();
//		info.setSize(800,1000);
		//info.setBounds(0, 0, 800, 1000);
		info.setPreferredSize(new Dimension(800,1000));
		info.setBorder(null);
		info.setLayout(null);
		info.setOpaque(false);
		info.add(text1);
		info.add(text2);
		info.add(text3);
		
		
		JScrollPane scrollPane = new JScrollPane(info);
		scrollPane.setViewportView(info);
		scrollPane.getVerticalScrollBar().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setBounds(padding, padding*2+30, 850, 480);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.getViewport().setOpaque(false);
		
		this.add(title);
		this.add(scrollPane);
		
	}
}

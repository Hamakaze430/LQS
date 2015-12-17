package presentation.Receiptsui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
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
	int box_width = 100;
	int box_height = 30;
	int button_width = 80;
	int button_height = 30;
	int interval = 120;
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
		text1.setBounds(padding, padding, 820, padding*6+label_height*6);
		text1.setBorder(tb);
		text1.setOpaque(false);
		
		JLabel sendernameLabel = new JLabel("· 寄件人姓名：");
		sendernameLabel.setFont(font);
		sendernameLabel.setBounds(padding*2, padding+label_height, label_width, label_height);
		
		JLabel senderaddrLabel = new JLabel("· 寄件人住址：");
		senderaddrLabel.setFont(font);
		senderaddrLabel.setBounds(padding*2, (padding+label_height)*2, label_width, label_height);
		
		JLabel sendercompLabel = new JLabel("· 寄件人单位：");
		sendercompLabel.setFont(font);
		sendercompLabel.setBounds(padding*2, (padding+label_height)*3, label_width, label_height);
		
		JLabel sendertelLabel = new JLabel("· 寄件人固话：");
		sendertelLabel.setFont(font);
		sendertelLabel.setBounds(padding*2, (padding+label_height)*4, label_width, label_height);
		
		JLabel senderphoneLabel = new JLabel("· 寄件人手机：");
		senderphoneLabel.setFont(font);
		senderphoneLabel.setBounds(padding*2, (padding+label_height)*5, label_width, label_height);
		
		
		JTextField sendername = new JTextField(20);
		sendername.setFont(font);
		sendername.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		sendername.setOpaque(false);
		sendername.setBounds(padding*2+interval, padding+label_height, label_width, label_height);
		
		JTextField senderaddr = new JTextField(20);
		senderaddr.setFont(font);
		senderaddr.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		senderaddr.setOpaque(false);
		senderaddr.setBounds(padding*2+interval, (padding+label_height)*2, label_width, label_height);
		
		JTextField sendercomp = new JTextField(20);
		sendercomp.setFont(font);
		sendercomp.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		sendercomp.setOpaque(false);
		sendercomp.setBounds(padding*2+interval, (padding+label_height)*3, label_width, label_height);
		
		JTextField sendertel = new JTextField(20);
		sendertel.setFont(font);
		sendertel.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		sendertel.setOpaque(false);
		sendertel.setBounds(padding*2+interval, (padding+label_height)*4, label_width, label_height);
		
		JTextField senderphone = new JTextField(20);
		senderphone.setFont(font);
		senderphone.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		senderphone.setOpaque(false);
		senderphone.setBounds(padding*2+interval, (padding+label_height)*5, label_width, label_height);
		
		JLabel receivernameLabel = new JLabel("· 收件人姓名：");
		receivernameLabel.setFont(font);
		receivernameLabel.setBounds(padding*2+interval*3, padding+label_height, label_width, label_height);
		
		JLabel receiveraddrLabel = new JLabel("· 收件人住址：");
		receiveraddrLabel.setFont(font);
		receiveraddrLabel.setBounds(padding*2+interval*3, (padding+label_height)*2, label_width, label_height);
		
		JLabel receivercompLabel = new JLabel("· 收件人单位：");
		receivercompLabel.setFont(font);
		receivercompLabel.setBounds(padding*2+interval*3, (padding+label_height)*3, label_width, label_height);
		
		JLabel receivertelLabel = new JLabel("· 收件人固话：");
		receivertelLabel.setFont(font);
		receivertelLabel.setBounds(padding*2+interval*3, (padding+label_height)*4, label_width, label_height);
		
		JLabel receiverphoneLabel = new JLabel("· 收件人手机：");
		receiverphoneLabel.setFont(font);
		receiverphoneLabel.setBounds(padding*2+interval*3, (padding+label_height)*5, label_width, label_height);
		
		
		JTextField receivername = new JTextField(20);
		receivername.setFont(font);
		receivername.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		receivername.setOpaque(false);
		receivername.setBounds(padding*3+interval*4, padding+label_height, label_width, label_height);
		
		JTextField receiveraddr = new JTextField(20);
		receiveraddr.setFont(font);
		receiveraddr.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		receiveraddr.setOpaque(false);
		receiveraddr.setBounds(padding*3+interval*4, (padding+label_height)*2, label_width, label_height);
		
		JTextField receivercomp = new JTextField(20);
		receivercomp.setFont(font);
		receivercomp.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		receivercomp.setOpaque(false);
		receivercomp.setBounds(padding*3+interval*4, (padding+label_height)*3, label_width, label_height);
		
		JTextField receivertel = new JTextField(20);
		receivertel.setFont(font);
		receivertel.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		receivertel.setOpaque(false);
		receivertel.setBounds(padding*3+interval*4, (padding+label_height)*4, label_width, label_height);
		
		JTextField receiverphone = new JTextField(20);
		receiverphone.setFont(font);
		receiverphone.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		receiverphone.setOpaque(false);
		receiverphone.setBounds(padding*3+interval*4, (padding+label_height)*5, label_width, label_height);
		
		
		text2= new JLabel();
		TitledBorder tb2 = BorderFactory.createTitledBorder("收件人信息");
		tb2.setTitleJustification(TitledBorder.LEFT);
		text2.setBounds(padding, padding*8+label_height*6, 820,  padding*3+label_height*2);
		text2.setBorder(tb2);
		text2.setOpaque(false);
		
		JLabel receivernameLabel2 = new JLabel("· 收件人姓名：");
		receivernameLabel2.setFont(font);
		receivernameLabel2.setBounds(padding*2, padding*9+label_height*7, label_width, label_height);
		
		JLabel timeLabel = new JLabel("· 收件时间：");
		timeLabel.setFont(font);
		timeLabel.setBounds(padding*2+interval*3, padding*9+label_height*7, label_width, label_height);
		
		JTextField receivername2 = new JTextField(20);
		receivername2.setFont(font);
		receivername2.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		receivername2.setOpaque(false);
		receivername2.setBounds(padding*2+interval, padding*9+label_height*7, label_width, label_height);
		
		JTextField time = new JTextField(20);
		time.setFont(font);
		time.setBorder(null);
		time.setOpaque(false);
		time.setBounds(padding*3+interval*4, padding*9+label_height*7, label_width, label_height);
		time.setText(bl.getCurrentTime());
		time.setEditable(false);
		
		text3= new JLabel();
		TitledBorder tb3 = BorderFactory.createTitledBorder("货物信息");
		tb3.setTitleJustification(TitledBorder.LEFT);
		text3.setBounds(padding,padding*12+label_height*8, 820, padding*11+label_height*9);
		text3.setBorder(tb3);
		text3.setOpaque(false);
		
		JLabel initNumberLabel = new JLabel("· 原 件 数：");
		initNumberLabel.setFont(font);
		initNumberLabel.setBounds(padding*2, padding*12+label_height*9, label_width, label_height);
		
		JLabel trueweightLabel = new JLabel("· 实际重量：");
		trueweightLabel.setFont(font);
		trueweightLabel.setBounds(padding*2, padding*13+label_height*10, label_width, label_height);
		
		JLabel volumeLabel = new JLabel("· 体    积：");
		volumeLabel.setFont(font);
		volumeLabel.setBounds(padding*2, padding*14+label_height*11, label_width, label_height);
		
		JLabel goodstypeLabel = new JLabel("· 内件品名：");
		goodstypeLabel.setFont(font);
		goodstypeLabel.setBounds(padding*2, padding*15+label_height*12, label_width, label_height);
		
		JLabel transtypeLabel = new JLabel("· 快递类型：");
		transtypeLabel.setFont(font);
		transtypeLabel.setBounds(padding*2, padding*16+label_height*13, label_width, label_height);
		
		JLabel costLabel = new JLabel("· 包 装 费：");
		costLabel.setFont(font);
		costLabel.setBounds(padding*2, padding*17+label_height*14, label_width, label_height);
		
		JLabel costLabel2 = new JLabel("(纸箱(5元)、木箱(10元)、快递袋(1元))");
		costLabel2.setFont(font);
		costLabel2.setBounds(padding*2, padding*17+label_height*15, 500, label_height);
		
		JLabel allcostLabel = new JLabel("· 费用合计：");
		allcostLabel.setFont(font);
		allcostLabel.setBounds(padding*2, padding*18+label_height*16, label_width, label_height);
		
		JLabel orderLabel = new JLabel("· 订单条形码号：");
		orderLabel.setFont(font);
		orderLabel.setBounds(padding*2, padding*19+label_height*17, label_width, label_height);
		
		JTextField initNumber = new JTextField(20);
		initNumber.setFont(font);
		initNumber.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		initNumber.setOpaque(false);
		initNumber.setBounds(padding*2+interval,  padding*12+label_height*9, label_width, label_height);
		
		JTextField trueweight = new JTextField(20);
		trueweight.setFont(font);
		trueweight.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		trueweight.setOpaque(false);
		trueweight.setBounds(padding*2+interval,  padding*13+label_height*10, label_width, label_height);
		
		JTextField volume = new JTextField(20);
		volume.setFont(font);
		volume.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		volume.setOpaque(false);
		volume.setBounds(padding*2+interval,  padding*14+label_height*11, label_width, label_height);
		
		JTextField goodstype = new JTextField(20);
		goodstype.setFont(font);
		goodstype.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		goodstype.setOpaque(false);
		goodstype.setBounds(padding*2+interval,  padding*15+label_height*12, label_width, label_height);
		
		ButtonGroup g = new ButtonGroup();
		
		JRadioButton finan = new JRadioButton("经济快递",true);
		finan.setFont(font);
		finan.setBorder(null);
		finan.setBounds(padding*2+interval,padding*16+label_height*13, box_width, box_height);
		finan.setOpaque(false);
		
		JRadioButton st = new JRadioButton("标准快递");
		st.setFont(font);
		st.setBorder(null);
		st.setBounds(padding*2+interval*2,padding*16+label_height*13, box_width, box_height);
		st.setOpaque(false);
		
		JRadioButton fast = new JRadioButton("特快");
		fast.setFont(font);
		fast.setBorder(null);
		fast.setBounds(padding*2+interval*3,padding*16+label_height*13, box_width, box_height);
		fast.setOpaque(false);
		
		JTextField cost = new JTextField(20);
		cost.setFont(font);
		cost.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		cost.setOpaque(false);
		cost.setBounds(padding*2+interval,  padding*17+label_height*14, label_width, label_height);
		
		JTextField allcost = new JTextField(20);
		allcost.setFont(font);
		allcost.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		allcost.setOpaque(false);
		allcost.setBounds(padding*2+interval,  padding*18+label_height*16, label_width, label_height);
		//allcost.setText(t);
		allcost.setEditable(false);
		
		JTextField order = new JTextField(20);
		order.setFont(font);
		order.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		order.setOpaque(false);
		order.setBounds(padding*2+interval,  padding*19+label_height*17, label_width, label_height);
		//order.setText(t);
		order.setEditable(false);
		
		info = new JPanel();
		info.setPreferredSize(new Dimension(880,text1.getHeight()+text2.getHeight()+text3.getHeight()+padding*5));
		info.setBorder(null);
		info.setLayout(null);
		info.setOpaque(false);
		info.add(text1);
		info.add(text2);
		info.add(text3);
		
		info.add(sendernameLabel);
		info.add(senderaddrLabel);
		info.add(sendercompLabel);
		info.add(sendertelLabel);
		info.add(senderphoneLabel);
		info.add(sendername);
		info.add(senderaddr);
		info.add(sendercomp);
		info.add(sendertel);
		info.add(senderphone);
		
		info.add(receivernameLabel);
		info.add(receiveraddrLabel);
		info.add(receivercompLabel);
		info.add(receivertelLabel);
		info.add(receiverphoneLabel);
		info.add(receivername);
		info.add(receiveraddr);
		info.add(receivercomp);
		info.add(receivertel);
		info.add(receiverphone);
		
		info.add(receivernameLabel2);
		info.add(receivername2);
		info.add(timeLabel);
		info.add(time);
		
		info.add(initNumberLabel);
		info.add(trueweightLabel);
		info.add(volumeLabel);
		info.add(goodstypeLabel);
		info.add(transtypeLabel);
		info.add(costLabel);
		info.add(costLabel2);
		info.add(allcostLabel);
		info.add(orderLabel);
		info.add(trueweight);
		info.add(initNumber);
		info.add(volume);
		info.add(goodstype);
		info.add(st);
		info.add(fast);
		info.add(finan);
		info.add(cost);
		info.add(cost);
		g.add(finan);
		g.add(fast);
		g.add(st);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(info);
		scrollPane.setOpaque(false);
		scrollPane.setBounds(padding, padding*2+30, 880, 450);		
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getViewport().setOpaque(false);
		
		JButton submit = new JButton("提交");
		submit.setFont(font);
		submit.setBounds(720, 510, button_width, button_height);
		
		JButton back = new JButton("返回");
		back.setFont(font);
		back.setBounds(720+button_width+padding, 510, button_width, button_height);
		
		this.add(title);
		this.add(scrollPane);
		this.add(submit);
		this.add(back);
		
		
	}
}

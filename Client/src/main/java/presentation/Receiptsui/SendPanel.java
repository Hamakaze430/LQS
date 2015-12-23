package presentation.Receiptsui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

import presentation.Userui.MainPanel;
import presentation.mainui.PictureButton;
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
	JButton submit;
	JButton back;
	JTextField order;
	JTextField receiveraddr;
	JTextField receiverphone;
	JTextField receivername;
	JTextField senderaddr;
	JTextField receivercomp;
	JTextField receivertel;
	JTextField senderphone;
	JTextField goodstype;
	private ReceiptsblService bl;
	private UserblService user;
	int padding = 10;
	int label_width = 200;
	int label_height = 30;
	int box_width = 120;
	int box_height = 30;
	int button_width = 80;
	int button_height = 30;
	int interval = 120;
	JLabel text1;
	JLabel text2;
	JLabel text3;
	JPanel info;
	JTextField sendername;
	JTextField sendercomp;
	JTextField sendertel;
	private int buttonNum;
	JTextField initNumber;
	JTextField trueweight;
	JTextField volume;
	public SendPanel(UserblService user, int buttonNum){
		this.user=user;
		bl = new Receiptsbl(user);
		this.buttonNum = buttonNum;
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		this.buttonNum=buttonNum;
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
		text1.setBounds(padding, padding, 820, padding*6+label_height*3);
		text1.setBorder(tb);
		text1.setOpaque(false);	
		
		JLabel sendernameLabel = new JLabel("· 寄件人姓名：");
		sendernameLabel.setFont(font);
		sendernameLabel.setBounds(padding, padding*2, label_width, label_height);
		
		JLabel senderphoneLabel = new JLabel("· 寄件人手机：");
		senderphoneLabel.setFont(font);
		senderphoneLabel.setBounds(padding, padding*3+label_height, label_width, label_height);	

		
		JLabel sendercompLabel = new JLabel("· 寄件人单位：");
		sendercompLabel.setFont(font);
		sendercompLabel.setBounds(padding*2+interval+label_width, padding*2, label_width, label_height);
		
		JLabel sendertelLabel = new JLabel("· 寄件人固话：");
		sendertelLabel.setFont(font);
	
		sendertelLabel.setBounds(padding*2+interval+label_width, padding*3+label_height, label_width, label_height);		
		JLabel senderaddrLabel = new JLabel("· 寄件人住址：");
		senderaddrLabel.setFont(font);
		senderaddrLabel.setBounds(padding, padding*4+label_height*2, label_width, label_height);

		
		sendername = new JTextField(20);
		sendername.setFont(font);
		sendername.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		sendername.setOpaque(false);
		sendername.setBounds(padding+interval, padding*2, label_width, label_height);
		sendername.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					e.consume();
					 KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		senderphone = new JTextField(20);
		senderphone.setFont(font);
		senderphone.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		senderphone.setOpaque(false);
		senderphone.setBounds(padding+interval,  padding*3+label_height, label_width, label_height);
		senderphone.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					e.consume();
					 KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		sendercomp = new JTextField(20);
		sendercomp.setFont(font);
		sendercomp.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		sendercomp.setOpaque(false);
		sendercomp.setBounds(padding*2+interval*2+label_width, padding*2, label_width, label_height);
		sendercomp.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					e.consume();
					 KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		sendertel = new JTextField(20);
		sendertel.setFont(font);
		sendertel.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		sendertel.setOpaque(false);
		sendertel.setBounds(padding*2+interval*2+label_width, padding*3+label_height, label_width, label_height);
		sendertel.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					e.consume();
					 KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		senderaddr = new JTextField(20);
		senderaddr.setFont(font);
		senderaddr.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		senderaddr.setOpaque(false);
		senderaddr.setBounds(padding+interval, padding*4+label_height*2, label_width*3, label_height);	
		senderaddr.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					e.consume();
					 KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JLabel receivernameLabel = new JLabel("· 收件人姓名：");
		receivernameLabel.setFont(font);
		receivernameLabel.setBounds(padding, padding*2, label_width, label_height);
		

		JLabel receiverphoneLabel = new JLabel("· 收件人手机：");
		receiverphoneLabel.setFont(font);
		receiverphoneLabel.setBounds(padding, padding*3+label_height, label_width, label_height);	
		
		JLabel receivercompLabel = new JLabel("· 收件人单位：");
		receivercompLabel.setFont(font);
		receivercompLabel.setBounds(padding*2+interval+label_width, padding*2, label_width, label_height);
		
		JLabel receivertelLabel = new JLabel("· 收件人固话：");
		receivertelLabel.setFont(font);
		receivertelLabel.setBounds(padding*2+interval+label_width, padding*3+label_height, label_width, label_height);
				
		JLabel receiveraddrLabel = new JLabel("· 收件人住址：");
		receiveraddrLabel.setFont(font);
		receiveraddrLabel.setBounds(padding, padding*4+label_height*2, label_width, label_height);

		
		receivername = new JTextField(20);
		receivername.setFont(font);
		receivername.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		receivername.setOpaque(false);
		receivername.setBounds(padding+interval, padding*2, label_width, label_height);
		receivername.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					e.consume();
					 KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		receiverphone = new JTextField(20);
		receiverphone.setFont(font);
		receiverphone.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		receiverphone.setOpaque(false);
		receiverphone.setBounds(padding+interval,  padding*3+label_height, label_width, label_height);
		receiverphone.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					e.consume();
					 KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		receivercomp = new JTextField(20);
		receivercomp.setFont(font);
		receivercomp.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		receivercomp.setOpaque(false);
		receivercomp.setBounds(padding*2+interval*2+label_width, padding*2, label_width, label_height);
		receivercomp.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					e.consume();
					 KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		receivertel = new JTextField(20);
		receivertel.setFont(font);
		receivertel.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		receivertel.setOpaque(false);
		receivertel.setBounds(padding*2+interval*2+label_width, padding*3+label_height, label_width, label_height);
		receivertel.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					e.consume();
					 KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		receiveraddr = new JTextField(20);
		receiveraddr.setFont(font);
		receiveraddr.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		receiveraddr.setOpaque(false);
		receiveraddr.setBounds(padding+interval, padding*4+label_height*2, label_width*3, label_height);
		receiveraddr.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					e.consume();
					 KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		text2= new JLabel();
		TitledBorder tb2 = BorderFactory.createTitledBorder("收件人信息");
		tb2.setTitleJustification(TitledBorder.LEFT);
		text2.setBounds(padding, padding*7+label_height*3, 820, padding*6+label_height*3);
		text2.setBorder(tb2);
		text2.setOpaque(false);
		
		info = new JPanel();
		info.setPreferredSize(new Dimension(800,1000));
		
		text3= new JLabel();
		TitledBorder tb3 = BorderFactory.createTitledBorder("货物信息");
		tb3.setTitleJustification(TitledBorder.LEFT);
		text3.setBounds(padding,padding*14+label_height*6, 820, padding*11+label_height*9);
		text3.setBorder(tb3);
		text3.setOpaque(false);
		
		JLabel initNumberLabel = new JLabel("· 原 件 数：");
		initNumberLabel.setFont(font);
		initNumberLabel.setBounds(padding, padding*2, label_width, label_height);
		
		JLabel trueweightLabel = new JLabel("· 实际重量：");
		trueweightLabel.setFont(font);
		trueweightLabel.setBounds(padding, padding*3+label_height, label_width, label_height);
		
		JLabel volumeLabel = new JLabel("· 体    积：");
		volumeLabel.setFont(font);
		volumeLabel.setBounds(padding, padding*4+label_height*2, label_width, label_height);
		
		JLabel goodstypeLabel = new JLabel("· 内件品名：");
		goodstypeLabel.setFont(font);
		goodstypeLabel.setBounds(padding, padding*5+label_height*3, label_width, label_height);
		
		JLabel transtypeLabel = new JLabel("· 快递类型：");
		transtypeLabel.setFont(font);
		transtypeLabel.setBounds(padding, padding*6+label_height*4, label_width, label_height);
		
		JLabel costLabel = new JLabel("· 包 装 费：");
		costLabel.setFont(font);
		costLabel.setBounds(padding, padding*7+label_height*5, label_width, label_height);
		
		JLabel costLabel2 = new JLabel("(纸箱(5元)、木箱(10元)、快递袋(1元))");
		costLabel2.setFont(font);
		costLabel2.setBounds(padding, padding*7+label_height*6, 500, label_height);
		
		JLabel allcostLabel = new JLabel("· 费用合计：");
		allcostLabel.setFont(font);
		allcostLabel.setBounds(padding, padding*8+label_height*7, label_width, label_height);
		
		JLabel orderLabel = new JLabel("· 订单条形码号：");
		orderLabel.setFont(font);
		orderLabel.setBounds(padding, padding*9+label_height*8, label_width, label_height);
		
		initNumber = new JTextField(20);
		initNumber.setFont(font);
		initNumber.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		initNumber.setOpaque(false);
		initNumber.setBounds(padding*2+interval, padding*2, label_width, label_height);
		initNumber.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					e.consume();
					 KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		trueweight = new JTextField(20);
		trueweight.setFont(font);
		trueweight.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		trueweight.setOpaque(false);
		trueweight.setBounds(padding*2+interval, padding*3+label_height*1, label_width, label_height);
		trueweight.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					e.consume();
					 KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		volume = new JTextField(20);
		volume.setFont(font);
		volume.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		volume.setOpaque(false);
		volume.setBounds(padding*2+interval,  padding*4+label_height*2, label_width, label_height);
		volume.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					e.consume();
					 KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		goodstype = new JTextField(20);
		goodstype.setFont(font);
		goodstype.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		goodstype.setOpaque(false);
		goodstype.setBounds(padding*2+interval, padding*5+label_height*3, label_width, label_height);
		goodstype.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					e.consume();
					 KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		ButtonGroup g = new ButtonGroup();
		
		JRadioButton finan = new JRadioButton("经济快递",true);
		finan.setFont(font);
		finan.setBorder(null);
		finan.setBounds(padding*2+interval,padding*6+label_height*4, box_width, box_height);
		finan.setOpaque(false);
		
		JRadioButton st = new JRadioButton("标准快递");
		st.setFont(font);
		st.setBorder(null);
		st.setBounds(padding*2+interval*2,padding*6+label_height*4, box_width, box_height);
		st.setOpaque(false);
		
		JRadioButton fast = new JRadioButton("特快");
		fast.setFont(font);
		fast.setBorder(null);
		fast.setBounds(padding*2+interval*3,padding*6+label_height*4, box_width, box_height);
		fast.setOpaque(false);
		
		JTextField cost = new JTextField(20);
		cost.setFont(font);
		cost.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		cost.setOpaque(false);
		cost.setBounds(padding*2+interval,  padding*6+label_height*5, label_width, label_height);
		
		JTextField allcost = new JTextField(20);
		allcost.setFont(font);
		allcost.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		allcost.setOpaque(false);
		allcost.setBounds(padding*2+interval,  padding*8+label_height*7, label_width, label_height);
		//allcost.setText(t);
		allcost.setEditable(false);
		
		order = new JTextField(20);
		order.setFont(font);
		order.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		order.setOpaque(false);
		order.setBounds(padding*2+interval+15,  padding*9+label_height*8, label_width, label_height);
		
		info = new JPanel();
		info.setPreferredSize(new Dimension(880,text1.getHeight()+text2.getHeight()+text3.getHeight()+padding*5));
		info.setBorder(null);
		info.setLayout(null);
		info.setOpaque(false);
		info.add(text1);
		info.add(text2);
		info.add(text3);
		
		text1.add(sendernameLabel);
		text1.add(senderaddrLabel);
		text1.add(sendercompLabel);
		text1.add(sendertelLabel);
		text1.add(senderphoneLabel);
		text1.add(sendername);
		text1.add(senderaddr);
		text1.add(sendercomp);
		text1.add(sendertel);
		text1.add(senderphone);
		
		text2.add(receivernameLabel);
		text2.add(receiveraddrLabel);
		text2.add(receivercompLabel);
		text2.add(receivertelLabel);
		text2.add(receiverphoneLabel);
		text2.add(receivername);
		text2.add(receiveraddr);
		text2.add(receivercomp);
		text2.add(receivertel);
		text2.add(receiverphone);		

		text3.add(initNumberLabel);
		text3.add(trueweightLabel);
		text3.add(volumeLabel);
		text3.add(goodstypeLabel);
		text3.add(transtypeLabel);
		text3.add(costLabel);
		text3.add(costLabel2);
		text3.add(allcostLabel);
		text3.add(orderLabel);
		text3.add(trueweight);
		text3.add(initNumber);
		text3.add(volume);
		text3.add(goodstype);
		text3.add(st);
		text3.add(fast);
		text3.add(finan);
		text3.add(cost);
		text3.add(order);
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

			public void mousePressed(MouseEvent e) {}

			public void mouseReleased(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {
				PictureButton.setIcon("src/main/java/image/submitButton_clicked.png",submit);
			}

			public void mouseExited(MouseEvent e) {
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
				SendPanel.this.setVisible(false);
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
		this.add(scrollPane);
		this.add(submit);
		this.add(back);		
	}
	
	class SubmitListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

package presentation.Receiptsui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import Miscellaneous.Job;
import businessLogic.Receiptsbl.Receiptsbl;
import presentation.Userui.MainPanel;
import presentation.mainui.PictureButton;
import vo.UserVO;
import vo.receipts.IncomeVO;
import vo.receipts.PaymentVO;
import businessLogicService.ReceiptsblService.ReceiptsblService;
import businessLogicService.UserblService.UserblService;
/**
 * 付款单
 * @author TOSHIBA
 *
 */
public class PaymentPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel title;
	JLabel date;
	ButtonGroup bg;
	JButton submit;
	JButton back;
	JRadioButton j1,j2,j3,j4;
	JTextField cost;
	JTextField name;
	JTextField payaccount;
	JTextArea psarea;
	private UserblService user;
	private ReceiptsblService bl;
	private int buttonNum;
	public PaymentPanel(UserblService user, int buttonNum){
		bl = new Receiptsbl(user);
		this.user=user;
		this.buttonNum = buttonNum;
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		initPPanel();
	}
	private void initPPanel() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,18);
		title = new JLabel(user.getCompanyName()+"付款单",JLabel.CENTER);
		title.setFont(font);
		title.setBounds(150, 10, 600, 50);
		
		JLabel dateLabel = new JLabel("· 付款日期: ");
		dateLabel.setFont(font);
		dateLabel.setBounds(50, 60, 300, 50);	
		
		JLabel costLabel = new JLabel("· 付款金额：");
		costLabel.setFont(font);
		costLabel.setBounds(50, 100, 300, 50);
		
		JLabel list = new JLabel("· 付款条目：");
		list.setFont(font);
		list.setBounds(50, 140, 300, 50);
		
		JLabel payer = new JLabel("· 付 款 人：");
		payer.setFont(font);
		payer.setBounds(50,180,300,50);
		
		JLabel account = new JLabel("· 付款账号：");
		account.setFont(font);
		account.setBounds(50,220,300,50);
		
		JLabel ps = new JLabel("· 备        注：");
		ps.setFont(font);
		ps.setBounds(50,260,300,50);
		
		date = new JLabel(bl.getCurrentTime()); 
		date.setFont(font);
		date.setBounds(200, 60, 300, 50);
		
		cost = new JTextField();
		cost.setFont(font);
		cost.setBounds(200, 100, 160, 40);
		cost.setBorder(new MatteBorder(0,0,1,0,Color.black));
		cost.setOpaque(false);
		cost.addFocusListener(new FocusListener(){

			public void focusGained(FocusEvent e) {

			}

			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (cost.getText().equals("")) return;
				double money_double = Double.parseDouble(cost.getText());
				cost.setText(String.format("%.2f", money_double));
			}
			
		});
		bg = new ButtonGroup();
		cost.addKeyListener(new KeyListener(){

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
		ButtonGroup bg = new ButtonGroup();
		
		j1 = new JRadioButton("租金",true);
		j1.setFont(font);
		j1.setBounds(200, 145, 60, 40);
		j1.setBorder(null);
		j1.setOpaque(false);
		
		j2 = new JRadioButton("运费",false);
		j2.setFont(font);
		j2.setBounds(280, 145, 60, 40);
		j2.setBorder(null);
		j2.setOpaque(false);
		
		j3 = new JRadioButton("员工工资",false);
		j3.setFont(font);
		j3.setBounds(360, 145, 100, 40);
		j3.setBorder(null);
		j3.setOpaque(false);
		
		j4 = new JRadioButton("运费",false);
		j4.setFont(font);
		j4.setBounds(470, 145, 60, 40);
		j4.setBorder(null);
		j4.setOpaque(false);
		
		name = new JTextField();
		name.setFont(font);
		name.setBounds(200, 180, 160, 40);
		name.setBorder(new MatteBorder(0,0,1,0,Color.black));
		name.setOpaque(false);
		name.setText(user.getUserName());
		name.setEditable(false);
		name.addKeyListener(new KeyListener(){

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
		
		payaccount= new JTextField();
		payaccount.setFont(font);
		payaccount.setBounds(200, 220, 160, 40);
		payaccount.setBorder(new MatteBorder(0,0,1,0,Color.black));
		payaccount.setOpaque(false);
		payaccount.addKeyListener(new KeyListener(){

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
		
		psarea = new JTextArea();
		psarea.setFont(font);
		psarea.setBounds(200, 270, 400, 150);
		psarea.setLineWrap(true);
		psarea.setBorder(BorderFactory.createLineBorder(Color.black));
		psarea.setOpaque(false);
		
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
				PaymentPanel.this.setVisible(false);
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
		this.add(date);
		this.add(dateLabel);
		this.add(costLabel);
		
		this.add(list);
		bg.add(j1);
		this.add(j1);
		bg.add(j2);
		this.add(j2);
		bg.add(j3);
		this.add(j3);
		bg.add(j4);
		this.add(j4);
		this.add(payer);
		this.add(account);
		this.add(ps);
		this.add(cost);
		this.add(name);
		this.add(payaccount);		
		this.add(psarea);
		this.add(submit);
		this.add(back);
	}
	
	class SubmitListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
			if (cost.getText().equals("")){
				JOptionPane.showMessageDialog(null, "请输入付款金额！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if (payaccount.getText().equals("")){
				JOptionPane.showMessageDialog(null, "请输入付款账号！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			String s = payaccount.getText();
			try{
				long id = Long.parseLong(s);
			}catch(NumberFormatException e1){
				//输入编号不是数字
				JOptionPane.showMessageDialog(null, "请输入正确的付款账号！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
	 		if(! bl.findAccount(s)){
				//System.out.println("找不到");
	 			
				JOptionPane.showMessageDialog(null, "该账号不存在！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
	 		String Item = "";
	 		if (j1.isSelected()) Item = j1.getText();
	 		else if (j2.isSelected()) Item = j2.getText();
	 		else if (j3.isSelected()) Item = j3.getText();
	 		else if (j4.isSelected()) Item = j4.getText();
	 		else {
	 			JOptionPane.showMessageDialog(null, "请选择付款条目！","", JOptionPane.ERROR_MESSAGE);
				return;
	 		}
		 	
		 	int n = JOptionPane.showConfirmDialog(null, "确定提交?", "确认框",JOptionPane.YES_NO_OPTION);
			if (n == 1) {
				return;
			}
			/*String name, String creator, String date, 
			String account, String amount, String item, String memo*/
		 	PaymentVO paymentVO = new PaymentVO(title.getText(),user.getUserName(),
		 			date.getText(), payaccount.getText(), cost.getText(), Item, psarea.getText());
		 	bl.addReceipt(paymentVO);
		 	
		 	date.setText(bl.getCurrentTime());
		 	payaccount.setText("");
		 	cost.setText("");
		 	bg.clearSelection();
		 	psarea.setText("");
		 	JOptionPane.showMessageDialog(null, "提交成功^_^","", JOptionPane.CLOSED_OPTION);
		}
	}
}

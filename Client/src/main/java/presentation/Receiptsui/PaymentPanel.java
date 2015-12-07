package presentation.Receiptsui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

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
	private UserblService user;
	public PaymentPanel(UserblService user){
		this.user=user;
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		initPPanel();
	}
	private void initPPanel() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,18);
		JLabel title = new JLabel(user.getCompanyName()+"付款单",JLabel.CENTER);
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
		
		JLabel date = new JLabel("2015/12/2"); //改
		date.setFont(font);
		date.setBounds(200, 60, 300, 50);
		
		JTextField cost = new JTextField();
		cost.setFont(font);
		cost.setBounds(200, 100, 160, 40);
		cost.setBorder(new MatteBorder(0,0,1,0,Color.black));
		cost.setOpaque(false);
		
		ButtonGroup bg = new ButtonGroup();
		
		JRadioButton j1 = new JRadioButton("租金",true);
		j1.setFont(font);
		j1.setBounds(200, 145, 60, 40);
		j1.setBorder(null);
		j1.setOpaque(false);
		
		JRadioButton j2 = new JRadioButton("运费",false);
		j2.setFont(font);
		j2.setBounds(280, 145, 60, 40);
		j2.setBorder(null);
		j2.setOpaque(false);
		
		JRadioButton j3 = new JRadioButton("员工工资",false);
		j3.setFont(font);
		j3.setBounds(360, 145, 100, 40);
		j3.setBorder(null);
		j3.setOpaque(false);
		
		JRadioButton j4 = new JRadioButton("运费",false);
		j4.setFont(font);
		j4.setBounds(470, 145, 60, 40);
		j4.setBorder(null);
		j4.setOpaque(false);
		
		JTextField name = new JTextField();
		name.setFont(font);
		name.setBounds(200, 180, 160, 40);
		name.setBorder(new MatteBorder(0,0,1,0,Color.black));
		name.setOpaque(false);
		
		JTextField payaccount = new JTextField();
		payaccount.setFont(font);
		payaccount.setBounds(200, 220, 160, 40);
		payaccount.setBorder(new MatteBorder(0,0,1,0,Color.black));
		payaccount.setOpaque(false);
		
		JTextArea psarea = new JTextArea();
		psarea.setFont(font);
		psarea.setBounds(200, 270, 400, 150);
		psarea.setLineWrap(true);
		psarea.setBorder(BorderFactory.createLineBorder(Color.black));
		psarea.setOpaque(false);
		
		JButton submit = new JButton("提交");
		submit.setFont(font);
		submit.setBounds(700, 500, 80, 40);
		
		JButton back = new JButton("返回");
		back.setFont(font);
		back.setBounds(800, 500, 80, 40);
		
		this.add(title);
		this.add(date);
		this.add(dateLabel);
		this.add(costLabel);
		this.add(cost);
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
		this.add(name);
		this.add(account);
		this.add(payaccount);
		this.add(ps);
		this.add(psarea);
		this.add(submit);
		this.add(back);
	}

}

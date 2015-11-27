package presentation.LogisticsInfoSearchui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import businessLogic.LogisticsInfoSearchbl.LogisticsInfoSearchbl;
import businessLogicService.LogisticsInfoSearchblService.LogisticsInfoSearchblService;
import init.Client;
import presentation.mainui.WelcomePanel;
import vo.LogisticsVO;

public class LogisticsPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LogisticsInfoSearchblService bl;
	private JTextField orderNumber;
	private JTextArea text;
	private JLabel idLabel;
	private JPanel display;
	public LogisticsPanel(){
		bl = new LogisticsInfoSearchbl();
		this.setSize(1024,768);
		this.setLayout(null);
		this.initbg();
		this.initInput();
		this.initDisplay();
		this.initReturn();
		this.setVisible(true);
	}
	
	
	final int BUTTON_WIDTH = 200;
	final int BUTTON_HEIGHT = 40;
	final int LEFT_PADDING = 30;
	final int TOP_PADDING = 50;
	final int BUTTOM_PADDING = 100;
	final int PADDING_HORIZATION = 30;
	
	private void initReturn() {
		JButton back = new JButton("返回");
		back.setBounds(this.getWidth()-2*LEFT_PADDING-BUTTON_WIDTH, 
				       this.getHeight()-2*TOP_PADDING-BUTTON_HEIGHT, 
				       BUTTON_WIDTH, BUTTON_HEIGHT);
		
		
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				Client.frame.add(new WelcomePanel());
				Client.frame.remove(LogisticsPanel.this);
				Client.frame.repaint();
			}
		});
		
		this.add(back);
		
	}

	private void initbg() {
		JLabel bg = new JLabel("这也是背景图片",JLabel.CENTER);
		bg.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.add(bg);
	}

	private void initInput(){
		JLabel label = new JLabel("请输入您的快递单号: ");
		orderNumber = new JTextField(15);
		JButton searchButton = new JButton("查询");
		searchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				searchInfo();
			}
		});
		
		JPanel inputPanel = new JPanel();
		inputPanel.setBounds(LEFT_PADDING, TOP_PADDING, this.getWidth(), BUTTON_HEIGHT);
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(label);
		inputPanel.add(orderNumber);
		inputPanel.add(searchButton);
		
		this.add(inputPanel);
	}
	private void initDisplay() {
		
		
		text = new JTextArea();
		TitledBorder tb = BorderFactory.createTitledBorder("物流信息");
		tb.setTitleJustification(TitledBorder.LEFT);
		text.setBorder(tb);
		JScrollPane scrollPane = new JScrollPane(text);
		
		idLabel = new JLabel("·订单条形码号:");
		
	    display = new JPanel();
//	    display.setOpaque(true);
//	    display.setBackground(Color.BLACK);
	    display.setBounds(2*LEFT_PADDING, 
	    				  TOP_PADDING + BUTTON_HEIGHT + PADDING_HORIZATION,
	    				  300,
	    				  this.getHeight() - (TOP_PADDING + BUTTON_HEIGHT + PADDING_HORIZATION) - BUTTOM_PADDING
	    );
	    display.setLayout(new BoxLayout(display,BoxLayout.Y_AXIS));
	    display.add(idLabel);
	    display.add(scrollPane);
	    display.setVisible(false);
		this.add(display);
	}	
	private void searchInfo() {
		// TODO Auto-generated method stub
		String order = orderNumber.getText();
		long id = 0;
		try{
			id = Long.parseLong(order);
		}catch(NumberFormatException e){
			//输入数量不是整数
			JOptionPane.showMessageDialog(null, "请输入正确的订单条形码号","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		LogisticsVO logistics = bl.search(order);
		//查无商品
		if(logistics == null){
			JOptionPane.showMessageDialog(null, "找不到对应的订单信息(请输1234567890)","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		//清空输入
		orderNumber.setText("");
		text.setText("");
		//显示物流信息
		idLabel.setText("·订单条形码号: " + order);
		for (String state: logistics.getState()){
			text.append("  · "+state+"\n");
		}
		display.setVisible(true);
		
		
	}
}

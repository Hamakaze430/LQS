package presentation.LogisticsInfoSearchui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import businessLogic.LogisticsInfoSearchbl.LogisticsInfoSearchbl;
import businessLogicService.LogisticsInfoSearchblService.LogisticsInfoSearchblService;
import init.Client;
import presentation.mainui.PictureLabel;
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
	
		this.initInput();
		this.initDisplay();
		this.initReturn();
		this.initbg();
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
		JLabel bg = new PictureLabel("src/main/java/image/SearchBG.jpg");
		bg.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.add(bg);
	}

	private void initInput(){
		JLabel label = new JLabel("请输入您的快递单号（10位数字）: ");
		label.setForeground(Color.white);
		label.setFont(new Font("华文彩云",Font.PLAIN,20));
		orderNumber = new JTextField(8);
		orderNumber.setOpaque(false);
		orderNumber.setBorder(new MatteBorder(0, 0, 1, 0, Color.WHITE));
		orderNumber.setForeground(Color.WHITE);
		orderNumber.setFont(new Font("Meiryo UI",Font.BOLD,20));
		orderNumber.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				searchInfo();
			}
			
		});
		JButton searchButton = new JButton("回车");
		searchButton.setFont(new Font("华文彩云",Font.PLAIN,25));
		searchButton.setForeground(Color.WHITE);
		searchButton.setContentAreaFilled(false);
		searchButton.setOpaque(false);
		searchButton.setBorder(null);
		searchButton.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				searchInfo();
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				((JButton)e.getSource()).setText("查询");
				((JButton)e.getSource()).setBorder(new MatteBorder(0, 0, 1, 0, Color.WHITE));
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				((JButton)e.getSource()).setText("回车");
				((JButton)e.getSource()).setBorder(null);
			}
			
		});
		
		JPanel inputPanel = new JPanel();
		inputPanel.setOpaque(false);
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
			//System.out.println("找不到");
			JOptionPane.showMessageDialog(null, "找不到对应的订单信息","", JOptionPane.ERROR_MESSAGE);
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

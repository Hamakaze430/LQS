/**
 * 物流查询界面
 */
package presentation.LogisticsInfoSearchui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
import presentation.Userui.LoginPanel;
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
	
	/**
	 * 含"返回"按钮，返回开始界面
	 */
	private void initReturn() {
		 final JButton back = new JButton();
		
		back.setBounds(850,600,110, 110);
		setIcon("src/main/java/image/Search_back.png", back);
		back.setBorder(null);
		back.setFocusPainted(false);
		back.setContentAreaFilled(false);
		back.addMouseListener(new MouseListener(){

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
				back.setBounds(840,590,130, 130);
				setIcon("src/main/java/image/Search_back.png", back);
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				back.setBounds(850,600,110, 110);
				setIcon("src/main/java/image/Search_back.png", back);
			}
			
		});
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				Client.frame.add(new WelcomePanel());
				Client.frame.remove(LogisticsPanel.this);
				Client.frame.repaint();
			}
		});
		
		this.add(back);
		
	}

	
	/**
	 * 背景图片
	 */
	private void initbg() {
		JLabel bg = new PictureLabel("src/main/java/image/2.jpg");
		bg.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.add(bg);
	}

	
	/**
	 * 输入框
	 */
	private void initInput(){
		JLabel label = new JLabel("请输入您的快递单号（10位数字）: ");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("微软雅黑",Font.PLAIN,18));
		orderNumber = new JTextField(8);
		orderNumber.setCaretColor(Color.WHITE);
		orderNumber.setOpaque(false);
		orderNumber.setBorder(new MatteBorder(0, 0, 1, 0, Color.WHITE));
		orderNumber.setForeground(Color.WHITE);
		orderNumber.setFont(new Font("Meiryo UI",Font.BOLD,18));
		orderNumber.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				searchInfo();
			}
			
		});
		JButton searchButton = new JButton("查询");
		searchButton.setFont(new Font("微软雅黑",Font.PLAIN,20));
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
				
				((JButton)e.getSource()).setBorder(new MatteBorder(0, 0, 1, 0, Color.WHITE));
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
				((JButton)e.getSource()).setBorder(null);
			}
			
		});
		
		JPanel inputPanel = new JPanel();
		inputPanel.setOpaque(false);
		inputPanel.setBounds(LEFT_PADDING, TOP_PADDING+10, this.getWidth(), BUTTON_HEIGHT);
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(label);
		inputPanel.add(orderNumber);
		inputPanel.add(searchButton);
		
		this.add(inputPanel);
	}
	
	/**
	 * 显示框
	 * 未完善
	 */
	private void initDisplay() {
		
		Font font = new Font("微软雅黑",Font.PLAIN,18);
		text = new JTextArea();
		text.setFont(font);
		text.setOpaque(false);
		//text.setBackground(new Color(255,255,255,60));
		text.setForeground(Color.black);
//		text.setEnabled(false);
		text.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(text);
		scrollPane.setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		idLabel = new JLabel("· 订单条形码号:");
		idLabel.setFont(font);
		idLabel.setForeground(Color.BLACK);
	    display = new JPanel();
	    display.setOpaque(false);
	   // display.setBackground(new Color(255,255,255,0));
	    display.setBounds(2*LEFT_PADDING+10, 
	    				  TOP_PADDING + BUTTON_HEIGHT + PADDING_HORIZATION,
	    				  490,
	    				  this.getHeight() - (TOP_PADDING + BUTTON_HEIGHT + PADDING_HORIZATION) - BUTTOM_PADDING
	    );
	    
	    JPanel bg = new JPanel();
	    bg.setBackground(new Color(255,255,255,60));
	    bg.setBounds(2*LEFT_PADDING, 
				  TOP_PADDING + BUTTON_HEIGHT + PADDING_HORIZATION,
				  500,
				  this.getHeight() - (TOP_PADDING + BUTTON_HEIGHT + PADDING_HORIZATION) - BUTTOM_PADDING
	    		);
	    bg.setVisible(true);
	    this.add(bg);
	    display.setLayout(new BoxLayout(display,BoxLayout.Y_AXIS));
	    display.add(idLabel);
	    display.add(scrollPane);
//	    display.add(text);
	    display.setVisible(false);
		this.add(display);
		 
	}	
	
	/**
	 * 物流信息处理，包括报错和逻辑
	 */
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
		display.setVisible(false);
		orderNumber.setText("");
		text.setText("");
		//显示物流信息
		idLabel.setText("· 订单条形码号: " + order);
		int i = 0;
		List<String> list = logistics.getState();
		for (; i <list.size()-1; i++){
			text.append("  · "+list.get(i)+"\n");
		}
		text.append("  · "+list.get(i));
		display.setVisible(true);
		this.repaint();
		
		
	}
	
	/**
	 * Button设置图片的方法
	 */
	private void setIcon(String file,JButton iconButton){
		ImageIcon icon = new ImageIcon(file);
		Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(), iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		iconButton.setIcon(icon);
	}
}

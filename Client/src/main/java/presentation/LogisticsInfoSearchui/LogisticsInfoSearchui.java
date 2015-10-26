package presentation.LogisticsInfoSearchui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import businessLogicService.LogisticsInfoSearchblService.LogisticsInfoSearchblService;
import vo.LogisticsVO;
import vo.State;

public class LogisticsInfoSearchui extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LogisticsInfoSearchblService bl;
	private JTextField orderNumber;
	private JTextArea text;
	private JLabel idLabel;
	private JPanel display;
	public LogisticsInfoSearchui(LogisticsInfoSearchblService bl){
		this.bl = bl;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		this.initInput();
		this.initDisplay();
		
		this.validate();
	}
	
	private void initDisplay() {
		
		
		text = new JTextArea();
		TitledBorder tb = BorderFactory.createTitledBorder("物流信息");
		tb.setTitleJustification(TitledBorder.LEFT);
		text.setBorder(tb);
		JScrollPane scrollPane = new JScrollPane(text);
		
		idLabel = new JLabel("订单条形码号: ");
		
	    display = new JPanel();
	    display.setLayout(new BoxLayout(display,BoxLayout.Y_AXIS));
	    display.add(idLabel);
	    display.add(scrollPane);
	    display.setVisible(false);
		this.add(display);
	}

	private void initInput(){
		JLabel label = new JLabel("输入订单条形码号: ");
		orderNumber = new JTextField(10);
		
		JButton searchButton = new JButton("查询");
		searchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				searchInfo();
			}
		});
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(label);
		inputPanel.add(orderNumber);
		inputPanel.add(searchButton);
		
		this.add(inputPanel);
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
			JOptionPane.showMessageDialog(null, "找不到对应的订单信息","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		//清空输入
		orderNumber.setText("");
		text.setText("");
		//显示物流信息
		idLabel.setText("订单条形码号: " + order);
		for (State state: logistics.getState()){
			text.append(state.toString()+"\n");
		}
		display.setVisible(true);
		
		
	}
}

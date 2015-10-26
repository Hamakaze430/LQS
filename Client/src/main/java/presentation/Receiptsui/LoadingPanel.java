package presentation.Receiptsui;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vo.UserVO;
import vo.receipt.LoadingVO;

public class LoadingPanel extends ReceiptPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserVO user;
	private LoadingVO one;
	public LoadingPanel(UserVO user){
		this.user = user;
		init();
	}
	private void init() {
		// TODO Auto-generated method stub
		/*
		 * 装车日期、本营业厅编号（025城市编码+000鼓楼营业厅）、
		 * 汽运编号 （营业厅编号+20150921日期+00000编码 、五位数字）、
		 * 到达地（本地中转中心或者其它营业厅）、
		 * 车辆代号、监装员、押运员、本次装箱所有订单条形码号）、
		 * 运费（运费根据出发地和目的地自动生成）。
		 * String id;
			String destination;
	String carID;
	String supervisor;
	String driver;
	ArrayList<Long> order;
		 */
		one = new LoadingVO(user);
		JLabel dateLabel = new JLabel("装车日期: ");
		JTextField date = new JTextField(7);
		date.setHorizontalAlignment(JTextField.CENTER);
		date.setText(((LoadingVO) one).getDate());
		date.setEditable(false);
		
		JLabel hallIdLabel = new JLabel("本营业厅编号: ");
		JTextField hallId = new JTextField(5);
		hallId.setHorizontalAlignment(JTextField.CENTER);
		hallId.setText(((LoadingVO) one).getHallId());
		hallId.setEditable(false);
		
		JLabel idLabel = new JLabel("汽运标号: ");
		JTextField foreId = new JTextField(10);
		foreId.setHorizontalAlignment(JTextField.CENTER);
		foreId.setText(((LoadingVO) one).getForeId());
		foreId.setEditable(false);
		JTextField id = new JTextField(5);
		id.setHorizontalAlignment(JTextField.CENTER);
		id.setText(((LoadingVO) one).getPartId());
		
		this.add(dateLabel);
		this.add(date);
		this.add(hallIdLabel);
		this.add(hallId);
		this.add(idLabel);
		this.add(foreId);
		this.add(id);
	}
	
}

package presentation.Receiptsui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vo.ReceiptVO;
import vo.receipt.LoadingVO;

public class ReceiptPanel extends JPanel{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private ReceiptVO one;
	
	public ReceiptPanel(int type){
		switch (type){
		case 0:{
			/*
			 * 装车日期、本营业厅编号（025城市编码+000鼓楼营业厅）、
			 * 汽运编号 （营业厅编号+20150921日期+00000编码 、五位数字）、
			 * 到达地（本地中转中心或者其它营业厅）、
			 * 车辆代号、监装员、押运员、本次装箱所有订单条形码号）、
			 * 运费（运费根据出发地和目的地自动生成）。
			 */
			one = new LoadingVO();
			JLabel dateLabel = new JLabel("装车日期: ");
			JTextField date = new JTextField(7);
			date.setHorizontalAlignment(JTextField.CENTER);
			date.setText(((LoadingVO) one).getDate());
			date.setEditable(false);
			JLabel hallIdLabel = new JLabel("本营业厅编号");
			JTextField hallId = new JTextField(7);
			hallId.setHorizontalAlignment(JTextField.CENTER);
			hallId.setText(((LoadingVO) one).getHallID());
			hallId.setEditable(false);
			this.add(dateLabel);
			this.add(date);
		}
		default: break;
		}
	}
}

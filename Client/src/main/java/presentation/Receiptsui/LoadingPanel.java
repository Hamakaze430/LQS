package presentation.Receiptsui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class LoadingPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private ReceiptPanel parent;
	public LoadingPanel(ReceiptPanel parent){
		this.parent = parent;
		init();
		
	}
	private void init() {
		// TODO Auto-generated method stub
		DateFormat formatter1 = new SimpleDateFormat("yyyy.MM.dd");
		DateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
		Date currentDate = new Date();
		
		JLabel dateLabel = new JLabel("装车日期: ");
		JTextField date = new JTextField(7);
		date.setHorizontalAlignment(JTextField.CENTER);
		
		date.setText(formatter1.format(currentDate));
		date.setEditable(false);
		
		JLabel hallIdLabel = new JLabel("营业厅编号: ");
		JTextField hallId = new JTextField(5);
		hallId.setHorizontalAlignment(JTextField.CENTER);
		hallId.setText(parent.user.hall.id);
		hallId.setEditable(false);
		
		JLabel idLabel = new JLabel("汽运编号: ");
		JTextField id = new JTextField(15);
		id.setHorizontalAlignment(JTextField.CENTER);
		
		id.setText(
				hallId.getText()
				+formatter2.format(currentDate)
				+parent.bl.getLoadingId()
		);

		id.setEditable(false);
		
		
		JButton submit = new JButton("提交");
		submit.addActionListener(new SubmitAction());
		
		this.add(dateLabel);
		this.add(date);
		this.add(hallIdLabel);
		this.add(hallId);
		this.add(idLabel);
		this.add(id);
		this.add(submit);
	}
	
	class SubmitAction implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			
		}
	
	}
}

package presentation.Receiptsui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import businessLogicService.ReceiptsblService.ReceiptsblService;
import vo.UserVO;

public class Receiptsui extends JPanel{
	private ReceiptsblService bl;
	private ReceiptPanel one;
	private UserVO user;
	public Receiptsui(ReceiptsblService bl,UserVO user){
		this.user = user;
		this.bl = bl;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		this.initDisplay(0);
		this.initButton();
		
		this.validate();
	}
	
	private void initDisplay(int type) {
		// TODO Auto-generated method stub
		switch (type){
		case 0: one = new LoadingPanel(user); break;
		default: break;
		}
		this.add(one);
	}
	
	private void initButton() {
		// TODO Auto-generated method stub
		JButton save = new JButton("保存");
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				saveReceipts();
			}
		});
		JButton submit = new JButton("提交");
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				submitReceipts();
			}
		});
		JButton close = new JButton("关闭");	
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				closeReceipts();
			}
		});
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.add(save);
		panel.add(submit);
		panel.add(close);
		
		this.add(panel);
	}
	
	private void saveReceipts() {
		// TODO Auto-generated method stub
		
	}
	private void submitReceipts() {
		// TODO Auto-generated method stub
		
	}
	private void closeReceipts() {
		// TODO Auto-generated method stub
		
	}

}

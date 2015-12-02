package presentation.Receiptsui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businessLogicService.UserblService.UserblService;
/**
 * 收件单
 * @author TOSHIBA
 *
 */
public class ReceivePanel extends JPanel{
	private UserblService user;
	public ReceivePanel(UserblService user){
		this.user = user;
		init();
	}

	private void init() {
		JLabel title = new JLabel(user.getHallName()+"收件单");
		JLabel idLabel = new JLabel("· 收件编号: ");
		JTextField id = new JTextField(20);
		JLabel nameLabel = new JLabel("· 收件人姓名: ");
		JTextField name = new JTextField(20);
		JLabel dateLabel = new JLabel("· 收件日期: ");
		JLabel date = new JLabel("2015/12/2"); //改
		JButton submit = new JButton("提交");
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
				
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}	
		});
		this.add(title);
		this.add(idLabel);
		this.add(id);
		this.add(nameLabel);
		this.add(name);
		this.add(dateLabel);
		this.add(date);
		this.add(submit);
	}
}

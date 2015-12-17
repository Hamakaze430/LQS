package presentation.Receiptsui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import businessLogic.Receiptsbl.Receiptsbl;
import businessLogicService.ReceiptsblService.ReceiptsblService;
import businessLogicService.UserblService.UserblService;
/**
 * 收件单
 * @author TOSHIBA
 *
 */
public class ReceivePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserblService user;
	private ReceiptsblService bl;
	public ReceivePanel(UserblService user){
		this.user = user;
		bl = new Receiptsbl(user);
		this.setLayout(null);
		this.setOpaque(false);
		this.setBorder(null);
		init();
	}

	private void init() {
		Font font = new Font("黑体",Font.PLAIN,18);
		JLabel title = new JLabel(user.getHallName()+"收件单",JLabel.CENTER);
		title.setFont(font);
		title.setBounds(150, 10, 600, 50);
		
		JLabel idLabel = new JLabel("· 收件编号: ");
		idLabel.setFont(font);
		idLabel.setBounds(50, 60, 300, 50);		
		
		JTextField id = new JTextField(20);
		id.setFont(new Font("黑体",Font.PLAIN,15));
		id.setOpaque(false);
		id.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		id.setBounds(170, 65, 200, 40);
		
		JLabel nameLabel = new JLabel("· 收件人姓名: ");
		nameLabel.setFont(font);
		nameLabel.setBounds(50, 160, 300, 50);	
		
		JTextField name = new JTextField(20);
		name.setFont(new Font("黑体",Font.PLAIN,15));
		name.setOpaque(false);
		name.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		name.setBounds(180, 165, 190, 40);
		
		JLabel dateLabel = new JLabel("· 收件日期: ");
		dateLabel.setFont(font);
		dateLabel.setBounds(50, 260, 300, 50);	
		
		JLabel date = new JLabel(); 
		date.setText(bl.getCurrentTime());
		date.setFont(font);
		date.setBounds(170, 260, 300, 50);
		
		
		JButton submit = new JButton("提交");
		submit.setBounds(750, 480, 80, 40);
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

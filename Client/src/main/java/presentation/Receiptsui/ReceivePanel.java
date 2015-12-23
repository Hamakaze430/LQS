package presentation.Receiptsui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

<<<<<<< HEAD
=======
import presentation.Userui.ApartmentManagerPanel;
>>>>>>> cbe00da9c0dffa9b67dd64d9a93858b9dea56d6d
import presentation.Userui.MainPanel;
import presentation.mainui.PictureButton;
import vo.ReceiptVO;
import vo.receipts.LoadingVO;
import vo.receipts.ReceiveVO;
import businessLogic.Receiptsbl.Receiptsbl;
import businessLogicService.ReceiptsblService.ReceiptsblService;
import businessLogicService.UserblService.UserblService;
/**
 * 收件单
 * 好惹
 * @author TOSHIBA
 *
 */
public class ReceivePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel title;
	JButton back;
	JButton submit;
	JTextField id;
	JTextField name;
	JLabel date;
	int padding =10;
	int interval = 140;
	int label_width = 200;
	int label_height = 30;;
	int button_width = 70;
	int button_height = 30;
	private UserblService user;
	private ReceiptsblService bl;
<<<<<<< HEAD
	int buttonNum;
=======
	private int buttonNum;
>>>>>>> cbe00da9c0dffa9b67dd64d9a93858b9dea56d6d
	public ReceivePanel(UserblService user,int buttonNum){
		this.user = user;
		this.buttonNum = buttonNum;
		bl = new Receiptsbl(user);
		this.buttonNum = buttonNum;
		this.setLayout(null);
		this.setOpaque(false);
		this.setBorder(null);
		init();
	}

	private void init() {
		Font font = new Font("黑体",Font.PLAIN,18);
		title = new JLabel(user.getHallName()+"收件单",JLabel.CENTER);
		title.setFont(font);
		title.setBounds(150, 10, 600, 50);
		
		JLabel idLabel = new JLabel("· 快递单号: ");
		idLabel.setFont(font);
		idLabel.setBounds(padding, padding*2+50, label_width, label_height);		
		
		id = new JTextField(20);
		id.setFont(new Font("黑体",Font.PLAIN,15));
		id.setOpaque(false);
		id.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		id.setBounds(padding+interval, padding*2+50, label_width, label_height);
		id.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					e.consume();
					 KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JLabel nameLabel = new JLabel("· 收件人姓名: ");
		nameLabel.setFont(font);
		nameLabel.setBounds(padding,padding*3+50+label_height, label_width, label_height);	
		
<<<<<<< HEAD
=======

>>>>>>> cbe00da9c0dffa9b67dd64d9a93858b9dea56d6d
		name = new JTextField(20);
		name.setFont(new Font("黑体",Font.PLAIN,15));
		name.setOpaque(false);
		name.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		name.setBounds(padding+interval,padding*3+50+label_height, label_width, label_height);
		name.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					e.consume();
					 KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JLabel dateLabel = new JLabel("· 收件日期: ");
		dateLabel.setFont(font);
		dateLabel.setBounds(padding,padding*4+50+label_height*2, label_width, label_height);	
		
		date = new JLabel(); 
		date.setText(bl.getCurrentTime());
		date.setFont(font);
		date.setBounds(padding+interval,padding*4+50+label_height*2, label_width, label_height);		
		
		submit = new JButton();
		submit.setFont(font);
		submit.setBorder(null);
		submit.setOpaque(false);
		submit.setFocusPainted(false);
		submit.setContentAreaFilled(false);
		submit.setBounds(740, 510, button_width, button_height);
		PictureButton.setIcon("src/main/java/image/submitButton_unclicked.png",submit);
		submit.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent e) {}

			public void mouseReleased(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {
				PictureButton.setIcon("src/main/java/image/submitButton_clicked.png",submit);
			}

			public void mouseExited(MouseEvent e) {
				PictureButton.setIcon("src/main/java/image/submitButton_unclicked.png",submit);
			}			
		});		
<<<<<<< HEAD
=======

>>>>>>> cbe00da9c0dffa9b67dd64d9a93858b9dea56d6d
		
		submit.addActionListener(new SubmitListener());
		
		back = new JButton();
		back.setFont(font);
		back.setBorder(null);
		back.setOpaque(false);
		back.setFocusPainted(false);
		back.setContentAreaFilled(false);
		back.setBounds(820, 510, button_width, button_height);
		PictureButton.setIcon("src/main/java/image/backButton_unclicked.png",back);
		back.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				ReceivePanel.this.setVisible(false);
				MainPanel.closeButton(buttonNum);
			}

			public void mousePressed(MouseEvent e) {}

			public void mouseReleased(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {
				PictureButton.setIcon("src/main/java/image/backButton_clicked.png",back);
			}

			public void mouseExited(MouseEvent e) {
				PictureButton.setIcon("src/main/java/image/backButton_unclicked.png",back);
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
		this.add(back);
	}
	class SubmitListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String Id = id.getText();
			if (Id.equals("")){
				JOptionPane.showMessageDialog(null, "请输入相应的快递单号！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			try{
				long id = Long.parseLong(Id);
			}catch(NumberFormatException e1){
				//输入编号不是数字
				JOptionPane.showMessageDialog(null, "请输入正确的快递单号！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String Name = name.getText();
			if (Name.equals("")){
				JOptionPane.showMessageDialog(null, "请输入收件人姓名！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			
			if(! bl.findLogistics(Id)){
				//System.out.println("找不到");
				JOptionPane.showMessageDialog(null, "不存在快递单号为"+Id+"的货物！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String Date = date.getText();
			
			int n = JOptionPane.showConfirmDialog(null, "确定提交?", "确认框",JOptionPane.YES_NO_OPTION);
			if (n == 1) {
				return;
			}
			
			ReceiptVO vo = new ReceiveVO(title.getText(),user.getUserName(),Id,Name,Date);
		 	bl.addReceipt(vo);
		 	
		 	id.setText("");
		 	name.setText("");
		 	date.setText(bl.getCurrentTime());
		}
		
	}
}



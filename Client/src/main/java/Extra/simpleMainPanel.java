package Extra;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businessLogic.Receiptsbl.Receiptsbl;
import businessLogicService.ReceiptsblService.ReceiptsblService;
import businessLogicService.UserblService.UserblService;

public class simpleMainPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Font font1;
	private Font font2;
	private UserblService user;
	private ReceiptsblService bl;
	private final int widthOfUp = 1000;
	private final int heightOfUp = 50;
	private static JButton[] buttontoshow = new JButton[30];
	private static String[] iconAddress = new String[30];
	private final static int width = 64;
	private final static int height = 70;
	private static int buttonClicked = -1;
	private int padding = 10;
	private int label_width = 200;
	private int label_height = 30;
	
	public simpleMainPanel(UserblService user,ReceiptsblService bl){
		this.user = user;
		bl = new Receiptsbl(user);
		this.setSize(1024,768);
		this.setLayout(null);
		initInfo();
//		initFunction();
	}
	private void initInfo() {
		// TODO Auto-generated method stub
		Color color = Color.BLACK;
		Font font = new Font("华文行楷",Font.PLAIN,16);
		
		JLabel welcomeSentence = new JLabel("",JLabel.LEFT);
		welcomeSentence.setBounds(padding, 50, label_width, label_height);
		welcomeSentence.setForeground(color);
		welcomeSentence.setFont(font);
		if (user.getUserSex().equals("男")) welcomeSentence.setText(user.getUserName()+"先生，你好(￣▽￣)ノ");//具体晚上好
		else welcomeSentence.setText(user.getUserName()+"女士，你好(￣▽￣)ノ");
		
		JLabel position = new JLabel("",JLabel.LEFT);
		position.setBounds(padding, 50+padding, label_width, label_height);
		position.setForeground(color);
		position.setFont(font);
		position.setText("当前位置："+user.getHallName());
		
		JLabel date = new JLabel("",JLabel.LEFT);
		date.setBounds(padding, 50+padding*2+label_height, label_width, label_height);
		date.setForeground(color);
		date.setFont(font);
		date.setText("日    期："+bl.getCurrentTime());
		
		this.add(welcomeSentence);
		this.add(date);
		this.add(position);
	}
	private void initFunction() {
		// TODO Auto-generated method stub
		font1 = new Font("华文细楷",Font.PLAIN,18);
		font2 = new Font("华文细楷",Font.BOLD,18);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1024, 768);
		
		final int PADDING_LEFT = 50;
		
		
	}

}

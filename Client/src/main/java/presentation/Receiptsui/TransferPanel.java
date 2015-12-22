package presentation.Receiptsui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import presentation.Receiptsui.LoadingPanel.SubmitAction;
import presentation.mainui.PictureButton;
import businessLogic.Receiptsbl.Receiptsbl;
import businessLogicService.ReceiptsblService.ReceiptsblService;
import businessLogicService.UserblService.UserblService;

/**
 * 中转单
 * @author TOSHIBA
 *
 */
public class TransferPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton back;
	JButton submit;
	private ReceiptsblService bl;
	private UserblService user;
	int padding = 10;
	int label_width = 200;
	int label_height = 30;
	int box_width = 120;
	int box_height = 30;
	int button_width = 80;
	int button_height = 30;
	
	public TransferPanel(UserblService user){
		this.user = user;
		bl = new Receiptsbl(user);
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		initTPanel();
	}
	private void initTPanel() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,16);
		JLabel title = new JLabel(user.getHallName()+"装车单",JLabel.CENTER);
		title.setFont(font);
		title.setBounds(150, 10, 600, 30);
		
		JLabel dateLabel = new JLabel("· 装车日期: ");
		dateLabel.setFont(font);
		dateLabel.setBounds(padding, padding*2+label_height, label_width, label_height);
		
		JTextField date = new JTextField(7);
		date.setFont(font);
		date.setOpaque(false);
		date.setBorder(null);
		date.setBounds(padding+120, padding*2+label_height, label_width, label_height);
		date.setText(bl.getCurrentTime());
		date.setEditable(false);
		
		JLabel idLabel = new JLabel("· 中转单编号: ");
		idLabel.setFont(font);
		idLabel.setBounds(padding, padding*3+label_height*2, label_width, label_height);
		
		JTextField id = new JTextField(20);
		id.setFont(font);
		id.setOpaque(false);
		id.setBorder(null);
		id.setBounds(padding+120, padding*3+label_height*2, label_width, label_height);
		//id.setText();
		id.setEditable(false);
		
		JLabel formLabel = new JLabel("· 中转形式: ");
		formLabel.setFont(font);
		formLabel.setBounds(padding, padding*4+label_height*3, label_width, label_height);
		
		ButtonGroup bg = new ButtonGroup();
		
		JRadioButton plane = new JRadioButton("飞机",true);
		plane.setFont(font);
		plane.setBounds(padding+120, padding*4+label_height*3, 50, label_height);
		plane.setBorder(null);
		plane.setFocusPainted(false);
		plane.setOpaque(false);
		
		JRadioButton railway = new JRadioButton("铁路",false);
		railway.setFont(font);
		railway.setBounds(padding+120+80, padding*4+label_height*3, 50, label_height);
		railway.setBorder(null);
		railway.setFocusPainted(false);
		railway.setOpaque(false);
		
		JRadioButton road = new JRadioButton("公路",false);
		road.setFont(font);
		road.setBounds(padding+120+80*2, padding*4+label_height*3, 50, label_height);
		road.setBorder(null);
		road.setFocusPainted(false);
		road.setOpaque(false);
		
		JLabel transNumber = new JLabel("· 航班/列次/车次号：");
		transNumber.setFont(font);
		transNumber.setBounds(padding,  padding*5+label_height*4, label_width, label_height);
		
		JTextField number = new JTextField(10);
		number.setFont(font);
		number.setOpaque(false);
		number.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		number.setBounds(padding+180, padding*5+label_height*4, label_width, label_height);
		
		JLabel startplace = new JLabel("· 出 发 地: ");
		startplace.setFont(font);
		startplace.setBounds(padding, padding*6+label_height*5, label_width, label_height);
		
		JTextField startplacename = new JTextField(20);
		startplacename.setFont(font);
		startplacename.setOpaque(false);
		startplacename.setBorder(null);
		startplacename.setBounds(padding+120, padding*6+label_height*5, label_width, label_height);
		startplacename.setText(user.getHallName());
		startplacename.setEditable(false);
		
		JLabel destination = new JLabel("· 到 达 地：");
		destination.setFont(font);
		destination.setBounds(padding,  padding*7+label_height*6, label_width, label_height);
		
		JComboBox<String> city = new JComboBox<String>();
		city.setFont(font);
		city.addItem("请选择城市");
		city.setSelectedItem("请选择城市");
		city.setBounds(padding+120,padding*7+label_height*6, box_width, box_height);
		
		JLabel containerLabel = new JLabel("· 货 柜 号：");
		containerLabel.setFont(font);
		containerLabel.setBounds(padding,  padding*8+label_height*7, label_width, label_height);
		
		JTextField container = new JTextField(10);
		container.setFont(font);
		container.setOpaque(false);
		container.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		container.setBounds(padding+120, padding*8+label_height*7, label_width, label_height);
		
		JLabel spyer = new JLabel("· 监 装 员：");
		spyer.setFont(font);
		spyer.setBounds(padding, padding*9+label_height*8, label_width, label_height);
		
		JTextField spyername = new JTextField(10);
		spyername.setFont(font);
		spyername.setOpaque(false);
		spyername.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		spyername.setBounds(padding+120, padding*9+label_height*8, label_width, label_height);
		
		JLabel order = new JLabel("· 托运单号：");
		order.setFont(font);
		order.setBounds(padding, padding*10+label_height*9, label_width, label_height);
		
		JTextArea orders = new JTextArea();
		orders.setFont(font);
		orders.setLineWrap(true);
		orders.setBorder(BorderFactory.createLineBorder(Color.black));
		orders.setOpaque(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(padding+120,padding*10+label_height*9, label_width*2, label_height*4);
		scrollPane.getViewport().add(orders);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		
		JLabel costLabel = new JLabel("· 运    费：");
		costLabel.setFont(font);
		costLabel.setBounds(padding, padding*11+label_height*13, label_width, label_height);
		
		JTextArea cost = new JTextArea();
		cost.setFont(font);
		cost.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		cost.setBounds(padding+120, padding*11+label_height*13, label_width, label_height);
		cost.setOpaque(false);
		
		submit = new JButton();
		submit.setFont(font);
		submit.setBorder(null);
		submit.setOpaque(false);
		submit.setFocusPainted(false);
		submit.setContentAreaFilled(false);
		submit.setBounds(740, 510, 70, 30);
		PictureButton.setIcon("src/main/java/image/submitButton_unclicked.png",submit);
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
				PictureButton.setIcon("src/main/java/image/submitButton_clicked.png",submit);
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/submitButton_unclicked.png",submit);
			}
			
		});
		
		
		back = new JButton();
		back.setFont(font);
		back.setBorder(null);
		back.setOpaque(false);
		back.setFocusPainted(false);
		back.setContentAreaFilled(false);
		back.setBounds(820, 510, 70, 30);
		PictureButton.setIcon("src/main/java/image/backButton_unclicked.png",back);
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
				PictureButton.setIcon("src/main/java/image/backButton_clicked.png",back);
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/backButton_unclicked.png",back);
			}
			
		});
		
		
		this.add(title);
		this.add(date);
		this.add(dateLabel);
		this.add(id);
		this.add(idLabel);
		this.add(formLabel);
		bg.add(plane);
		this.add(plane);
		bg.add(railway);
		this.add(railway);
		bg.add(road);
		this.add(road);
		this.add(transNumber);
		this.add(number);
		this.add(startplacename);
		this.add(startplace);
		this.add(city);
		this.add(destination);
		this.add(container);
		this.add(containerLabel);
		this.add(spyername);
		this.add(spyer);
		this.add(order);
		this.add(scrollPane);
		this.add(costLabel);
		this.add(cost);
		this.add(back);
		this.add(submit);
	}

}

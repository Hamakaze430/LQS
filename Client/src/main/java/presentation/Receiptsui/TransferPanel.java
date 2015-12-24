package presentation.Receiptsui;

import java.awt.Color;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import Miscellaneous.Place;
import presentation.Receiptsui.LoadingPanel.SubmitAction;
import presentation.Userui.MainPanel;
import presentation.mainui.PictureButton;
import vo.UserVO;
import vo.receipts.TransferVO;
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
	JLabel title;
	JTextField date;
	JTextField id;
	JButton back;
	JButton submit;
	JTextField container;
	JTextField spyername;
	JRadioButton plane, railway, road;
	JTextField number;
	JComboBox city,desti;
	JTextArea orders;
	JTextField cost;
	private ReceiptsblService bl;
	private UserblService user;
	private int buttonNum;
	int padding = 10;
	int label_width = 200;
	int label_height = 30;
	int box_width = 120;
	int box_height = 30;
	int button_width = 80;
	int button_height = 30;
	
	public TransferPanel(UserblService user, int buttonNum){
		this.user = user;
		bl = new Receiptsbl(user);
		this.buttonNum = buttonNum;
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		initTPanel();
	}
	private void initTPanel() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,16);
		title = new JLabel(user.getHallName()+"中转单",JLabel.CENTER);
		title.setFont(font);
		title.setBounds(150, 10, 600, 30);
		
		JLabel dateLabel = new JLabel("· 装车日期: ");
		dateLabel.setFont(font);
		dateLabel.setBounds(padding, padding*2+label_height, label_width, label_height);
		
		date = new JTextField(7);
		date.setFont(font);
		date.setOpaque(false);
		date.setBorder(null);
		date.setBounds(padding+120, padding*2+label_height, label_width, label_height);
		date.setText(bl.getCurrentTime());
		date.setEditable(false);
		
		JLabel idLabel = new JLabel("· 中转单编号: ");
		idLabel.setFont(font);
		idLabel.setBounds(padding, padding*3+label_height*2, label_width, label_height);
		
		id = new JTextField(20);
		id.setFont(font);
		id.setOpaque(false);
		id.setBorder(null);
		id.setBounds(padding+120, padding*3+label_height*2, label_width, label_height);
		id.setText(user.getHallId()+bl.changeDateFormat(date.getText()));
		id.setText(id.getText()+bl.getLastId(id.getText()));
		id.setEditable(false);
		
		JLabel formLabel = new JLabel("· 中转形式: ");
		formLabel.setFont(font);
		formLabel.setBounds(padding, padding*4+label_height*3, label_width, label_height);
		
		ButtonGroup bg = new ButtonGroup();
		
		plane = new JRadioButton("飞机",true);
		plane.setFont(font);
		plane.setBounds(padding+120, padding*4+label_height*3, 50, label_height);
		plane.setBorder(null);
		plane.setFocusPainted(false);
		plane.setOpaque(false);
		
		railway = new JRadioButton("铁路",false);
		railway.setFont(font);
		railway.setBounds(padding+120+80, padding*4+label_height*3, 50, label_height);
		railway.setBorder(null);
		railway.setFocusPainted(false);
		railway.setOpaque(false);
		
		road = new JRadioButton("公路",false);
		road.setFont(font);
		road.setBounds(padding+120+80*2, padding*4+label_height*3, 50, label_height);
		road.setBorder(null);
		road.setFocusPainted(false);
		road.setOpaque(false);
		
		JLabel transNumber = new JLabel("· 航班/列次/车次号：");
		transNumber.setFont(font);
		transNumber.setBounds(padding,  padding*5+label_height*4, label_width, label_height);
		
		number = new JTextField(10);
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
		
		city = new JComboBox();
		city.setFont(font);
		city.addItem("请选择城市");
		city.setSelectedItem("请选择城市");
		city.setBounds(padding+120,padding*7+label_height*6, box_width, box_height);
		
		for (Place p : Place.values()){
			if (!user.getHallPlace().equals(p.name())) city.addItem(p.name());
		}

		
		desti = new JComboBox();
		desti.setFont(font);
		desti.addItem("请选择中转中心");
		desti.addItem("请先选择城市");
		desti.setSelectedIndex(0);
		desti.setBounds(padding+box_width+125,padding*7+label_height*6, box_width+30, box_height);
		
		city.addItemListener(new ItemListener(){

			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				desti.removeAllItems();
				
				if (city.getSelectedIndex() == 0){
					desti.addItem("请选择中转中心");
					desti.addItem("请先选择城市");
					desti.setSelectedIndex(0);
					return;
				}
				
				String place = city.getSelectedItem().toString();
				List<String> list = bl.getHallNameListByAddress("中转中心",place);
				if (list.size() == 1) {
					desti.addItem(list.get(0));
					desti.setSelectedIndex(0);
				}
				else{
					desti.addItem("请选择中转中心");
					desti.setSelectedIndex(0);
					for (String s : list) desti.addItem(s);
				}
			}
			
		});
		
		JLabel containerLabel = new JLabel("· 货 柜 号：");
		containerLabel.setFont(font);
		containerLabel.setBounds(padding,  padding*8+label_height*7, label_width, label_height);
		
		container = new JTextField(10);
		container.setFont(font);
		container.setOpaque(false);
		container.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		container.setBounds(padding+120, padding*8+label_height*7, label_width, label_height);
		container.addKeyListener(new KeyListener(){

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
		
		JLabel spyer = new JLabel("· 监 装 员：");
		spyer.setFont(font);
		spyer.setBounds(padding, padding*9+label_height*8, label_width, label_height);
		
		spyername = new JTextField(10);
		spyername.setFont(font);
		spyername.setOpaque(false);
		spyername.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		spyername.setBounds(padding+120, padding*9+label_height*8, label_width, label_height);
		spyername.addKeyListener(new KeyListener(){

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
		
		JLabel order = new JLabel("· 托运单号：");
		order.setFont(font);
		order.setBounds(padding, padding*10+label_height*9, label_width, label_height);
		
		orders = new JTextArea();
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
		
		cost = new JTextField();
		cost.setFont(font);
		cost.setBorder(null);
		cost.setBounds(padding+120, padding*11+label_height*13, label_width, label_height);
		cost.setOpaque(false);
		cost.setEditable(false);
//		cost.setText(t);
		CostListener listener = new CostListener();
		plane.addActionListener(listener);
		railway.addActionListener(listener);
		road.addActionListener(listener);
		city.addActionListener(listener);
		desti.addActionListener(listener);
		
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
		
		submit.addActionListener(new SubmitListener());
		
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
				TransferPanel.this.setVisible(false);
				MainPanel.closeButton(buttonNum);
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
		this.add(desti);
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
	
	class CostListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (city.getSelectedIndex() == 0) {
				cost.setText("");
				return;
			}
			String endPlace =city.getSelectedItem().toString();
			if (plane.isSelected()){
				cost.setText(String.format("%.2f", bl.getTransferCost("plane",bl.getHallPlace(),endPlace)));
				return;
			}
			if (railway.isSelected()){
				cost.setText(String.format("%.2f", bl.getTransferCost("railway",bl.getHallPlace(),endPlace)));
				return;
			}
			if (road.isSelected()){
				cost.setText(String.format("%.2f", bl.getTransferCost("road",bl.getHallPlace(),endPlace)));
				return;
			}
			
		}
		
	}
	
	
	class SubmitListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (number.getText().equals("")){
				if (plane.isSelected()) JOptionPane.showMessageDialog(null, "请输入航班号！","", JOptionPane.ERROR_MESSAGE);
				else if (railway.isSelected()) JOptionPane.showMessageDialog(null, "请输入列次号！","", JOptionPane.ERROR_MESSAGE);
				else if (road.isSelected()) JOptionPane.showMessageDialog(null, "请输入车次号！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if (city.getSelectedIndex() == 0){
				JOptionPane.showMessageDialog(null, "请选择到达城市！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if (desti.getSelectedItem().toString().equals("请选择中转中心")){
				JOptionPane.showMessageDialog(null, "请选择到达地中转中心！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if (container.getText().equals("")){
				JOptionPane.showMessageDialog(null, "请输入货柜号！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if (spyername.getText().equals("")){
				JOptionPane.showMessageDialog(null, "请输入监装员姓名！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			UserVO sup = bl.findUser(spyername.getText());
			if(sup == null ){
				//System.out.println("找不到");
				JOptionPane.showMessageDialog(null, "不存在对应的员工！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (!sup.getHall().equals(user.getHallName())){
				JOptionPane.showMessageDialog(null, "所填的监装员不属于本单位！","注意", JOptionPane.WARNING_MESSAGE);
//				return;
			}
			
			String str = orders.getText();
			if (str.equals("")){
				JOptionPane.showMessageDialog(null, "请输入相应的快递单号！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
		 	List<String> list = new ArrayList<String>();
		 	String[] split = str.split("\n");
		 	for (String s : split) {
		 		try{
					long id = Long.parseLong(s);
				}catch(NumberFormatException e1){
					//输入编号不是数字
					JOptionPane.showMessageDialog(null, "请输入正确的快递单号！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
		 		if(! bl.findLogistics(s)){
					//System.out.println("找不到");
		 			
					JOptionPane.showMessageDialog(null, "不存在快递单号为"+s+"的货物！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
		 		list.add(s);
		 	}
			
			int n = JOptionPane.showConfirmDialog(null, "确定提交?", "确认框",JOptionPane.YES_NO_OPTION);
			if (n == 1) {
				return;
			}
			
			String traffic = "";
			if (plane.isSelected()) traffic = plane.getText();
			else if (railway.isSelected()) traffic = railway.getText();
			else if (road.isSelected()) traffic = road.getText();
			
			TransferVO vo = new TransferVO(title.getText(),user.getUserName(),date.getText(),
					id.getText(), traffic, number.getText(), user.getHallName(), desti.getSelectedItem().toString(),
					container.getText(), spyername.getText(), list, cost.getText());
			bl.addReceipt(vo);
			date.setText(bl.getCurrentTime());
			id.setText(user.getHallId()+bl.changeDateFormat(date.getText())+bl.getLastId(user.getHallId()+bl.changeDateFormat(date.getText())));
			plane.setSelected(true);
			number.setText("");
			city.setSelectedIndex(0);
			desti.removeAllItems();
			desti.addItem("请选择中转中心");
			desti.addItem("请先选择城市");
			desti.setSelectedIndex(0);
			container.setText("");
			spyername.setText("");
			orders.setText("");
			cost.setText("");
			JOptionPane.showMessageDialog(null, "提交成功^_^","", JOptionPane.CLOSED_OPTION);
		}
		
	}

}

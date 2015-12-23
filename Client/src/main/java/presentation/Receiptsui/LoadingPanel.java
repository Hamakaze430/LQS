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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import presentation.mainui.PictureButton;
import Miscellaneous.Place;
import Miscellaneous.ReceiptState;
import businessLogic.CarAndDriverbl.CarAndDriverbl;
import businessLogic.Receiptsbl.Receiptsbl;
import businessLogicService.CarAndDriverblService.CarAndDriverblService;
import businessLogicService.ReceiptsblService.ReceiptsblService;
import businessLogicService.UserblService.UserblService;
import presentation.Userui.ApartmentManagerPanel;
import presentation.Userui.MainPanel;
import vo.LogisticsVO;
import vo.ReceiptVO;
import vo.UserVO;
import vo.receipts.LoadingVO;


/**
 * 装车单
 * 写完惹【还剩bl.getLoadingCost();
 * @author TOSHIBA
 *
 */
public class LoadingPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private ReceiptsblService bl;
	private UserblService user;
	private int buttonNum;
	JLabel title;
	JTextField date;
	JTextField hallId;
	JTextField id;
	JComboBox province;
	JComboBox place;
	JButton back;
	JButton submit;
	JTextField car;
	JTextField drivername;
	JTextField spyname;
	JTextArea orders;
	JTextField cost;
	double cost_double;
	int padding = 10;
	int label_width = 200;
	int label_height = 30;
	int box_width = 200;
	int box_height = 30;
	int button_width = 80;
	int button_height = 30;
	int labelWidth = 150;
	
	public LoadingPanel(UserblService user,int buttonNum){
		
		this.user = user;
		bl = new Receiptsbl(user);
		this.setLayout(null);
		this.buttonNum = buttonNum;
		this.setBorder(null);
		this.setOpaque(false);
		
		init();
	}
	
	private void init() {
		// TODO Auto-generated method stub
		
		Font font = new Font("黑体",Font.PLAIN,16);
		title = new JLabel(user.getHallName()+"装车单",JLabel.CENTER);
		title.setFont(font);
		title.setBounds(150, 10, 600, 30);
		
		JLabel dateLabel = new JLabel("· 装车日期: ");
		dateLabel.setFont(font);
		dateLabel.setBounds(padding, padding*2+label_height, label_width, label_height);
		
		date = new JTextField(7);
		date.setFont(font);
		date.setOpaque(false);
		date.setBorder(null);
		date.setBounds(padding+labelWidth, padding*2+label_height, label_width, label_height);
		date.setText(bl.getCurrentTime());
		date.setEditable(false);
		date.addKeyListener(new KeyListener(){

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
		JLabel hallIdLabel = new JLabel("· "+user.getHallType()+"编号: ");
		hallIdLabel.setFont(font);
		hallIdLabel.setBounds(padding, padding*3+label_height*2, label_width, label_height);
		
		hallId = new JTextField(5);
		hallId.setFont(font);
		hallId.setOpaque(false);
		hallId.setBorder(null);
		hallId.setBounds(padding+labelWidth, padding*3+label_height*2, label_width, label_height);
		hallId.setText(bl.getHallId());
		hallId.setEditable(false);
		hallId.addKeyListener(new KeyListener(){

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
		
		JLabel idLabel = new JLabel("· 汽运编号: ");
		idLabel.setFont(font);
		idLabel.setBounds(padding, padding*4+label_height*3, label_width, label_height);
		
		id = new JTextField(15);
		id.setFont(font);
		id.setOpaque(false);
		id.setBorder(null);
		id.setBounds(padding+labelWidth, padding*4+label_height*3, label_width, label_height);
		id.setText(
				hallId.getText()
				+bl.changeDateFormat(date.getText())
		);
		id.setText(id.getText()+bl.getLastId(id.getText()));
		id.setEditable(false);
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
		
		JLabel destination = new JLabel("· 到 达 地：");
		destination.setFont(font);
		destination.setBounds(padding,  padding*5+label_height*4, label_width, label_height);
		
		province = new JComboBox();
		place = new JComboBox();
		province.setFont(font);
		province.addItem(bl.getHallPlace());
		province.setSelectedIndex(0);
		province.setBounds(padding+labelWidth,padding*5+label_height*4, box_width, box_height);
		place.setFont(font);
		place.addItem("请选择地点");
		place.setSelectedIndex(0);
		List<String> list = bl.getHallNameListByAddress(province.getSelectedItem().toString());
		for (String s : list){
			if  (!s.equals(bl.getHallName())) place.addItem(s);
		}
		place.setBounds(padding+labelWidth+box_width+padding, padding*5+box_height*4, box_width, box_height);
		
		
		JLabel carID = new JLabel("· 车辆代号：");
		carID.setFont(font);
		carID.setBounds(padding, padding*6+label_height*5, label_width, label_height);
		
		car = new JTextField(10);
		car.setFont(font);
		car.setOpaque(false);
		car.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		car.setBounds(padding+labelWidth, padding*6+label_height*5, label_width, label_height);
		car.addKeyListener(new KeyListener(){

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
		
		WarnLabel carWarn = new WarnLabel("车辆代号不存在"); 
		carWarn.setBounds(padding+2*labelWidth, padding*6+label_height*5, label_width, label_height);
		
		JLabel driver = new JLabel("· 司    机：");
		driver.setFont(font);
		driver.setBounds(padding, padding*7+label_height*6, label_width, label_height);
		
		drivername = new JTextField(10);
		drivername.setFont(font);
		drivername.setOpaque(false);
		drivername.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		drivername.setBounds(padding+labelWidth, padding*7+label_height*6, label_width, label_height);
		drivername.addKeyListener(new KeyListener(){

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
		
		JLabel spy = new JLabel("· 监 装 员：");
		spy.setFont(font);
		spy.setBounds(padding, padding*8+label_height*7, label_width, label_height);
		
		spyname = new JTextField(10);
		spyname.setFont(font);
		spyname.setOpaque(false);
		spyname.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		spyname.setBounds(padding+labelWidth, padding*8+label_height*7, label_width, label_height);
		spyname.addKeyListener(new KeyListener(){

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
		
		JLabel order = new JLabel("· 订单条形码号：");
		order.setFont(font);
		order.setBounds(padding, padding*9+label_height*8, label_width, label_height);
		
		orders = new JTextArea();
		orders.setFont(font);
		orders.setLineWrap(true);
		orders.setBorder(BorderFactory.createLineBorder(Color.black));
		orders.setOpaque(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(padding+labelWidth,padding*9+label_height*8, label_width*2, label_height*4);
		scrollPane.getViewport().add(orders);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		
		JLabel costLabel = new JLabel("· 运    费：");
		costLabel.setFont(font);
		costLabel.setBounds(padding, padding*10+label_height*12, label_width, label_height);
		
		cost = new JTextField();
		cost.setFont(font);
		cost.setBorder(null);
		cost.setBounds(padding+labelWidth, padding*10+label_height*12, label_width, label_height);
		cost.setOpaque(false);
		cost_double = bl.getLoadingCost();
		cost.setText(String.format("%.2f", cost_double));
		cost.setEditable(false);
		
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
		
		submit.addActionListener(new SubmitAction());
		
		back.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoadingPanel.this.setVisible(false);
				MainPanel.closeButton(buttonNum);
			}		
		});
		
		this.add(title);
		this.add(dateLabel);
		this.add(date);
		this.add(hallIdLabel);
		this.add(hallId);
		this.add(idLabel);
		this.add(id);
		this.add(destination);
		this.add(province);
		this.add(place);
		this.add(carID);
		this.add(car);
		this.add(driver);
		this.add(drivername);
		this.add(spy);
		this.add(spyname);
		this.add(order);
		this.add(scrollPane);
		this.add(costLabel);
		this.add(cost);
		this.add(submit);
		this.add(back);
	}
	
	/*  String date, String hallId, 
	    String id, String destination, 
		String carId, String supervisor, 
	 	String driver, ArrayList<String> order,
		double cost
	*/
	class SubmitAction implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			if (place.getSelectedIndex() == 0){
				JOptionPane.showMessageDialog(null, "请选择到达地！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (car.getText().equals("")){
				JOptionPane.showMessageDialog(null, "请输入车辆代号！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String CarId = car.getText();
			
			try{
				long id = Long.parseLong(CarId);
			}catch(NumberFormatException e1){
				//输入编号不是数字
				JOptionPane.showMessageDialog(null, "请输入正确的车辆代号！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			//不存在
			if(! bl.findCarAndDriver("car",CarId)){
				//System.out.println("找不到");
				JOptionPane.showMessageDialog(null, "不存在对应的车辆！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			String Driver = drivername.getText();
			if (Driver.equals("")){
				JOptionPane.showMessageDialog(null, "请输入司机姓名！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(! bl.findCarAndDriver("driver",Driver)){
				//System.out.println("找不到");
				JOptionPane.showMessageDialog(null, "不存在对应的司机！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String Supervisor = spyname.getText();
			if (Supervisor.equals("")){
				JOptionPane.showMessageDialog(null, "请输入监装员姓名！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			UserVO sup = bl.findUser(Supervisor);
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
		 	List<String> Order = new ArrayList<String>();
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
		 		Order.add(s);
		 	}
			
			int n = JOptionPane.showConfirmDialog(null, "确定提交?", "确认框",JOptionPane.YES_NO_OPTION);
			if (n == 1) {
				return;
			}
			String Name = title.getText();
			String Creator = user.getUserName();
			String Date = date.getText();
			String HallId = hallId.getText();
			String Id = id.getText();
			String Destination = place.getSelectedItem().toString();
		 	double Cost = cost_double;
		 	ReceiptVO vo = new LoadingVO(Name,Creator,
		 			Date, HallId, Id, Destination, CarId, Supervisor, Driver, Order, Cost);
		 	
		 	bl.addReceipt(vo);
		 	
		 	date.setText(bl.getCurrentTime());;
		 	id.setText(
					hallId.getText()
					+bl.changeDateFormat(date.getText())
			);
		 	id.setText(id.getText()+bl.getLastId(id.getText()));
			place.setSelectedIndex(0);
			car.setText("");
			drivername.setText("");
			spyname.setText("");
			orders.setText("");
		}
	
	}
	
	class WarnLabel extends JLabel{
		public WarnLabel(){
			this.setForeground(Color.RED);
			this.setOpaque(false);
			this.setFont(new Font("宋体",Font.PLAIN,10));
		}
		public WarnLabel(String s){
			super(s);
			this.setForeground(Color.RED);
			this.setOpaque(false);
			this.setFont(new Font("宋体",Font.PLAIN,10));
		}
	}

}

	

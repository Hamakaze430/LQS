package presentation.Receiptsui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import presentation.mainui.PictureButton;
import Miscellaneous.Place;
import businessLogic.Receiptsbl.Receiptsbl;
import businessLogicService.ReceiptsblService.ReceiptsblService;
import businessLogicService.UserblService.UserblService;


/**
 * 装车单
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
	
	JComboBox<String> province;
	JComboBox<String> place;
	JButton back;
	JButton submit;
	int padding = 10;
	int label_width = 200;
	int label_height = 30;
	int box_width = 200;
	int box_height = 30;
	int button_width = 80;
	int button_height = 30;
	
	public LoadingPanel(UserblService user){
		
		this.user = user;
		bl = new Receiptsbl(user);
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		
		init();
	}
	
	private void init() {
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
		
		JLabel hallIdLabel = new JLabel("· "+user.getHallType()+"编号: ");
		hallIdLabel.setFont(font);
		hallIdLabel.setBounds(padding, padding*3+label_height*2, label_width, label_height);
		
		JTextField hallId = new JTextField(5);
		hallId.setFont(font);
		hallId.setOpaque(false);
		hallId.setBorder(null);
		hallId.setBounds(padding+120, padding*3+label_height*2, label_width, label_height);
		hallId.setText(bl.getHallId());
		hallId.setEditable(false);
		
		JLabel idLabel = new JLabel("· 汽运编号: ");
		idLabel.setFont(font);
		idLabel.setBounds(padding, padding*4+label_height*3, label_width, label_height);
		
		JTextField id = new JTextField(15);
		id.setFont(font);
		id.setOpaque(false);
		id.setBorder(null);
		id.setBounds(padding+120, padding*4+label_height*3, label_width, label_height);
		id.setText(
				hallId.getText()
				+bl.changeDateFormat(date.getText())
		);
		id.setText(id.getText()+bl.getLastId(id.getText()));
		id.setEditable(false);
		
		JLabel destination = new JLabel("· 到 达 地：");
		destination.setFont(font);
		destination.setBounds(padding,  padding*5+label_height*4, label_width, label_height);
		
		province = new JComboBox<String>();
		place = new JComboBox<String>();
		province.setFont(font);
		province.addItem(bl.getHallPlace());
		province.setSelectedIndex(0);
		province.setBounds(padding+120,padding*5+label_height*4, box_width, box_height);
		place.setFont(font);
		place.addItem("请选择地点");
		place.setSelectedIndex(0);
		List<String> list = bl.getHallNameListByAddress(province.getSelectedItem().toString());
		for (String s : list){
			if  (!s.equals(bl.getHallName())) place.addItem(s);
		}
		place.setBounds(padding+120+box_width+padding, padding*5+box_height*4, box_width, box_height);
		
		
		JLabel carID = new JLabel("· 车辆代号：");
		carID.setFont(font);
		carID.setBounds(padding, padding*6+label_height*5, label_width, label_height);
		
		JTextField car = new JTextField(10);
		car.setFont(font);
		car.setOpaque(false);
		car.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		car.setBounds(padding+120, padding*6+label_height*5, label_width, label_height);
		
		JLabel spyer = new JLabel("· 司    机：");
		spyer.setFont(font);
		spyer.setBounds(padding, padding*7+label_height*6, label_width, label_height);
		
		JTextField spyername = new JTextField(10);
		spyername.setFont(font);
		spyername.setOpaque(false);
		spyername.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		spyername.setBounds(padding+120, padding*7+label_height*6, label_width, label_height);
		
		JLabel supercargo = new JLabel("· 监 装 员：");
		supercargo.setFont(font);
		supercargo.setBounds(padding, padding*8+label_height*7, label_width, label_height);
		
		JTextField supercargoname = new JTextField(10);
		supercargoname.setFont(font);
		supercargoname.setOpaque(false);
		supercargoname.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		supercargoname.setBounds(padding+120, padding*8+label_height*7, label_width, label_height);
		
		JLabel order = new JLabel("· 订单条形码号：");
		order.setFont(font);
		order.setBounds(padding, padding*9+label_height*8, label_width, label_height);
		
		JTextArea orders = new JTextArea();
		orders.setFont(font);
		orders.setLineWrap(true);
		orders.setBorder(BorderFactory.createLineBorder(Color.black));
		orders.setOpaque(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(padding+150,padding*9+label_height*8, label_width*2, label_height*4);
		scrollPane.getViewport().add(orders);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		
		JLabel costLabel = new JLabel("· 运    费：");
		costLabel.setFont(font);
		costLabel.setBounds(padding, padding*10+label_height*12, label_width, label_height);
		
		JTextArea cost = new JTextArea();
		cost.setFont(font);
		cost.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		cost.setBounds(padding+120, padding*10+label_height*12, label_width, label_height);
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
		this.add(spyer);
		this.add(spyername);
		this.add(supercargo);
		this.add(supercargoname);
		this.add(order);
		this.add(scrollPane);
		this.add(costLabel);
		this.add(cost);
		this.add(submit);
		this.add(back);
	}
	
	class SubmitAction implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			
		}
	
	}
}

package presentation.Receiptsui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import presentation.mainui.PictureButton;
import Miscellaneous.Cities;
import businessLogicService.UserblService.UserblService;

/**
 * 出库单
 * @author TOSHIBA
 *
 */
public class StorageOutPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton submit;
	JButton back;
	private UserblService user;
	public StorageOutPanel(UserblService user){
		this.user=user;
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		initSOPanel();
	}
	private void initSOPanel() {
		int padding = 10;
		int textwidth = 200;
		int textheight = 30;
		int labelwidth = 300;
		int labelheight = 30;
		int boxwidth = 200;
		int boxheight = 30;
		int buttonwidth = 80;
		int buttonheight = 30;
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,18);
		JLabel title = new JLabel(user.getCenterName()+"出库单",JLabel.CENTER);
		title.setFont(font);
		title.setBounds(150, 10, 600, 50);
		
		JLabel idLabel = new JLabel("· 快递编号：");
		idLabel.setFont(font);
		idLabel.setBounds(padding, 60, labelwidth, labelheight);
		
		JTextField id = new JTextField();
		id.setFont(font);
		id.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		id.setBounds(padding+120, 60, textwidth, textheight);
		id.setOpaque(false);
		
		JLabel dateLabel = new JLabel("· 出库日期：");
		dateLabel.setFont(font);
		dateLabel.setBounds(padding, 60+labelheight+padding, labelwidth, labelheight);
		
		//改自动生成当前时间
		JLabel date = new JLabel("2015/10/30");
		date.setFont(font);
		date.setBounds(padding+120, 60+labelheight+padding, labelwidth, labelheight);
		
		JLabel destinationlabel = new JLabel("· 目 的 地：");
		destinationlabel.setFont(font);
		destinationlabel.setBounds(padding, 60+2*(labelheight+padding), labelwidth, labelheight);
		
		JComboBox<String> destination = new JComboBox<String>();
		Cities[] cities = Cities.values();
		destination.addItem("请选择目标城市");
		for(int i=0;i<cities.length;i++){
			destination.addItem(cities[i].name());
		}
		destination.setSelectedItem("请选择目标城市");
		destination.setBounds(padding+120, 60+2*(labelheight+padding), boxwidth, boxheight);
		JComboBox<String> place = new JComboBox<String>();
		place.addItem("请选择目标地点");
		//添加目标地点
		
		
		
		place.setSelectedItem("请选择目标地点");
		place.setBounds(padding+120+boxwidth+padding, 60+2*(labelheight+padding), boxwidth, boxheight);
		
		JLabel formlabel = new JLabel("· 装运形式：");
		formlabel.setFont(font);
		formlabel.setBounds(padding, 60+3*(labelheight+padding), labelwidth, labelheight);
		
		ButtonGroup bg = new ButtonGroup();
		
		JRadioButton train = new JRadioButton("火车",true);
		train.setFont(font);
		train.setBounds(padding+120, 60+3*(labelheight+padding), 80, 30);
		train.setLayout(null);
		train.setOpaque(false);
		
		JRadioButton plane = new JRadioButton("飞机");
		plane.setFont(font);
		plane.setBounds(padding+120+90, 60+3*(labelheight+padding), 80, 30);
		plane.setLayout(null);
		plane.setOpaque(false);
		
		JRadioButton car = new JRadioButton("汽车");
		car.setFont(font);
		car.setBounds(padding+120+90+90, 60+3*(labelheight+padding), 80, 30);
		car.setLayout(null);
		car.setOpaque(false);
		
		JLabel numberlabel = new JLabel("· 汽运编号：");
		numberlabel.setFont(font);
		numberlabel.setBounds(padding, 60+4*(labelheight+padding), labelwidth, labelheight);
		
		JTextField number = new JTextField();
		number.setFont(font);
		number.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		number.setBounds(padding+120, 60+4*(labelheight+padding), textwidth, textheight);
		number.setOpaque(false);
		
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
		this.add(idLabel);
		this.add(dateLabel);	
		this.add(id);
		this.add(date);
		this.add(destinationlabel);
		this.add(destination);
		this.add(place);
		this.add(formlabel);
		bg.add(train);
		this.add(train);
		bg.add(plane);
		this.add(plane);
		bg.add(car);
		this.add(car);
		this.add(numberlabel);
		this.add(number);
		this.add(back);
		this.add(submit);
	}
}

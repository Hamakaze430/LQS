package presentation.Receiptsui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import presentation.mainui.PictureButton;
import Miscellaneous.Cities;
import businessLogicService.UserblService.UserblService;
/**
 * 入库单
 * @author TOSHIBA
 *
 */
public class StorageInPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton submit;
	JButton back;
	private UserblService user;
	public StorageInPanel(UserblService user){
		this.user=user;
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		initSIPanel();
	}
	private void initSIPanel() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,18);
		JLabel title = new JLabel(user.getHallName()+"入库单",JLabel.CENTER);
		title.setFont(font);
		title.setBounds(150, 10, 600, 50);
		
		JLabel idLabel = new JLabel("· 快递编号: ");
		idLabel.setFont(font);
		idLabel.setBounds(10, 60, 300, 50);		
		
		JTextField id = new JTextField(20);
		id.setFont(font);
		id.setOpaque(false);
		id.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		id.setBounds(130, 65, 200, 40);
		
		JLabel l1 = new JLabel("· 目 的 地：");
		l1.setFont(font);
		l1.setBounds(10, 110, 200, 30);
		
		JComboBox<String> destination = new JComboBox<String>();
		Cities[] cities = Cities.values();
		destination.addItem("请选择目标城市");
		for(int i=0;i<cities.length;i++){
			destination.addItem(cities[i].name());
		}
		destination.setSelectedItem("请选择目标城市");
		destination.setBounds(130, 110, 210, 30);
		JComboBox<String> place = new JComboBox<String>();
		place.addItem("请选择目标地点");
		//添加目标地点
		
		
		
		place.setSelectedItem("请选择目标地点");
		place.setBounds(360, 110, 210, 30);
		  
		JLabel l2 = new JLabel("· 区    号：");
		JLabel l3 = new JLabel("· 排    号：");
		JLabel l4 = new JLabel("· 架    号：");
		JLabel l5 = new JLabel("· 位    号：");
		l2.setFont(font);
		l3.setFont(font);
		l4.setFont(font);
		l5.setFont(font);	
		l2.setBounds(10, 150, 200, 30);
		l3.setBounds(10, 190, 200, 30);
		l4.setBounds(10, 230, 200, 30);
		l5.setBounds(10, 270, 200, 30);
		
		JComboBox<String> c1 = new JComboBox<String>();
		JComboBox<String> c2 = new JComboBox<String>();
		JComboBox<String> c3 = new JComboBox<String>();
		JComboBox<String> c4 = new JComboBox<String>();
		c1.addItem("请选择区号");
		c2.addItem("请选择排号");
		c3.addItem("请选择架号");
		c4.addItem("请选择位号");
		//添加仓库位置信息
		
		
		
		c1.setBounds(130, 150, 150, 30);
		c2.setBounds(130, 190, 150, 30);
		c3.setBounds(130, 230, 150, 30);
		c4.setBounds(130, 270, 150, 30);
		
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
		this.add(id);
		this.add(idLabel);
		this.add(l1);
		this.add(destination);
		this.add(place);
		this.add(l5);
		this.add(l4);
		this.add(l3);
		this.add(l2);
		this.add(c4);
		this.add(c3);
		this.add(c2);
		this.add(c1);
		this.add(back);
		this.add(submit);
	}
}

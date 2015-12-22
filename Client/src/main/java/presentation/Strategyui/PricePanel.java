package presentation.Strategyui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import presentation.mainui.PictureButton;
/**
 * 价格策略
 * @author TOSHIBA
 *
 */
public class PricePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton back;
	JButton save;
	public PricePanel(){
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		initPPanel();
	}
	private void initPPanel() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,18);
		JLabel l1 = new JLabel("· 请设置各运送方式价格：");
		l1.setFont(font);
		l1.setBounds(10, 10, 250, 30);
		
		JLabel carPrice = new JLabel("汽车：                 元每公里每吨");
		JLabel trainPrice = new JLabel("火车：                 元每公里每吨");
		JLabel planePrice = new JLabel("飞机：                 元每公里每吨");
		carPrice.setFont(font);
		trainPrice.setFont(font);
		planePrice.setFont(font);
		carPrice.setBounds(250, 10, 500, 30);
		trainPrice.setBounds(250, 40, 500, 30);
		planePrice.setBounds(250, 70, 500, 30);
		
		JTextField car = new JTextField(20);
		JTextField train = new JTextField(20);
		JTextField plane = new JTextField(20);
		car.setFont(font);
		train.setFont(font);
		plane.setFont(font);
		car.setBounds(300, 8, 160, 30);
		train.setBounds(300, 38, 160, 30);
		plane.setBounds(300, 68, 160, 30);
		train.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		car.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		plane.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		car.setOpaque(false);
		train.setOpaque(false);
		plane.setOpaque(false);
		
		JLabel l2 = new JLabel("· 请设置经济快递、标准快递、次晨特快价格比：         ：        ：        ");
		l2.setFont(font);
		l2.setBounds(10, 100, 800, 30);
		
		JTextField type1 = new JTextField(20);
		JTextField type2 = new JTextField(20);
		JTextField type3 = new JTextField(20);
		type1.setFont(font);
		type2.setFont(font);
		type3.setFont(font);
		type1.setBounds(405, 98, 80, 30);
		type2.setBounds(505, 98, 80, 30);
		type3.setBounds(600, 98, 80, 30);
		type1.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		type2.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		type3.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		type1.setOpaque(false);
		type2.setOpaque(false);
		type3.setOpaque(false);
		
		JLabel l3 = new JLabel("· 请设置标准快递价格：        元每公斤");
		l3.setFont(font);
		l3.setBounds(10, 130, 800, 30);
		
		JTextField stPrice = new JTextField(20);
		stPrice.setFont(font);
		stPrice.setBounds(210, 130, 80, 30);
		stPrice.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		stPrice.setOpaque(false);
		
		JLabel l4 = new JLabel("· 请设置城市间距离：");
		l4.setFont(font);
		l4.setBounds(10, 160, 800, 30);
		
		JTable table = new JTable(5,5);
		table.setBounds(10, 200, 800, 200);
		table.setValueAt("北京", 0, 1);
		table.setValueAt("上海", 0, 2);
		table.setValueAt("广州", 0, 3);
		table.setValueAt("南京", 0, 4);
		table.setValueAt("北京", 1, 0);
		table.setValueAt("上海", 2, 0);
		table.setValueAt("广州", 3, 0);
		table.setValueAt("南京", 4, 0);
		table.setRowHeight(30);
		table.setBackground(new Color(255,255,255,100));
		table.setOpaque(false);
		
		
		save = new JButton();
		save.setFont(font);
		save.setBorder(null);
		save.setOpaque(false);
		save.setFocusPainted(false);
		save.setContentAreaFilled(false);
		
		//save.setBounds(820, 450, 70, 30);
		save.setBounds(740, 510, 70, 30);
		PictureButton.setIcon("src/main/java/image/saveButton_unclicked.png",save);
		save.addMouseListener(new MouseListener(){

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
				PictureButton.setIcon("src/main/java/image/saveButton_clicked.png",save);
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/saveButton_unclicked.png",save);
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
		
		this.add(l1);
		this.add(planePrice);
		this.add(trainPrice);
		this.add(carPrice);
		this.add(plane);
		this.add(train);
		this.add(car);
		this.add(l2);
		this.add(type3);
		this.add(type2);
		this.add(type1);
		this.add(l3);
		this.add(stPrice);
		this.add(l4);
		this.add(table);
		this.add(back);
		this.add(save);
		
	}
}

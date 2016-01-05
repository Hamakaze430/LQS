package presentation.WareHouseui;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.mainui.PictureButton;

/**
 * 分区管理
 * @author TOSHIBA
 *
 */
public class DivisionPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton save;
	JButton back;
	int padding = 10;
	int label_width = 200;
	int label_height = 30;
	int box_width = 120;
	int box_height = 30;
	int button_width = 80;
	int button_height = 30;
	
	public DivisionPanel(){
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		initDPanel();
	}
	private void initDPanel() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,16);
		JLabel l1 = new JLabel("· 请选择要管理的排：");
		l1.setFont(font);
		l1.setBounds(padding, padding, label_width, label_height);
		JLabel l2 = new JLabel("· 请选择要转换到的分区：");
		l2.setFont(font);
		l2.setBounds(padding, 2*padding+label_height, label_width, label_height);
		
		JComboBox line = new JComboBox();
		line.setFont(font);
		line.setBounds(padding+200, padding, box_width, box_height);
		line.addItem("请选择排号");
		line.setSelectedItem("请选择排号");
		
		JComboBox area = new JComboBox();
		area.setFont(font);
		area.setBounds(padding+200, padding*2+box_height, box_width, box_height);
		area.addItem("请选择分区");
		area.setSelectedItem("请选择分区");
		
		JLabel present = new JLabel("· 当前分区情况：");
		present.setFont(font);
		present.setBounds(padding, padding*3+label_height*2, label_width, label_height);
		
		JLabel situation = new JLabel();
		situation.setFont(font);
		situation.setBounds(padding, padding*4+label_height*3, label_width*4, label_height*5);
		
		save = new JButton();
		save.setFont(font);
		save.setBorder(null);
		save.setOpaque(false);
		save.setFocusPainted(false);
		save.setContentAreaFilled(false);
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
		this.add(l2);
		this.add(line);
		this.add(area);
		this.add(present);
		this.add(situation);
		this.add(save);
		this.add(back);
	}

}

package presentation.CarAndDriverui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

<<<<<<< HEAD
import presentation.mainui.PictureButton;
=======
import businessLogic.CarAndDriverbl.CarAndDriverbl;
import businessLogicService.CarAndDriverblService.CarAndDriverblService;
import businessLogicService.UserblService.UserblService;
>>>>>>> 53bb2ae242dfc910e1ced7c53f2a8cc23ea37739
import vo.CarVO;
import vo.CheckVO;
import vo.DriverVO;
import vo.HallVO;

public class DriverPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
	JButton add;
	JButton delete;
	JButton back;
=======
	private CarAndDriverblService bl;
	private DefaultTableModel defaultModel;
	private UserblService user;
	private int buttonNum;
>>>>>>> 53bb2ae242dfc910e1ced7c53f2a8cc23ea37739
	int padding = 10;
	int label_width = 200;
	int label_height = 30;
	int box_width = 120;
	int box_height = 30;
	int button_width = 80;
	int button_height = 30;
	public DriverPanel(UserblService user, int buttonNum){
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		this.user = user;
		this.buttonNum = buttonNum;
		bl = new CarAndDriverbl();
		init();
	}
	
	private void init() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,16);
		Vector<String> name = new Vector<String>();
		name.add("司机编号");
		name.add("司机姓名");
		name.add("性别");
		name.add("出生日期");
		name.add("身份证号");
		name.add("手机号");
		name.add("行驶证期限");
		
		Vector<DriverVO> data = new Vector<DriverVO>();		
		defaultModel = new DefaultTableModel(data,name);
		JTable table = new JTable(defaultModel){		
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		table.setRowHeight(35);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setBackground(new Color(200, 200, 200));
		table.setBackground(new Color(255,255,255,100));
		table.getTableHeader().setReorderingAllowed(false);
		table.setOpaque(false);
		table.setRowSorter(new TableRowSorter<DefaultTableModel>(defaultModel));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(padding, padding, 884, 490);
		scrollPane.getViewport().add(table);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		
		initTable();	
		
		
		add = new JButton();
		add.setBorder(null);
		add.setOpaque(false);
		add.setFocusPainted(false);
		add.setContentAreaFilled(false);
		add.setBounds(660, 510, 70, 30);
		PictureButton.setIcon("src/main/java/image/addButton_unclicked.png",add);
		add.addMouseListener(new MouseListener(){

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
				PictureButton.setIcon("src/main/java/image/addButton_clicked.png",add);
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/addButton_unclicked.png",add);
			}
			
		});
		delete = new JButton();
		delete.setBorder(null);
		delete.setOpaque(false);
		delete.setFocusPainted(false);
		delete.setContentAreaFilled(false);
		delete.setBounds(740, 510, 70, 30);
		PictureButton.setIcon("src/main/java/image/deleteButton_unclicked.png",delete);
		delete.addMouseListener(new MouseListener(){

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
				PictureButton.setIcon("src/main/java/image/deleteButton_clicked.png",delete);
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/deleteButton_unclicked.png",delete);
			}
			
		});
		back = new JButton();
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
		
		
		this.add(scrollPane);
		this.add(add);
		this.add(delete);
		this.add(back);
	}

	public void setValue(DriverVO info) {
		// TODO Auto-generated method stub
		
	}
	private void initTable() {
		// TODO Auto-generated method stub
		List<DriverVO> list = bl.findAllDriverInfo(user.getHallId());
		for (DriverVO vo : list) defaultModel.addRow(vo);
	}

}


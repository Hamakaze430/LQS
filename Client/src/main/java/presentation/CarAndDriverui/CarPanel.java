package presentation.CarAndDriverui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import presentation.Receiptsui.LoadingPanel;
import presentation.Userui.MainPanel;
import presentation.mainui.PictureButton;
import businessLogic.CarAndDriverbl.CarAndDriverbl;
import businessLogicService.CarAndDriverblService.CarAndDriverblService;
import businessLogicService.UserblService.UserblService;
import vo.CarVO;
import vo.CheckVO;
import vo.HallVO;

public class CarPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton add;
	JButton delete;
	JButton back;
	JButton search;
	JTable table;
	JTextField searchid;
	private CarAndDriverblService bl;
	private DefaultTableModel defaultModel;
	private UserblService user;
	private int buttonNum;
	int interval = 220;
	int padding = 10;
	int label_width = 250;
	int label_height = 30;
	int box_width = 120;
	int box_height = 30;
	int button_width = 80;
	int button_height = 30;
	public CarPanel(UserblService user,int buttonNum){
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
		
		JLabel searchLabel = new JLabel("· 请输入要查询的车辆代号：");
		searchLabel.setFont(font);
		searchLabel.setBounds(padding, padding, label_width, label_height);
		
		searchid = new JTextField(20);
		searchid.setFont(font);
		searchid.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		searchid.setBounds(padding+interval, padding, 150, label_height);
		searchid.setOpaque(false);
		searchid.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				searchCar(searchid.getText());
			}
			
		});
		
		search = new JButton("查询");
		search.setFont(new Font("微软雅黑",Font.PLAIN,18));
		search.setBounds(padding*2+interval+150, padding, 40, button_height);
		search.setForeground(Color.black);
		search.setContentAreaFilled(false);
		search.setOpaque(false);
		search.setBorder(null);
		search.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				searchCar(searchid.getText());
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
				((JButton)e.getSource()).setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
				((JButton)e.getSource()).setBorder(null);
			}
			
		});
		
		
		
		
		Vector<String> name = new Vector<String>();
		name.add("车辆代号");
		name.add("车牌号");
		name.add("服役时间");
		
		Vector<CarVO> data = new Vector<CarVO>();		
		defaultModel = new DefaultTableModel(data,name);
		table = new JTable(defaultModel){		
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
		scrollPane.setBounds(padding, padding*2+label_height, 884, 440);
		scrollPane.getViewport().add(table);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		
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
				new addCar(user,bl,defaultModel).setVisible(true);
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
				int index = table.convertRowIndexToModel(table.getSelectedRow());
				if(index == -1){
					JOptionPane.showMessageDialog(null, "请选中要删除的车辆信息！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int n = JOptionPane.showConfirmDialog(null, "确定删除改信息?", "确认框",JOptionPane.YES_NO_OPTION);
				//System.out.println(index);
				if (n == 1) return;
				
				CarVO vo = (CarVO)defaultModel.getDataVector().elementAt(index);
				bl.deleteCarInfo(vo);
				defaultModel.removeRow(index);
				JOptionPane.showMessageDialog(null, "删除成功^_^","", JOptionPane.CLOSED_OPTION);
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
				CarPanel.this.setVisible(false);
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
		initTable();
		this.add(scrollPane);
		this.add(add);
		this.add(back);
		this.add(delete);
		this.add(searchLabel);
		this.add(searchid);
		this.add(search);
	}

	protected void searchCar(String s) {
		// TODO Auto-generated method stub
		
		searchid.setText("");
		int index = -1;
		for (int i = 0; i < table.getRowCount(); i++){
			if (table.getValueAt(i, 0).toString().equals(s)){
				index = i; 
				break;
			}
		}
		if (index == -1){
			JOptionPane.showMessageDialog(null, "找不到对应的车辆信息！","", JOptionPane.ERROR_MESSAGE);
			initTable();
			return;
		}
		index = table.convertRowIndexToModel(index);
		CarVO vo = (CarVO)defaultModel.getDataVector().elementAt(index);
		defaultModel.setRowCount(0);
		defaultModel.addRow(vo);
		
	}

	public void setValue(CarVO info) {
		// TODO Auto-generated method stub
		
	}
	
	private void initTable() {
		// TODO Auto-generated method stub
		defaultModel.setRowCount(0);
		List<CarVO> list = bl.findAllCarInfo(user.getHallId());
		for (CarVO vo : list) defaultModel.addRow(vo);
	}

}

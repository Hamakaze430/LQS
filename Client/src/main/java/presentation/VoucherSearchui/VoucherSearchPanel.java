package presentation.VoucherSearchui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import presentation.mainui.PictureButton;
import vo.HallVO;
import vo.VoucherSearchVO;
/**
 * 收款单查询
 * @author TOSHIBA
 *
 */
public class VoucherSearchPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton back;
	JButton confirm;
	JComboBox<String> year = new JComboBox<String>();
	JComboBox<String> month = new JComboBox<String>();
	JComboBox<String> day = new JComboBox<String>();
	
	public VoucherSearchPanel(){
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		initVSPanel();
	}
	private void initVSPanel() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,14);
		JLabel l1 = new JLabel("· 请选择查询方式：");
		l1.setFont(font);
		l1.setBounds(5, 5, 200, 40);
		
		ButtonGroup bg = new ButtonGroup();
		
		JRadioButton j1 = new JRadioButton("按天查询",true);
		j1.setFont(font);
		j1.setBounds(160, 5, 100, 40);
		j1.setOpaque(false);
		j1.setBorder(null);
		
		JRadioButton j2 = new JRadioButton("按营业厅查询",true);
		j2.setFont(font);
		j2.setBounds(280, 5, 130, 40);
		j2.setOpaque(false);
		j2.setBorder(null);
		
		JLabel l2 = new JLabel("· 请选择要查询的日期：");
		l2.setFont(font);
		l2.setBounds(5, 40, 180, 40);
		
		day.addItem("请选择日期");
		for(int i = 1;i<=28;i++){
			day.addItem(i+"");
		}		
		day.setSelectedItem("请选择日期");
		day.setBounds(400, 48, 100, 24);
		day.setFont(font);
		
		year.addItem("请选择年份");
		Calendar c = Calendar.getInstance();
		for(int i = 1960;i<=c.get(Calendar.YEAR);i++){
			year.addItem(i+"");
		}
		year.setSelectedItem("请选择年份");
		year.setBounds(160, 48, 100, 24);
		year.setFont(font);
		
		
		month.addItem("请选择月份");
		for(int i = 1;i<=12;i++){
			month.addItem(i+"");
		}
		month.setSelectedItem("请选择月份");
		month.setBounds(280, 48, 100, 24);
		month.setFont(font);
		month.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (month.getSelectedItem().equals("1")||month.getSelectedItem().equals("3")||
						month.getSelectedItem().equals("5")||month.getSelectedItem().equals("7")
								||month.getSelectedItem().equals("8")||month.getSelectedItem().equals("10")
								||month.getSelectedItem().equals("12")) {
					day.addItem("29");
					day.addItem("30");
					day.addItem("31");
				}
				else if(month.getSelectedItem().equals("4")||month.getSelectedItem().equals("6")||
						month.getSelectedItem().equals("9")||month.getSelectedItem().equals("11")){
					day.addItem("29");
					day.addItem("30");
				}
				int temp=Integer.parseInt((String) year.getSelectedItem());
				if(month.getSelectedItem().equals("2")&&(!isLeapYear(temp))){
					day.addItem("29");
				}
			}	
		});
	
		Vector<String> name = new Vector<String>();
		name.add("营业厅编号");
		name.add("收款日期");
		name.add("收款金额");
		
		Vector<VoucherSearchVO> data = new Vector<VoucherSearchVO>();		
		DefaultTableModel defaultModel = new DefaultTableModel(data,name);
		JTable table = new JTable(defaultModel){		
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		//table.setBounds(10, 80, 884, 400);
		table.setRowHeight(35);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setBackground(new Color(200, 200, 200));
		table.setBackground(new Color(255,255,255,100));
		table.getTableHeader().setReorderingAllowed(false);
		table.setOpaque(false);
		table.setRowSorter(new TableRowSorter<DefaultTableModel>(defaultModel));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 884, 400);
	//	scrollPane.add(table.getTableHeader());
		scrollPane.getViewport().add(table);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		
		
		defaultModel.addRow(new VoucherSearchVO("南京市鼓楼营业厅","2015/10/30","10.00"));
		
		
		
		JLabel cost = new JLabel("总收款金额：");
		cost.setFont(font);
		cost.setBounds(10, 480, 100, 40);
		
		confirm = new JButton();
		confirm.setFont(font);
		confirm.setBorder(null);
		confirm.setOpaque(false);
		confirm.setFocusPainted(false);
		confirm.setContentAreaFilled(false);
		confirm.setBounds(740, 510, 70, 30);
		PictureButton.setIcon("src/main/java/image/confirmButton_unclicked.png",confirm);
		confirm.addMouseListener(new MouseListener(){

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
				PictureButton.setIcon("src/main/java/image/confirmButton_clicked.png",confirm);
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/confirmButton_unclicked.png",confirm);
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
		bg.add(j1);
		this.add(j1);
		bg.add(j2);
		this.add(j2);
		this.add(cost);
		this.add(confirm);
		this.add(back);
		this.add(l2);
		this.add(year);
		this.add(month);
		this.add(day);
		//this.add(table);
		this.add(scrollPane);
		
	}
	public boolean isLeapYear(int year){
		if(year%400==0||(year%4==0&&year%100!=0)) return true;
		return false;
	}
}

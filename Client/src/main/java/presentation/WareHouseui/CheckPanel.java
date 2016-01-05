package presentation.WareHouseui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import presentation.mainui.PictureButton;
import vo.CheckVO;
import vo.VoucherSearchVO;
/**
 * 库存查看
 * @author TOSHIBA
 *
 */
public class CheckPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComboBox year = new JComboBox();
	JComboBox month = new JComboBox();
	JComboBox day = new JComboBox();
	JComboBox year1 = new JComboBox();
	JComboBox month1 = new JComboBox();
	JComboBox day1 = new JComboBox();
	JButton back;
	int padding = 10;
	int label_width = 200;
	int label_height = 30;
	int box_width = 120;
	int box_height = 30;
	int button_width = 80;
	int button_height = 30;
	
	public CheckPanel(){
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		initCPanel();
	}
	private void initCPanel() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,16);
		JLabel l1 = new JLabel("· 开始日期：");
		l1.setFont(font);
		l1.setBounds(padding, padding, label_width, label_height);
		JLabel l2 = new JLabel("· 结束日期：");
		l2.setFont(font);
		l2.setBounds(padding, 2*padding+label_height, label_width, label_height);
		
		day.addItem("请选择日期");
		for(int i = 1;i<=28;i++){
			day.addItem(i+"");
		}		
		day.setSelectedItem("请选择日期");
		day.setBounds(3*padding+120+2*box_width, padding, box_width, box_height);
		day.setFont(font);
		
		year.addItem("请选择年份");
		Calendar c = Calendar.getInstance();
		for(int i = 1960;i<=c.get(Calendar.YEAR);i++){
			year.addItem(i+"");
		}
		year.setSelectedItem("请选择年份");
		year.setBounds(padding+120, padding, box_width, box_height);
		year.setFont(font);
		
		
		month.addItem("请选择月份");
		for(int i = 1;i<=12;i++){
			month.addItem(i+"");
		}
		month.setSelectedItem("请选择月份");
		month.setBounds(2*padding+120+box_width, padding, box_width, box_height);
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
		
		day1.addItem("请选择日期");
		for(int i = 1;i<=28;i++){
			day1.addItem(i+"");
		}		
		day1.setSelectedItem("请选择日期");
		day1.setBounds(3*padding+120+2*box_width, padding+box_height+padding, box_width, box_height);
		day1.setFont(font);
		
		year1.addItem("请选择年份");
		
		for(int i = 1960;i<=c.get(Calendar.YEAR);i++){
			year1.addItem(i+"");
		}
		year1.setSelectedItem("请选择年份");
		year1.setBounds(padding+120, padding+box_height+padding, box_width, box_height);
		year1.setFont(font);
		
		
		month1.addItem("请选择月份");
		for(int i = 1;i<=12;i++){
			month1.addItem(i+"");
		}
		month1.setSelectedItem("请选择月份");
		month1.setBounds(2*padding+120+box_width, padding+box_height+padding, box_width, box_height);
		month1.setFont(font);
		month1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (month1.getSelectedItem().equals("1")||month1.getSelectedItem().equals("3")||
						month1.getSelectedItem().equals("5")||month1.getSelectedItem().equals("7")
								||month1.getSelectedItem().equals("8")||month1.getSelectedItem().equals("10")
								||month1.getSelectedItem().equals("12")) {
					day1.addItem("29");
					day1.addItem("30");
					day1.addItem("31");
				}
				else if(month1.getSelectedItem().equals("4")||month1.getSelectedItem().equals("6")||
						month1.getSelectedItem().equals("9")||month1.getSelectedItem().equals("11")){
					day1.addItem("29");
					day1.addItem("30");
				}
				int temp=Integer.parseInt((String) year1.getSelectedItem());
				if(month1.getSelectedItem().equals("2")&&(!isLeapYear(temp))){
					day1.addItem("29");
				}
			}	
		});
		
		
		JButton search = new JButton("查询");
		search.setFont(font);
		search.setBorder(null);
		search.setBounds(padding+120+box_width*3+padding*3, padding+box_height+padding, button_width, button_height);
		
		Vector<String> name = new Vector<String>();
		name.add("单据类型");
		name.add("快递编号");
		name.add("运费");
		name.add("仓库位置");
		
		Vector<CheckVO> data = new Vector<CheckVO>();		
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
		scrollPane.setBounds(padding, padding*3+box_height*2, 884, 280);
	//	scrollPane.add(table.getTableHeader());
		scrollPane.getViewport().add(table);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
			
		defaultModel.addRow(new CheckVO("入库单","0250001001","10.00","航空区A排A架A位"));
		
		JLabel sum = new JLabel("总计：");
		sum.setFont(font);
		sum.setBounds(padding, padding*3+box_height*2+280+5, label_width, label_height);
		
		JLabel l3 = new JLabel("· 入库单总数：");
		l3.setFont(font);
		l3.setBounds(padding, padding*3+box_height*2+280+label_height+5, label_width, label_height);
		
		JLabel l4 = new JLabel("· 出库单总数：");
		l4.setFont(font);
		l4.setBounds(padding, padding*3+box_height*2+280+label_height*2+10, label_width, label_height);
		
		JLabel l5 = new JLabel("· 仓库占用率：");
		l5.setFont(font);
		l5.setBounds(padding, padding*3+box_height*2+280+label_height*3+15, label_width, label_height);
		
		JLabel l6 = new JLabel("· 总  金  额：");
		l6.setFont(font);
		l6.setBounds(padding, padding*3+box_height*2+280+label_height*4+20, label_width, label_height);
		
		JLabel inReceipt = new JLabel();
		inReceipt.setFont(font);
		inReceipt.setBounds(padding+120, padding*3+box_height*2+280+label_height+5, label_width, label_height);
		
		JLabel outReceipt = new JLabel();
		outReceipt.setFont(font);
		outReceipt.setBounds(padding+120, padding*3+box_height*2+280+label_height*2+10, label_width, label_height);
		
		JLabel rate = new JLabel();
		rate.setFont(font);
		rate.setBounds(padding+120, padding*3+box_height*2+280+label_height*3+15, label_width, label_height);
		
		JLabel priceSum = new JLabel();
		priceSum.setFont(font);
		priceSum.setBounds(padding+120, padding*3+box_height*2+280+label_height*4+20, label_width, label_height);
		
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
		this.add(day);
		this.add(month);
		this.add(year);
		this.add(day1);
		this.add(month1);
		this.add(year1);
		this.add(search);
		this.add(scrollPane);
		this.add(sum);
		this.add(l3);
		this.add(l4);
		this.add(l5);
		this.add(l6);
		this.add(inReceipt);
		this.add(outReceipt);
		this.add(priceSum);
		this.add(back);
	}
	
	public boolean isLeapYear(int year){
		if(year%400==0||(year%4==0&&year%100!=0)) return true;
		return false;
	}

}

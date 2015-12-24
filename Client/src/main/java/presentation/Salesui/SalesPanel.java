package presentation.Salesui;

import init.Client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import presentation.mainui.PictureButton;

import presentation.CostBenefitui.CostPanel;
import presentation.mainui.WelcomePanel;
import vo.ReceiptVO;
import vo.SalesVO;
import vo.receipts.IncomeVO;
import vo.receipts.PassIncomeVO;
import vo.receipts.PassPaymentVO;
import vo.receipts.PaymentVO;
import businessLogic.Salesbl.Sales;
import businessLogicService.UserblService.UserblService;
/**
 * 经营情况
 * @author TOSHIBA
 *
 */
public class SalesPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton back;
	JButton importButton;
	JButton confirm;
	private UserblService user;
	private Sales sales=new Sales();
	private String startDate;
	private String endDate;
	
	JComboBox year1 = new JComboBox();
	JComboBox month1 = new JComboBox();
	JComboBox day2 = new JComboBox();
	JComboBox year2 = new JComboBox();
	JComboBox month2 = new JComboBox();
	JComboBox day1 = new JComboBox();
	public SalesPanel(UserblService user){
		this.user=user;
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		initSPanel();
	}
	private void initSPanel() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,18);
		
		JLabel start = new JLabel("· 请选择开始日期："); 
		start.setFont(font);
		start.setBounds(30, 20, 200, 40);
		
		JLabel end = new JLabel("· 请选择结束日期："); 
		end.setFont(font);
		end.setBounds(30, 60, 200, 40);
		
		day1.addItem("请选择日期");	
		day1.setSelectedItem("请选择日期");
		day1.setBounds(465, 28, 120, 24);
		day1.setFont(font);
		
		year1.addItem("请选择年份");
		Calendar c = Calendar.getInstance();
		for(int i = 2000;i<=c.get(Calendar.YEAR);i++){
			year1.addItem(i+"");
		}
		year1.setSelectedItem("请选择年份");
		year1.setBounds(205, 28, 120, 24);
		year1.setFont(font);
		
		
		month1.addItem("请选择月份");
		for(int i = 1;i<=12;i++){
			month1.addItem(i+"");
		}
		month1.setSelectedItem("请选择月份");
		month1.setBounds(335, 28, 120, 24);
		month1.setFont(font);
		month1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				day1.removeAllItems();
				day1.addItem("请选择日期");
				if (month1.getSelectedIndex() == 0) return;
				for(int i = 1;i<=28;i++){
					day1.addItem(i+"");
				}
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
				if(month1.getSelectedItem().equals("2")&&(isLeapYear(temp))){
					day1.addItem("29");
				}
			}	
		});
	
		day2.addItem("请选择日期");		
		day2.setSelectedItem("请选择日期");
		day2.setBounds(465, 68, 120, 24);
		day2.setFont(font);
		
		year2.addItem("请选择年份");
		
		for(int i = 2000;i<=c.get(Calendar.YEAR);i++){
			year2.addItem(i+"");
		}
		year2.setSelectedItem("请选择年份");
		year2.setBounds(205, 68, 120, 24);
		year2.setFont(font);
		
		
		month2.addItem("请选择月份");
		for(int i = 1;i<=12;i++){
			month2.addItem(i+"");
		}
		month2.setSelectedItem("请选择月份");
		month2.setBounds(335, 68, 120, 24);
		month2.setFont(font);
		month2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				day2.removeAllItems();
				day2.addItem("请选择日期");
				if (month2.getSelectedIndex() == 0) return;
				for(int i = 1;i<=28;i++){
					day2.addItem(i+"");
				}
				if (month2.getSelectedItem().equals("1")||month2.getSelectedItem().equals("3")||
						month2.getSelectedItem().equals("5")||month2.getSelectedItem().equals("7")
								||month2.getSelectedItem().equals("8")||month2.getSelectedItem().equals("10")
								||month2.getSelectedItem().equals("12")) {
					day2.addItem("29");
					day2.addItem("30");
					day2.addItem("31");
				}
				else if(month2.getSelectedItem().equals("4")||month2.getSelectedItem().equals("6")||
						month2.getSelectedItem().equals("9")||month2.getSelectedItem().equals("11")){
					day2.addItem("29");
					day2.addItem("30");
				}
				int temp=Integer.parseInt((String) year2.getSelectedItem());
				if(month2.getSelectedItem().equals("2")&&(!isLeapYear(temp))){
					day2.addItem("29");
				}
			}	
		});
		
		confirm = new JButton("确定");
		confirm.setFont(font);
		confirm.setBorder(new MatteBorder(1,1,1,1,Color.BLACK));
		confirm.setOpaque(false);
		confirm.setFocusPainted(false);
		confirm.setContentAreaFilled(false);
		confirm.setBounds(600, 68, 80, 24);
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
				confirm.setFont(new Font("黑体",Font.BOLD,18));
				confirm.setBorder(new MatteBorder(2,2,2,2,Color.BLACK));
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				confirm.setFont(new Font("黑体",Font.PLAIN,18));
				confirm.setBorder(new MatteBorder(1,1,1,1,Color.BLACK));

			}
			
		});
		
		
		JLabel title = new JLabel(user.getCompanyName()+"经营情况表",JLabel.CENTER);
		title.setFont(font);
		title.setBounds(150, 85, 600, 50);
		
		Vector<String> name = new Vector<String>();
		name.add("单据类型");
		name.add("建单日期");
		name.add("建单人");
		name.add("金额");
		
		Vector<SalesVO> data = new Vector<SalesVO>();

		//newly added "final" below....orz
		final DefaultTableModel defaultModel = new DefaultTableModel(data,name);
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
		scrollPane.setBounds(10, 130, 884, 360);
	//	scrollPane.add(table.getTableHeader());
		scrollPane.getViewport().add(table);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		
		
		//defaultModel.addRow(new SalesVO("收款单","2015/10/30","张三","10.00"));
		
		importButton = new JButton();
		importButton.setFont(font);
		importButton.setBorder(null);
		importButton.setOpaque(false);
		importButton.setFocusPainted(false);
		importButton.setContentAreaFilled(false);
		importButton.setBounds(740, 510, 70, 30);
		PictureButton.setIcon("src/main/java/image/importButton_unclicked.png",importButton);
		importButton.addMouseListener(new MouseListener(){

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
				PictureButton.setIcon("src/main/java/image/importButton_clicked.png",importButton);
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/importButton_unclicked.png",importButton);
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
		
		this.add(start);
		this.add(end);
		this.add(day1);
		this.add(month1);
		this.add(year1);
		this.add(day2);
		this.add(month2);
		this.add(year2);
		this.add(confirm);
		this.add(title);
		this.add(scrollPane);
		this.add(importButton);
		this.add(back);
		
		
		/*
		 * adding logic....
		 * */
		confirm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent args0){
//				if(year1.getSelectedIndex()!=0&&month1.getSelectedIndex()!=0&&
//						day1.getSelectedIndex()!=0&&year2.getSelectedIndex()!=0
//						&&month2.getSelectedIndex()!=0&&day2.getSelectedIndex()!=0){
//					int y1=year1.getSelectedIndex();
//					int m1=month1.getSelectedIndex();
//					int d1=day1.getSelectedIndex();
//					int y2=year2.getSelectedIndex();
//					int m2=month2.getSelectedIndex();
//					int d2=day2.getSelectedIndex();
//					startDate=year1.getSelectedItem()+"-"
//							+month1.getSelectedItem()+"-"
//							+day1.getSelectedItem();
//					endDate=year2.getSelectedItem()+"-"
//							+month2.getSelectedItem()+"-"
//							+day2.getSelectedItem();
//				}
//				else{
//					JOptionPane.showMessageDialog(null, "请先选择日期>_<","", 
//												JOptionPane.INFORMATION_MESSAGE);
//					return;
//				}
				
				startDate="2014-10-01";
				
				endDate=("2015-12-31");
				
				sales.setDate(startDate, endDate);
				SalesVO vo=sales.show();
				
				defaultModel.setRowCount(0);
				
//				while(defaultModel.getRowCount()!=0){
//					defaultModel.removeRow(0);
//				}
				//System.out.println(defaultModel.getRowCount());
				ArrayList<IncomeVO> incomeList=vo.getIncomeList();
				Iterator<IncomeVO> iit=incomeList.iterator();
				while(iit.hasNext()){
					PassIncomeVO piv=new PassIncomeVO(iit.next());
					defaultModel.addRow(piv);
				}
				ArrayList<PaymentVO> paymentList=vo.getPaymentList();
				Iterator<PaymentVO> pit=paymentList.iterator();
				while(pit.hasNext()){
					PassPaymentVO ppv=new PassPaymentVO(pit.next());
					defaultModel.addRow(ppv);
				}
				//defaultModel.addRow(vo);
			}
		});

		confirm.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

		importButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent args0){
				if(sales.getReport())
					JOptionPane.showMessageDialog(null, "导出成功^_^","", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "导出failed","", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
	}

	
	public boolean isLeapYear(int year){
		if(year%400==0||(year%4==0&&year%100!=0)) return true;
		return false;
	}

}

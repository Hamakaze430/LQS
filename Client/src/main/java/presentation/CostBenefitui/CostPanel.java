package presentation.CostBenefitui;

import init.Client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import presentation.LogisticsInfoSearchui.LogisticsPanel;
import presentation.mainui.WelcomePanel;
import vo.CostBenefitVO;
import vo.HallVO;
import vo.VoucherSearchVO;
import businessLogic.CostBenefitbl.CostBenefit;
import businessLogicService.CostBenefitblService.CostBenefitblService;
import businessLogicService.UserblService.UserblService;
/**
 * 成本收益
 * @author TOSHIBA
 *
 */
public class CostPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserblService user;
	private CostBenefit cb=new CostBenefit();
	
	
	public CostPanel(UserblService user){
		this.user=user;
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		initCPanel();	
	}

	private void initCPanel() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,18);
		JLabel title = new JLabel(user.getCompanyName()+"成本收益表",JLabel.CENTER);
		title.setFont(font);
		title.setBounds(150, 10, 600, 50); 
		
		Vector<String> name = new Vector<String>();
		name.add("总收入");
		name.add("总支出");
		name.add("总利润");
		
		
		Vector<CostBenefitVO> data = new Vector<CostBenefitVO>();		
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
		scrollPane.setBounds(10, 75, 884, 400);
	//	scrollPane.add(table.getTableHeader());
		scrollPane.getViewport().add(table);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		
		
		defaultModel.addRow(new CostBenefitVO("10.00","10.00","10.00"));
		
		JButton b1 = new JButton("导出Excel");
		b1.setFont(new Font("黑体",Font.PLAIN,15));
		b1.setBounds(650, 490, 110, 30);
		JButton b2 = new JButton("返回");
		b2.setFont(new Font("黑体",Font.PLAIN,15));
		b2.setBounds(770, 490, 110, 30);
		
		
		/*
		 *added 
		 **/
		b1.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent args0){
				cb.getReport();
				/*
				 * 
				 * 是不是要下一个界面。。。。这里orz
				 * */
			}
		});
		
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent args0){
				Client.frame.add(new WelcomePanel());
				Client.frame.remove(CostPanel.this);
				Client.frame.repaint();
			}
		});
		
		this.add(title);
		this.add(b1);
		this.add(b2);
		this.add(scrollPane);
	}
}

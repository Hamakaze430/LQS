package presentation.BankAccountui;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import vo.BankAccountVO;
import vo.VoucherSearchVO;

/**
 * 账户管理
 * @author TOSHIBA
 *
 */
public class AccountPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AccountPanel(){
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		initAPanel();
	}
	private void initAPanel() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,18);
		Vector<String> name = new Vector<String>();
		name.add("账号");
		name.add("名称");
		name.add("金额");
		
		Vector<BankAccountVO> data = new Vector<BankAccountVO>();		
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
		scrollPane.setBounds(0, 0, 884, 480);
	//	scrollPane.add(table.getTableHeader());
		scrollPane.getViewport().add(table);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		
		
		defaultModel.addRow(new BankAccountVO("12345678","鼓楼快递公司账户1","10000"));
		JButton newaccount = new JButton("新建");
		JButton change = new JButton("修改");
		JButton delete = new JButton("删除");
		JButton back = new JButton("返回");
		
		newaccount.setFont(font);
		change.setFont(font);
		delete.setFont(font);
		back.setFont(font);
		
		newaccount.setBounds(575, 490, 70, 30);
		change.setBounds(655, 490, 70, 30);
		delete.setBounds(735, 490, 70, 30);
		back.setBounds(815, 490, 70, 30);
		
		this.add(scrollPane);
		this.add(newaccount);
		this.add(back);
		this.add(delete);
		this.add(change);
		
	}

}

package presentation.CarAndDriverui;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;
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

import vo.CarVO;
import vo.CheckVO;
import vo.DriverVO;
import vo.HallVO;

public class DriverPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int padding = 10;
	int label_width = 200;
	int label_height = 30;
	int box_width = 120;
	int box_height = 30;
	int button_width = 80;
	int button_height = 30;
	public DriverPanel(){
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
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
		DefaultTableModel defaultModel = new DefaultTableModel(data,name);
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
			
		defaultModel.addRow(new DriverVO("025000001","张三","男","2015.10.30","320582201510301111","18260065397","一年"));
		
		
		JButton add = new JButton("新建");
		add.setFont(font);
		add.setBounds(800-button_width-padding, padding*2+490, button_width, button_height);
		
		JButton back = new JButton("返回");
		back.setFont(font);
		back.setBounds(800, padding*2+490, button_width, button_height);
		
		this.add(scrollPane);
		this.add(add);
		this.add(back);
	}

	public void setValue(DriverVO info) {
		// TODO Auto-generated method stub
		
	}

}


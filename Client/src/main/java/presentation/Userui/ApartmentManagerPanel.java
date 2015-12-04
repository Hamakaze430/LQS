package presentation.Userui;


import java.awt.Color;
import java.awt.Component;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
/**
 * 部门管理
 * @author TOSHIBA
 *
 */
import javax.swing.table.TableRowSorter;

import presentation.mainui.SimpleButton;
import vo.HallVO;
public class ApartmentManagerPanel extends JPanel {
	public ApartmentManagerPanel(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setBorder(null);
		this.setOpaque(false);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		Vector<String> name = new Vector<String>();
		name.add("部门名称");
		name.add("部门编号");
		name.add("部门地点");
		Vector<HallVO> data = new Vector<HallVO>();		
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
		table.setOpaque(false);
		table.setRowSorter(new TableRowSorter<DefaultTableModel>(defaultModel));  
		
//		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(table);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		this.add(scrollPane);
		
	
		defaultModel.addRow(new HallVO("南京市鼓楼营业厅","025000","南京市鼓楼区"));
		defaultModel.addRow(new HallVO("南京市中转中心","0250","南京市"));
		defaultModel.addRow(new HallVO("南京市鼓楼营业厅","025000","南京市鼓楼区"));
	
		JPanel buttons = new JPanel();
		buttons.setBorder(null);
		buttons.setOpaque(false);
		buttons.setLayout(new BoxLayout(buttons,BoxLayout.X_AXIS));
		buttons.setAlignmentX(RIGHT_ALIGNMENT);
		buttons.setAlignmentY(CENTER_ALIGNMENT);
		JButton creat = new SimpleButton("新建");
		JButton change = new SimpleButton("修改");
		JButton delete = new SimpleButton("删除");
		JButton close = new SimpleButton("关闭");
		buttons.add(creat);
		buttons.add(change);
		buttons.add(delete);
		buttons.add(close);
		this.add(buttons);
	}
}


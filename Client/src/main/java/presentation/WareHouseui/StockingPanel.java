package presentation.WareHouseui;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import vo.CheckVO;
import vo.StockingVO;
/**
 * 库存盘点
 * @author TOSHIBA
 *
 */
public class StockingPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int padding = 10;
	
	
	int button_width = 110;
	int button_height = 30;
	public StockingPanel(){
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		initSPanel();
	}
	private void initSPanel() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,16);
		Vector<String> name = new Vector<String>();
		name.add("快递编号");
		name.add("入库日期");
		name.add("目的地");
		name.add("区号");
		name.add("排号");
		name.add("架号");
		name.add("位号");
		
		
		Vector<StockingVO> data = new Vector<StockingVO>();		
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
		scrollPane.setBounds(padding, padding, 884, 480);
	//	scrollPane.add(table.getTableHeader());
		scrollPane.getViewport().add(table);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
			
		defaultModel.addRow(new StockingVO("0250001001","2015/10/30","南京中转中心","航空区","A排","A架","A位"));
		
		JButton importButton = new JButton("导出Excel");
		importButton.setFont(font);
		importButton.setBounds(650, 500, button_width, button_height);
		JButton back = new JButton("返回");
		back.setFont(font);
		back.setBounds(650+button_width+padding, 500, button_width, button_height);
		
		this.add(scrollPane);
		this.add(importButton);
		this.add(back);
	}
}

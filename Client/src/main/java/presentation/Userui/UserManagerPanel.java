package presentation.Userui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import businessLogic.Userbl.ApartmentManagerbl;
import businessLogic.Userbl.UserManagerbl;
import businessLogic.Userbl.Userbl;
import businessLogicService.UserblService.ApartmentManagerblService;
import businessLogicService.UserblService.UserManagerblService;
import businessLogicService.UserblService.UserblService;
import presentation.mainui.SimpleButton;
import vo.HallVO;
import vo.UserVO;

/**
 * 用户管理界面，包括用户信息的增加，删除，修改。
 * 其中修改待完善
 */
public class UserManagerPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	UserManagerblService bl;
	DefaultTableModel defaultModel;
	JTable table;
	int rowEditable = -1;
	int columnEditable = -1;
	String temp;
	int buttonNum;
	public UserManagerPanel(int buttonNum){	
		bl = new UserManagerbl();
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.buttonNum = buttonNum;
		this.setBorder(null);
		this.setOpaque(false);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		Vector<String> name = new Vector<String>();
		name.add("用户名");
		name.add("用户密码");
		name.add("用户权限");
		name.add("姓名");
		name.add("性别");
		name.add("职位");
		name.add("工作单位");
		Vector<UserVO> data = new Vector<UserVO>();		
		defaultModel = new DefaultTableModel(data,name);		
		table = new JTable(defaultModel){
			
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column){
				if (row == rowEditable && column == columnEditable) return true;
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
		setUpPasswordColumn(table, table.getColumnModel().getColumn(1));
		table.getColumnModel().getColumn(3).setPreferredWidth(10);
		table.getColumnModel().getColumn(4).setPreferredWidth(10);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();  
	    r.setHorizontalAlignment(JLabel.CENTER); 
	    table.setDefaultRenderer(Object.class, r);
		
//		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(table);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		this.add(scrollPane);
		
		initTable();

		
		JPanel buttons = new JPanel();
		buttons.setBorder(null);
		buttons.setOpaque(false);
		buttons.setLayout(new BoxLayout(buttons,BoxLayout.X_AXIS));
		buttons.setAlignmentX(RIGHT_ALIGNMENT);
		buttons.setAlignmentY(CENTER_ALIGNMENT);
		JButton creat = new SimpleButton("新建");
		creat.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new CreatUserDialog(bl,defaultModel).setVisible(true);
			}
			
		});
		JButton change = new SimpleButton("修改");
		change.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				rowEditable = table.getSelectedRow();
				columnEditable = table.getSelectedColumn();
				if (columnEditable == 0) {
					JOptionPane.showMessageDialog(null, "用户名不可修改！","", JOptionPane.ERROR_MESSAGE);
					rowEditable = -1;
					columnEditable = -1;
					return;
				}
				
				if (columnEditable != 1) {
					JOptionPane.showMessageDialog(null, "对不起，暂时只可更改密码_(:зゝ∠)_敬请期待(*￣︶￣)y ！","", JOptionPane.ERROR_MESSAGE);
					rowEditable = -1;
					columnEditable = -1;
					return;
				}
				
//				if (columnEditable == 1){
//					
//				}
				TableCellEditor cell = table.getCellEditor(rowEditable, columnEditable);
				temp = (String) table.getValueAt(rowEditable, columnEditable);
				//System.out.println(temp);
				cell.addCellEditorListener(new CellEditorListener(){

					public void editingStopped(ChangeEvent e) {
						// TODO Auto-generated method stub
						
						int n = JOptionPane.showConfirmDialog(null, "确定修改该信息?", "确认框",JOptionPane.YES_NO_OPTION);
						if (n == 1) {
							table.setValueAt(temp, rowEditable, columnEditable);
							rowEditable = -1;
							columnEditable = -1;
							return;
						}
						int index = table.convertRowIndexToModel(rowEditable);
						UserVO vo = (UserVO)defaultModel.getDataVector().elementAt(index);
						bl.update(vo);
						rowEditable = -1;
						columnEditable = -1;				
					}

					public void editingCanceled(ChangeEvent e) {
						// TODO Auto-generated method stub
						System.out.println("Canceled");
					}
					
				});
			}
			
		});
		JButton delete = new SimpleButton("删除");
		delete.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int index = table.convertRowIndexToModel(table.getSelectedRow());
				if(index == -1){
					JOptionPane.showMessageDialog(null, "请选中要删除的用户信息！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int n = JOptionPane.showConfirmDialog(null, "确定删除改信息?", "确认框",JOptionPane.YES_NO_OPTION);
				//System.out.println(index);
				if (n == 1) return;
				
				UserVO vo = (UserVO)defaultModel.getDataVector().elementAt(index);
				bl.delete(vo);
				defaultModel.removeRow(index);
				
				
			}
			
		});
		JButton close = new SimpleButton("关闭");
		close.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserManagerPanel.this.setVisible(false);
				MainPanel.closeButton(buttonNum);
			}
			
		});
		buttons.add(creat);
		buttons.add(change);
		buttons.add(delete);
		buttons.add(close);
		this.add(buttons);
	}

	private void initTable() {
		// TODO Auto-generated method stub
		List<UserVO> list = bl.getAll();
		for (UserVO vo : list) defaultModel.addRow(vo);
		//defaultModel.addRow(new UserVO("02500000000","123456","快递员","王五","男","快递员","南京市鼓楼营业厅"));
	}
	
	@SuppressWarnings("serial")
	public void setUpPasswordColumn(JTable table, TableColumn passwordColumn) {
        // Set up the editor for the sport cells.
        JPasswordField password = new JPasswordField();
        password. setEchoChar('*');
        passwordColumn.setCellEditor(new DefaultCellEditor(password));
        DefaultTableCellRenderer renderer =  new DefaultTableCellRenderer(){
        	public void setValue(Object value){
        		String password = "******";
        		super.setValue(password);
        	}
        };
        renderer.setHorizontalAlignment(JLabel.CENTER); 
        passwordColumn.setCellRenderer(renderer);
    }


}

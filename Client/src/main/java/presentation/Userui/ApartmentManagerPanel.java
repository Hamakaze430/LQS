/**
 * 部门管理界面，包括部门信息的增加，删除，修改。
 */

package presentation.Userui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
/**
 * 部门管理
 * @author TOSHIBA
 *
 */
import javax.swing.table.TableRowSorter;

import businessLogic.Userbl.ApartmentManagerbl;
import businessLogicService.UserblService.ApartmentManagerblService;
import init.Client;
import presentation.mainui.PictureButton;
import presentation.mainui.SimpleButton;
import vo.HallVO;
public class ApartmentManagerPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ApartmentManagerblService bl;
	DefaultTableModel defaultModel;
	JTable table;
	int rowEditable = -1;
	int columnEditable = -1;
	String temp;
	int buttonNum;
	JButton add;
	JButton delete;
	JButton back;
	int padding =10;
	public ApartmentManagerPanel(int buttonNum){	
		bl = new ApartmentManagerbl();
		this.setLayout(null);
		this.buttonNum = buttonNum;
		this.setBorder(null);
		this.setOpaque(false);
		init();
	}
	
	
	/**
	 * 界面初始化
	 */
	private void init() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,16);
		Vector<String> name = new Vector<String>();
		name.add("部门名称");
		name.add("部门编号");
		name.add("部门地点");
		Vector<HallVO> data = new Vector<HallVO>();		
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
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();  
	    r.setHorizontalAlignment(JLabel.CENTER); 
	    table.setDefaultRenderer(Object.class, r);
		
//		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(padding, padding, 884, 480);
		scrollPane.getViewport().add(table);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		this.add(scrollPane);
		
		initTable();
	
		
		
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
		
		add.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new CreatApartmentDialog(bl,defaultModel).setVisible(true);
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
		delete.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int index = table.convertRowIndexToModel(table.getSelectedRow());
				if(index == -1){
					JOptionPane.showMessageDialog(null, "请选中要删除的部门信息！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int n = JOptionPane.showConfirmDialog(null, "确定删除改信息?", "确认框",JOptionPane.YES_NO_OPTION);
				//System.out.println(index);
				if (n == 1) return;
				
				HallVO vo = (HallVO)defaultModel.getDataVector().elementAt(index);
				bl.delete(vo);
				defaultModel.removeRow(index);
				JOptionPane.showMessageDialog(null, "删除成功^_^","", JOptionPane.CLOSED_OPTION);
				
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
		back.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ApartmentManagerPanel.this.setVisible(false);
				MainPanel.closeButton(buttonNum);
			}
			
		});
		
		this.add(add);
		this.add(delete);
		this.add(back);
		
	}

	
	/**
	 * 从逻辑层获取部门信息列表
	 */
	private void initTable() {
		// TODO Auto-generated method stub
		List<HallVO> list = bl.getAll();
		for (HallVO vo : list) defaultModel.addRow(vo);
	}

}


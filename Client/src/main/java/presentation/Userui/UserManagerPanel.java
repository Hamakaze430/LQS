package presentation.Userui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import presentation.mainui.PictureButton;
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
	JButton add;
	JButton delete;
	JButton back;
	int padding =10;
	public UserManagerPanel(int buttonNum){	
		bl = new UserManagerbl();
		this.setLayout(null);
		this.buttonNum = buttonNum;
		this.setBorder(null);
		this.setOpaque(false);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,16);
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
				new CreatUserDialog(bl,defaultModel).setVisible(true);
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
					JOptionPane.showMessageDialog(null, "请选中要删除的用户信息！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int n = JOptionPane.showConfirmDialog(null, "确定删除改信息?", "确认框",JOptionPane.YES_NO_OPTION);
				//System.out.println(index);
				if (n == 1) return;
				
				UserVO vo = (UserVO)defaultModel.getDataVector().elementAt(index);
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
				UserManagerPanel.this.setVisible(false);
				MainPanel.closeButton(buttonNum);
			}
			
		});
		
		this.add(back);
		this.add(add);
		this.add(delete);
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

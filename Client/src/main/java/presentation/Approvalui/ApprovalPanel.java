package presentation.Approvalui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableRowSorter;

import presentation.Userui.ApartmentManagerPanel;
import presentation.Userui.MainPanel;
import presentation.mainui.PictureButton;
import vo.ApprovalVO;
import vo.HallVO;
/**
 * 审批单据
 * @author TOSHIBA
 *
 */
public class ApprovalPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int buttonNum;
	DefaultTableModel defaultModel;
	JTable table;
	JButton back;
	JButton pass;
	int rowEditable = -1;
	int columnEditable = -1;
	int padding =10;
	public ApprovalPanel (int buttonNum){
		this.buttonNum=buttonNum;
		this.setBorder(null);
		this.setOpaque(false);
		this.setLayout(null);
		initAPanel();
	}
	private void initAPanel() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,16);
		Vector<String> name = new Vector<String>();
		//name.add("全选");
		name.add("单据类型");
		name.add("单据编号");
		name.add("提交部门");
		name.add("单据状态");
		Vector<ApprovalVO> data = new Vector<ApprovalVO>();		
		defaultModel = new DefaultTableModel(data,name);	
		
		table = new JTable(defaultModel){		
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column){
				if (row == rowEditable && column == columnEditable) return true;
				return false;
			}
		};
		table.setRowHeight(35);
		//table.getColumnModel().getColumn(1).setCellEditor((TableCellEditor) new DefaultCellEditor(new JCheckBox()));
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setBackground(new Color(200, 200, 200));
		table.setBackground(new Color(255,255,255,100));
		table.getTableHeader().setReorderingAllowed(false);
		table.setOpaque(false);
		table.setRowSorter(new TableRowSorter<DefaultTableModel>(defaultModel));  
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();  
	    r.setHorizontalAlignment(JLabel.CENTER); 
	    table.setDefaultRenderer(Object.class, r);
	    
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(padding, padding, 884, 480);
		scrollPane.getViewport().add(table);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		
		pass = new JButton();
		pass.setFont(font);
		pass.setBorder(null);
		pass.setOpaque(false);
		pass.setFocusPainted(false);
		pass.setContentAreaFilled(false);
		pass.setBounds(740, 510, 70, 30);
		PictureButton.setIcon("src/main/java/image/passButton_unclicked.png",pass);
		pass.addMouseListener(new MouseListener(){

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
				PictureButton.setIcon("src/main/java/image/passButton_clicked.png",pass);
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/passButton_unclicked.png",pass);
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
				ApprovalPanel.this.setVisible(false);
				MainPanel.closeButton(buttonNum);
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
		this.add(scrollPane);
		this.add(back);
		this.add(pass);
	}
}

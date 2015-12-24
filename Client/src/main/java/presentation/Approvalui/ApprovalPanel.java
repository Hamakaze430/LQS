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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
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
	DefaultTableModel dm;
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

		dm = new DefaultTableModel();  
        dm.setDataVector(new Object[][]{},  
                new Object[]{"全选", "单据类型","提交部门","提交时间","单据状态"});  
  
        JTable table = new JTable(dm){		
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column){
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
		table.setRowSorter(new TableRowSorter<DefaultTableModel>(dm));  
		setUpSelectedColumn(table, table.getColumnModel().getColumn(0));
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
	
	public void setUpSelectedColumn(JTable table, TableColumn selectedColumn) {
        // Set up the editor for the sport cells.
        JCheckBox box = new JCheckBox();
        selectedColumn.setCellEditor(new DefaultCellEditor(box));
        DefaultTableCellRenderer renderer =  new DefaultTableCellRenderer(){
        	public void setValue(Object value){
        		
        	}
        };
//        renderer.setHorizontalAlignment(JLabel.CENTER); 
//        passwordColumn.setCellRenderer(renderer);
    }
}

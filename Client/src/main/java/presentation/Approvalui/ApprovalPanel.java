package presentation.Approvalui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import businessLogic.Approvalbl.Approvalbl;
import businessLogicService.ApprovalblService.ApprovalblService;
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
	JButton refresh;
	JButton pass;
	boolean flag = false;
	int rowEditable = -1;
	int columnEditable = -1;
	int padding =10;
	private ApprovalblService bl;
	private List<ApprovalVO>  list;
	public ApprovalPanel (int buttonNum){
		bl = new Approvalbl();
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
                new Object[]{"全选", "单据名称","提交时间","单据状态"});  
  
        table = new JTable(dm){		
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column){
				return true;
			}
		};
		
		
		
		table.getColumn("全选").setCellRenderer(new CheckRenderer());  
		table.getColumn("全选").setCellEditor(new CheckEditor(new JTextField()));  
		table.getColumnModel().getColumn(0).setHeaderRenderer(new CheckRenderer("全选"));
		table.getTableHeader().addMouseListener(new MouseAdapter(){
			   public void mouseClicked(MouseEvent e) {
			    int colIndex = table.getColumnModel().getColumnIndexAtX(e.getX());
			    if( colIndex==0 )
			    {
			     flag = !flag;
			     table.getColumnModel().getColumn(0).setHeaderValue(flag);
			     for (int i = 0; i < dm.getRowCount(); i++)
			    	 dm.setValueAt(flag, i, 0);
//			     header.repaint();
			    }
			   }
			  });
		
		
		table.setRowHeight(35);
		//table.getColumnModel().getColumn(1).setCellEditor((TableCellEditor) new DefaultCellEditor(new JCheckBox()));
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setBackground(new Color(200, 200, 200));
		table.setBackground(new Color(255,255,255,100));
		table.getTableHeader().setReorderingAllowed(false);
		table.setOpaque(false);
		table.setRowSorter(new TableRowSorter<DefaultTableModel>(dm));  
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();  
	    r.setHorizontalAlignment(JLabel.CENTER); 
	    table.setDefaultRenderer(Object.class, r);
	    table.getColumnModel().getColumn(0).setWidth(10);
	    
	    initTable();
	    
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(padding, padding, 884, 480);
		scrollPane.getViewport().add(table);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		
		refresh = new JButton();
		refresh.setFont(font);
		refresh.setBorder(null);
		refresh.setOpaque(false);
		refresh.setFocusPainted(false);
		refresh.setContentAreaFilled(false);
		refresh.setBounds(660, 510, 70, 30);
		PictureButton.setIcon("src/main/java/image/refresh_unclicked.png",refresh);
		refresh.addMouseListener(new MouseListener(){

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
				PictureButton.setIcon("src/main/java/image/refresh_clicked.png",refresh);
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/refresh_unclicked.png",refresh);
			}
			
		});
		
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
				List<Integer> indexs = new ArrayList<Integer>();
				for (int i =0; i < dm.getRowCount(); i++){
					if (table.getValueAt(i, 0).equals(true)) {
						int temp = table.convertRowIndexToModel(i);
						indexs.add(temp);
					}
				}
				
				int index = table.convertRowIndexToModel(table.getSelectedRow());
				if(index == -1&&indexs.size()==0){
					JOptionPane.showMessageDialog(null, "请选中某一单据！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				int n = JOptionPane.showConfirmDialog(null, "确定通过?", "确认框",JOptionPane.YES_NO_OPTION);
				//System.out.println(index);
				if (n == 1) return;
				if (indexs.size() == 0){
					ApprovalVO vo= list.get(index);
					bl.getPassed(vo);
				}
				else{
					for (int temp:indexs){
						ApprovalVO vo= list.get(temp);
						bl.getPassed(vo);
					}
				}
				initTable();
				JOptionPane.showMessageDialog(null, "通过^_^","", JOptionPane.CLOSED_OPTION);
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
		this.add(refresh);
	}
	
	
	private void initTable() {
		// TODO Auto-generated method stub
		list = bl.findAll();
		dm.setRowCount(0);
		if (list == null) return;
		for (ApprovalVO vo : list) {
			dm.addRow(new Object[]{false, vo.getName(), vo.getDate(), vo.getStatus()});
		}
	}

	class CheckEditor extends DefaultCellEditor{  
		  
		private JCheckBox cb;
		private JPanel panel;
		
	    public CheckEditor(JTextField checkBox) {  
	        super(checkBox);  
	        this.setClickCountToStart(1); 
	        cb = new JCheckBox();
	    	cb.setSelected(false);
	    	cb.setFocusPainted(false);
	    	cb.setOpaque(false);
	    	panel = new JPanel();
//	    	panel.setOpaque(false);
	    	
	    	panel.add(cb);
	    }  
	  
	    public Component getTableCellEditorComponent(final JTable table, Object value,  
	            boolean isSelected,int row, int column) { 	 
	    	panel.setForeground(table.getSelectionForeground());  
	    	panel.setBackground(table.getSelectionBackground()); 
	    	return panel;
	    }   
	       
	    public Object getCellEditorValue() {  
			 if(cb.isSelected()) return true;
			 else return false;
	    } 
	  
	    public boolean stopCellEditing() {  
	        return super.stopCellEditing();  
	    }  

	}  
	  
	class CheckRenderer extends JPanel implements TableCellRenderer {  
	  
		private JCheckBox cb;
		
	    public CheckRenderer(String s) {  
	    	cb = new JCheckBox(s);
	    	cb.setSelected(false);
	    	cb.setFocusPainted(false);
	    	cb.setOpaque(false);
	    	this.add(cb);
	    	this.setOpaque(false);  
	    } 
	    public CheckRenderer() {  
	    	cb = new JCheckBox();
	    	cb.setSelected(false);
	    	cb.setFocusPainted(false);
	    	cb.setOpaque(false);
	    	this.add(cb);
//	    	this.setOpaque(false);  
	    } 
	  
	    public Component getTableCellRendererComponent(JTable table, Object value,  
	            boolean isSelected, boolean hasFocus, int row, int column) {  
	        if (isSelected) {  
	            setForeground(table.getSelectionForeground());  
	            setBackground(table.getSelectionBackground());  
	        } else {  
	            setForeground(table.getForeground());  
	            setBackground(UIManager.getColor("UIManager"));  
	        }   
	        if (value.equals(true)) cb.setSelected(true);
	        else cb.setSelected(false);
	        return this;  
	    }  
	}

}

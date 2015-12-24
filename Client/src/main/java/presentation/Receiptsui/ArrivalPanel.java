package presentation.Receiptsui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import presentation.Receiptsui.LoadingPanel.SubmitAction;
import presentation.Userui.MainPanel;
import presentation.mainui.PictureButton;
import vo.CheckVO;
import vo.ReceiptVO;
import vo.UserVO;
import vo.receipts.ArrivalVO;
import vo.receipts.LoadingVO;
import vo.receipts.TransferVO;
import businessLogic.Receiptsbl.Receiptsbl;
import businessLogicService.ReceiptsblService.ReceiptsblService;
import businessLogicService.UserblService.UserblService;
/**
 * 到达单
 * @author TOSHIBA
 *
 */
public class ArrivalPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel title;
	JButton back;
	JTextField order;
	JButton submit;
	private ReceiptsblService bl;
	private UserblService user;
	int padding = 10;
	int label_width = 200;
	int label_height = 30;
	int box_width = 120;
	int box_height = 30;
	int button_width = 80;
	int button_height = 30;
	JTextField date;
	JLabel startplace;
	JTextField startplacename;
	JLabel state;
	JScrollPane scrollPane;
	DefaultTableModel dm;
	boolean flag;
	int buttonNum;
	public ArrivalPanel(UserblService user,int buttonNum){
		this.user=user;
		this.buttonNum=buttonNum;
		bl = new Receiptsbl(user);
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);	
		initAPanel();
	}
	private void initAPanel() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,16);
		title = new JLabel(user.getHallName()+"到达单",JLabel.CENTER);
		title.setFont(font);
		title.setBounds(150, 10, 600, 30);
		
		JLabel idLabel = new JLabel("· "+user.getHallType()+"编号: ");
		idLabel.setFont(font);
		idLabel.setBounds(padding, padding*2+label_height, label_width, label_height);
		
		JTextField id = new JTextField(7);
		id.setFont(font);
		id.setOpaque(false);
		id.setBorder(null);
		id.setBounds(padding+160, padding*2+label_height, label_width, label_height);
		id.setText(bl.getHallId());
		id.setEditable(false);
		
		JLabel dateLabel = new JLabel("· 到 达 日 期: ");
		dateLabel.setFont(font);
		dateLabel.setBounds(padding, padding*3+label_height*2, label_width, label_height);
		
		date = new JTextField(7);
		date.setFont(font);
		date.setOpaque(false);
		date.setBorder(null);
		date.setBounds(padding+160, padding*3+label_height*2, label_width, label_height);
		date.setText(bl.getCurrentTime());
		date.setEditable(false);
		
		JLabel orderNumber = new JLabel("· 汽运编号: ");
		orderNumber.setFont(font);
		orderNumber.setBounds(padding, padding*4+label_height*3, label_width, label_height);
		
		startplace = new JLabel("· 出 发 地：");
		startplace.setFont(font);
		startplace.setBounds(padding,padding*5+label_height*4, label_width, label_height);
		startplace.setVisible(false);
		
		startplacename = new JTextField(10);
		startplacename.setFont(font);
		startplacename.setOpaque(false);
		startplacename.setBorder(null);
		startplacename.setBounds(padding+160, padding*5+label_height*4, label_width, label_height);
		startplacename.setText(user.getHallName());
		startplacename.setEditable(false);
		startplacename.setVisible(false);
		
		state = new JLabel("· 货物到达状态：");
		state.setFont(font);
		state.setBounds(padding,padding*6+label_height*5, label_width, label_height);
		state.setVisible(false);
		
		dm = new DefaultTableModel();  
        dm.setDataVector(new Object[][]{},  
                new Object[]{"订单条形码号", "货物状态"});  
  
        JTable table = new JTable(dm){		
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column){
				if (column == 0) return false;
				return true;
			}
		};
      
		table.getColumn("货物状态").setCellRenderer(new PanelRenderer());  
		table.getColumn("货物状态").setCellEditor(new PanelEditor(new JTextField()));  
		
		
	
		table.setRowHeight(35);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setBackground(new Color(200, 200, 200));
		table.setBackground(new Color(255,255,255,100));
		table.getTableHeader().setReorderingAllowed(false);
		table.setOpaque(false);
		table.setRowSorter(new TableRowSorter<DefaultTableModel>(dm));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(padding+160, padding*6+label_height*5, 600, 250);
		scrollPane.getViewport().add(table);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);		
		//defaultModel.addRow(new CheckVO("入库单","0250001001","10.00","航空区A排A架A位"));
		scrollPane.setVisible(false);
		
		order = new JTextField(7);
		order.setFont(font);
		order.setOpaque(false);
		order.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		order.setBounds(padding+160, padding*4+label_height*3, label_width, label_height);	
		order.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				startplace.setVisible(false);
				startplacename.setVisible(false);
				state.setVisible(false);
				scrollPane.setVisible(false);
				flag = false;
				dm.setRowCount(0);
				if (order.getText().equals("")) return;
				ReceiptVO vo = bl.getLoadingOrTransferVO(order.getText());
				if (vo == null){
					JOptionPane.showMessageDialog(null, "请输入正确的中转单编号/汽运编号！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (vo.getType().equals("装车单")){
					if (!((LoadingVO)vo).getDestination().equals(user.getHallName())) {
						JOptionPane.showMessageDialog(null, "对应装车单的目的地不是本单位！","", JOptionPane.ERROR_MESSAGE);
						return;
					}
					startplacename.setText(bl.getHallName(((LoadingVO)vo).getHallId()));
					List<String> list = ((LoadingVO)vo).getOrder();
					for (String s : list){
						dm.addRow(new Object[]{s,""});
					}
				}
				else{
					if (!((TransferVO)vo).getDestination().equals(user.getHallName())) {
						JOptionPane.showMessageDialog(null, "对应中转单的目的地不是本单位！","", JOptionPane.ERROR_MESSAGE);
						return;
					}
					startplacename.setText(((TransferVO)vo).getStartplace());
					List<String> list = ((TransferVO)vo).getOrders();
					for (String s : list){
						dm.addRow(new Object[]{s,"完整"});
					}
				}
				flag = true;
				startplace.setVisible(true);
				startplacename.setVisible(true);
				state.setVisible(true);
				scrollPane.setVisible(true);
			}
			
		});
			
		if (user.getHallType().equals("中转中心"))  {
			orderNumber.setText("· 中转单编号/汽运编号: ");
			order.setBounds(padding+200, padding*4+label_height*3, label_width, label_height);	
		}
		
		submit = new JButton();
		submit.setFont(font);
		submit.setBorder(null);
		submit.setOpaque(false);
		submit.setFocusPainted(false);
		submit.setContentAreaFilled(false);
		submit.setBounds(740, 510, 70, 30);
		PictureButton.setIcon("src/main/java/image/submitButton_unclicked.png",submit);
		submit.addMouseListener(new MouseListener(){

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
				PictureButton.setIcon("src/main/java/image/submitButton_clicked.png",submit);
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/submitButton_unclicked.png",submit);
			}
			
		});
		
		submit.addActionListener(new SubmitAction());
		
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
				ArrivalPanel.this.setVisible(false);
				MainPanel.closeButton(buttonNum);
			}

			public void mousePressed(MouseEvent e) {}

			public void mouseReleased(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {
				PictureButton.setIcon("src/main/java/image/backButton_clicked.png",back);
			}

			public void mouseExited(MouseEvent e) {
				PictureButton.setIcon("src/main/java/image/backButton_unclicked.png",back);
			}			
		});	
		
		this.add(title);
		this.add(idLabel);
		this.add(id);
		this.add(date);
		this.add(dateLabel);
		this.add(order);
		this.add(orderNumber);
		this.add(back);
		this.add(submit);
		this.add(startplace);
		this.add(startplacename);
		this.add(state);
		this.add(scrollPane);		
	}	
	
	class PanelEditor extends DefaultCellEditor{  
		  
		private JPanel panel;
		private ButtonGroup bg;
		private JRadioButton good, bad, lost;
	    private String label;  
	  
	    public PanelEditor(JTextField checkBox) {  
	        super(checkBox);  
	        this.setClickCountToStart(1); 
	        panel = new JPanel();
	        panel.setOpaque(false);
	        bg = new ButtonGroup();
	    	good = new JRadioButton("完整",true);
	    	good.setOpaque(false);
	    	bad = new JRadioButton("损坏",false);
	    	bad.setOpaque(false);
	    	lost = new JRadioButton("丢失",false);
	    	lost.setOpaque(false);
	    	good.setFocusPainted(false);
	    	bad.setFocusPainted(false);
	    	lost.setFocusPainted(false);
	    	bg.add(good);
	    	bg.add(bad);
	    	bg.add(lost); 	 
	    	panel.add(good);
	    	panel.add(bad);
	    	panel.add(lost);
	    }  
	  
	    public Component getTableCellEditorComponent(final JTable table, Object value,  
	            boolean isSelected,int row, int column) { 
	    	return panel;
	    }   
	       
	    public Object getCellEditorValue() {  
	    	 if (good.isSelected()) return good.getText();
		     if (bad.isSelected()) return bad.getText();
		     if (lost.isSelected()) return lost.getText();
			 return null;
	    } 
	  
	    public boolean stopCellEditing() {  
	        return super.stopCellEditing();  
	    }  

	}  
	  
	class PanelRenderer extends JPanel implements TableCellRenderer {  
	  
		ButtonGroup bg;
		JRadioButton good, bad, lost;
		
	    public PanelRenderer() {  
	    	bg = new ButtonGroup();
	    	good = new JRadioButton("完整",true);
	    	good.setOpaque(false);
	    	bad = new JRadioButton("损坏",false);
	    	bad.setOpaque(false);
	    	lost = new JRadioButton("丢失",false);
	    	lost.setOpaque(false);
	    	bg.add(good);
	    	bg.add(bad);
	    	bg.add(lost);
	    	this.add(good);
	    	this.add(bad);
	    	this.add(lost);
	      //  this.setOpaque(false);  
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
	        if (value.equals(good.getText())) good.setSelected(true);
	        else if (value.equals(bad.getText())) bad.setSelected(true);
	        else if (value.equals(lost.getText())) lost.setSelected(true);
	        return this;  
	    }  
	}  
	
	
	class SubmitAction implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			if (flag == false){
				JOptionPane.showMessageDialog(null, "请输入正确的中转单编号/汽运编号！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			int n = JOptionPane.showConfirmDialog(null, "确定提交?", "确认框",JOptionPane.YES_NO_OPTION);
			if (n == 1) {
				return;
			}

		    List<String> orders = new ArrayList<String>();
		    List<String> states = new ArrayList<String>();
		    for (int i = 0; i < dm.getRowCount(); i++){
		    	orders.add((String)dm.getValueAt(i, 0));
		    	states.add((String)dm.getValueAt(i, 1));
		    }
			ArrivalVO vo = new ArrivalVO(title.getText(),user.getUserName(),date.getText(),
					user.getHallId(), order.getText(),startplace.getText(),orders,states);
		 	bl.addReceipt(vo);
		 	order.setText("");
		 	startplace.setVisible(false);
			startplacename.setVisible(false);
			state.setVisible(false);
			scrollPane.setVisible(false);
			flag = false;
			JOptionPane.showMessageDialog(null, "提交成功^_^","", JOptionPane.CLOSED_OPTION);
		 	
		}
	
	}
}

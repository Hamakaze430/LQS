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
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import presentation.Receiptsui.LoadingPanel.SubmitAction;
import presentation.mainui.PictureButton;
import vo.CheckVO;
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
	JButton back;
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
	JLabel startplace;
	JTextField startplacename;
	JLabel state;
	JScrollPane scrollPane;
	public ArrivalPanel(UserblService user){
		this.user=user;
		bl = new Receiptsbl(user);
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);	
		initAPanel();
	}
	private void initAPanel() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,16);
		JLabel title = new JLabel(user.getCenterName()+"到达单",JLabel.CENTER);
		title.setFont(font);
		title.setBounds(150, 10, 600, 30);
		
		JLabel idLabel = new JLabel("· 中转中心编号: ");
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
		
		JTextField date = new JTextField(7);
		date.setFont(font);
		date.setOpaque(false);
		date.setBorder(null);
		date.setBounds(padding+160, padding*3+label_height*2, label_width, label_height);
		date.setText(bl.getCurrentTime());
		date.setEditable(false);
		
		JLabel orderNumber = new JLabel("· 中转单/汽运编号: ");
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
		
		Vector<String> name = new Vector<String>();
		name.add("订单条形码号");
		name.add("货物状态");
		
		Vector<CheckVO> data = new Vector<CheckVO>();		
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(padding+160, padding*6+label_height*5, 600, 250);
		scrollPane.getViewport().add(table);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);		
		defaultModel.addRow(new CheckVO("入库单","0250001001","10.00","航空区A排A架A位"));
		scrollPane.setVisible(false);
		
		JTextField order = new JTextField(7);
		order.setFont(font);
		order.setOpaque(false);
		order.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		order.setBounds(padding+160, padding*4+label_height*3, label_width, label_height);	
		order.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				startplace.setVisible(true);
				startplacename.setVisible(true);
				state.setVisible(true);
				scrollPane.setVisible(true);
			}
			
		});
			
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
	

}

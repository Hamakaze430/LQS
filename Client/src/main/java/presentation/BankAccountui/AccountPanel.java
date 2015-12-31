package presentation.BankAccountui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BoxLayout;
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

import businessLogic.BankAccountbl.BankAccountbl;
import businessLogicService.BankAccountblService.BankAccountblService;
import presentation.mainui.PictureButton;
import vo.BankAccountVO;

/**
 * 账户管理
 * @author TOSHIBA
 *
 */
public class AccountPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton newaccount;
	JButton delete;
	JButton back;
	JButton search;
	int button_width = 50;
	int button_height =30;
	JTextField key;
	int padding = 10;
	int label_width = 200;
	int label_height = 30;
	int interval =140;
	BankAccountblService bl;
	public AccountPanel(){
		bl = new BankAccountbl();
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		initAPanel();
	}
	private void initAPanel() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,16);
		
		JLabel notice = new JLabel("· 请输入关键字：");
		notice.setFont(font);
		notice.setBounds(padding, padding, label_width, label_height);
		
		key = new JTextField(20);
		key.setFont(font);
		key.setOpaque(false);
		key.setBounds(padding+interval, padding, label_width, label_height);
		key.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		
		search = new JButton("查询");
		search.setFont(new Font("微软雅黑",Font.PLAIN,18));
		search.setBorder(null);
		search.setOpaque(false);
		search.setFocusPainted(false);
		search.setContentAreaFilled(false);
		search.setBounds(padding*2+interval+label_width, padding, button_width, button_height);
		search.addMouseListener(new MouseListener(){

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
				((JButton)e.getSource()).setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				((JButton)e.getSource()).setBorder(null);
			}
			
		});
	
		Vector<String> name = new Vector<String>();
		name.add("账号");
		name.add("名称");
		name.add("金额");
		
		Vector<BankAccountVO> data = new Vector<BankAccountVO>();		
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
		scrollPane.setBounds(padding, padding*2+label_height, 884, 450);
	//	scrollPane.add(table.getTableHeader());
		scrollPane.getViewport().add(table);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		
		
		newaccount = new JButton();		
		delete = new JButton();
		back = new JButton();
		
		newaccount.setFont(font);
		delete.setFont(font);
		back.setFont(font);		
		
		newaccount.setBorder(null);
		newaccount.setOpaque(false);
		newaccount.setFocusPainted(false);
		newaccount.setContentAreaFilled(false);
		newaccount.setBounds(660, 510, 70, 30);
		PictureButton.setIcon("src/main/java/image/addButton_unclicked.png",newaccount);
		newaccount.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new addAccount(bl).setVisible(true);;
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/addButton_clicked.png",newaccount);
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/addButton_unclicked.png",newaccount);
			}
			
		});
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
		this.add(notice);
		this.add(key);
		this.add(search);
		this.add(scrollPane);
		this.add(newaccount);
		this.add(back);
		this.add(delete);
		
	}

}

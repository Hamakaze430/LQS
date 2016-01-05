package presentation.CostBenefitui;

import init.Client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import presentation.LogisticsInfoSearchui.LogisticsPanel;
import presentation.Receiptsui.ReceivePanel;
import presentation.Userui.MainPanel;
import presentation.mainui.PictureButton;
import presentation.mainui.WelcomePanel;
import vo.CostBenefitVO;
import vo.HallVO;
import businessLogic.CostBenefitbl.CostBenefitbl;
import businessLogicService.CostBenefitblService.CostBenefitblService;
import businessLogicService.UserblService.UserblService;
/**
 * 成本收益
 * @author TOSHIBA
 *
 */
public class CostPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserblService user;
	private CostBenefitbl cb=new CostBenefitbl();
	JButton back;
	JButton importButton;
	int buttonNum;
	public CostPanel(UserblService user, int buttonNum){
		this.user=user;
		this.setLayout(null);
		this.setBorder(null);
		this.buttonNum = buttonNum;
		this.setOpaque(false);
		initCPanel();	
	}

	private void initCPanel() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,18);
		JLabel title = new JLabel(user.getCompanyName()+"成本收益表",JLabel.CENTER);
		title.setFont(font);
		title.setBounds(150, 10, 600, 50); 
		
		Vector<String> name = new Vector<String>();
		name.add("总支出");
		name.add("总收入");
		name.add("总利润");
		
		
		Vector<CostBenefitVO> data = new Vector<CostBenefitVO>();		
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
		scrollPane.setBounds(10, 75, 884, 400);
	//	scrollPane.add(table.getTableHeader());
		scrollPane.getViewport().add(table);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		
		
		
		/*
		 * set up CostBenefit
		 * */
		cb.setDate();
		CostBenefitVO cbVO=cb.getVO();
//		System.out.println(cbVO.getProfit());
		defaultModel.addRow(cbVO);
		
		//defaultModel.addRow(new CostBenefitVO("10.00","10.00","10.00"));
		
		
		importButton = new JButton();
		importButton.setFont(font);
		importButton.setBorder(null);
		importButton.setOpaque(false);
		importButton.setFocusPainted(false);
		importButton.setContentAreaFilled(false);
		importButton.setBounds(740, 510, 70, 30);
		PictureButton.setIcon("src/main/java/image/importButton_unclicked.png",importButton);
		importButton.addMouseListener(new MouseListener(){

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
				PictureButton.setIcon("src/main/java/image/importButton_clicked.png",importButton);
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/importButton_unclicked.png",importButton);
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
				CostPanel.this.setVisible(false);
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
		
		
		/*
		 *added 
		 **/
		importButton.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent args0){
				if(cb.getReport())
					JOptionPane.showMessageDialog(null, "导出成功^_^","", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "导出failed","", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
		this.add(title);
		this.add(importButton);
		this.add(back);
		this.add(scrollPane);
	}
	
}

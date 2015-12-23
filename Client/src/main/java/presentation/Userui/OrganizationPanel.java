package presentation.Userui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import presentation.mainui.PictureButton;
/**
 * 人员机构界面
 * 
 *
 */
public class OrganizationPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int padding = 10;
	int interval = 200;
	int label_width = 200;
	int label_height = 30;
	int button_width = 70;
	int button_height = 30;
	int buttonNum;
	JButton back;
	JButton change;
	JTextField hallSalesman;
	JTextField centerSalesman;
	JTextField commodity;
	JTextField Courier;
	JTextField apersonnel;
	JTextField bpersonnel;
	JPanel hallPanel;
	JPanel centerPanel;
	JPanel companyPanel;
	public OrganizationPanel(int buttonNum){
		this.buttonNum=buttonNum;
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		initOPanel();
	}
	private void initOPanel() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,16);
		JLabel l = new JLabel("· 请选择部门：");
		l.setBounds(padding, padding, label_width, label_height);
		l.setFont(font);
		
		JComboBox c = new JComboBox();
		c.setFont(font);
		c.setBounds(padding+interval,padding,label_width,label_height);
		c.addItem("请选择要管理的部门");
		c.setSelectedItem("请选择要管理的部门");
		
		JLabel nowLabel = new JLabel("· 该部门当前人员结构：");
		nowLabel.setFont(font);
		nowLabel.setBounds(padding, padding*2+label_height, label_width, label_height);
		
		//实现 根据选择的部门 出现不同panel，分为hallPanel，centerPanel，companyPanel
		
		hallPanel = new JPanel();
		hallPanel.setBounds(padding, padding*3+label_height*2, 884, 500);
		hallPanel.setLayout(null);
		hallPanel.setOpaque(false);
		hallPanel.setVisible(false);
		
		JLabel hallSalesmanLabel = new JLabel("    业务员名单：");
		hallSalesmanLabel.setFont(font);
		hallSalesmanLabel.setBounds(padding, padding, label_width, label_height);
		
		hallSalesman = new JTextField();
		hallSalesman.setFont(font);
		hallSalesman.setBounds(padding+interval, padding, label_width*2, label_height);
		hallSalesman.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		hallSalesman.setOpaque(false);
		hallSalesman.setEditable(false);
		
		JLabel CourierLabel = new JLabel("    快递员名单：");
		CourierLabel.setFont(font);
		CourierLabel.setBounds(padding, padding*2+label_height, label_width, label_height);
		
		Courier = new JTextField();
		Courier.setFont(font);
		Courier.setBounds(padding+interval, padding*2+label_height, label_width*2, label_height);
		Courier.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		Courier.setOpaque(false);
		Courier.setEditable(false);
		
		hallPanel.add(hallSalesmanLabel);
		hallPanel.add(hallSalesman);
		hallPanel.add(CourierLabel);
		hallPanel.add(Courier);
		
		centerPanel = new JPanel();
		centerPanel.setBounds(padding, padding*3+label_height*2, 884, 500);
		centerPanel.setLayout(null);
		centerPanel.setOpaque(false);		
		centerPanel.setVisible(false);
		
		JLabel centerSalesmanLabel = new JLabel("    业务人员名单：");
		centerSalesmanLabel.setFont(font);
		centerSalesmanLabel.setBounds(padding, padding, label_width, label_height);
		
		centerSalesman = new JTextField();
		centerSalesman.setFont(font);
		centerSalesman.setBounds(padding+interval, padding, label_width*2, label_height);
		centerSalesman.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		centerSalesman.setOpaque(false);
		centerSalesman.setEditable(false);
		
		JLabel commodityLabel = new JLabel("    仓库管理人员名单：");
		commodityLabel.setFont(font);
		commodityLabel.setBounds(padding, padding*2+label_height, label_width, label_height);
		
		commodity = new JTextField();
		commodity.setFont(font);
		commodity.setBounds(padding+interval, padding*2+label_height, label_width*2, label_height);
		commodity.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		commodity.setOpaque(false);
		commodity.setEditable(false);
		
		centerPanel.add(commodityLabel);
		centerPanel.add(commodity);
		centerPanel.add(centerSalesmanLabel);
		centerPanel.add(centerSalesman);
		
		companyPanel = new JPanel();
		companyPanel.setBounds(padding, padding*3+label_height*2, 884, 500);
		companyPanel.setLayout(null);
		companyPanel.setOpaque(false);
		companyPanel.setVisible(false);
		
		JLabel apersonnelLabel = new JLabel("    高级财务人员名单：");
		apersonnelLabel.setFont(font);
		apersonnelLabel.setBounds(padding, padding, label_width, label_height);
		
		apersonnel = new JTextField();
		apersonnel.setFont(font);
		apersonnel.setBounds(padding+interval, padding, label_width*2, label_height);
		apersonnel.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		apersonnel.setOpaque(false);
		apersonnel.setEditable(false);
		
		JLabel bpersonnelLabel = new JLabel("    低级财务人员名单：");
		bpersonnelLabel.setFont(font);
		bpersonnelLabel.setBounds(padding, padding*2+label_height, label_width, label_height);
		
		bpersonnel = new JTextField();
		bpersonnel.setFont(font);
		bpersonnel.setBounds(padding+interval, padding*2+label_height, label_width*2, label_height);
		bpersonnel.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		bpersonnel.setOpaque(false);
		bpersonnel.setEditable(false);
		
		companyPanel.add(apersonnelLabel);
		companyPanel.add(apersonnel);
		companyPanel.add(bpersonnelLabel);
		companyPanel.add(bpersonnel);
		
		change = new JButton();
		change.setFont(font);
		change.setBorder(null);
		change.setOpaque(false);
		change.setFocusPainted(false);
		change.setContentAreaFilled(false);
		change.setBounds(740, 510, button_width,button_height);
		PictureButton.setIcon("src/main/java/image/changeButton_unclicked.png",change);
		change.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new changeOrgnization().setVisible(true);;
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/changeButton_clicked.png",change);
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/changeButton_unclicked.png",change);
			}
			
		});
		
		
		back = new JButton();
		back.setFont(font);
		back.setBorder(null);
		back.setOpaque(false);
		back.setFocusPainted(false);
		back.setContentAreaFilled(false);
		back.setBounds(820, 510, button_width,button_height);
		PictureButton.setIcon("src/main/java/image/backButton_unclicked.png",back);
		back.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				OrganizationPanel.this.setVisible(false);
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
		
		this.add(c);
		this.add(l);
		this.add(nowLabel);
		this.add(hallPanel);
		this.add(centerPanel);
		this.add(companyPanel);
		this.add(change);
		this.add(back);
	}

}

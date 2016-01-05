package presentation.Strategyui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import businessLogic.Strategybl.Role;
import businessLogic.Strategybl.Salarybl.Salarybl;
import businessLogicService.UserblService.UserblService;
import po.SalaryPO;
import presentation.Userui.MainPanel;
import presentation.mainui.PictureButton;
import vo.SalaryVO;
/**
 * 薪水策略
 * @author TOSHIBA
 *
 */
public class SalaryStrategyPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserblService user;
	private Salarybl salary = new Salarybl();
	ButtonGroup bg;
	JRadioButton j1,j2,j3;
	JButton back;
	JButton save;
	JTextArea salt;
	int buttonNum;
	public SalaryStrategyPanel(int buttonNum){
		this.buttonNum = buttonNum;
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		initSSPanel();
	}
	private void initSSPanel() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,18);
		JLabel l1 = new JLabel("· 请选择职位：");
		l1.setFont(font);
		l1.setBounds(10, 15, 200, 30);
		
		final JComboBox c = new JComboBox();
		c.addItem("请选择职位");
		c.addItem("高级财务人员");
		c.addItem("低级财务人员");
		c.addItem("营业厅业务员");
		c.addItem("中转中心业务员");
		c.addItem("中转中心仓库管理员");
		c.addItem("总经理");
		c.addItem("快递员");
		c.addItem("司机");
		c.addItem("管理员");
		c.setFont(font);
		c.setBounds(150, 15, 200, 30);
		
		
		
		JLabel l2 = new JLabel("· 请选择薪水结算方式：");
		l2.setFont(font);
		l2.setBounds(10, 60, 250, 30);
		
		bg = new ButtonGroup();
		
		j1 = new JRadioButton("按月");
		j1.setFont(font);
		j1.setBounds(220, 60, 80, 30);
		j1.setOpaque(false);
		j2 = new JRadioButton("按次");
		j2.setFont(font);
		j2.setBounds(320, 60, 80, 30);
		j2.setOpaque(false);
		j3 = new JRadioButton("提成");
		j3.setFont(font);
		j3.setBounds(420, 60, 80, 30);
		j3.setOpaque(false);
		
		
		
		JLabel l3 = new JLabel("· 请输入薪水或提成比例：");
		l3.setFont(font);
		l3.setBounds(10, 110, 240, 30);
		
		final JTextField t = new JTextField(20);
		t.setFont(font);
		t.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		t.setBounds(250, 110, 100, 30);
		t.setOpaque(false);
		
		JLabel l4 = new JLabel("· 当前薪水策略：");
		l4.setFont(font);
		l4.setBounds(10, 160, 200, 30);
		
		salt = new JTextArea();
		salt.setFont(font);
		salt.setBorder(null);
		salt.setBounds(50, 200, 400, 400);
		salt.setOpaque(false);
		salt.setEditable(false);
		
		initSalt();
		
		c.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*
				 * added logic.....
				 * */
				if(c.getSelectedIndex()==0){bg.clearSelection();}
				else if (c.getSelectedItem().toString().equals("司机")){
					j2.setSelected(true);
				}
				else if (c.getSelectedItem().toString().equals("快递员")){
					j3.setSelected(true);
				}
				else j1.setSelected(true);
				
			}
			
		});
		
		
		save = new JButton();
		save.setFont(font);
		save.setBorder(null);
		save.setOpaque(false);
		save.setFocusPainted(false);
		save.setContentAreaFilled(false);
		save.setBounds(740, 510, 70, 30);
		PictureButton.setIcon("src/main/java/image/saveButton_unclicked.png",save);
		
		save.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				Role role = Role.getRole(c.getSelectedItem().toString());
				SalaryVO vo = salary.getSalary(role);
				if (vo != null) salt.setText(vo.getText());
				double rate = 0.0;
				String newSum = "";
				if (c.getSelectedIndex() == 0){
					JOptionPane.showMessageDialog(null, "请选择要修改的职位(´･_･`)","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if (t.getText().equals("")){
					JOptionPane.showMessageDialog(null, "系统认为输入可能有误(´･_･`)","", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				if(t.getText().contains("%")){				
					rate = Double.parseDouble(t.getText().replace("%", ""))/100;
				}
				else{
					try{
						Double temp = Double.parseDouble(t.getText());
					}catch(NumberFormatException e1){
						JOptionPane.showMessageDialog(null, "系统认为输入可能有误(´･_･`)","", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					if(Double.parseDouble(t.getText())<1.0){
						rate = Double.parseDouble(t.getText());
					}
					else newSum = t.getText();
				}
					
				salary.setSalary(role, newSum, rate);
				t.setText("");
				vo = salary.getSalary(role);
				
				initSalt();
				
				c.setSelectedIndex(0);
				JOptionPane.showMessageDialog(null, "设置成功(*￣▽￣)y ","", JOptionPane.INFORMATION_MESSAGE);
							
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/saveButton_clicked.png",save);
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/saveButton_unclicked.png",save);
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
				SalaryStrategyPanel.this.setVisible(false);
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
		
		
		this.add(l1);
		this.add(c);
		this.add(l2);
		bg.add(j1);
		this.add(j1);
		bg.add(j2);
		this.add(j2);
		bg.add(j3);
		this.add(j3);
		this.add(l3);
		this.add(t);
		this.add(l4);
		this.add(salt);
		this.add(save);
		this.add(back);
		
		
	}
	private void initSalt() {
		// TODO Auto-generated method stub
		salt.setText("");
		for (Role r : Role.values()){
			if (r.equals(Role.ACCOUNTANT)) continue;
			SalaryVO vo = salary.getSalary(r);
			salt.append(r.getName()+": "+vo.getText()+"\n");
		}
	}
}

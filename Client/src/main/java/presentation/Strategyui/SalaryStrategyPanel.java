package presentation.Strategyui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
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
	public SalaryStrategyPanel(){
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
		
		JComboBox<String> c = new JComboBox<String>();
		c.addItem("请选择职位");
		c.addItem("高级财务人员");
		c.addItem("低级财务人员");
		c.addItem("中转中心业务员");
		c.addItem("中转中心仓库管理员");
		c.addItem("营业厅业务员");
		c.addItem("快递员");
		c.addItem("司机");
		c.setFont(font);
		c.setBounds(150, 15, 200, 30);
		
		JLabel l2 = new JLabel("· 请选择薪水结算方式：");
		l2.setFont(font);
		l2.setBounds(10, 60, 250, 30);
		
		ButtonGroup bg = new ButtonGroup();
		
		JRadioButton j1 = new JRadioButton("按月");
		j1.setFont(font);
		j1.setBounds(220, 60, 80, 30);
		j1.setOpaque(false);
		JRadioButton j2 = new JRadioButton("按次");
		j2.setFont(font);
		j2.setBounds(320, 60, 80, 30);
		j2.setOpaque(false);
		JRadioButton j3 = new JRadioButton("提成");
		j3.setFont(font);
		j3.setBounds(420, 60, 80, 30);
		j3.setOpaque(false);
		
		JLabel l3 = new JLabel("· 请输入薪水或提成比例：");
		l3.setFont(font);
		l3.setBounds(10, 110, 240, 30);
		
		JTextField t = new JTextField(20);
		t.setFont(font);
		t.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		t.setBounds(250, 110, 100, 30);
		t.setOpaque(false);
		
		JLabel l4 = new JLabel("· 当前薪水策略：");
		l4.setFont(font);
		l4.setBounds(10, 160, 200, 30);
		
		JButton save = new JButton("保存");
		save.setFont(font);
		save.setBounds(700, 500, 80, 30);
		JButton back = new JButton("返回");
		back.setFont(font);
		back.setBounds(800, 500, 80, 30);
		
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
		this.add(save);
		this.add(back);
	}
}

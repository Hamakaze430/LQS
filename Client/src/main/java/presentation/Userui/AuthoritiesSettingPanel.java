package presentation.Userui;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import vo.Authorities;
/**
 * 权限管理
 * @author TOSHIBA
 *
 */
public class AuthoritiesSettingPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AuthoritiesSettingPanel(){
		this.setBorder(null);
		this.setOpaque(false);
		this.setLayout(null);
		initASPanel();
	}
	private void initASPanel() {
		// TODO Auto-generated method stub
		JLabel l1 = new JLabel("· 请选择要设置的职位：");
		l1.setFont(new Font("黑体",Font.PLAIN,18));
		l1.setBounds(40, 30, 250, 50);
		
		ButtonGroup bg = new ButtonGroup();
		
		JRadioButton j1 = new JRadioButton("总经理",true);
		j1.setFont(new Font("黑体",Font.PLAIN,18));
		j1.setBounds(50, 60, 120, 80);		
		j1.setBorder(null);
		j1.setOpaque(false);
		
		JRadioButton j2 = new JRadioButton("高级财务人员",false);
		j2.setFont(new Font("黑体",Font.PLAIN,18));
		j2.setBounds(250, 60, 200, 80);		
		j2.setBorder(null);
		j2.setOpaque(false);
		
		JRadioButton j3 = new JRadioButton("低级财务人员",false);
		j3.setFont(new Font("黑体",Font.PLAIN,18));
		j3.setBounds(500, 60, 200, 80);		
		j3.setBorder(null);
		j3.setOpaque(false);
		
		JRadioButton j4 = new JRadioButton("中转中心业务员",false);
		j4.setFont(new Font("黑体",Font.PLAIN,18));
		j4.setBounds(50, 100, 200, 80);		
		j4.setBorder(null);
		j4.setOpaque(false);
		
		JRadioButton j5 = new JRadioButton("中转中心仓库管理员",false);
		j5.setFont(new Font("黑体",Font.PLAIN,18));
		j5.setBounds(250, 100, 200, 80);		
		j5.setBorder(null);
		j5.setOpaque(false);
		
		JRadioButton j6 = new JRadioButton("营业厅业务员",false);
		j6.setFont(new Font("黑体",Font.PLAIN,18));
		j6.setBounds(50, 140, 200, 80);		
		j6.setBorder(null);
		j6.setOpaque(false);
		
		JRadioButton j7 = new JRadioButton("快递员",false);
		j7.setFont(new Font("黑体",Font.PLAIN,18));
		j7.setBounds(250, 140, 200, 80);		
		j7.setBorder(null);
		j7.setOpaque(false);
		
		
		JLabel l2 = new JLabel("· 请选择权限：");
		l2.setFont(new Font("黑体",Font.PLAIN,18));
		l2.setBounds(40, 200, 250, 50);
		
		int i=0,j=0;
		JCheckBox c1 = new JCheckBox(Authorities.中转单.toString(),false);
		CreateCheckBox.initCheckBox(c1, i,j);
		i++;
		JCheckBox c2 = new JCheckBox(Authorities.人员机构.toString(),false);
		CreateCheckBox.initCheckBox(c2, i,j);
		i++;
		JCheckBox c3 = new JCheckBox(Authorities.付款单.toString(),false);
		CreateCheckBox.initCheckBox(c3, i,j);
		i++;
		JCheckBox c4 = new JCheckBox(Authorities.价格策略.toString(),false);
		CreateCheckBox.initCheckBox(c4, i,j);
		i++;
		JCheckBox c5 = new JCheckBox(Authorities.入库单.toString(),false);
		CreateCheckBox.initCheckBox(c5, i,j);
		i=0;
		j++;
		JCheckBox c6 = new JCheckBox(Authorities.出库单.toString(),false);
		CreateCheckBox.initCheckBox(c6, i,j);
		i++;
		JCheckBox c7 = new JCheckBox(Authorities.分区管理.toString(),false);
		CreateCheckBox.initCheckBox(c7, i,j);
		i++;
		JCheckBox c8 = new JCheckBox(Authorities.到达单.toString(),false);
		CreateCheckBox.initCheckBox(c8, i,j);
		i++;
		JCheckBox c9 = new JCheckBox(Authorities.司机信息.toString(),false);
		CreateCheckBox.initCheckBox(c9, i,j);
		i++;
		JCheckBox c10 = new JCheckBox(Authorities.审批单据.toString(),false);
		CreateCheckBox.initCheckBox(c10, i,j);
		i=0;
		j++;
		JCheckBox c11 = new JCheckBox(Authorities.寄件单.toString(),false);
		CreateCheckBox.initCheckBox(c11, i,j);
		i++;
		JCheckBox c12 = new JCheckBox(Authorities.库存查看.toString(),false);
		CreateCheckBox.initCheckBox(c12, i,j);
		i++;
		JCheckBox c13 = new JCheckBox(Authorities.库存盘点.toString(),false);
		CreateCheckBox.initCheckBox(c13, i,j);
		i++;
		JCheckBox c14 = new JCheckBox(Authorities.成本收益.toString(),false);
		CreateCheckBox.initCheckBox(c14, i,j);
		i++;
		JCheckBox c15 = new JCheckBox(Authorities.收件单.toString(),false);
		CreateCheckBox.initCheckBox(c15, i,j);
		i=0;
		j++;
		JCheckBox c16 = new JCheckBox(Authorities.收款单.toString(),false);
		CreateCheckBox.initCheckBox(c16, i,j);
		i++;
		JCheckBox c17 = new JCheckBox(Authorities.收款单查询.toString(),false);
		CreateCheckBox.initCheckBox(c17, i,j);
		i++;
		JCheckBox c18 = new JCheckBox(Authorities.期初建账.toString(),false);
		CreateCheckBox.initCheckBox(c18, i,j);
		i++;
		JCheckBox c19 = new JCheckBox(Authorities.权限管理.toString(),false);
		CreateCheckBox.initCheckBox(c19, i,j);
		i++;
		JCheckBox c20 = new JCheckBox(Authorities.派件单.toString(),false);
		CreateCheckBox.initCheckBox(c20, i,j);
		i=0;
		j++;
		JCheckBox c21 = new JCheckBox(Authorities.用户管理.toString(),false);
		CreateCheckBox.initCheckBox(c21, i,j);
		i++;
		JCheckBox c22 = new JCheckBox(Authorities.系统日志.toString(),false);
		CreateCheckBox.initCheckBox(c22, i,j);
		i++;
		JCheckBox c23 = new JCheckBox(Authorities.经营情况.toString(),false);
		CreateCheckBox.initCheckBox(c23, i,j);
		i++;
		JCheckBox c24 = new JCheckBox(Authorities.薪水策略.toString(),false);
		CreateCheckBox.initCheckBox(c24, i,j);
		i++;
		JCheckBox c25 = new JCheckBox(Authorities.装车单.toString(),false);
		CreateCheckBox.initCheckBox(c25, i,j);
		i=0;
		j++;
		JCheckBox c26 = new JCheckBox(Authorities.账户管理.toString(),false);
		CreateCheckBox.initCheckBox(c26, i,j);
		i++;
		JCheckBox c27 = new JCheckBox(Authorities.车辆信息.toString(),false);
		CreateCheckBox.initCheckBox(c27, i,j);
		i++;
		JCheckBox c28 = new JCheckBox(Authorities.部门管理.toString(),false);
		CreateCheckBox.initCheckBox(c28, i,j);
		
		JButton b1 = new JButton("确定");
		b1.setBounds(650, 485, 80, 40);
		b1.setBorder(null);
		b1.setOpaque(false);
		JButton b2 = new JButton("取消");
		b2.setBounds(750, 485, 80, 40);
		b2.setBorder(null);
		b2.setOpaque(false);
		
		bg.add(j1);
		this.add(j1);
		bg.add(j2);
		this.add(j2);
		bg.add(j3);
		this.add(j3);
		bg.add(j4);
		this.add(j4);
		bg.add(j5);
		this.add(j5);
		bg.add(j6);
		this.add(j6);
		bg.add(j7);
		this.add(j7);
		
		this.add(c1);
		this.add(c2);
		this.add(c3);
		this.add(c4);
		this.add(c5);
		this.add(c6);
		this.add(c7);
		this.add(c8);
		this.add(c9);
		this.add(c10);
		this.add(c11);
		this.add(c12);
		this.add(c13);
		this.add(c14);
		this.add(c15);
		this.add(c16);
		this.add(c17);
		this.add(c18);
		this.add(c19);
		this.add(c20);
		this.add(c21);
		this.add(c22);
		this.add(c23);
		this.add(c24);
		this.add(c25);
		this.add(c26);
		this.add(c27);
		this.add(c28);
		
		this.add(l1);
		this.add(l2);
		
		this.add(b1);
		this.add(b2);
		
		
		
	}
}

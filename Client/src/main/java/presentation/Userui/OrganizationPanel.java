package presentation.Userui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 人员机构界面
 * 待完善
 *
 */
public class OrganizationPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public OrganizationPanel(){
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		initOPanel();
	}
	private void initOPanel() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,18);
		JLabel l = new JLabel("· 请选择部门：");
		l.setBounds(10, 10, 200, 40);
		l.setFont(font);
		
		JComboBox<String> c = new JComboBox<String>();
		c.setFont(font);
		c.setBounds(160, 10, 190, 35);
		c.addItem("请选择要管理的部门");
		c.setSelectedItem("请选择要管理的部门");
		
		JButton b = new JButton("返回");
		b.setFont(font);
		b.setBounds(800, 500, 80, 30);
		
		this.add(c);
		this.add(l);
		this.add(b);
	}

}

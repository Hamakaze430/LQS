package presentation.Userui;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Miscellaneous.Authorities;
import Miscellaneous.Identity;
import businessLogic.Userbl.AuthoritiesSettingbl;
import businessLogicService.UserblService.AuthoritiesSettingblService;
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
	private String tempText = null;
	private List<String> tempList = new ArrayList<String>();
	private JCheckBox[] boxs;
	private JRadioButton[] buttons;
	private AuthoritiesSettingblService bl;
	private ButtonGroup bg;
	private int buttonNum;
	public AuthoritiesSettingPanel(int buttonNum){
		this.setBorder(null);
		this.setOpaque(false);
		this.setLayout(null);
		this.buttonNum = buttonNum;
		bl = new AuthoritiesSettingbl();
		initASPanel();
	}
	private void initASPanel() {
		// TODO Auto-generated method stub
		JLabel l1 = new JLabel("· 请选择要设置的职位：");
		l1.setFont(new Font("黑体",Font.PLAIN,18));
		l1.setBounds(40, 30, 250, 50);
		
		bg = new ButtonGroup();
		
		ActionListener listener = new RadioButtonListener();
		Identity[] identity = Identity.values();
		buttons = new JRadioButton[identity.length];
		for (int i = 0; i < identity.length; i++){
			buttons[i] = new JRadioButton(identity[i].name(),false);
			buttons[i].setFont(new Font("黑体",Font.PLAIN,18));
			buttons[i].setBounds(50+ 200*(i/3), 60+40*(i % 3), 180, 50);
			buttons[i].setBorder(null);
			buttons[i].setOpaque(false);
			buttons[i].setFocusPainted(false);
			buttons[i].addActionListener(listener);
			bg.add(buttons[i]);
			this.add(buttons[i]);
		}
		
		JLabel l2 = new JLabel("· 请选择权限：");
		l2.setFont(new Font("黑体",Font.PLAIN,18));
		l2.setBounds(40, 200, 250, 50);
		
		ActionListener listener2 = new ChenckBoxListener();
		Authorities[] authorities = Authorities.values();
		boxs = new JCheckBox[authorities.length];
		for (int i = 0; i < Authorities.values().length; i++){
			boxs[i] = new JCheckBox(authorities[i].toString(),false);
			CreateCheckBox.initCheckBox(boxs[i], i / 6,i % 6);
			boxs[i].addActionListener(listener2);
			this.add(boxs[i]);
		}
		
		JButton b1 = new JButton("确定");
		b1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int n = JOptionPane.showConfirmDialog(null, "确定该设置?", "确认框",JOptionPane.YES_NO_OPTION);
				if (n == 1) {
					return;
				};
				
				bl.save(tempText,tempList);
				bg.clearSelection();
				tempText = null;
				tempList.clear();
				for (int i = 0; i < boxs.length; i++){
					boxs[i].setSelected(false);
				}
				AuthoritiesSettingPanel.this.repaint();
			}
			
		});
		b1.setBounds(650, 485, 80, 40);
		b1.setBorder(null);
		b1.setOpaque(false);
		JButton b2 = new JButton("取消");
		b2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AuthoritiesSettingPanel.this.setVisible(false);
				MainPanel.closeButton(buttonNum);
			}
			
		});
		b2.setBounds(750, 485, 80, 40);
		b2.setBorder(null);
		b2.setOpaque(false);		
		
		this.add(l1);
		this.add(l2);
		
		this.add(b1);
		this.add(b2);
	}
	
	class RadioButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			tempText = ((JRadioButton)e.getSource()).getText();
			tempList = bl.getList(tempText);
//			System.out.println(tempText);
//			for (String s : tempList) System.out.println(s);
			for (int i = 0; i < boxs.length; i++){
				boxs[i].setSelected(false);
			}
			Authorities[] authorities = Authorities.values();
			for (String s : tempList){
				for (int i = 0; i < authorities.length; i++ ){
					if (authorities[i].name().equals(s)){
						boxs[i].setSelected(true);
						break;
					}
				}
				
			}
			AuthoritiesSettingPanel.this.repaint();
		}
	}
	
	class ChenckBoxListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JCheckBox c = (JCheckBox)e.getSource();
//			System.out.println(c.isSelected());
//			System.out.println(c.getText());
			if (c.isSelected()) tempList.add(c.getText());
			else tempList.remove(c.getText());
		}
	}
}

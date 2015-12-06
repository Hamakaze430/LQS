package presentation.Userui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EnumSet;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Miscellaneous.Authorities;
import Miscellaneous.Identity;
import Miscellaneous.Place;
import businessLogicService.UserblService.ApartmentblService;
import businessLogicService.UserblService.UserblService;
import init.Client;
import presentation.mainui.SimpleButton;
import vo.HallVO;

public class CreatUserDialog extends JDialog {
	JTextField name;
	JComboBox<String> placeBox;
	JTextField place;
	JTextField id;
	JPasswordField password;
	JComboBox<String> identity;
	UserblService bl;
	DefaultTableModel defaultModel;
	ButtonGroup bg;
	JRadioButton type1;
	JRadioButton type2;
	JRadioButton type3;
	public CreatUserDialog(UserblService bl, DefaultTableModel defaultModel){
		super(Client.frame,"新建部门信息",true);
		this.bl = bl;
		this.defaultModel = defaultModel;
		this.setSize(350, 400);
		this.setContentPane(new initPanel());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
	}
	
	class initPanel extends JPanel{
		initPanel(){
			this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			
		//	ActionListener lister = new IdListener();
			
			
			
			
			
			JLabel idLabel = new JLabel("用户名: ");
			id = new JTextField(20);
			id.setEditable(false);
			
			JLabel passwordLabel = new JLabel("密码: ");
			password = new JPasswordField(20);
			
			JLabel identityLabel = new JLabel("用户权限");
			identity = new JComboBox<String>();
			identity.addItem("-请设置用户权限-");
			identity.setSelectedIndex(0);
			for (Identity a : Identity.values()){
				identity.addItem(a.name());
			}
			
			JPanel panel1 = new JPanel();
			TitledBorder tb = BorderFactory.createTitledBorder("账号信息");		
			tb.setTitleJustification(TitledBorder.LEFT);
			panel1.setBorder(tb);
			panel1.add(idLabel);
			panel1.add(id);
			panel1.add(passwordLabel);
			panel1.add(password);
			panel1.add(identityLabel);
			panel1.add(identity);
			this.add(panel1);
			
			
			JPanel panel2 = new JPanel();
			tb = BorderFactory.createTitledBorder("个人信息");		
			tb.setTitleJustification(TitledBorder.LEFT);
			panel2.setBorder(tb);
			
			this.add(panel2);
//			
//			
//			JLabel nameLabel = new JLabel("姓名: ");
//			nameLabel.setBounds(gap_left,gap_up,width_label,height);
//			name = new JTextField(20);
//			name.setBounds(gap_left+width_label, gap_up, width_text , height);
//			JLabel  = new JLabel("部门位置: ");
//			placeLabel.setBounds(gap_left, gap_up+gap, width_label, height);
//			
//			placeBox = new JComboBox<String>();
//		
//			Place[] es = Place.values();
//			for (Place p : es) placeBox.addItem(p.name());
//			placeBox.setBounds(gap_left+width_label, gap_up+gap, 90 , height);
//			place = new JTextField(20);
//			place.setBounds(gap_left+width_label+100, gap_up+gap, width_text-100 , height);
//			
//			JLabel typeLabel = new JLabel("部门类型: ");
//			
//			typeLabel.setBounds(gap_left, gap_up+2*gap, width_label, height);
//			type1 = new JRadioButton("公司");
//			type1.setBounds(gap_left+width_label, gap_up+2*gap, 70, height);
//			type1.setFocusPainted(false);
//			
//			type2 = new JRadioButton("中转中心");
//			type2.setBounds(180, gap_up+2*gap, 110, height);
//			type2.setFocusPainted(false);
//			
//			type3 = new JRadioButton("营业厅");
//			type3.setBounds(290, gap_up+2*gap, 100, height);
//			type3.setFocusPainted(false);
//			
//			bg = new ButtonGroup();
//			bg.add(type1); bg.add(type2); bg.add(type3);
//			
//			
//			
//			
//			JButton check = new SimpleButton("确定");
//			check.setFont(new Font("宋体",Font.PLAIN,18));
//			check.setBounds(CreatUserDialog.this.getWidth()-gap_left-2*width_button, gap_up+4*gap, width_button, height_button);
//			check.addActionListener(new ActionListener(){
//
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//					String Name = name.getText();
//					if (Name.equals("")) {
//						JOptionPane.showMessageDialog(null, "请输入部门名称！","", JOptionPane.ERROR_MESSAGE);
//						return;
//					}
//					
//					Place type = Place.value(placeBox.getSelectedItem().toString());
//					if (type1.isSelected()) bl.addNum(type1.getText(),null);
//					else if (type2.isSelected()) bl.addNum(type2.getText(),type);
//					else if (type3.isSelected()) bl.addNum(type3.getText(),type); 
//					else {
//						JOptionPane.showMessageDialog(null, "请选择部门类型！","", JOptionPane.ERROR_MESSAGE);
//						return;
//					}
//					
//					String Id = id.getText();
//					String Place = placeBox.getSelectedItem()+place.getText();
//					name.setText("");
//					id.setText("");
//					place.setText("");
//					bg.clearSelection();
//					HallVO vo = new HallVO(Name, Id, Place);
//					defaultModel.addRow(vo);
//					bl.insert(vo);
//				}
//				
//			});
//			JButton cancel = new SimpleButton("取消");
//			cancel.setFont(new Font("宋体",Font.PLAIN,18));
//			cancel.setBounds(CreatApartmentDialog.this.getWidth()-gap_left-width_button, gap_up+4*gap, width_button, height_button);
//			cancel.addActionListener(new ActionListener(){
//
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//					CreatApartmentDialog.this.dispose();
//				}
//				
//			});
//			
//			placeBox.addActionListener(lister);
//			type1.addActionListener(lister);
//			type2.addActionListener(lister);
//			type3.addActionListener(lister);
			
		}
	}
//	class IdListener implements ActionListener{	
//		public void actionPerformed(ActionEvent e) {		
//			Place place = Place.value(placeBox.getSelectedItem().toString());
//			String areaCode = place.getId();
//			if (type1.isSelected()) {id.setText(toThreeString(bl.getNum(type1.getText(),place))); return;}
//			if (type2.isSelected()) id.setText(areaCode + (bl.getNum(type2.getText(),place)));
//			if (type3.isSelected()) id.setText(areaCode + toThreeString(bl.getNum(type3.getText(),place)));
//			return;
//			
//		}
//
//		private String toThreeString(int num) {
//			if (num < 10) return "00"+num;
//			if (num < 100) return "0"+num;
//			return num+"";
//		}
//	}
}

package presentation.Userui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EnumSet;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Miscellaneous.Place;
import businessLogicService.UserblService.ApartmentManagerblService;
import init.Client;
import presentation.mainui.SimpleButton;
import vo.HallVO;

/**
 * ApartmentManagerPanel的子窗口,新增部门信息窗口
 */
public class CreatApartmentDialog extends JDialog {
	JTextField name;
	JComboBox<String> placeBox;
	JTextField place;
	JTextField id;
	ApartmentManagerblService bl;
	DefaultTableModel defaultModel;
	ButtonGroup bg;
	JRadioButton type1;
	JRadioButton type2;
	JRadioButton type3;
	public CreatApartmentDialog(ApartmentManagerblService bl, DefaultTableModel defaultModel){
		super(Client.frame,"新建部门信息",true);
		this.bl = bl;
		this.defaultModel = defaultModel;
		this.setSize(400, 200);
		this.setContentPane(new initPanel());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
	}
	
	class initPanel extends JPanel{
		initPanel(){
			final int width_label = 100;
			final int width_text = 250;
			final int height = 25;
			final int gap_left = 10;
			final int gap_up = 10;
			final int gap = 30;
			final int width_button = 90;
			final int height_button = 30;
			this.setLayout(null);
			
			ActionListener lister = new IdListener();
			JLabel nameLabel = new JLabel("部门名称: ");
			nameLabel.setBounds(gap_left,gap_up,width_label,height);
			name = new JTextField(20);
			name.setBounds(gap_left+width_label, gap_up, width_text , height);
			JLabel placeLabel = new JLabel("部门位置: ");
			placeLabel.setBounds(gap_left, gap_up+gap, width_label, height);
			
			placeBox = new JComboBox<String>();
		
			Place[] es = Place.values();
			for (Place p : es) placeBox.addItem(p.name());
			placeBox.setBounds(gap_left+width_label, gap_up+gap, 90 , height);
			place = new JTextField(20);
			place.setBounds(gap_left+width_label+100, gap_up+gap, width_text-100 , height);
			
			JLabel typeLabel = new JLabel("部门类型: ");
			
			typeLabel.setBounds(gap_left, gap_up+2*gap, width_label, height);
			type1 = new JRadioButton("公司");
			type1.setBounds(gap_left+width_label, gap_up+2*gap, 70, height);
			type1.setFocusPainted(false);
			
			type2 = new JRadioButton("中转中心");
			type2.setBounds(180, gap_up+2*gap, 110, height);
			type2.setFocusPainted(false);
			
			type3 = new JRadioButton("营业厅");
			type3.setBounds(290, gap_up+2*gap, 100, height);
			type3.setFocusPainted(false);
			
			bg = new ButtonGroup();
			bg.add(type1); bg.add(type2); bg.add(type3);
			
			
			JLabel idLabel = new JLabel("部门编号: ");
			idLabel.setBounds(gap_left, gap_up+3*gap, width_label, height);
			id = new JTextField(20);
			id.setBounds(gap_left+width_label, gap_up+3*gap, width_text , height);
			id.setEditable(false);
			
			JButton check = new SimpleButton("确定");
			check.setFont(new Font("宋体",Font.PLAIN,18));
			check.setBounds(CreatApartmentDialog.this.getWidth()-gap_left-2*width_button, gap_up+4*gap, width_button, height_button);
			check.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String Name = name.getText();
					if (Name.equals("")) {
						JOptionPane.showMessageDialog(null, "请输入部门名称！","", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					Place type = Place.value(placeBox.getSelectedItem().toString());
					if (type1.isSelected()) bl.addNum(type1.getText(),null);
					else if (type2.isSelected()) bl.addNum(type2.getText(),type);
					else if (type3.isSelected()) bl.addNum(type3.getText(),type); 
					else {
						JOptionPane.showMessageDialog(null, "请选择部门类型！","", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					String Id = id.getText();
					String Place = placeBox.getSelectedItem()+place.getText();
					name.setText("");
					id.setText("");
					place.setText("");
					bg.clearSelection();
					HallVO vo = new HallVO(Name, Id, Place);
					defaultModel.addRow(vo);
					bl.insert(vo);
				}
				
			});
			JButton cancel = new SimpleButton("取消");
			cancel.setFont(new Font("宋体",Font.PLAIN,18));
			cancel.setBounds(CreatApartmentDialog.this.getWidth()-gap_left-width_button, gap_up+4*gap, width_button, height_button);
			cancel.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					CreatApartmentDialog.this.dispose();
				}
				
			});
			
			placeBox.addActionListener(lister);
			type1.addActionListener(lister);
			type2.addActionListener(lister);
			type3.addActionListener(lister);
			
			this.add(nameLabel);
			this.add(name);
			this.add(placeLabel);
			this.add(placeBox);
			this.add(place);
			this.add(typeLabel);
			this.add(type1);
			this.add(type2);
			this.add(type3);
			this.add(idLabel);
			this.add(id);
			this.add(check);
			this.add(cancel);
		}
	}
	
	/**
	 * 根据已知生成ID。
	 */
	class IdListener implements ActionListener{	
		public void actionPerformed(ActionEvent e) {		
			Place place = Place.value(placeBox.getSelectedItem().toString());
			String areaCode = place.getId();
			if (type1.isSelected()) {id.setText(toThreeString(bl.getNum(type1.getText(),place))); return;}
			if (type2.isSelected()) id.setText(areaCode + (bl.getNum(type2.getText(),place)));
			if (type3.isSelected()) id.setText(areaCode + toThreeString(bl.getNum(type3.getText(),place)));
			return;
			
		}

		private String toThreeString(int num) {
			if (num < 10) return "00"+num;
			if (num < 100) return "0"+num;
			return num+"";
		}
	}
}

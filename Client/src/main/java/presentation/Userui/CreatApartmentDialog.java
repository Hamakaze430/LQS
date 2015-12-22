package presentation.Userui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import Miscellaneous.Place;
import businessLogicService.UserblService.ApartmentManagerblService;
import init.Client;
import presentation.mainui.PictureButton;
import presentation.mainui.PictureLabel;
import presentation.mainui.SimpleButton;
import vo.HallVO;

/**
 * ApartmentManagerPanel的子窗口,新增部门信息窗口
 */
public class CreatApartmentDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	JButton save;
	JButton cancel;
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
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		initPanel(){
			final int width_label = 100;
			final int width_text = 250;
			final int height = 25;
			final int gap_left = 10;
			final int gap_up = 10;
			final int gap = 30;
			final int width_button = 60;
			final int height_button = 30;
			this.setLayout(null);
			PictureLabel userbg = new PictureLabel("src/main/java/image/userBG.jpg");
			userbg.setBounds(0, 0, 400, 200);
			Font font = new Font("黑体",Font.PLAIN,16);
			ActionListener lister = new IdListener();
			JLabel nameLabel = new JLabel("部门名称: ");
			nameLabel.setBounds(gap_left,gap_up,width_label,height);
			name = new JTextField(20);
			name.setFont(font);
			name.setBorder(new MatteBorder(0,0,1,0,Color.black));
			name.setOpaque(false);
			name.setBounds(gap_left+width_label, gap_up, width_text , height);
			JLabel placeLabel = new JLabel("部门位置: ");
			placeLabel.setBounds(gap_left, gap_up+gap, width_label, height);
			
			placeBox = new JComboBox<String>();
		
			Place[] es = Place.values();
			for (Place p : es) placeBox.addItem(p.name());
			placeBox.setBounds(gap_left+width_label, gap_up+gap, 90 , height);
			place = new JTextField(20);
			place.setFont(font);
			place.setOpaque(false);
			place.setBorder(new MatteBorder(0,0,1,0,Color.black));
			place.setBounds(gap_left+width_label+100, gap_up+gap, width_text-100 , height);
			
			JLabel typeLabel = new JLabel("部门类型: ");
			
			typeLabel.setBounds(gap_left, gap_up+2*gap, width_label, height);
			type1 = new JRadioButton("公司",true);
			type1.setBounds(gap_left+width_label, gap_up+2*gap, 70, height);
			type1.setBorder(null);
			type1.setOpaque(false);
			type1.setContentAreaFilled(false);
			type1.setFocusPainted(false);
			
			type2 = new JRadioButton("中转中心");
			type2.setBounds(180, gap_up+2*gap, 110, height);
			type2.setBorder(null);
			type2.setOpaque(false);
			type2.setContentAreaFilled(false);
			type2.setFocusPainted(false);
			
			type3 = new JRadioButton("营业厅");
			type3.setBounds(290, gap_up+2*gap, 100, height);
			type3.setBorder(null);
			type3.setOpaque(false);
			type3.setContentAreaFilled(false);
			type3.setFocusPainted(false);
			
			bg = new ButtonGroup();
			bg.add(type1); bg.add(type2); bg.add(type3);
			
			
			JLabel idLabel = new JLabel("部门编号: ");
			idLabel.setBounds(gap_left, gap_up+3*gap, width_label, height);
			id = new JTextField(20);
			
			id.setBounds(gap_left+width_label, gap_up+3*gap, width_text , height);
			id.setEditable(false);
			id.setFont(font);
			id.setText("001");
			id.setOpaque(false);
			id.setBorder(null);
			save = new JButton();
			save.setFont(font);
			save.setBorder(null);
			save.setOpaque(false);
			save.setContentAreaFilled(false);
			save.setBounds(CreatApartmentDialog.this.getWidth()-gap_left-2*width_button, gap_up+4*gap, width_button, height_button);
			PictureButton.setIcon("src/main/java/image/saveButton_unclicked.png",save);
			save.addMouseListener(new MouseListener(){

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
					PictureButton.setIcon("src/main/java/image/saveButton_clicked.png",save);
				}

				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					PictureButton.setIcon("src/main/java/image/saveButton_unclicked.png",save);
				}
				
			});
			save.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String Name = name.getText();
					if (Name.equals("")) {
						JOptionPane.showMessageDialog(null, "请输入部门名称！","", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					String type;
					if (type1.isSelected()) type = type1.getText();
					else if (type2.isSelected()) type = type2.getText();
					else if (type3.isSelected()) type = type3.getText();
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
					bl.insert(vo,type);
				}
				
			});
			cancel = new JButton();
			cancel.setFont(font);
			cancel.setBorder(null);
			cancel.setOpaque(false);
			cancel.setContentAreaFilled(false);
			cancel.setBounds(CreatApartmentDialog.this.getWidth()-gap_left-width_button, gap_up+4*gap, width_button, height_button);
			PictureButton.setIcon("src/main/java/image/backButton_unclicked.png",cancel);
			cancel.addMouseListener(new MouseListener(){

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
					PictureButton.setIcon("src/main/java/image/backButton_clicked.png",cancel);
				}

				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					PictureButton.setIcon("src/main/java/image/backButton_unclicked.png",cancel);
				}
				
			});
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
			this.add(save);
			this.add(cancel);
			this.add(userbg);
		}
	}
	
	/**
	 * 根据已知生成ID。
	 */
	class IdListener implements ActionListener{	
		public void actionPerformed(ActionEvent e) {		
			String place = placeBox.getSelectedItem().toString();
			String areaCode = null;
			for (Place p: Place.values()){
				if (p.name().equals(place)) areaCode = p.getId();
			}
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

package presentation.Userui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EnumSet;
import java.util.List;

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
import Miscellaneous.Job;
import Miscellaneous.Place;
import Miscellaneous.IDGenerator;
import businessLogic.Userbl.Apartmentbl;
import businessLogicService.UserblService.ApartmentblService;
import businessLogicService.UserblService.UserblService;
import init.Client;
import presentation.mainui.SimpleButton;
import vo.HallVO;
import vo.UserVO;

public class CreatUserDialog extends JDialog {
	JTextField name;
	JComboBox<String> place;
	JComboBox<String> job;
	JTextField id;
	JPasswordField password;
	JComboBox<String> identity;
	UserblService userbl;
	DefaultTableModel defaultModel;
	ButtonGroup bg;
	JRadioButton female;
	JRadioButton male;
	public CreatUserDialog(UserblService userbl, DefaultTableModel defaultModel){
		super(Client.frame,"新建部门信息",true);
		this.userbl = userbl;
		this.defaultModel = defaultModel;
		this.setSize(700, 400);
		this.setContentPane(new initPanel());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
	}
	
	class initPanel extends JPanel{
		initPanel(){
			this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			
			ActionListener lister = new IdListener();
			
			JLabel idLabel = new JLabel("用户名: ");
			id = new JTextField(10);
			id.setEditable(false);
			
			JLabel passwordLabel = new JLabel("密码: ");
			password = new JPasswordField("",15);
			
			JLabel identityLabel = new JLabel("用户权限: ");
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
			
			JLabel nameLabel = new JLabel("姓名: ");
			name = new JTextField(10);
			JLabel sexLabel = new JLabel("性别: ");
			male = new JRadioButton("男");
			female = new JRadioButton("女");
			bg = new ButtonGroup();
			bg.add(female);
			bg.add(male);
			JLabel jobLabel = new JLabel("职位: ");
			job = new JComboBox<String>();
			job.addItem("-请选择职位-");
			for(Job j : Job.values()){
				job.addItem(j.name());
			}
			job.addActionListener(lister);
			
			JLabel placeLabel = new JLabel("工作单位: ");
			place = new JComboBox<String>();
			place.addItem("-请选择工作单位-");
//			place.setEditable(true);
			ApartmentblService apartment = new Apartmentbl();
			List<String> list = apartment.getAllName();
			for (String s : list) place.addItem(s);
			place.addActionListener(lister);
			
			JPanel panel2 = new JPanel();
			tb = BorderFactory.createTitledBorder("个人信息");		
			tb.setTitleJustification(TitledBorder.LEFT);
			panel2.setBorder(tb);
			panel2.add(nameLabel);
			panel2.add(name);
			panel2.add(sexLabel);
			panel2.add(male);
			panel2.add(female);
			panel2.add(jobLabel);
			panel2.add(job);
			panel2.add(placeLabel);
			panel2.add(place);
			this.add(panel2);

			JButton check = new SimpleButton("确定");
			check.setFont(new Font("宋体",Font.PLAIN,18));
			check.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String Name = name.getText();
					if (Name.equals("")) {
						JOptionPane.showMessageDialog(null, "请输入用户姓名！","", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					String Sex = null;
					if (male.isSelected()) Sex = "男";
					else if (female.isSelected()) Sex = "女";
					else {
						JOptionPane.showMessageDialog(null, "请选择用户性别！","", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					String Job;
					if (job.getSelectedIndex() == 0){
						JOptionPane.showMessageDialog(null, "请选择用户职位！","", JOptionPane.ERROR_MESSAGE);
						return;
					}
					else {
						Job = job.getSelectedItem().toString();
					}
					
					String Place;
					if (place.getSelectedIndex() == 0){
						JOptionPane.showMessageDialog(null, "请选择用户的工作单位！","", JOptionPane.ERROR_MESSAGE);
						return;
					}
					else {
						Place = place.getSelectedItem().toString();
					}
					
					
					String Id = id.getText();
					
					String Password = String.valueOf(password.getPassword());
					if(Password.equals("")){
						JOptionPane.showMessageDialog(null, "请输入用户密码！","", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					
					String Identity;
					if (identity.getSelectedIndex() == 0){
						JOptionPane.showMessageDialog(null, "请选择用户权限！","", JOptionPane.ERROR_MESSAGE);
						return;
					}
					else {
						Identity = identity.getSelectedItem().toString();
					}
					
					id.setText("");
					password.setText("");
					identity.setSelectedItem(0);
					name.setText("");
					bg.clearSelection();
					job.setSelectedItem(0);
					place.setSelectedItem(0);
					
					UserVO vo = new UserVO(Id,Password,Identity,Name,Sex,Job,Place);
					defaultModel.addRow(vo);
					userbl.addUser(vo);
				}
				
			});
			JButton cancel = new SimpleButton("取消");
			cancel.setFont(new Font("宋体",Font.PLAIN,18));
			cancel.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					CreatUserDialog.this.dispose();
				}
				
			});
			
			JPanel panel3 = new JPanel();
			panel3.setOpaque(true);
			panel3.setBorder(null);
			panel3.setAlignmentX(LEFT_ALIGNMENT);
			panel3.add(check);
			panel3.add(cancel);
			this.add(panel3);
			
		}
	}
	class IdListener implements ActionListener{	
		public void actionPerformed(ActionEvent e) {		
			if (place.getSelectedIndex() != 0 && job.getSelectedIndex() != 0){
				Job jobType = Job.value(job.getSelectedItem().toString());
				ApartmentblService apartment = new Apartmentbl();
				String hallID = apartment.getId(place.getSelectedItem().toString());
				id.setText(IDGenerator.generateID(jobType,hallID));
			}
			
		}
	}
}

package presentation.Userui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Miscellaneous.Authorities;
import Miscellaneous.Identity;
import Miscellaneous.Job;
import Miscellaneous.Place;
import Miscellaneous.IDGenerator;
import businessLogic.Userbl.ApartmentManagerbl;
import businessLogic.Userbl.Apartmentbl;
import businessLogicService.UserblService.ApartmentManagerblService;
import businessLogicService.UserblService.ApartmentblService;
import businessLogicService.UserblService.UserManagerblService;
import businessLogicService.UserblService.UserblService;
import init.Client;
import presentation.mainui.PictureButton;
import presentation.mainui.PictureLabel;
import presentation.mainui.SimpleButton;
import vo.HallVO;
import vo.UserVO;
/**
 * UserManagerPanel的子窗口,新增用户信息窗口
 * 组件位置各种乱_(:зゝ∠)_待改善
 */
public class CreatUserDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField name;
	JComboBox<String> place;
	JComboBox<String> job;
	JTextField id;
	JPasswordField password;
	JComboBox<String> identity;
	UserManagerblService userbl;
	DefaultTableModel defaultModel;
	ButtonGroup bg;
	JRadioButton female;
	JRadioButton male;
	JButton back;
	JButton save;
	public CreatUserDialog(UserManagerblService userbl, DefaultTableModel defaultModel){
		super(Client.frame,"新建部门信息",true);
		this.userbl = userbl;
		this.defaultModel = defaultModel;
		this.setSize(800, 400);
		this.setContentPane(new initPanel());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
	}
	
	class initPanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int padding = 20;
		int button_width = 80;
		int button_height = 30;
		int text_width = 160;
		int text_height = 30;
		int label_width = 200;
		int label_height = 30;
		int box_width = 50;
		int box_height = 30;
		initPanel(){
			this.setLayout(null);
			this.setBorder(null);
			this.setOpaque(false);
			
			PictureLabel userbg = new PictureLabel("src/main/java/image/userBG.jpg");
			userbg.setBounds(0, 0, 800, 400);
			
			JPanel panel1 = new JPanel();
			TitledBorder tb = BorderFactory.createTitledBorder("账号信息");		
			tb.setTitleJustification(TitledBorder.LEFT);
			panel1.setBorder(tb);
			panel1.setOpaque(false);
			panel1.setLayout(null);
			panel1.setBounds(padding, padding*2+160, 800-2*padding, 120);
			//padding, padding*2+120, 800-2*padding, 160
			Font font = new Font("黑体",Font.PLAIN,16);
			ActionListener lister = new IdListener();
			
			JLabel idLabel = new JLabel("用户名: ");
			idLabel.setFont(font);
			idLabel.setBounds(padding, padding*2, label_width, label_height);
			id = new JTextField(10);
			id.setFont(font);
			id.setBounds(padding+60, padding*2, text_width, text_height);
			id.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
			id.setOpaque(false);
			id.setEditable(false);
			
			JLabel passwordLabel = new JLabel("密 码: ");
			passwordLabel.setFont(font);
			passwordLabel.setBounds(padding*2+60+text_width, padding*2, label_width, label_height);
			password = new JPasswordField("123456",15);
//			password.setFont(font);
			password.setBounds(padding*2+60+60+text_width, padding*2, text_width, text_height);
			password.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
			password.setOpaque(false);
			
			JLabel identityLabel = new JLabel("用户权限: ");
			identityLabel.setFont(font);
			identityLabel.setBounds(padding*3+100+text_width*2, padding*2, label_width, label_height);
			identity = new JComboBox<String>();
			identity.setFont(font);
			identity.setBounds(padding*3+120+60+text_width*2, padding*2, 180, text_height);
			identity.addItem("-请设置用户权限-");
			identity.setSelectedIndex(0);
			for (Identity a : Identity.values()){
				identity.addItem(a.name());
			}
						
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
			panel2.setOpaque(false);
			panel2.setLayout(null);
			panel2.setBounds(padding, padding, 800-2*padding, 160);
			
			JLabel nameLabel = new JLabel("姓 名: ");
			nameLabel.setFont(font);
			nameLabel.setBounds(padding,  padding*2, label_width, label_height);
			name = new JTextField(10);
			name.setFont(font);
			name.setBounds(padding+60, padding*2, text_width, text_height);
			name.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
			name.setOpaque(false);
			
			JLabel sexLabel = new JLabel("性 别: ");
			sexLabel.setFont(font);
			sexLabel.setBounds(padding+60+text_width+padding, padding*2, label_width, label_height);
			male = new JRadioButton("男",true);
			male.setFont(font);
			male.setBorder(null);
			male.setOpaque(false);
			male.setBounds(padding+60+text_width+padding+60, padding*2, box_width, box_height);
			female = new JRadioButton("女");
			female.setFont(font);
			female.setBorder(null);
			female.setOpaque(false);
			female.setBounds(padding+60+text_width+padding*2+60+box_width, padding*2, box_width, box_height);
			bg = new ButtonGroup();
			bg.add(female);
			bg.add(male);
			JLabel jobLabel = new JLabel("职 位: ");
			jobLabel.setFont(font);
			jobLabel.setBounds(padding, padding*3+label_height, label_width, label_height);
			job = new JComboBox<String>();
			job.setFont(font);
			job.setBounds(padding+60, padding*3+label_height, text_width, text_height);
			job.addItem("-请选择职位-");
			for(Job j : Job.values()){
				job.addItem(j.name());
			}
			job.addActionListener(lister);
			
			JLabel placeLabel = new JLabel("工作单位: ");
			placeLabel.setFont(font);
			placeLabel.setBounds(padding*2+60+text_width, padding*3+label_height, label_width, label_height);
			place = new JComboBox<String>();
			place.addItem("-请选择工作单位-");
			place.setFont(font);
			place.setBounds(padding*3+60*2+text_width, padding*3+label_height, text_width+30, text_height);
			ApartmentManagerblService apartment = new ApartmentManagerbl();
			List<String> list = apartment.getAllName();
			for (String s : list) place.addItem(s);
			place.addActionListener(lister);
			
			
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

			save = new JButton();
			save.setFont(font);
			save.setBorder(null);
			save.setContentAreaFilled(false);
			save.setOpaque(false);
			save.setBounds(800-3*padding-2*button_width, padding, button_width-10, button_height);
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
					password.setText("123456");
					identity.setSelectedIndex(0);
					name.setText("");
					male.setSelected(true);
					job.setSelectedIndex(0);
					place.setSelectedIndex(0);
					
					UserVO vo = new UserVO(Id,Password,Identity,Name,Sex,Job,Place);
					defaultModel.addRow(vo);
					userbl.addUser(vo);
				}
				
			});
			
			back =new JButton();
			back.setBorder(null);
			back.setOpaque(false);
			back.setContentAreaFilled(false);
			back.setFont(font);
			back.setBounds(800-2*padding-button_width, padding, button_width-10, button_height);
			PictureButton.setIcon("src/main/java/image/backButton_unclicked.png",back);
			back.addMouseListener(new MouseListener(){

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
					PictureButton.setIcon("src/main/java/image/backButton_clicked.png",back);
				}

				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					PictureButton.setIcon("src/main/java/image/backButton_unclicked.png",back);
				}
				
			});
			back.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					CreatUserDialog.this.dispose();
				}
				
			});
			
			JPanel panel3 = new JPanel();
			panel3.setBounds(padding, padding*3+10+120*2, 800-2*padding, padding*2+button_height);
			panel3.setOpaque(false);
			panel3.setBorder(null);
			panel3.setLayout(null);;
			panel3.add(save);
			panel3.add(back);
			this.add(panel3);
			this.add(userbg);
			
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

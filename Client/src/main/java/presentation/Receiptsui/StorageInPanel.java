package presentation.Receiptsui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import presentation.Userui.MainPanel;
import presentation.mainui.PictureButton;
import vo.receipts.StorageInVO;
import Miscellaneous.Cities;
import Miscellaneous.Place;
import businessLogic.Receiptsbl.Receiptsbl;
import businessLogicService.ReceiptsblService.ReceiptsblService;
import businessLogicService.UserblService.UserblService;
/**
 * 入库单
 * @author TOSHIBA
 *
 */
public class StorageInPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton submit;
	JButton back;
	private UserblService user;
	private ReceiptsblService bl;
	int buttonNum;
	JTextField id;
	JLabel title,date;
	JComboBox destination,place,c1,c2,c3,c4;
	public StorageInPanel(UserblService user, int buttonNum){
		this.user=user;
		bl = new Receiptsbl(user);
		this.buttonNum = buttonNum;
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		initSIPanel();
	}
	private void initSIPanel() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,18);
		title = new JLabel(user.getHallName()+"入库单",JLabel.CENTER);
		title.setFont(font);
		title.setBounds(150, 10, 600, 50);
		
		JLabel idLabel = new JLabel("· 快递编号: ");
		idLabel.setFont(font);
		idLabel.setBounds(10, 60, 300, 30);		
		
		id = new JTextField(20);
		id.setFont(font);
		id.setOpaque(false);
		id.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		id.setBounds(130, 60, 200, 30);
		
		JLabel dateLabel = new JLabel("· 入库日期: ");
		dateLabel.setFont(font);
		dateLabel.setBounds(10, 100, 300, 30);	
		
		date = new JLabel(bl.getCurrentTime());
		date.setFont(font);
		date.setBounds(130, 100, 300, 30);	
		
		JLabel l1 = new JLabel("· 目 的 地：");
		l1.setFont(font);
		l1.setBounds(10, 140, 200, 30);
		
		destination = new JComboBox();
		Place[] cities = Place.values();
		destination.addItem("请选择目标城市");
		for(int i=0;i<cities.length;i++){
			destination.addItem(cities[i].name());
		}
		destination.setSelectedItem("请选择目标城市");
		destination.setBounds(130, 140, 210, 30);
		place = new JComboBox();
		place.addItem("请选择目标地点");
		//添加目标地点
		
		
		
		place.setSelectedItem("请选择目标地点");
		place.setBounds(360, 140, 210, 30);
		  
		JLabel l2 = new JLabel("· 区    号：");
		JLabel l3 = new JLabel("· 排    号：");
		JLabel l4 = new JLabel("· 架    号：");
		JLabel l5 = new JLabel("· 位    号：");
		l2.setFont(font);
		l3.setFont(font);
		l4.setFont(font);
		l5.setFont(font);	
		l2.setBounds(10, 180, 200, 30);
		l3.setBounds(10, 220, 200, 30);
		l4.setBounds(10, 260, 200, 30);
		l5.setBounds(10, 300, 200, 30);
		
		c1 = new JComboBox();
		c2 = new JComboBox();
		c3 = new JComboBox();
		c4 = new JComboBox();
		c1.addItem("请选择区号");
		c2.addItem("请选择排号");
		c3.addItem("请选择架号");
		c4.addItem("请选择位号");
		//添加仓库位置信息
		
		
		
		c1.setBounds(130, 180, 150, 30);
		c2.setBounds(130, 220, 150, 30);
		c3.setBounds(130, 260, 150, 30);
		c4.setBounds(130, 300, 150, 30);
		
		submit = new JButton();
		submit.setFont(font);
		submit.setBorder(null);
		submit.setOpaque(false);
		submit.setFocusPainted(false);
		submit.setContentAreaFilled(false);
		submit.setBounds(740, 510, 70, 30);
		PictureButton.setIcon("src/main/java/image/submitButton_unclicked.png",submit);
		submit.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (id.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "请输入快递单号！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				try{
					long a = Long.parseLong(id.getText());
				}catch(NumberFormatException e1){
					//输入编号不是数字
					JOptionPane.showMessageDialog(null, "请输入正确的快递单号！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
		 		if(! bl.findLogistics(id.getText())){
					//System.out.println("找不到");
		 			
					JOptionPane.showMessageDialog(null, "不存在快递单号为"+id.getText()+"的货物！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
		 		
//				if (!judge(destination,"目标城市")) return;
//				if (!judge(place,"目标地点")) return;
//				if (!judge(c1,"区号")) return;
//				if (!judge(c2,"排号")) return;
//				if (!judge(c3,"架号")) return;
//				if (!judge(c4,"位号")) return;
				
				int n = JOptionPane.showConfirmDialog(null, "确定提交?", "确认框",JOptionPane.YES_NO_OPTION);
				if (n == 1) {
					return;
				}
				
				StorageInVO vo = new StorageInVO(title.getText(),user.getUserName(),date.getText(),
						id.getText(), destination.getSelectedItem().toString(), 
						c1.getSelectedItem().toString(),c2.getSelectedItem().toString(),c3.getSelectedItem().toString(),c4.getSelectedItem().toString());
				
				date.setText(bl.getCurrentTime());
				bl.addReceipt(vo);
				id.setText("");
				destination.setSelectedIndex(0);
				place.setSelectedIndex(0);
				c1.setSelectedIndex(0);
				c2.setSelectedIndex(0);
				c3.setSelectedIndex(0);
				c4.setSelectedIndex(0);
				JOptionPane.showMessageDialog(null, "提交成功^_^","", JOptionPane.CLOSED_OPTION);
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/submitButton_clicked.png",submit);
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/submitButton_unclicked.png",submit);
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
				StorageInPanel.this.setVisible(false);
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
		
		
		this.add(title);
		this.add(id);
		this.add(idLabel);
		this.add(dateLabel);
		this.add(date);
		this.add(l1);
		this.add(destination);
		this.add(place);
		this.add(l5);
		this.add(l4);
		this.add(l3);
		this.add(l2);
		this.add(c4);
		this.add(c3);
		this.add(c2);
		this.add(c1);
		this.add(back);
		this.add(submit);
	}
	
	protected boolean judge(JComboBox cb, String string) {
		// TODO Auto-generated method stub
		if (cb.getSelectedIndex() == 0){
			JOptionPane.showMessageDialog(null, "请选择"+string+"！","", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
}

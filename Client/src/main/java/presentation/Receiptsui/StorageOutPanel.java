package presentation.Receiptsui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import presentation.Userui.MainPanel;
import presentation.mainui.PictureButton;
import vo.ReceiptVO;
import vo.UserVO;
import vo.receipts.StorageInVO;
import vo.receipts.StorageOutVO;
import Miscellaneous.Cities;
import Miscellaneous.Place;
import businessLogic.Receiptsbl.Receiptsbl;
import businessLogicService.ReceiptsblService.ReceiptsblService;
import businessLogicService.UserblService.UserblService;

/**
 * 出库单
 * @author TOSHIBA
 *
 */
public class StorageOutPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton submit;
	JButton back;
	private UserblService user;
	private ReceiptsblService bl;
	int buttonNum;
	JLabel title, date;
	JComboBox destination, place;
	JTextField id,number;
	JRadioButton car,train,plane;
	public StorageOutPanel(UserblService user, int buttonNum){
		this.user=user;
		this.buttonNum = buttonNum;
		bl = new Receiptsbl(user);
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		initSOPanel();
	}
	private void initSOPanel() {
		int padding = 10;
		int textwidth = 200;
		int textheight = 30;
		int labelwidth = 300;
		int labelheight = 30;
		int boxwidth = 200;
		int boxheight = 30;
		int buttonwidth = 80;
		int buttonheight = 30;
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,18);
		title = new JLabel(user.getHallName()+"出库单",JLabel.CENTER);
		title.setFont(font);
		title.setBounds(150, 10, 600, 50);
		
		JLabel idLabel = new JLabel("· 快递编号：");
		idLabel.setFont(font);
		idLabel.setBounds(padding, 60, labelwidth, labelheight);
		
		id = new JTextField();
		id.setFont(font);
		id.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		id.setBounds(padding+120, 60, textwidth, textheight);
		id.setOpaque(false);
		
		JLabel dateLabel = new JLabel("· 出库日期：");
		dateLabel.setFont(font);
		dateLabel.setBounds(padding, 60+labelheight+padding, labelwidth, labelheight);
		
		
		date = new JLabel(bl.getCurrentTime());
		date.setFont(font);
		date.setBounds(padding+120, 60+labelheight+padding, labelwidth, labelheight);
		
		JLabel destinationlabel = new JLabel("· 目 的 地：");
		destinationlabel.setFont(font);
		destinationlabel.setBounds(padding, 60+2*(labelheight+padding), labelwidth, labelheight);
		
		destination = new JComboBox();
		Place[] cities = Place.values();
		destination.addItem("请选择目标城市");
		for(int i=0;i<cities.length;i++){
			destination.addItem(cities[i].name());
		}
		destination.setSelectedItem("请选择目标城市");
		destination.setBounds(padding+120, 60+2*(labelheight+padding), boxwidth, boxheight);
		place = new JComboBox();
		place.addItem("请选择目标地点");
		//添加目标地点
		
		
		
		place.setSelectedItem("请选择目标地点");
		place.setBounds(padding+120+boxwidth+padding, 60+2*(labelheight+padding), boxwidth, boxheight);
		
		JLabel formlabel = new JLabel("· 装运形式：");
		formlabel.setFont(font);
		formlabel.setBounds(padding, 60+3*(labelheight+padding), labelwidth, labelheight);
		
		ButtonGroup bg = new ButtonGroup();
		
		train = new JRadioButton("火车",true);
		train.setFont(font);
		train.setBounds(padding+120, 60+3*(labelheight+padding), 80, 30);
		train.setLayout(null);
		train.setOpaque(false);
		
		plane = new JRadioButton("飞机");
		plane.setFont(font);
		plane.setBounds(padding+120+90, 60+3*(labelheight+padding), 80, 30);
		plane.setLayout(null);
		plane.setOpaque(false);
		
		car = new JRadioButton("汽车");
		car.setFont(font);
		car.setBounds(padding+120+90+90, 60+3*(labelheight+padding), 80, 30);
		car.setLayout(null);
		car.setOpaque(false);
		
		JLabel numberlabel = new JLabel("· 汽运编号：");
		numberlabel.setFont(font);
		numberlabel.setBounds(padding, 60+4*(labelheight+padding), labelwidth, labelheight);
		
		number = new JTextField();
		number.setFont(font);
		number.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
		number.setBounds(padding+120, 60+4*(labelheight+padding), textwidth, textheight);
		number.setOpaque(false);
		
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
		 		
		 		if(destination.getSelectedIndex() == 0){
		 			JOptionPane.showMessageDialog(null, "请选择目标城市！","", JOptionPane.ERROR_MESSAGE);
					return;
		 		}
		 		if(place.getSelectedIndex() == 0){
		 			JOptionPane.showMessageDialog(null, "请选择目标地点！","", JOptionPane.ERROR_MESSAGE);
					return;
		 		}
		 		if (number.getText().equals("")){
		 			JOptionPane.showMessageDialog(null, "请输入中转单编号/汽运编号！","", JOptionPane.ERROR_MESSAGE);
		 			return;
		 		}
			
		 		try{
		 			long a = Long.parseLong(id.getText());
		 		}catch(NumberFormatException e1){
		 			//输入编号不是数字
		 			JOptionPane.showMessageDialog(null, "请输入正确的中转单编号/汽运编号！","", JOptionPane.ERROR_MESSAGE);
		 			return;
		 		}
		 		
		 		ReceiptVO form = bl.getLoadingOrTransferVO(number.getText());
		 		if (form == null){
					JOptionPane.showMessageDialog(null, "请输入正确的中转单编号/汽运编号！","", JOptionPane.ERROR_MESSAGE);
					return;
		 		}
		 		
		 		int n = JOptionPane.showConfirmDialog(null, "确定提交?", "确认框",JOptionPane.YES_NO_OPTION);
				if (n == 1) {
					return;
				}
				String traffic = "";
				if (plane.isSelected()) traffic = plane.getText();
				else if (car.isSelected()) traffic = car.getText();
				else if (train.isSelected()) traffic = train.getText();
				StorageOutVO vo = new StorageOutVO(title.getText(),user.getUserName(),date.getText(),
						id.getText(), destination.getSelectedItem().toString(), 
						traffic, number.getText());
				
				date.setText(bl.getCurrentTime());
				bl.addReceipt(vo);
				id.setText("");
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
				StorageOutPanel.this.setVisible(false);
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
		this.add(idLabel);
		this.add(dateLabel);	
		this.add(id);
		this.add(date);
		this.add(destinationlabel);
		this.add(destination);
		this.add(place);
		this.add(formlabel);
		bg.add(train);
		this.add(train);
		bg.add(plane);
		this.add(plane);
		bg.add(car);
		this.add(car);
		this.add(numberlabel);
		this.add(number);
		this.add(back);
		this.add(submit);
	}
}

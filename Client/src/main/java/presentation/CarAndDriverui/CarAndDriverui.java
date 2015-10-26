package presentation.CarAndDriverui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import businessLogicService.CarAndDriverblService.CarAndDriverblService;
import vo.CarVO;
import vo.DriverVO;

public class CarAndDriverui extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private CarAndDriverblService bl;
	private JTextField IDField;
	private JComboBox<String> carOrDriver;
	private CarPanel carPanel;
	private DriverPanel driverPanel;
	
	
	public CarAndDriverui(CarAndDriverblService bl){
		this.bl = bl;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.initChoose();
		this.initMenu();
		
		this.initDisplay();
		
		this.validate();
	}
	
	private void initChoose(){
		String[] word = {"司机","车辆"};
		carOrDriver = new JComboBox<String>(word);
		
		carOrDriver.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					if (carOrDriver.getSelectedItem().equals("车辆")){
					//	bl.selectType("0");
					}
					else{
					//	bl.selectType("1");
					}				
					
				}
			}
		});
		
		JPanel choosePanel = new JPanel();
		choosePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel chooseLabel = new JLabel("类型:");
		choosePanel.add(chooseLabel);
		choosePanel.add(carOrDriver);
		this.add(choosePanel);
	}
	
	private void initMenu(){
		JLabel IDLabel = new JLabel("输入ID:");
		IDField = new JTextField(9);
		
		JButton searchButton = new JButton("查询");
		searchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				showInfo();
			}
		});
		
		JButton addButton = new JButton("新建");
		addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				addInfo();
			}
		});
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(IDLabel);
		inputPanel.add(IDField);
		inputPanel.add(searchButton);
		inputPanel.add(addButton);
		
		this.add(inputPanel);
	}
	
	private void initDisplay(){
		JPanel display = new JPanel();
		display.setBorder(BorderFactory.createLoweredBevelBorder());
		//display.setLayout(new FlowLayout(FlowLayout.LEFT));
		carPanel = new CarPanel();
		driverPanel = new DriverPanel();
		carPanel.setVisible(false);
		driverPanel.setVisible(false);
		display.add(carPanel);
		display.add(driverPanel);
		this.add(display);
	}
	
	private void showInfo(){
		int id = 0;
		try{
			id = Integer.parseInt(IDField.getText());
		}catch(NumberFormatException e){
			//输入数量不是整数
			JOptionPane.showMessageDialog(null, "请输入正确的编号","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (carOrDriver.getSelectedItem().equals("车辆")){
			CarVO info = bl.findCarInfo(IDField.getText());
			if(info == null){
				JOptionPane.showMessageDialog(null, "找不到对应的信息","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			IDField.setText("");
			carPanel.setValue(info);
			driverPanel.setVisible(false);
			carPanel.setVisible(true);
			this.validate();
		}
		else{
			DriverVO info = bl.findDriverInfo(IDField.getText());
			if(info == null){
				JOptionPane.showMessageDialog(null, "找不到对应的信息","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			IDField.setText("");
			driverPanel.setValue(info);
			carPanel.setVisible(false);
			driverPanel.setVisible(true);
			this.validate();
		}
	}
	
	private void addInfo(){
		if (carOrDriver.getSelectedItem().equals("车辆")){
			
		}
		else{
			
		}
	}
	
}

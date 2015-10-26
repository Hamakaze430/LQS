package presentation.CarAndDriverui;

import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vo.CarVO;

public class CarPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel idLabel;
	private JLabel licenseLabel;
	private JLabel timeLabel;
	public CarPanel(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		idLabel = new JLabel();
		licenseLabel = new JLabel();
		timeLabel = new JLabel();
		this.add(idLabel);
		this.add(licenseLabel);
		this.add(timeLabel);
	}
	
	public void setValue(CarVO car){
		idLabel.setText("车辆代号: "+car.getId());
		licenseLabel.setText("车牌号: "+car.getLicense());
		timeLabel.setText("服役时间: "+car.getTime().toString());
	}
	
}

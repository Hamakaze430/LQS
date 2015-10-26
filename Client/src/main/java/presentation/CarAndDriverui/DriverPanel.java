package presentation.CarAndDriverui;

import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vo.CarVO;
import vo.DriverVO;

public class DriverPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel birthLabel;
	private JLabel identityLabel;
	private JLabel mobileLabel;
	private JLabel genderLabel;
	private JLabel timeLabel;

	public DriverPanel(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		idLabel = new JLabel();
		nameLabel = new JLabel();
		birthLabel = new JLabel();
		identityLabel = new JLabel();
		mobileLabel = new JLabel();
		genderLabel = new JLabel();
		timeLabel = new JLabel();
		this.add(idLabel);
		this.add(nameLabel);
		this.add(birthLabel);
		this.add(identityLabel);
		this.add(mobileLabel);
		this.add(genderLabel);
		this.add(timeLabel);
	}
	
	public void setValue(DriverVO driver){
		idLabel.setText("司机编号:"+driver.getId());
		nameLabel.setText("姓名:"+driver.getName());
		birthLabel.setText("出生日期:"+driver.getBirth().toString());
		identityLabel.setText("身份证号:"+driver.getIdentity());
		mobileLabel.setText("手机:"+driver.getMobile());
		genderLabel.setText("性别:"+driver.getGender());
		timeLabel.setText("行驶证期限"+driver.getTime().toString());
	}
	
}

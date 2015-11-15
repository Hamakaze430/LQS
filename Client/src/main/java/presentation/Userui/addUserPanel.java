import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vo.UserVO;


public class addUserPanel extends JPanel {
private static final long serialVersionUID = 1L;
	
	private JLabel idLabel;
	private JLabel passwordLabel;
	private JLabel positionLabel;
	private JLabel authorityLabel;
	public addUserPanel(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		idLabel = new JLabel();
		passwordLabel = new JLabel();
		positionLabel = new JLabel();
		authorityLabel = new JLabel();
		this.add(idLabel);
		this.add(passwordLabel);
		this.add(positionLabel);
		this.add(authorityLabel);
	}
	
	public void setValue(UserVO user){
		idLabel.setText("用户编号: "+user.getID());
		passwordLabel.setText("密码: "+user.getPassword());
		positionLabel.setText("用户职位: "+user.getPosition());
		authorityLabel.setText("用户权限: "+user.getAuthority());
	}
	

}

package presentation.Userui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vo.UserVO;


public class showPanel extends JPanel{
private static final long serialVersionUID = 1L;
	
	private JLabel mainLabel;
	private JLabel nameLabel;
	private JLabel idLabel;
	private JLabel positionLabel;
	private JButton viewConstruction;
	
	
	public showPanel(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		mainLabel = new JLabel();
		nameLabel = new JLabel();
		idLabel = new JLabel();
		positionLabel = new JLabel();
		this.add(mainLabel);
		this.add(nameLabel);
		this.add(idLabel);
		this.add(positionLabel);
		
	}
	
	public void setValue(UserVO user){
		mainLabel.setText("人员结构: ");
		nameLabel.setText("姓名："+user.getName());
		idLabel.setText("编号："+user.getID());
		positionLabel.setText("职位："+user.getPosition());
		
		
	}
}

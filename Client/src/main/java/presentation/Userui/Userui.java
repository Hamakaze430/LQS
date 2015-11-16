package presentation.Userui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businessLogicService.UserblService.UserblService;

public class Userui extends JPanel{
private static final long serialVersionUID = 1L;
	
	private UserblService bl;
	private showPanel showPanel;
	private addUserPanel addUserPanel;
	
	public Userui(UserblService bl){
		this.bl = bl;
		this.initaddUser();
		

	}

	

}

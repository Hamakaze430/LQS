package presentation.Userui;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import init.Client;
import presentation.mainui.SimpleButton;

public class CreatApartmentDialog extends JDialog {
	public CreatApartmentDialog(){
		super(Client.frame,"新建部门信息",true);
		this.setSize(350, 200);
		this.setContentPane(new initPanel());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
	}
	
	class initPanel extends JPanel{
		initPanel(){
			//this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			JLabel nameLabel = new JLabel("部门名称: ");
			JTextField name = new JTextField(20);
			JLabel placeLabel = new JLabel("部门位置: ");
			JTextField place = new JTextField(20);
			JLabel idLabel = new JLabel("部门编号: ");
			JTextField id = new JTextField(20);
			JButton check = new SimpleButton("确定");
			JButton cancel = new SimpleButton("取消");
			this.add(nameLabel);
			this.add(name);
			this.add(placeLabel);
			this.add(place);
			this.add(idLabel);
			this.add(id);
			this.add(check);
			this.add(cancel);
		}
	}
}

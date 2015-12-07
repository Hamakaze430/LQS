package presentation.Userui;

import java.awt.Font;

import javax.swing.JCheckBox;

import Miscellaneous.Authorities;

public class CreateCheckBox extends JCheckBox{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CreateCheckBox(){
		
	}
	public static void initCheckBox(JCheckBox c,int i,int j){		
		c.setBounds(50+150*i, 240+40*j, 120, 40);
		c.setFont(new Font("黑体",Font.PLAIN,18));
		c.setOpaque(false);
		c.setBorder(null);
		
	}
}

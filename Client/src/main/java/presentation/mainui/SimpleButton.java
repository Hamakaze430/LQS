package presentation.mainui;

import java.awt.Font;

import javax.swing.JButton;

public class SimpleButton extends JButton{
	public SimpleButton(String s){
		super(s);
		this.setContentAreaFilled(false);
		this.setOpaque(false);
//		this.setBorder(null);
		Font font = new Font("宋体",Font.BOLD,18);
		this.setFont(font);
	}
}

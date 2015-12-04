package presentation.Userui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import presentation.mainui.PictureButton;

public class InitButton extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static int width = 70;
	private final static int height = 70;
	public InitButton(){
		
	}
	public static void editButton(JButton button,int i,String file){
		
		button.setBounds(80*i+5, 5, width, height);
		PictureButton.setIcon(file,button);
		button.setBorder(null);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
	
	}

}

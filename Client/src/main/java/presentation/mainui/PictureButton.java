package presentation.mainui;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PictureButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PictureButton(){
	}
	
	
	public static void setIcon(String file,JButton button){
		ImageIcon icon = new ImageIcon(file);
		Image temp = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		button.setIcon(icon);
	}
}

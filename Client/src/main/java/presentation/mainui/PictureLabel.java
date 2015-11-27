package presentation.mainui;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PictureLabel extends JLabel {
	private static final long serialVersionUID = 1L;
	private ImageIcon im = null;
	
	public PictureLabel(String s){
		this.im = new ImageIcon(s);  
	}
	
	protected void paintComponent(Graphics g) {  
		g.drawImage(im.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);   
	}
}



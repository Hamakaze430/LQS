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
	private int num;
	public InitButton(int i,String file){
		this.num = i;
		editButton(i,file);
	}
	private void editButton(int i,String file){
		
		this.setBounds(80*i+5, 5, width, height);
		PictureButton.setIcon(file,this);
		this.setBorder(null);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
	
	}
	public int getNum(){
		return num;
	}

}

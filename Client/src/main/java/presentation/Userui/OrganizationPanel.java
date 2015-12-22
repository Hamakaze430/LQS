package presentation.Userui;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.mainui.PictureButton;
/**
 * 人员机构界面
 * 待完善
 *
 */
public class OrganizationPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton back;
	public OrganizationPanel(){
		this.setLayout(null);
		this.setBorder(null);
		this.setOpaque(false);
		initOPanel();
	}
	private void initOPanel() {
		// TODO Auto-generated method stub
		Font font = new Font("黑体",Font.PLAIN,18);
		JLabel l = new JLabel("· 请选择部门：");
		l.setBounds(10, 10, 200, 40);
		l.setFont(font);
		
		JComboBox<String> c = new JComboBox<String>();
		c.setFont(font);
		c.setBounds(160, 10, 190, 35);
		c.addItem("请选择要管理的部门");
		c.setSelectedItem("请选择要管理的部门");
		
		back = new JButton();
		back.setFont(font);
		back.setBorder(null);
		back.setOpaque(false);
		back.setFocusPainted(false);
		back.setContentAreaFilled(false);
		back.setBounds(820, 510, 70, 30);
		PictureButton.setIcon("src/main/java/image/backButton_unclicked.png",back);
		back.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/backButton_clicked.png",back);
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				PictureButton.setIcon("src/main/java/image/backButton_unclicked.png",back);
			}
			
		});
		
		this.add(c);
		this.add(l);
		this.add(back);
	}

}

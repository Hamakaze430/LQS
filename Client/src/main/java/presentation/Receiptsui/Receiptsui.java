package presentation.Receiptsui;

import javax.swing.JPanel;

import businessLogicService.ReceiptsblService.ReceiptsblService;

public class Receiptsui extends JPanel{
	private ReceiptsblService bl;
	public Receiptsui(ReceiptsblService bl){
		this.bl = bl;
	}
	
}

package po.receipts;

import Miscellaneous.FormType;
import po.ReceiptPO;

public class StorageInPO extends ReceiptPO{

	String id;
	String end;
	String section;
	String row;
	String shelf;
	String position;
	public StorageInPO(long receiptId, String name, String creator, String date, String id, String end, String section, String row, String shelf, String position) {
		super(FormType.入库单.name(), name, creator, date, receiptId);
		// TODO Auto-generated constructor stub
		this.id = id;
		this.end = end;
		this.section = section;
		this.row = row;
		this.shelf = shelf;
		this.position = position;	
	}
	public String getId(){
		return id;
	}
	public String getEnd(){
		return end;
	}
	public String getSection(){
		return section;
	}
	public String getRow(){
		return row;
	}
	public String getShelf(){
		return shelf;
	}
	public String getPosition(){
		return position;
	}
	

}

package vo.receipts;

import Miscellaneous.FormType;
import po.receipts.StorageInPO;
import vo.ReceiptVO;

public class StorageInVO extends ReceiptVO{

	String id;
	String end;
	String section;
	String row;
	String shelf;
	String position;
	public StorageInVO(String name, String creator, String date, String id, String end, String section, String row, String shelf, String position) {
		super(FormType.入库单.name(), name, creator, date);
		// TODO Auto-generated constructor stub
		this.id = id;
		this.end = end;
		this.section = section;
		this.row = row;
		this.shelf = shelf;
		this.position = position;	
	}
	public StorageInVO(StorageInPO po){
		super(FormType.入库单.name(), po.getName(), po.getCreator(), po.getCreateDate());
		// TODO Auto-generated constructor stub
		this.id = po.getId();
		this.end = po.getEnd();
		this.section = po.getSection();
		this.row = po.getRow();
		this.shelf = po.getShelf();
		this.position = po.getPosition();	
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
	
	public StorageInPO toPO(long receiptId){
		return new StorageInPO(receiptId,getName(),getCreator(), getDate(),
				id, end, section, row, shelf, position);
	}

}

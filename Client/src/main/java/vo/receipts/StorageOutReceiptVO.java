package vo.receipts;

import java.util.ArrayList;

import vo.ComGoodsVO;

public class StorageOutReceiptVO {
	
	String id;
	String date;
    String location;
	
    ArrayList<ComGoodsVO> list;
	
	public StorageOutReceiptVO(ArrayList<ComGoodsVO> list, String id, String date, String location){
		
		this.id =id;
		this.location = location;
		this.date = date;
		
		this.list = list;
		
	}
	
	public String getID(){
		return this.id;
	}
	
	public String getDate(){
		return this.date;
	}
	
	public String getLocation(){
		return this.location;
	}
	
	public ArrayList<ComGoodsVO> getList(){
		return this.list;
	}
	

}

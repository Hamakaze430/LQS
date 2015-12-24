package po.receipts;

import javax.swing.JTextField;

import Miscellaneous.FormType;
import po.ReceiptPO;

public class SendPO extends ReceiptPO {

	String sendername;
	String sendercomp;
	String senderphone;
	String sendertel;
	String senderaddr;
	
	String receivername;
	String receivercomp;
	String receiverphone;
	String receivertel;
	String receiveraddr;
	
	String initnumber; //原件数
	String trueweight; //实际重量
	String volume; //体积
	String goodstype; //内件品名
	String expresstype; //快递类型
	String bagging; //包装费
	String allcost; //费用合计
	String order; 

	
	public SendPO(long receiptId, String name, String creator, String date,
			String sendername, String sendercomp, String senderphone, String sendertel, String senderaddr,
			String receivername, String receivercomp, String receiverphone, String receivertel, String receiveraddr,
			String initnumber, String trueweight, String volume, String goodstype, String expresstype,String bagging, String allcost, String order) {
		super(FormType.寄件单.name(), name, creator, date, receiptId);
		
		this.sendername = sendername;
		this.sendercomp = sendercomp;
		this.senderphone = senderphone;
		this.sendertel = sendertel;
		this.senderaddr = senderaddr;
		
		this.receivername = receivername;
		this.receivercomp = receivercomp;
		this.receiverphone = receiverphone;
		this.receivertel = receivertel;
		this.receiveraddr = receiveraddr;
		
		this.initnumber = initnumber; //原件数
		this.trueweight = trueweight; //实际重量
		this.volume = volume; //体积
		this.goodstype = goodstype; //内件品名
		this.expresstype = expresstype; //快递类型
		this.bagging = bagging; //包装费
		this.allcost = allcost; //费用合计
		this.order = order; 
		// TODO Auto-generated constructor stub
	}
	
	public String getSendername(){
		return sendername;
	}
	public String getSendercomp(){
		return sendercomp;
	}
	public String getSenderphone(){
		return senderphone;
	}
	public String getSendertel(){
		return sendertel;
	}
	public String getSenderaddr(){
		return senderaddr;
	}
	
	public String getReceivername(){
		return receivername;
	}
	public String getReceivercomp(){
		return receivercomp;
	}
	public String getReceiverphone(){
		return receiverphone;
	}
	public String getReceivertel(){
		return receivertel;
	}
	public String getReceiveraddr(){
		return receiveraddr;
	}
	
	public String getInitnumber(){
		return  initnumber; //原件数
	}
	public String getTrueweight(){
		return  trueweight; //实际重量
	}
	public String getVolume(){
		return  volume; //体积
	}
	public String getGoodstype(){
		return  goodstype; //内件品名
	}
	public String getExpresstype(){
		return  expresstype; //快递类型
	}
	public String getBagging(){
		return  bagging; //包装费
	}
	public String getAllcost(){
		return  allcost; //费用合计
	}
	public String getOrder(){
		return  order; 
	}
	

}

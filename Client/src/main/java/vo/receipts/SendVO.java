package vo.receipts;

import javax.swing.JTextField;

import Miscellaneous.FormType;
import po.receipts.SendPO;
import vo.ReceiptVO;

public class SendVO extends ReceiptVO {

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

	
	public SendVO(String name, String creator, String date,
			String sendername, String sendercomp, String senderphone, String sendertel, String senderaddr,
			String receivername, String receivercomp, String receiverphone, String receivertel, String receiveraddr,
			String initnumber, String trueweight, String volume, String goodstype, String expresstype,String bagging, String allcost, String order) {
		super(FormType.寄件单.name(), name, creator, date);
		
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
	
	public SendVO(SendPO po){
		super(FormType.寄件单.name(), po.getName(), po.getCreator(), po.getCreateDate());
		
		this.sendername = po.getSendername();
		this.sendercomp = po.getSendercomp();
		this.senderphone = po.getSenderphone();
		this.sendertel = po.getSendertel();
		this.senderaddr = po.getSenderaddr();
		
		this.receivername = po.getReceivername();
		this.receivercomp = po.getReceivercomp();
		this.receiverphone = po.getReceiverphone();
		this.receivertel = po.getReceivertel();
		this.receiveraddr = po.getReceiveraddr();
		
		this.initnumber = po.getInitnumber(); //原件数
		this.trueweight = po.getTrueweight(); //实际重量
		this.volume = po.getVolume(); //体积
		this.goodstype = po.getGoodstype(); //内件品名
		this.expresstype = po.getExpresstype(); //快递类型
		this.bagging = po.getBagging(); //包装费
		this.allcost = po.getAllcost(); //费用合计
		this.order = po.getOrder(); 
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
	
	public SendPO toPO(long receiptId){
		return new SendPO(receiptId, getName(), getCreator(), getDate(),	
				sendername,	sendercomp,	senderphone, sendertel,	senderaddr,
				receivername, receivercomp, receiverphone, receivertel, receiveraddr,
				initnumber, trueweight, volume, goodstype, expresstype, bagging, allcost, order);
	}

}

package Miscellaneous;

import java.util.ArrayList;

import po.BalancePO;
import po.CarPO;
import po.ComGoodsPO;
import po.DriverPO;
import po.OrderPO;
import po.receipts.ArrivalReceiptPO;
import po.receipts.ArriveReceiptPO;
import po.receipts.DeliverReceiptPO;
import po.receipts.HallTransferReceiptPO;
import po.receipts.PaymentPO;
import po.receipts.StorageInReceiptPO;
import po.receipts.StorageOutReceiptPO;
import po.receipts.TransferReceiptPO;
import vo.BalanceVO;
import vo.CarVO;
import vo.ComGoodsVO;
import vo.DriverVO;
import vo.OrderVO;
import vo.receipts.ArrivalReceiptVO;
import vo.receipts.ArriveReceiptVO;
import vo.receipts.DeliverReceiptVO;
import vo.receipts.HallTransferReceiptVO;
import vo.receipts.PaymentVO;
import vo.receipts.StorageInReceiptVO;
import vo.receipts.StorageOutReceiptVO;
import vo.receipts.TransferReceiptVO;

public class Convert {
public static OrderVO po_to_vo_order(OrderPO po){
		
		OrderVO vo = new OrderVO(po.getSenderName(),po.getSenderAddress(),po.getSenderPost(),po.getReceiverTel(),
				po.getReceiverPhone(),po.getReceiverName(),po.getReceiverAddress(),po.getReceiverPost(),po.getReceiverTel(),
				po.getReceiverPhone(),po.getNum(),po.getWeight(),po.getVolume(),po.getGoodsName(),po.getSize(),
				po.getPkgCost(),po.getTotalCost(),po.getID(),po.getType(),po.getArrivalState(),po.getExpectedTime(),
				po.getCurrentSpot());
		
		return vo;
		
	}
	
	public static OrderPO vo_to_po_order(OrderVO vo){
			
		OrderPO po = new OrderPO(vo.getSenderName(),vo.getSenderAddress(),vo.getSenderPost(),vo.getReceiverTel(),
				vo.getReceiverPhone(),vo.getReceiverName(),vo.getReceiverAddress(),vo.getReceiverPost(),vo.getReceiverTel(),
				vo.getReceiverPhone(),vo.getNum(),vo.getWeight(),vo.getVolume(),vo.getGoodsName(),vo.getSize(),
				vo.getPkgCost(),vo.getTotalCost(),vo.getID(),vo.getType(),vo.getState(),vo.getExpectedTime(),
				vo.getCurrentSpot());
			
		return po;
		
	}
	
	public static ArrayList<OrderVO> po_to_vo_orderlist(ArrayList<OrderPO> polist){
		
		ArrayList<OrderVO> volist = new ArrayList<OrderVO>();
		for(int i=0;i<polist.size();i++)
			volist.add(po_to_vo_order(polist.get(i)));
		
		return volist;
		
	}
	
	public static ArrayList<OrderPO> vo_to_po_orderlist(ArrayList<OrderVO> volist){
		
		ArrayList<OrderPO> polist = new ArrayList<OrderPO>();
		for(int i=0;i<volist.size();i++)
			polist.add(vo_to_po_order(volist.get(i)));
		
		return polist;
		
	}
	
	public static ArriveReceiptVO po_to_vo_arrive(ArriveReceiptPO po){
		
		ArriveReceiptVO vo = new ArriveReceiptVO(po.getID(),po.getDate(),po.getFrom(),po.getLocation(),po_to_vo_orderlist(po.getOrderList()));
		
		return vo;
		
	}
	
	public static ArriveReceiptPO vo_to_po_arrive(ArriveReceiptVO vo){
		
		ArriveReceiptPO po = new ArriveReceiptPO(vo.getID(),vo.getDate(),vo.getFrom(),vo.getLocation(),vo_to_po_orderlist(vo.getList()));
		
		return po;
		
	}
	
	public static TransferReceiptVO po_to_vo_transfer(TransferReceiptPO po){
		
		TransferReceiptVO vo = new TransferReceiptVO(po.getID(),po.getDate(),po.getTo(),po.getLocation(),po.getTransportID(),po.getSupervisor(),po.getType(),po_to_vo_orderlist(po.getOrderList()));
		
		return vo;
		
	}
	
	public static TransferReceiptPO vo_to_po_transfer(TransferReceiptVO vo){
		
		TransferReceiptPO po = new TransferReceiptPO(vo.getID(),vo.getDate(),vo.getTo(),vo.getLocation(),vo.getTransportID(),vo.getSupervisor(),vo.getType(),vo_to_po_orderlist(vo.getList()));
		
		return po;
		
	}
	
	public static StorageInReceiptVO po_to_vo_storagein(StorageInReceiptPO po){
		
		ArrayList<ComGoodsPO> goodspo = po.getGoods();
		ArrayList<ComGoodsVO> goodsvo = new ArrayList<ComGoodsVO>();
		for(int i=0;i<goodspo.size();i++)
			goodsvo.add(new ComGoodsVO(po_to_vo_order(goodspo.get(i).getOrder()),
					goodspo.get(i).getType(),goodspo.get(i).getLine(),goodspo.get(i).getShelf(),
					goodspo.get(i).getCell()));
			
		StorageInReceiptVO vo = new StorageInReceiptVO(goodsvo,po.getID(),po.getDate(),po.getLocation());
		
		return vo;
		
	}
	
    public static StorageInReceiptPO vo_to_po_storagein(StorageInReceiptVO vo){
		
		ArrayList<ComGoodsVO> goodsvo = vo.getList();
		ArrayList<ComGoodsPO> goodspo = new ArrayList<ComGoodsPO>();
		for(int i=0;i<goodsvo.size();i++)
			goodspo.add(new ComGoodsPO(vo_to_po_order(goodsvo.get(i).getOrder()),
					goodsvo.get(i).getType(),goodsvo.get(i).getLine(),goodsvo.get(i).getShelf(),
					goodsvo.get(i).getCell()));
			
		StorageInReceiptPO po = new StorageInReceiptPO(goodspo,vo.getID(),vo.getDate(),vo.getLocation());
		
		return po;
		
	}
	
    public static StorageOutReceiptVO po_to_vo_storageout(StorageOutReceiptPO po){
		
		ArrayList<ComGoodsPO> goodspo = po.getGoods();
		ArrayList<ComGoodsVO> goodsvo = new ArrayList<ComGoodsVO>();
		for(int i=0;i<goodspo.size();i++)
			goodsvo.add(new ComGoodsVO(po_to_vo_order(goodspo.get(i).getOrder()),
					goodspo.get(i).getType(),goodspo.get(i).getLine(),goodspo.get(i).getShelf(),
					goodspo.get(i).getCell()));
			
		StorageOutReceiptVO vo = new StorageOutReceiptVO(goodsvo,po.getID(),po.getDate(),po.getLocation());
		
		return vo;
		
	}
    
    public static StorageOutReceiptPO vo_to_po_storageout(StorageOutReceiptVO vo){
		
		ArrayList<ComGoodsVO> goodsvo = vo.getList();
		ArrayList<ComGoodsPO> goodspo = new ArrayList<ComGoodsPO>();
		for(int i=0;i<goodsvo.size();i++)
			goodspo.add(new ComGoodsPO(vo_to_po_order(goodsvo.get(i).getOrder()),
					goodsvo.get(i).getType(),goodsvo.get(i).getLine(),goodsvo.get(i).getShelf(),
					goodsvo.get(i).getCell()));
			
		StorageOutReceiptPO po = new StorageOutReceiptPO(goodspo,vo.getID(),vo.getDate(),vo.getLocation());
		
		return po;
		
	}
    
    public static ArrivalReceiptVO po_to_vo_arrival(ArrivalReceiptPO po){
    	
    	ArrivalReceiptVO vo = new ArrivalReceiptVO(po.getID(),po.getDate(),po.getFrom(),
    			po.getLocation(),po_to_vo_orderlist(po.getOrderList()));
    	
    	return vo;
    	
    }
    
    public static ArrivalReceiptPO vo_to_po_arrival(ArrivalReceiptVO vo){
    	
    	ArrivalReceiptPO po = new ArrivalReceiptPO(vo.getID(),vo.getDate(),vo.getFrom(),
    			vo.getLocation(),vo_to_po_orderlist(vo.getOrderList()));
    	
    	return po;
    	
    }
    
    public static HallTransferReceiptVO po_to_vo_halltransfer(HallTransferReceiptPO po){
    	
    	HallTransferReceiptVO vo = new HallTransferReceiptVO
    			(po.getID(),po.getLocation(),po.getDate(),
    					po.getHallID(),po.getTransportID(),po.getDestination(),po.getCarID(),
    					po.getSupervisor(),po.getGuard(),po_to_vo_orderlist(po.getOrderlist()));
    	
    	return vo;
    	
    }
    
    public static HallTransferReceiptPO vo_to_po_halltransfer(HallTransferReceiptVO vo){
    	
    	HallTransferReceiptPO po = new HallTransferReceiptPO(vo.getID(), vo.getLocation(),
    			vo.getDate(),vo.getHallID(),vo.getTransportID(),vo.getDestination(),
    			vo.getCarID(),vo.getSupervisor(),vo.getGuard(),
    			vo_to_po_orderlist(vo.getOrderlist()));
    	
    	return po;
    	
    }
    
    public static DeliverReceiptVO po_to_vo_deliver(DeliverReceiptPO po){
    	
    	DeliverReceiptVO vo = new DeliverReceiptVO(po.getID (),po.getDate(),po.getLocation(),
    			po.getDeliver(),po_to_vo_orderlist(po.getOrderList()));
    	
    	return vo;
    	
    }
    
    public static DeliverReceiptPO vo_to_po_deliver(DeliverReceiptVO vo){
    	
    	DeliverReceiptPO po = new DeliverReceiptPO(vo.getID(),vo.getDate(),vo.getLocation(),
    			vo.getDeliver(),vo_to_po_orderlist(vo.getOrderList()));
    	
    	return po;
    	
    }
    
    
    
    
	public static BalancePO vo_to_po_Balance(BalanceVO vo){
		return new BalancePO(vo.getDate(), vo.getMoney(), vo.getName(), vo.getBankAccount(),vo.getItem(), vo.getRemark());
	}
	
	
	
	public static BalanceVO po_to_vo_Balance(BalancePO po){
		return new BalanceVO(po.getDate(), po.getMoney(),  po.getName(), po.getBankAccount(),po.getItem(), po.getRemark());
	}

	
	
	public static PaymentPO vo_to_po_Payment(PaymentVO vo){
		
//		return new PaymentPO(vo.getCreator(), vo.getDate(),vo.getName(),vo.getStatus(), null);
		return null;
	}
	
	
	public static PaymentVO po_to_vo_Payment(PaymentPO po){
		
//		return new PaymentVO(po.getAmount(), null, null, null, null);
		return null;
		
	}
	
	public static CarPO vo_to_po_Car(CarPO vo){
		return new CarPO(vo.getID(),vo.getLicense(),vo.getTime());
	}
	
	
	public static CarVO po_to_vo_Car(CarPO po){
		return new CarVO(po.getID(),po.getLicense(),po.getTime());
	}
	
	public static DriverPO vo_to_po_Driver(DriverVO vo){
		return new DriverPO(vo.getId(), vo.getName(), vo.getBirth(), vo.getIdentity(),vo.getMobile(),vo.getGender(),vo.getTime());
	}
	
	
	public static DriverVO po_to_vo_Driver(DriverPO po){
		return new DriverVO(po.getId(),po.getName(),po.getBirth(),po.getIdentity(),po.getMobile(),po.getGender(),po.getTime());
	}

}

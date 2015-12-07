package businessLogic.Commoditybl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import po.ComGoodsPO;
import po.ComZonePO;
import po.receipts.StorageInReceiptPO;
import po.receipts.StorageOutReceiptPO;
import vo.ComGoodsVO;
import vo.ComZoneVO;
import vo.OrderVO;
import vo.receipts.ArriveReceiptVO;
import vo.receipts.StorageInReceiptVO;
import vo.receipts.StorageOutReceiptVO;
import vo.receipts.TransferReceiptVO;
import dataService.ResultMessage;
import dataService.CommoditydataService.CommoditydataService;
import Miscellaneous.Convert;
import businessLogicService.CommodityblService.CommodityblService;
import businessLogicService.CommodityblService.ExpressType;

public class Commoditybl implements CommodityblService,CommodityInfo, CommodityApproveInfo{
	CommoditydataService commodityDataService;
	StationInfo stationInfo;
	String userID;
	String comID;
	String location;
	
	public Commoditybl(StationInfo stationInfo, String userID){
		this.stationInfo = stationInfo;
		this.userID = userID;
		comID = userID.substring(0, userID.length()-2);
		location = commodityDataService.getLocation(comID);
	}

	public ArrayList<StorageInReceiptVO> viewAllStorageInReceiptSubmitted() {
		// TODO Auto-generated method stub
		ArrayList<StorageInReceiptVO> volist = new ArrayList<StorageInReceiptVO>();
		ArrayList<StorageInReceiptPO> polist = null;
		polist = commodityDataService.getSummitStorageIn();
		for(int i=0;i<polist.size();i++)
			volist.add(Convert.po_to_vo_storagein(polist.get(i)));
		return volist;
	}

	public ResultMessage approveStorageInReceipt(String id) {
		return commodityDataService.approveStorageInReceipt(id);
	}

	public ArrayList<StorageInReceiptVO> viewAllStorageInReceipt() {
		// TODO Auto-generated method stub
		ArrayList<StorageInReceiptVO> volist = new ArrayList<StorageInReceiptVO>();
		ArrayList<StorageInReceiptPO> polist = null;
		polist = commodityDataService.getStorageInReceipt();
		for(int i=0;i<polist.size();i++)
			volist.add(Convert.po_to_vo_storagein(polist.get(i)));
		return volist;
	}

	public ArrayList<StorageOutReceiptVO> viewAllStorageOutReceiptSubmitted() {
		// TODO Auto-generated method stub
		ArrayList<StorageOutReceiptVO> volist = new ArrayList<StorageOutReceiptVO>();
		ArrayList<StorageOutReceiptPO> polist = null;
		polist = commodityDataService.getSummitStorageOut();
		for(int i=0;i<polist.size();i++)
			volist.add(Convert.po_to_vo_storageout(polist.get(i)));
		return volist;
	}

	public ResultMessage approveStorageOutReceipt(String id) {
		return commodityDataService.approveStorageOutReceipt(id);
	}

	public ArrayList<StorageOutReceiptVO> viewAllStorageOutReceipt() {
		// TODO Auto-generated method stub
		ArrayList<StorageOutReceiptVO> volist = new ArrayList<StorageOutReceiptVO>();
		ArrayList<StorageOutReceiptPO> polist = null;
		polist = commodityDataService.getStorageOutReceipt();
		for(int i=0;i<polist.size();i++)
			volist.add(Convert.po_to_vo_storageout(polist.get(i)));
		return volist;
	}

	public ArrayList<ArriveReceiptVO> showArriveReceiptList() {
		// TODO Auto-generated method stub
		return stationInfo.viewApproveArrive(comID);
	}

	public StorageInReceiptVO showStorageInReceipt(ArriveReceiptVO vo)
			throws Exception {
		// TODO Auto-generated method stub
		ArrayList<OrderVO> orderList = vo.getList();
		ArrayList<ComGoodsVO> comGoodsList = new ArrayList<ComGoodsVO>();
		ComZonePO zonePO = null;
		
		zonePO = commodityDataService.getZone(comID);
		
		for(int i=0;i<orderList.size();i++){
			
			ExpressType etype = orderList.get(i).getType();
	        int result[];
			
	        if(etype==ExpressType.FAST)
				result = zonePO.selectCell(1);
			else 
				if(etype==ExpressType.STANDARD)
				    result = zonePO.selectCell(2);
			    else
				    result = zonePO.selectCell(3);
	        
	        if(result[0]==0)
	        	throw new Exception();
	        
	        int type = result[0];
	        int line = result[1]/(zonePO.getCellPerShelf()*zonePO.getShelfPerLine())+1;
	        int shelf = (result[1] - (line-1)*zonePO.getShelfPerLine())/zonePO.getCellPerShelf()+1;
	        int cell = result[1] - (line-1)*zonePO.getCellPerShelf()*zonePO.getShelfPerLine()-(shelf-1)*zonePO.getCellPerShelf();
	        
	        comGoodsList.add(new ComGoodsVO(orderList.get(i),type,line,shelf,cell));
	        
		}
		
		return new StorageInReceiptVO(comGoodsList,(String) commodityDataService.getNextStorageInID(comID),location,Calendar.YEAR+"/"+Calendar.MONTH+"/"+Calendar.DATE);
	}

	public ResultMessage editStorageInReceipt(StorageInReceiptVO vo,
			Object[][] data) {
		// TODO Auto-generated method stub
		ComZonePO comZonePO = null;
		comZonePO = commodityDataService.getZone(comID);
		
		int shelfPerLine = comZonePO.getShelfPerLine();
		int cellPerShelf = comZonePO.getCellPerShelf();
		
		boolean isEmptyPlane[] = comZonePO.getIsEmptyPlane();
		boolean isEmptyTrain[] = comZonePO.getIsEmptyTrain();
		boolean isEmptyCar[] = comZonePO.getIsEmptyCar();
		boolean isEmptyTem[] = comZonePO.getIsEmptyTem();
		
		for(int i=0;i<data.length;i++){
			int index = (Integer.parseInt((String) data[i][2])-1)*shelfPerLine*cellPerShelf+(Integer.parseInt((String) data[i][3])-1)*cellPerShelf+(Integer.parseInt((String) data[i][4])-1);
			String type = (String) data[i][1];
			if(type.equals("航运区"))
				if(isEmptyPlane[index])
					isEmptyPlane[index] = false;
				else
					return ResultMessage.FAILURE;
			if(type.equals("铁运区"))
				if(isEmptyTrain[index])
					isEmptyTrain[index] = false;
				else
					return ResultMessage.FAILURE;
			if(type.equals("汽运区"))
				if(isEmptyCar[index])
					isEmptyCar[index] = false;
				else
					return ResultMessage.FAILURE;
			if(type.equals("机动区"))
				if(isEmptyTem[index])
					isEmptyTem[index] = false;
				else
					return ResultMessage.FAILURE;
		}
		
        vo.setComGoods(data);
		
		return ResultMessage.SUCCESS;
	}

	public void subStorageInReceipt(StorageInReceiptVO vo) {
		// TODO Auto-generated method stub
		ArrayList<ComGoodsVO> goodsvo = vo.getList();
		ArrayList<ComGoodsPO> goodspo = new ArrayList<ComGoodsPO>();
		for(int i=0;i<goodsvo.size();i++)
			goodspo.add(new ComGoodsPO(Convert.vo_to_po_order(goodsvo.get(i).getOrder()),goodsvo.get(i).getType(),goodsvo.get(i).getLine(),goodsvo.get(i).getShelf(),goodsvo.get(i).getCell()));
			
		StorageInReceiptPO po = new StorageInReceiptPO(goodspo,vo.getID(),vo.getDate(),vo.getLocation());
		commodityDataService.addStorageInReceipt(po);
		
	}

	public ArrayList<TransferReceiptVO> showTransferReceiptList() {
		// TODO Auto-generated method stub
		return stationInfo.viewApproveTransfer(comID);
	}

	public StorageOutReceiptVO showStorageOutReceipt(TransferReceiptVO vo) {
		// TODO Auto-generated method stub
		ArrayList<OrderVO> orderList = vo.getList();
		ArrayList<ComGoodsVO> comGoodsList = new ArrayList<ComGoodsVO>();
		
		for(int i=0;i<orderList.size();i++){
			ComGoodsPO goodpo = null;
			goodpo = commodityDataService.getGoods(comID, orderList.get(i).getID());
			ComGoodsVO goodvo = new ComGoodsVO(orderList.get(i),goodpo.getType(),goodpo.getLine(),goodpo.getShelf(),goodpo.getCell());
			comGoodsList.add(goodvo);
		}
		
		return new StorageOutReceiptVO(comGoodsList,commodityDataService.getNextStorageOutID(comID),location,Calendar.YEAR+"/"+Calendar.MONTH+"/"+Calendar.DATE);

	}

	public void subStorageOutReceipt(StorageOutReceiptVO vo) {
		// TODO Auto-generated method stub
		ArrayList<ComGoodsVO> goodsvo = vo.getList();
		ArrayList<ComGoodsPO> goodspo = new ArrayList<ComGoodsPO>();
		for(int i=0;i<goodsvo.size();i++)
			goodspo.add(new ComGoodsPO(Convert.vo_to_po_order(goodsvo.get(i).getOrder()),goodsvo.get(i).getType(),goodsvo.get(i).getLine(),goodsvo.get(i).getShelf(),goodsvo.get(i).getCell()));
			
		StorageOutReceiptPO po = new StorageOutReceiptPO(goodspo,vo.getID(),vo.getDate(),vo.getLocation());
		commodityDataService.addStorageOutReceipt(po);
		
	}

	public ArrayList<ComGoodsVO> showInventory() {
		// TODO Auto-generated method stub
		ArrayList<ComGoodsVO> volist = new ArrayList<ComGoodsVO>();
		ArrayList<ComGoodsPO> polist = null;
		polist = commodityDataService.getComGoods(comID);
		
		for(int i=0;i<polist.size();i++){
			ComGoodsVO vo = new ComGoodsVO(Convert.po_to_vo_order(polist.get(i).getOrder()),polist.get(i).getType(),polist.get(i).getLine(),polist.get(i).getShelf(),polist.get(i).getCell());
			volist.add(vo);
		}	
		return volist;
	}

	public void outputInventory(ArrayList<ComGoodsVO> list) {
		// TODO Auto-generated method stub
		
	}

	public int[] showCheck(String start, String end) {
		// TODO Auto-generated method stub
		int result[] = new int[20];
		for(int i=0;i<20;i++)
			result[i] = 0;
		
		ArrayList<StorageInReceiptPO> storageinlist = commodityDataService.getStorageInReceipt(comID);
		ArrayList<StorageOutReceiptPO> storageoutlist = commodityDataService.getStorageOutReceipt(comID);
		
		for(int i=0;i<storageinlist.size();i++){
			StorageInReceiptPO tempo = storageinlist.get(i);
			if(tempo.getDate().compareTo(end)<=0&&tempo.getDate().compareTo(start)>=0){
				ArrayList<ComGoodsPO> goodslist = tempo.getGoods();
				
				for(int j=0;j<goodslist.size();j++){
					result[0]++;
					ComGoodsPO good = goodslist.get(j);
					result[5]+=good.getOrder().getTotalCost();
					switch(good.getType()){
					case 1:result[1]++;result[6]+=good.getOrder().getTotalCost();break;
					case 2:result[2]++;result[7]+=good.getOrder().getTotalCost();break;
					case 3:result[3]++;result[8]+=good.getOrder().getTotalCost();break;
					case 4:result[4]++;result[9]+=good.getOrder().getTotalCost();break;
					}
				}			
				
			}							
		}
		
		for(int i=0;i<storageoutlist.size();i++){
			StorageOutReceiptPO tempo = storageoutlist.get(i);
			if(tempo.getDate().compareTo(end)<=0&&tempo.getDate().compareTo(start)>=0){
				ArrayList<ComGoodsPO> goodslist = tempo.getGoods();
				
				for(int j=0;j<goodslist.size();j++){
					result[10]++;
					ComGoodsPO good = goodslist.get(j);
					result[15]+=good.getOrder().getTotalCost();
					switch(good.getType()){
					case 1:result[11]++;result[16]+=good.getOrder().getTotalCost();break;
					case 2:result[12]++;result[17]+=good.getOrder().getTotalCost();break;
					case 3:result[13]++;result[18]+=good.getOrder().getTotalCost();break;
					case 4:result[14]++;result[19]+=good.getOrder().getTotalCost();break;
					}
				}			
				
			}							
		}
		
		return result;
	}

	public ComZoneVO showZone() {
		// TODO Auto-generated method stub
		 ArrayList<ComGoodsVO> volist = new ArrayList<ComGoodsVO>();
		   ComZonePO zonepo = null;
		   zonepo = commodityDataService.getZone(comID);
		ArrayList<ComGoodsPO> polist = commodityDataService.getComGoods(comID);
		for(int i=0;i<polist.size();i++){
			ComGoodsPO tempo = polist.get(i);
			volist.add(new ComGoodsVO(Convert.po_to_vo_order(tempo.getOrder()),tempo.getType(),tempo.getLine(),tempo.getShelf(),tempo.getCell()));
		}
		   
			return new ComZoneVO(volist,zonepo.getSpace());
	}

	public ResultMessage editZone(int[] space) {
		// TODO Auto-generated method stub
       ResultMessage result = null;
		
		result = commodityDataService.modifyZone(comID, space);
		
		return result;
	}

	public ResultMessage initZone() {
		// TODO Auto-generated method stub
		 ResultMessage result = null;
			
			result = commodityDataService.initZone(comID);
			
			return result;		
	}

	public ResultMessage moveGoods(Object[][] data) {
		// TODO Auto-generated method stub
		ComZonePO comZonePO = null;
		comZonePO = commodityDataService.getZone(comID);
		
		int shelfPerLine = comZonePO.getShelfPerLine();
		int cellPerShelf = comZonePO.getCellPerShelf();
		
		boolean isEmptyPlane[] = comZonePO.getIsEmptyPlane();
		boolean isEmptyTrain[] = comZonePO.getIsEmptyTrain();
		boolean isEmptyCar[] = comZonePO.getIsEmptyCar();
		boolean isEmptyTem[] = comZonePO.getIsEmptyTem();
		
		for(int i=0;i<isEmptyPlane.length;i++)
			isEmptyPlane[i] = true;
		for(int i=0;i<isEmptyTrain.length;i++)
			isEmptyTrain[i] = true;
		for(int i=0;i<isEmptyCar.length;i++)
			isEmptyCar[i] = true;
		for(int i=0;i<isEmptyTem.length;i++)
			isEmptyTem[i] = true;
		
		for(int i=0;i<data.length;i++){
			int index = (Integer.parseInt((String) data[i][2])-1)*shelfPerLine*cellPerShelf+(Integer.parseInt((String) data[i][3])-1)*cellPerShelf+(Integer.parseInt((String) data[i][4])-1);
			String type = (String) data[i][1];
			if(type.equals("航运区"))
				if(isEmptyPlane[index])
					isEmptyPlane[index] = false;
				else
					return ResultMessage.FAILURE;
			if(type.equals("铁运区"))
				if(isEmptyTrain[index])
					isEmptyTrain[index] = false;
				else
					return ResultMessage.FAILURE;
			if(type.equals("汽运区"))
				if(isEmptyCar[index])
					isEmptyCar[index] = false;
				else
					return ResultMessage.FAILURE;
			if(type.equals("机动区"))
				if(isEmptyTem[index])
					isEmptyTem[index] = false;
				else
					return ResultMessage.FAILURE;
		}
		
		commodityDataService.moveGoods(comID, data);
		
		return ResultMessage.SUCCESS;
	}


}

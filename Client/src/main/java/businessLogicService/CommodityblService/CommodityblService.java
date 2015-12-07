package businessLogicService.CommodityblService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.ComGoodsVO;
import vo.ComZoneVO;
import vo.receipts.ArriveReceiptVO;
import vo.receipts.StorageInReceiptVO;
import vo.receipts.StorageOutReceiptVO;
import vo.receipts.TransferReceiptVO;
import dataService.ResultMessage;

public interface CommodityblService {
	public ArrayList<ArriveReceiptVO> showArriveReceiptList();
	public StorageInReceiptVO showStorageInReceipt(ArriveReceiptVO vo) throws Exception;
	ResultMessage editStorageInReceipt(StorageInReceiptVO vo, Object[][] data);
	public void subStorageInReceipt(StorageInReceiptVO vo);
	
	public ArrayList<TransferReceiptVO> showTransferReceiptList();
	public StorageOutReceiptVO showStorageOutReceipt(TransferReceiptVO vo);
	public void subStorageOutReceipt(StorageOutReceiptVO vo);
	
	public ArrayList<ComGoodsVO> showInventory();
	public void outputInventory(ArrayList<ComGoodsVO> list);
	public int[] showCheck(String start, String end) ;
	
	public ComZoneVO showZone();
	public ResultMessage editZone(int[] space);
	public ResultMessage initZone();
	public ResultMessage moveGoods(Object data[][]);

}

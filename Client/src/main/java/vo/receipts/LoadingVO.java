/**
 * 装车单
 */
package vo.receipts;
import java.util.List;
import Miscellaneous.FormType;
import po.ReceiptPO;
import po.receipts.LoadingPO;
import vo.ReceiptVO;

public class LoadingVO extends ReceiptVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final String date;
	public final String hallId;
	public final String id;
	public final String destination;
	public final String carId;
	public final String supervisor;
	public final String driver;
	public final List<String> order;
	public final String cost;
	
	public LoadingVO(String name, String creator,
					String date,String hallId, 
					String id, String destination, 
					 String carId, String supervisor, 
					 String driver, List<String> order,
					 String cost){
		super(FormType.装车单.name(),name,creator,date);
		this.date = date;
		this.hallId = hallId;
		this.id = id;
		this.destination = destination;
		this.carId = carId;
		this.supervisor = supervisor;
		this.driver = driver;
		this.order = order;
		this.cost = cost;		
	}	
	
	public LoadingVO(LoadingPO po){
		super(FormType.装车单.name(),po.getName(),po.getCreator(),po.getCreateDate());
		this.date = po.getDate();
		this.hallId = po.getHallId();
		this.id = po.getId();
		this.destination = po.getDestination();
		this.carId = po.getCarId();
		this.supervisor = po.getSupervisor();
		this.driver = po.getDriver();
		this.order = po.getOrder();
		this.cost = po.getCost();
	}
	
	public String getDate(){
		return date;
	}
	
	public String getHallId(){
		return hallId;
	}
	
	public String getId(){
		return id;
	}
	
	public String getDestination(){
		return destination;
	}
	
	public String getCarId(){
		return carId;
	}
	
	public String getSupervisor(){
		return supervisor;
	}
	
	public String getDriver(){
		return driver;
	}
	
	public List<String> getOrder(){
		return order;
	}
	
	
	public String getCost(){
		return cost;
	}
	
	public LoadingPO toPO(long receiptId){
		return new LoadingPO(
				receiptId,getName(),getCreator(),
				getDate(),getHallId(),getId(),
				getDestination(),getCarId(),getSupervisor(),
				getDriver(),getOrder(),getCost());
	}
	
	
	
}

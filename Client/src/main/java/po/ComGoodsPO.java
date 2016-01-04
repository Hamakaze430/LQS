package po;

import java.io.Serializable;

public class ComGoodsPO  implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	OrderPO order;
	String id;
	String date;
	int type;
	int line;
	int shelf;
	int cell;
	
	public ComGoodsPO(OrderPO order, int type, int line, int shelf, int cell){
		this.order = order;
		this.type = type;
		this.line = line;
		this.shelf = shelf;
		this.cell = cell;
		this.id = order.id;
		this.date = "";
	}
	
	public OrderPO getOrder(){
		return order;
	}
	
    public int getType(){
    	return type;
    }
    
    public int getLine(){
    	return line;
    }
    
    public int getShelf(){
    	return shelf;
    }
    
    public int getCell(){
    	return cell;
    }
    
    public void setLine(int line){
    	this.line = line;
    }
    
    public void setShelf(int shelf){
    	this.shelf = shelf;
    }
    
    public void setCell(int cell){
    	this.cell = cell;
    }

	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}
	

}

package po;

import java.io.Serializable;

/**
 * Created by admin on 15/10/25.
 */
public class VoucherSearchPO implements Serializable {
    String hall;
    //String date;
    String date;
    double price;

    public String getHall(){
        return hall;
    }

    public String getDate(){
        return date;
    }
    
    public double getPrice(){
    	return price;
    }
}

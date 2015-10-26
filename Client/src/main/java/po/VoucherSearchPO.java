package po;

import java.io.Serializable;

/**
 * Created by admin on 15/10/25.
 */
public class VoucherSearchPO implements Serializable {
    String type;
    String date;

    public String getType(){
        return type;
    }

    public String getDate(){
        return date;
    }
}

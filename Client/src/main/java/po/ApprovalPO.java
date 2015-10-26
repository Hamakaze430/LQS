package po;

import java.io.Serializable;

/**
 * Created by admin on 15/10/25.
 */
public class ApprovalPO implements Serializable {
    private String date;
    private Boolean approved;

    public String getDate(){
        return date;
    }

    public Boolean getState(){
        return approved;
    }

    public void approve(){
        approved=true;
    }

    public void unapprove(){
        approved=false;
    }
}

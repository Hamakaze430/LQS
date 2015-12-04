package dataService.ReceiptsdataService;

import java.rmi.Remote;

public interface ReceiptsdataService extends Remote {

    public String getReceipt(String type);

}

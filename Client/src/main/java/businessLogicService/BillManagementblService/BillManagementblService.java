package businessLogicService.BillManagementblService;

import vo.*;
import java.util.*;

public interface BillManagementblService{
    public String create();

    public String getDate();

    public String getName();

    public ArrayList<UserVO> getWorkers();

    public ArrayList<CarVO> getCars();

    public ArrayList<CommodityVO> getStorage();

    public ArrayList<BankAccountVO> getAccountInfo();

    public void save();

    public void check();

    public void pass();

    public void fail();
}

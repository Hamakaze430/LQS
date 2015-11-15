package businessLogicService.BillManagementblService;

import vo.*;

public interface BillManagementblService {
    public String creat();

    public String getDate();

    public String getName();

    public UserVO getWorkers();

    public CarVO getCars();

    public CommodityVO getStorage();

    public BankAccountVO getAccountInfo();

    public void save();

    public void check();

    public void pass();

    public void fail();
}

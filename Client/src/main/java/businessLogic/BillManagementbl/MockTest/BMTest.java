package businessLogic.BillManagementbl.MockTest;


import po.BillManagementPO;

/**
 * Created by admin on 15/11/15.
 */
public class BMTest {

    public void testCreate(){

        MockInfoGetter mockig=new MockInfoGetter();
        MockBillManagement bm=new MockBillManagement();

        BillManagementPO bmPO=mockig.getAll(bm.create());

        System.out.println(bmPO.getDate()+" "+bmPO.getName());
    }
    
}

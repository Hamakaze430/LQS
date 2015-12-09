package businessLogic.Salesbl.MockTest;

import po.receipts.IncomePO;

import java.util.ArrayList;

public class MockIncomeList{

    ArrayList<IncomePO> income=new ArrayList<IncomePO>();

    public MockIncomeList(String start, String end, MockReceipts mr){
        for(int i=0;i<mr.list.size();i++) {
            if (mr.list.get(i).getClass().equals(IncomePO.class)) {
                String after[] = mr.list.get(i).getCreateDate().split("\\/");
                String s[] = start.split("\\/");
                String e[] = end.split("\\/");
                if (Integer.parseInt(after[0]) > Integer.parseInt(s[0])
                        && Integer.parseInt(after[0]) < Integer.parseInt(e[0])){
                    income.add((IncomePO) mr.list.get(i));
                }
                else if (Integer.parseInt(after[0]) == Integer.parseInt(s[0])){
                    if (Integer.parseInt(after[1]) > Integer.parseInt(s[1]))
                        income.add((IncomePO) mr.list.get(i));
                    else if (Integer.parseInt(after[1]) == Integer.parseInt(s[1])) {
                        if (Integer.parseInt(after[2]) > Integer.parseInt(s[2])) {
                            income.add((IncomePO) mr.list.get(i));
                        }
                    }
                }
                else if (Integer.parseInt(after[0]) == Integer.parseInt(e[0])){
                    if (Integer.parseInt(after[1]) < Integer.parseInt(e[1]))
                        income.add((IncomePO) mr.list.get(i));
                    else if (Integer.parseInt(after[1]) == Integer.parseInt(e[1])) {
                        if (Integer.parseInt(after[2]) < Integer.parseInt(e[2])) {
                            income.add((IncomePO) mr.list.get(i));
                        }
                    }
                }
            }
        }
    }
}

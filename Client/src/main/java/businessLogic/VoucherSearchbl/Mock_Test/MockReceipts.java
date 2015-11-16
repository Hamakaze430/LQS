package businessLogic.VoucherSearchbl.Mock_Test;

import businessLogic.Receiptsbl.Receiptsbl;

public class MockReceipts  extends Receiptsbl{
	String ReceiptsID[]=new String[3];
	String Date[]=new String[3];
	String ReceiptsType[]=new String[3];
	String Hall[]=new String[3];
	double Price[]=new double[3];
	
	public MockReceipts(){
		ReceiptsID[0]="1230000001";
		ReceiptsID[1]="1230000002";
		ReceiptsID[2]="1230000003";
		
		Date[0]="2015/1/1";
		Date[1]="2015/1/1";
		Date[2]="2015/1/1";
		
		ReceiptsType[0]="Voucher";
		ReceiptsType[1]="Voucher";
		ReceiptsType[2]="Voucher";
		
		Hall[0]="025001";
		Hall[1]="025001";
		Hall[2]="025001";
		
		Price[0]=25.5;
		Price[1]=42;
		Price[2]=11.1;
		
		
	}
	
	
	@Override
	public String showVouchers(){
		String str="";
		for(int i=0;i<3;i++){
			if(Date[i]=="2015/1/1"&&ReceiptsType[i]=="Voucher"&&Hall[i]=="025001"){
				str+=ReceiptsID[i]+" "+Price[i]+"\n";
			}
		}
		return str;
	}
	
	@Override
	public double getPrice(){
		double total=0;
		for(int i=0;i<3;i++){
			if(Date[i]=="2015/1/1"&&ReceiptsType[i]=="Voucher"&&Hall[i]=="025001"){
				total+=Price[i];				
			}
		}
		return total;	
	}
	

}

package vo;

public enum ReceiptState {
	未审批(0),
	已通过(1);
	
	private int flag;
	private ReceiptState(int i){
		flag = i;
	}
}

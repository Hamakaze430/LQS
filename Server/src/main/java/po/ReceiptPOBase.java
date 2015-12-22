package po;

import java.io.Serializable;

import Miscellaneous.ReceiptState;


public abstract class ReceiptPOBase extends PersistentObj implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ReceiptState state = ReceiptState.未审批;

	public void approve(){
		this.state = ReceiptState.已通过;
	}
	
	
	public ReceiptState getState() {
		return state;
	}
	
	
}

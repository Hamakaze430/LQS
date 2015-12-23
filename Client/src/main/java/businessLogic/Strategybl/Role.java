package businessLogic.Strategybl;

public enum Role {
	POSTMAN("快递员"), CLERK_STATION("中转中心业务员"), CLERK_HALL("营业厅业务员"),
	STOREKEEPER("中转中心仓库管理员"), ACCOUNTANT("财务人员"), MANAGER("总经理"), 
	ADMINISTRATOR("管理员"), HIGHERFINANCE("高级财务人员"), LOWERFINANCE("低级财务人员"),
	DRIVER("司机"), ;

	String name;

	private Role(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public static Role getRole(String name){
		 for(Role r : values())
	            if(r.getName().equals(name))
	            	return r;
		 throw new IllegalArgumentException();
	}
}

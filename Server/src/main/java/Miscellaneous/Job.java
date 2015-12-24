package Miscellaneous;

public enum Job {
	总经理,
	财务人员,
	营业厅业务员,
	快递员,
	中转中心业务员,
	中转中心仓库管理员,
	管理员;
	
	public static Job value(String s){
		for (Job j : Job.values()){
			if (j.name().equals(s)){
				return j;
			}
		}
		return null;
	}
}

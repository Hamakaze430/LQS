package vo;

public enum State {
	//快递员已收件,到达寄件人营业厅,到达寄件人中转中心,到达收件人中转中心,到达收件人营业厅,派件中,收件人已收件
	快递员已收件("快递员已收件"),到达寄件人营业厅("到达寄件人营业厅"),
	到达寄件人中转中心("到达寄件人中转中心"),到达收件人中转中心("到达收件人中转中心"),
	到达收件人营业厅("到达收件人营业厅"),派件中("派件中"),收件人已收件("收件人已收件");
	
	private String s;
	
	private State(String s){
		this.s = s;
	}
	
	public String toString(){
		return s;
	}
}

package t0921;

//ê°??¥ ?˜ ë§Œë“¤?–´ì§? ëª¨ë¸?? ?–´?–¤ ëª¨ë¸?
//?–´?–¤ ë·°ì—?„œ?‚˜ ?‚¬?š©?•  ?ˆ˜ ?ˆ?Š” ?´?˜?Š¤ ëª¨ë¸
public class Calculator {
	private int su1;
	private int su2;
	private String oper;//?‚¬ì¹? ?—°?‚°?ë¥? ì§?? •
	
	private int result;//ê²°ê³¼ ???¥
	
	public Calculator(int su1, int su2, String oper) {
		super();
		this.su1 = su1;
		this.su2 = su2;
		this.oper = oper;
		choice();
	}
	
	public String getResult(){
		return "°á°ú°ª?: "+su1+oper+su2+"="+result;
	}
	
	public void choice(){
		if(oper.equals("+")) plus();
		else if(oper.equals("-")) minus();
		else if(oper.equals("*")) multi();
		else div();
	}
	
	public void plus(){
		result=su1+su2;
	}
	public void minus(){
		result=su1-su2;
	}
	public void multi(){
		result=su1*su2;
	}
	public void div(){
		result=su1/su2;
	}
}

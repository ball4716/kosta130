package t0930;

public class Book {
	private String title;
	private String author;
	private int price;
	
	public Book() {
		title="JavaWebProgramming";
		author="äȿ��";
		price=30000;
	}
	
	@Override
	public String toString() {
		return "[å����: "+title+", ����:"+author+", ����:"+price+"]";
	}
}

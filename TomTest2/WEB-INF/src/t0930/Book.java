package t0930;

public class Book {
	private String title;
	private String author;
	private int price;
	
	public Book() {
		title="JavaWebProgramming";
		author="채효원";
		price=30000;
	}
	
	@Override
	public String toString() {
		return "[책제목: "+title+", 저자:"+author+", 가격:"+price+"]";
	}
}

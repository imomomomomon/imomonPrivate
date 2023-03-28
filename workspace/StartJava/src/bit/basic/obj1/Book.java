package bit.basic.obj1;

public class Book {
	
	public static void main(String[] args) {
		BookInfo a = new BookInfo();
		BookInfo b = new BookInfo("이도경",100000,"서점","1993-07-07","인생");
		BookInfo c = new BookInfo(b);//복사생성자
		
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
	}
}

class BookInfo {
	private String author;
	private int price;
	private String publisher;
	private String regdate;
	private String bookName;
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public BookInfo() {
		// TODO Auto-generated constructor stub
		this("",0,"","","");
	}
	public BookInfo(String author,int price, String publisher, 
			String regdate, String bookName) {
		// TODO Auto-generated constructor stub
		this.author = author;
		this.price = price;
		this.publisher = publisher;
		this.regdate = regdate;
		this.bookName = bookName;
	}
	public BookInfo(BookInfo obj) {
		this.author = obj.author;
		this.price = obj.price;
		this.publisher = obj.publisher;
		this.regdate = obj.regdate;
		this.bookName = obj.bookName;
	}
	
	@Override
	public String toString() {//alt + shift + s + s
		return "Book [author=" + author + ", price=" + price + ", publisher=" + publisher + ", regdate=" + regdate
				+ ", bookName=" + bookName + "]";
	}
}

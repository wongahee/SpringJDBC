package gahee.spring.vo;

public class Book {
	protected String bookid;
	protected String bookname;
	protected String publisher;
	protected String price;

	public Book() {
	}

	public Book(String bookid, String bookname, String publisher, String price) {
		this.bookid = bookid;
		this.bookname = bookname;
		this.publisher = publisher;
		this.price = price;
	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(bookid).append(" ");
		sb.append(bookname).append(" ");
		sb.append(publisher).append(" ");
		sb.append(price).append("\n");
		
		return sb.toString();
	}
	
}
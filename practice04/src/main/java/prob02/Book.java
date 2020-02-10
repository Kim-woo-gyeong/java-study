package prob02;

public class Book {
	private int bookNo;
	private String title;
	private String author;
	private int stateCode;
	
	public Book( int bookNo, String title, String author ) {
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		this.stateCode = 1; // 1이면 대여가능 대여중이면 0으로 바꿔줌.
	}
	
	public int getBookNo() {
		return bookNo;
	}
	
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getStateCode() {
		return stateCode;
	}
	
	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}
	
	public void rent()
	{
		setStateCode(0);
		System.out.println(getTitle() + "이(가) 대여 됐습니다.");
	}
	
	public static void displayBookInfo(Book[] book)
	{
		for(int i = 0; i < book.length;i++)
		{
			System.out.print("책 제목 : " + book[i].getTitle() +"\t"+ " 작가 : " + book[i].getAuthor() + "\t");
			if(book[i].getStateCode() == 1)
				System.out.println("대여유무 : 재고있음");
			else
				System.out.println("대여유무 : 대여중");
		}
	}

}
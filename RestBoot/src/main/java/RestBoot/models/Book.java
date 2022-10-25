package RestBoot.models;

public class Book {
	private int id;
	private String bName;
	private String bAuthor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbAuthor() {
		return bAuthor;
	}
	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}
	public Book(int id, String bName, String bAuthor) {
		super();
		this.id = id;
		this.bName = bName;
		this.bAuthor = bAuthor;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bName=" + bName + ", bAuthor=" + bAuthor + "]";
	}
	
}

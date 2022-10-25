package RestBoot.dao;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import RestBoot.models.Book;

import java.util.ArrayList;

//this will implement all the different operations for us
@Component
public class BookRepository {
	static List<Book> list=new ArrayList<Book>();
	static {
		list.add(new Book(1,"Fault in our stars","John green"));
		list.add(new Book(2,"The devil and miss prym","Paulo coelho"));
	}
	//method to get all the books
	public List<Book> getAllBooks(){
		return this.list;
	}
	//method to get one book
	public Book getBook(int bookId) {
		//we will try to filter that particular if the id matches
		//or every other book goes again into the list
		try{
			Book book=this.list.stream().filter(b->b.getId()==bookId).findFirst().get();
			return book;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//let us add a book
	public void addBook(Book book) {
		this.list.add(book);
		return;
	}
	//let us delete a book
	public void deleteBook(int bookId) {
		list=list.stream().filter(b->b.getId()!=bookId).collect(Collectors.toList());
		return;
	}
	//let us update the book
	public void change(Book book,int bookId) {
		//i have to update the given bookId with the new information that is in book parameter
		list=list.stream().map(b->{
			if(b.getId()==bookId) {
				b.setbName(book.getbName());
				b.setbAuthor(book.getbAuthor());
			}
			return b;
		}).collect(Collectors.toList());
		return;
	}
}

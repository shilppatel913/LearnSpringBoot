package RestBoot.dao;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import RestBoot.models.Book;

import java.util.ArrayList;

//this will implement all the different operations for us
@Component
public class BookService {
	@Autowired
	private BookRepository bRepo;
	
//	static List<Book> list=new ArrayList<Book>();
//	static {
//		list.add(new Book(1,"Fault in our stars","John green"));
//		list.add(new Book(2,"The devil and miss prym","Paulo coelho"));
//	}
	//method to get all the books
	public List<Book> getAllBooks(){
		return (List<Book>)this.bRepo.findAll();
//		return this.list;
	}
	//method to get one book
	public Book getBook(int bookId) {
		//we will try to filter that particular if the id matches
		//or every other book goes again into the list
		
		Optional<Book> op=this.bRepo.findById(bookId);
		Book book=op.get();
		return book;
		
//		try{
//			Book book=this.list.stream().filter(b->b.getId()==bookId).findFirst().get();
//			return book;
//		}catch(Exception e) {
//			e.printStackTrace();
//			return null;
//		}
	}
	
	//let us add a book
	public void addBook(Book book) {
		this.bRepo.save(book);
//		this.list.add(book);
		return;
	}
	//let us delete a book
	public void deleteBook(int bookId) {
		this.bRepo.deleteById(bookId);
//		list=list.stream().filter(b->b.getId()!=bookId).collect(Collectors.toList());
		return;
	}
	//let us update the book
	public void change(Book book,int bookId) {
		//i have to update the given bookId with the new information that is in book parameter
		Optional<Book> op=this.bRepo.findById(bookId);
		Book bk=op.get();
		bk.setbName(book.getbName());
		bk.setbAuthor(book.getbAuthor());
		this.bRepo.save(bk);
//		list=list.stream().map(b->{
//			if(b.getId()==bookId) {
//				b.setbName(book.getbName());
//				b.setbAuthor(book.getbAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		return;
	}
}

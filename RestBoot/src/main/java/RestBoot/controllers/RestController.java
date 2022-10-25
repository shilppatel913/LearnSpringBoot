package RestBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import RestBoot.dao.BookRepository;
import RestBoot.models.Book;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	private BookRepository bookRepo;
	@GetMapping("/books")
	public List<Book> booksGet() {
		return this.bookRepo.getAllBooks(); //this will return a json response to the client
	}
	
	@GetMapping("/books/{bookId}")
	public Book oneBook(@PathVariable("bookId") int bId) {
		Book book=this.bookRepo.getBook(bId);
		return book;
	}
	
	@PostMapping("/books/add")
	public String bookAdd(@RequestBody Book book) {
		this.bookRepo.addBook(book);
		return "Book has been added successfully";
	}
	
	@DeleteMapping("/books/{bookId}")
	public String bookDelete(@PathVariable("bookId") int bookId) {
		this.bookRepo.deleteBook(bookId);
		return "book has been deleted successfully";
	}
	
	@PutMapping("/books/{bookId}")
	public String bookUpdate(@RequestBody Book book,@PathVariable("bookId") int bId) {
		this.bookRepo.change(book, bId);
		return "The book has been updated successfully";
	}
}

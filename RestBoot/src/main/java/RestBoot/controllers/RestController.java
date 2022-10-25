package RestBoot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import RestBoot.dao.BookService;
import RestBoot.models.Book;

@Component
@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	private BookService bookRepo;
	
	// In the generic type parameter of your Response Entity you pass the return type
	@GetMapping("/books")
	public ResponseEntity<List<Book>> booksGet() {
		List<Book> books =this.bookRepo.getAllBooks(); 
		if(books.size()<=0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.of(Optional.of(books));
	}
	
	@GetMapping("/books/{bookId}")
	public ResponseEntity<Book> oneBook(@PathVariable("bookId") int bId) {
		Book book=this.bookRepo.getBook(bId);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	@PostMapping("/books/add")
	public String bookAdd(@RequestBody Book book) {
		this.bookRepo.addBook(book);
		return "Book has been added successfully";
	}
	
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<String> bookDelete(@PathVariable("bookId") int bookId) {
		try {
			this.bookRepo.deleteBook(bookId);
			return ResponseEntity.of(Optional.of("the book has been deleted successfully"));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@PutMapping("/books/{bookId}")
	public String bookUpdate(@RequestBody Book book,@PathVariable("bookId") int bId) {
		this.bookRepo.change(book, bId);
		return "The book has been updated successfully";
	}
}

package RestBoot.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//now suppose this author was an object then we'd have to apply mapping
// It can unidirectional or bi directional
//you can specify using annotations which kind of mapping do you want
// we can also do bidirectional mapping meaning 
// we can have author in books and vice versa
//The problem is we may end up in an infinite loop when trying to get all the books as
//books will be having author and author will have again all the books and it goes on and on
//so we have to use two annotations to solve this problem
//JsonManageReference in the parent object and JsonBackReference in the child object
//Here books class will be the parent and author will be the class

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "b_id")
	private int id;
	@Column(name = "b_name")
	private String bName;
	//cascade type all means all the values of author will be set and also the table will be created
	//of all the entities which are related to books
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Author bAuthor;
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
	public Author getbAuthor() {
		return bAuthor;
	}
	public void setbAuthor(Author bAuthor) {
		this.bAuthor = bAuthor;
	}
	public Book(int id, String bName, Author bAuthor) {
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

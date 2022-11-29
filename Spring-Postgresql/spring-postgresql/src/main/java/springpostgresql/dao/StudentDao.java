package springpostgresql.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
	//used for data accessing creating inserting deleting and updating table
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//creating the table
	public void create() {
		String query="create table student(id serial primary key,name varchar(255) NOT NULL,city varchar(255))";
		int update=this.jdbcTemplate.update(query);
		System.out.println("Update"+update);
	}
	
	//inserting in the table student
	public void insert(String name,String city) {
		String query="insert into student(name,city) values(?,?)";
		int rows=this.jdbcTemplate.update(query,name,city);
		System.out.println(rows);
	}
}

package bootJPA.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import bootJPA.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	//here we can create custom methods and crudrep will convert into a query by itself
	public List<User> findByuserName(String  name); //findBy(whatever name you have given in User class)
//	public List<User> findByuserNameANDuserCity(String name,String city);
	
	//whatever prefix you apply it will all the names matching to that
	public List<User> findByuserNameStartingWith(String prefix);
	
	
	//you can write a query using @Query Annotation
	
	//jpql syntax
	@Query("select u from User u where u.userName=:n")
	public List<User> q1(@Param("n") String name);
	
	
	//sql syntax
	@Query(value="select * from user where user_name=?1",nativeQuery=true)
	public List<User> q2(String name);
	
}

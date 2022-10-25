package bootJPA;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import bootJPA.dao.UserRepository;
import bootJPA.entities.User;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class BootJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(BootJpaApplication.class, args);
		UserRepository userRepository=context.getBean(UserRepository.class);
		
		
		//create user
//		User user=new User();
//		user.setUserName("Isha Sachdeva");
//		user.setUserCity("Meerut");
//		user.setUserStreet("Mawana road");
//		userRepository.save(user);
//		System.out.println("User saved successfully");
		
//		//get one user
//		Optional<User> optional=userRepository.findById(6);
//		User user=optional.get();
//		System.out.println("Getting the user now"+user);
		
		
//		//getting all the users
//		Iterable<User>itr=userRepository.findAll();
//		itr.forEach(user->{
//			System.out.println(user);
//		});
		
		//updating a user so first get the user and then update
//		Optional<User> optional=userRepository.findById(6);
//		User user=optional.get();
//		user.setUserName("Parul");
//		userRepository.save(user);
//		System.out.println("User updated with the given id"+user);
		
		
		//You can also delete a user
//		userRepository.deleteById(6);
//		System.out.println("The user has been deleted successfully");
		
		//running custom queries
//		List<User> list=userRepository.findByuserName("parul");
//		System.out.println(list);
		
		//running the queries with @Query annotation
		List<User> t1=userRepository.q2("parul");
		System.out.println(t1.get(0).getUserName());
		
		
	}

}

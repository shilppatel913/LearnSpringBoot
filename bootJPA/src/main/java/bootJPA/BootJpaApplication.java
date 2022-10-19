package bootJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import bootJPA.dao.UserRepository;
import bootJPA.entities.User;

@SpringBootApplication
public class BootJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(BootJpaApplication.class, args);
		UserRepository userRepository=context.getBean(UserRepository.class);
		
		User user=new User();
		user.setUserName("Isha Sachdeva");
		user.setUserCity("Meerut");
		user.setUserStreet("Mawana road");
		userRepository.save(user);
		System.out.println("User saved successfully");
	}

}

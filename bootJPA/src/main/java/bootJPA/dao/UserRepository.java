package bootJPA.dao;



import org.springframework.data.repository.CrudRepository;

import bootJPA.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	
	
}

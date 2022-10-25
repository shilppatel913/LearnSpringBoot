package RestBoot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import RestBoot.models.Book;

@Component
public interface BookRepository extends CrudRepository<Book, Integer> {
	//we can make custom methods here

}

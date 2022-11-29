package springpostgresql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springpostgresql.dao.StudentDao;

@SpringBootApplication
public class SpringPostgresqlApplication implements CommandLineRunner {

	@Autowired
	private StudentDao studentDao;
	public static void main(String[] args) {
		SpringApplication.run(SpringPostgresqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		this.studentDao.create(); //table will be created if it does not exist
		this.studentDao.insert("Shilp","Ahmedabad");
		
	}

}

package practica1.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import practica1.model.Person;
import practica1.model.Person.Job;


public interface PersonRepository extends JpaRepository<Person, Long> {
	
	Person findByNameAndLastname(String name, String lastname);	
	Collection<Person> findByLastname(String lastname);
	Collection<Person> findByJob(Job job);
	List<Person> findAll();
}

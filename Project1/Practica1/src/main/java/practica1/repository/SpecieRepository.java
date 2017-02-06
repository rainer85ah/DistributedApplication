package practica1.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import practica1.model.Specie;
import practica1.model.Specie.Type;


public interface SpecieRepository extends JpaRepository<Specie, Long> {
	
	Specie findByName(String name);
	Collection<Specie> findByType(Type type);
	List<Specie> findAll();
}

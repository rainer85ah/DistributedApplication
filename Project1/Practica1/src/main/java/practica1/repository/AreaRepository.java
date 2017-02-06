package practica1.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import practica1.model.Area;


public interface AreaRepository extends JpaRepository<Area, Long> {
	
	Area findByName(String name);
	List<Area> findAll();
}

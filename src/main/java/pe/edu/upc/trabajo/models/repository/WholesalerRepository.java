package pe.edu.upc.trabajo.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.trabajo.models.entities.Wholesaler;
@Repository
public interface WholesalerRepository extends JpaRepository<Wholesaler, Integer> {
	List<Wholesaler> findByName(String name);
	
}

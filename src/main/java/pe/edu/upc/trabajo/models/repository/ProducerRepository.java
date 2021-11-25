package pe.edu.upc.trabajo.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.trabajo.models.entities.Producer;
@Repository
public interface ProducerRepository extends JpaRepository<Producer, Integer> {
	List<Producer> findByNameContaining(String name);
}

package pe.edu.upc.trabajo.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.trabajo.models.entities.TypeShipment;
@Repository
public interface TypeShipmentRepository extends JpaRepository<TypeShipment, Integer> {
	List<TypeShipment> findByName(String name);
}

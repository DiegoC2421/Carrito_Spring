package pe.edu.upc.trabajo.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.trabajo.models.entities.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {
	List<District> findByName(String name);
}

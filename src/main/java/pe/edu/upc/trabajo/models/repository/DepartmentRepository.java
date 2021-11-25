package pe.edu.upc.trabajo.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.trabajo.models.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	List<Department> findByName(String name);
}

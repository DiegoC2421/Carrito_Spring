package pe.edu.upc.trabajo.business.crud;

import java.util.List;

import pe.edu.upc.trabajo.models.entities.Department;

public interface DepartmentService extends CrudService<Department, Integer> {
	List<Department> findByName(String name) throws Exception;
}

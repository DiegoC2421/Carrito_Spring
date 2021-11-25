package pe.edu.upc.trabajo.business.crud;

import java.util.Optional;

import pe.edu.upc.trabajo.models.entities.Category;

public interface CategoryService extends CrudService<Category, Integer> {
	//List<Category> findByName(String name) throws Exception;
	Optional<Category> findByName(String name) throws Exception;

}

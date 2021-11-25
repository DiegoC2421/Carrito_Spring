package pe.edu.upc.trabajo.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.trabajo.models.entities.Category;
import pe.edu.upc.trabajo.models.entities.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByCategory(Category category);
	List<Product> findByName(String name);
	List<Product> findByNameContaining(String name);
	
}

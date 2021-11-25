package pe.edu.upc.trabajo.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.trabajo.business.crud.ProductService;
import pe.edu.upc.trabajo.models.entities.Category;
import pe.edu.upc.trabajo.models.entities.Product;
import pe.edu.upc.trabajo.models.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public JpaRepository<Product, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return productRepository;
	}

	@Override
	public List<Product> findByCategory(Category category) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.findByCategory(category);
	}

	@Override
	public List<Product> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.findByName(name);
	}

	@Override
	public List<Product> findByNameContaining(String name) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.findByNameContaining(name);
	}

	// PARTE CARRITO //
	@Override
	public List<Product> listProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product listById(int id) {
		return productRepository.findById(id).get();
	}
}

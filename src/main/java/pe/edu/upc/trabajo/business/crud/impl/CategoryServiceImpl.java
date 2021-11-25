package pe.edu.upc.trabajo.business.crud.impl;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.trabajo.business.crud.CategoryService;
import pe.edu.upc.trabajo.models.entities.Category;
import pe.edu.upc.trabajo.models.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public JpaRepository<Category, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return categoryRepository;
	}

	@Override
	public Optional<Category> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return categoryRepository.findByName(name);
	}


}

package pe.edu.upc.trabajo.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.trabajo.business.crud.DepartmentService;
import pe.edu.upc.trabajo.models.entities.Department;
import pe.edu.upc.trabajo.models.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public JpaRepository<Department, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return departmentRepository;
	}

	@Override
	public List<Department> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return departmentRepository.findByName(name);
	}

}

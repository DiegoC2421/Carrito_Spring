package pe.edu.upc.trabajo.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.trabajo.business.crud.TypeShipmentService;
import pe.edu.upc.trabajo.models.entities.TypeShipment;
import pe.edu.upc.trabajo.models.repository.TypeShipmentRepository;

@Service
public class TypeShipmentServiceImpl implements TypeShipmentService {

	@Autowired
	private TypeShipmentRepository typeShipmentRepository;
	
	@Override
	public JpaRepository<TypeShipment, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return typeShipmentRepository;
	}

	@Override
	public List<TypeShipment> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return typeShipmentRepository.findByName(name);
	}

}

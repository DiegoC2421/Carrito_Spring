package pe.edu.upc.trabajo.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.trabajo.business.crud.TypePaymentService;
import pe.edu.upc.trabajo.models.entities.TypePayment;
import pe.edu.upc.trabajo.models.repository.TypePaymentRepository;

@Service
public class TypePaymentServiceImpl implements TypePaymentService {

	@Autowired
	private TypePaymentRepository typePaymentRepository;
	
	@Override
	public JpaRepository<TypePayment, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return typePaymentRepository;
	}

	@Override
	public List<TypePayment> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return typePaymentRepository.findByName(name);
	}

}

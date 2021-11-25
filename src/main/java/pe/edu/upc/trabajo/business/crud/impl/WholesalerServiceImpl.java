package pe.edu.upc.trabajo.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.trabajo.business.crud.WholesalerService;
import pe.edu.upc.trabajo.models.entities.Wholesaler;
import pe.edu.upc.trabajo.models.repository.WholesalerRepository;

@Service
public class WholesalerServiceImpl implements WholesalerService {

	@Autowired
	private WholesalerRepository wholesalerRepository;
	
	@Override
	public JpaRepository<Wholesaler, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return wholesalerRepository;
	}

	@Override
	public List<Wholesaler> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return wholesalerRepository.findByName(name);
	}

}

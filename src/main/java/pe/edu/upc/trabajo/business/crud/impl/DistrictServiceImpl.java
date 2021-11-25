package pe.edu.upc.trabajo.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.trabajo.business.crud.DistrictService;
import pe.edu.upc.trabajo.models.entities.District;
import pe.edu.upc.trabajo.models.repository.DistrictRepository;

@Service
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	private DistrictRepository districtRepository;
	
	@Override
	public JpaRepository<District, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return districtRepository;
	}

	@Override
	public List<District> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return districtRepository.findByName(name);
	}

}

package pe.edu.upc.trabajo.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.trabajo.business.crud.StatusService;
import pe.edu.upc.trabajo.models.entities.Status;
import pe.edu.upc.trabajo.models.repository.StatusRepository;

@Service
public class StatusServiceImpl implements StatusService {

	@Autowired
	private StatusRepository statusRepository;
	
	@Override
	public JpaRepository<Status, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return statusRepository;
	}

}

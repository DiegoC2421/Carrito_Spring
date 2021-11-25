package pe.edu.upc.trabajo.business.crud;

import java.util.List;

import pe.edu.upc.trabajo.models.entities.Producer;

public interface ProducerService extends CrudService<Producer, Integer> {
	List<Producer> findByNameContaining(String name) throws Exception;
}

package pe.edu.upc.trabajo.business.crud;

import java.util.List;

import pe.edu.upc.trabajo.models.entities.Wholesaler;

public interface WholesalerService extends CrudService<Wholesaler, Integer> {
	List<Wholesaler> findByName(String name) throws Exception;
}

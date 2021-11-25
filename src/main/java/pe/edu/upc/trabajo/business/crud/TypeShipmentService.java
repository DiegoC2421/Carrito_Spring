package pe.edu.upc.trabajo.business.crud;

import java.util.List;

import pe.edu.upc.trabajo.models.entities.TypeShipment;

public interface TypeShipmentService extends CrudService<TypeShipment, Integer> {
	List<TypeShipment> findByName(String name) throws Exception;
}

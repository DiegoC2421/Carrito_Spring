package pe.edu.upc.trabajo.business.crud;

import java.util.List;

import pe.edu.upc.trabajo.models.entities.District;

public interface DistrictService extends CrudService<District, Integer> {
	List<District> findByName(String name) throws Exception;
}

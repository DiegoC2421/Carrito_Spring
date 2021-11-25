package pe.edu.upc.trabajo.business.crud;

import java.util.List;

import pe.edu.upc.trabajo.models.entities.TypePayment;

public interface TypePaymentService extends CrudService<TypePayment, Integer> {
	List<TypePayment> findByName(String name) throws Exception;

}

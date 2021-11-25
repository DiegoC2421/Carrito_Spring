package pe.edu.upc.trabajo.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.trabajo.models.entities.TypePayment;
@Repository
public interface TypePaymentRepository extends JpaRepository<TypePayment, Integer> {
	List<TypePayment> findByName(String name);
}

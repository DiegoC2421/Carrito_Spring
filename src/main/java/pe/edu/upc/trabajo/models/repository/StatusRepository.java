package pe.edu.upc.trabajo.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.trabajo.models.entities.Order;
import pe.edu.upc.trabajo.models.entities.Status;
@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
	//List<Order> findByOrderIdOrderById(int orderId);
}

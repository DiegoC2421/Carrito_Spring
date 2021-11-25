package pe.edu.upc.trabajo.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.trabajo.models.entities.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	List<Order> findByUserId(int id);
	Order findByPaidAndUserId(boolean paid, int userId);
}

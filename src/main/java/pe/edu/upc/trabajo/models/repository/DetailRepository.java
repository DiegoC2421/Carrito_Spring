package pe.edu.upc.trabajo.models.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.trabajo.models.entities.Detail;
@Repository
public interface DetailRepository extends JpaRepository<Detail, Integer> {
	List<Detail> findByOrderIdOrderById(int orderId);
}

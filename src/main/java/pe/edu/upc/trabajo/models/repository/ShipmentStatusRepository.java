package pe.edu.upc.trabajo.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.trabajo.models.entities.ShipmentStatus;
@Repository
public interface ShipmentStatusRepository extends JpaRepository<ShipmentStatus, Integer>{
	//List<ShipmentStatus> findByStatus(Status status);
	List<ShipmentStatus> findByOrderIdOrderById(int orderId);
}

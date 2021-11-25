package pe.edu.upc.trabajo.business.crud;

import java.util.List;

import pe.edu.upc.trabajo.models.entities.Detail;
import pe.edu.upc.trabajo.models.entities.Order;

public interface OrderService {
	List<Order> listOrdersByUserId(int id);
	public Order listActualOrder(int userId);
	public void createFirstOrder(Order order);
	public void addOrderDetail(Detail detail);
	public void payOrderActive(Order order);
	
	public Detail getOrderDetailById(int id);
	public void updateOrderDetailQuantity(int id, int quantity);
	public List<Detail> listActualOrderOrderByOrderDetailId(int userId);
	
//	List<Order> findByUserId(int id);
//	Order findByPaidAndUserId(boolean paid, int userId);
	
}

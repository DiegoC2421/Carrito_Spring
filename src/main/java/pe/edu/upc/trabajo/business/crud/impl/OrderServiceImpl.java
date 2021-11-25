package pe.edu.upc.trabajo.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.trabajo.business.crud.OrderService;
import pe.edu.upc.trabajo.models.entities.Detail;
import pe.edu.upc.trabajo.models.entities.Order;
import pe.edu.upc.trabajo.models.repository.DetailRepository;
import pe.edu.upc.trabajo.models.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private DetailRepository detailRepository;
	
	@Override
	public List<Order> listOrdersByUserId(int userId) {
		return orderRepository.findByUserId(userId);
	}
	
	@Override
	public Order listActualOrder(int userId) {
		return orderRepository.findByPaidAndUserId(false, userId);
	}
	
	@Override
	public List<Detail> listActualOrderOrderByOrderDetailId(int userId) {
		Order orderAux = orderRepository.findByPaidAndUserId(false, userId);
		List<Detail> orderDetailsList = detailRepository.findByOrderIdOrderById(orderAux.getId());
		return orderDetailsList;
	}
	
	@Override
	public void addOrderDetail(Detail detail) {
		detailRepository.save(detail);
	}
	
	@Override
	public void createFirstOrder(Order order) {
		orderRepository.save(order);
	}

	@Override
	public void payOrderActive(Order order) {
		order.setPaid(true);
		orderRepository.save(order);
		
		Order orderAux = new Order();
		orderAux.setPaid(false);
		orderAux.setUser(order.getUser());
		orderRepository.save(orderAux);
	}

	@Override
	public Detail getOrderDetailById(int id) {
		Detail orderDetailAux = detailRepository.findById(id).get();
		return orderDetailAux;
	}

	@Override
	public void updateOrderDetailQuantity(int id, int quantity) {
		Detail orderDetailAux = detailRepository.findById(id).get();
		orderDetailAux.setQuantity(quantity);
		detailRepository.save(orderDetailAux);
	}

//	@Override
//	public JpaRepository<Order, Integer> getJpaRepository() {
//		// TODO Auto-generated method stub
//		return orderRepository;
//	}
	
	/*@Override
	public JpaRepository<Order, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return orderRepository;
	}

	@Override
	public List<Order> findByDate(Date date) throws Exception {
		// TODO Auto-generated method stub
		return orderRepository.findByDate(date);
	}*/

}

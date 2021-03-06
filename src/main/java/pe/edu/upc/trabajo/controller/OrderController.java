package pe.edu.upc.trabajo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.trabajo.business.crud.OrderService;
import pe.edu.upc.trabajo.business.crud.ProductService;
import pe.edu.upc.trabajo.business.crud.TypePaymentService;
import pe.edu.upc.trabajo.business.crud.TypeShipmentService;
import pe.edu.upc.trabajo.models.entities.Detail;
import pe.edu.upc.trabajo.models.entities.Order;
import pe.edu.upc.trabajo.models.entities.Product;
import pe.edu.upc.trabajo.models.entities.User;

//import com.example.demo.model.Order;
//import com.example.demo.model.OrderDetail;
//import com.example.demo.model.Product;
//
//import com.example.demo.model.User;
//
//import com.example.demo.service.OrderService;
//import com.example.demo.service.ProductService;

@Controller
@RequestMapping("/order")
@SessionAttributes("userSession")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private TypePaymentService typePaymentService;
	
	@Autowired
	private TypeShipmentService typeShipmentService;
	
	@RequestMapping("/")
	public String GolistActualOrder(Map<String, Object> model, @ModelAttribute("userSession") User userSession) {
		model.put("listOrders", orderService.listOrdersByUserId(userSession.getId()));
		return "listOrders";
	}
	
	@RequestMapping("/listOrders")
	public String listOrders(Map<String, Object> model, @ModelAttribute("userSession") User userSession) {
		model.put("listOrders", orderService.listOrdersByUserId(userSession.getId()));
		return "listOrders";
	}
	
	@RequestMapping("/listActualOrder") // Cart
	public String listActualOrder(Map<String, Object> model, @ModelAttribute("userSession") User userSession) {
		Order orderAux = orderService.listActualOrder(userSession.getId());
		model.put("listOrdersDetail", orderService.listActualOrderOrderByOrderDetailId(userSession.getId()));
		return "listOrdersDetail";
	}
	
	@RequestMapping("/addToActualOrder") // Cart
	public String addToActualOrder(Map<String, Object> model,
			@ModelAttribute("userSession") User userSession,
			@RequestParam(value = "productId") Integer productId){
		
		Order orderAux = orderService.listActualOrder(userSession.getId());
		Detail orderDetailAux = new Detail();
		Product productAux = productService.listById(productId);
		
		orderDetailAux.setProduct(productAux);
		orderDetailAux.setQuantity(1); // Para cambiar esto, agregar otro @RequestParam con la cantidad
		orderDetailAux.setOrder(orderAux);
		
		orderService.addOrderDetail(orderDetailAux);
		
		model.put("listOrdersDetail", orderService.listActualOrderOrderByOrderDetailId(userSession.getId()));
		return "listOrdersDetail";
	}
	
	@RequestMapping("/pay") // Cart
	public String pay(Map<String, Object> model, @ModelAttribute("userSession") User userSession) {
		Order orderAux = orderService.listActualOrder(userSession.getId());
		orderService.payOrderActive(orderAux);		
		orderAux = orderService.listActualOrder(userSession.getId());
		model.put("listOrdersDetail", orderService.listActualOrderOrderByOrderDetailId(userSession.getId()));
		return "listOrdersDetail";
	}
	
	@RequestMapping("/add1") // Cart
	public String add1(Map<String, Object> model,
			@ModelAttribute("userSession") User userSession,
			@RequestParam(value = "odId") Integer odId) {
		
		Detail orderDetailAux = orderService.getOrderDetailById(odId);
		orderService.updateOrderDetailQuantity(odId, orderDetailAux.getQuantity() + 1);
		model.put("listOrdersDetail", orderService.listActualOrderOrderByOrderDetailId(userSession.getId()));
		return "listOrdersDetail";
	}
	
	@RequestMapping("/remove1") // Cart
	public String remove1(Map<String, Object> model,
			@ModelAttribute("userSession") User userSession,
			@RequestParam(value = "odId") Integer odId) {
				
		Detail orderDetailAux = orderService.getOrderDetailById(odId);
		orderService.updateOrderDetailQuantity(odId, orderDetailAux.getQuantity() - 1);
		model.put("listOrdersDetail", orderService.listActualOrderOrderByOrderDetailId(userSession.getId()));
		return "listOrdersDetail";
	}
	
//	@RequestMapping("/listar")
//	public String listar(Map<String, Object> model) {
//		model.put("listaDuenos", typePaymentService.listar());
//		return "listDueno";
//	}	
	
//	@RequestMapping("/listOrders")
//	public String listOrders(Map<String, Object> model, @ModelAttribute("userSession") User userSession) {
//		
//		model.put("listOrders", orderService.listOrdersByUserId(userSession.getId()));
//		return "listOrders";
//	}
	
}

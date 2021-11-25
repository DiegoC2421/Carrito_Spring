package pe.edu.upc.trabajo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.trabajo.business.crud.OrderService;
import pe.edu.upc.trabajo.business.crud.ProducerService;
import pe.edu.upc.trabajo.business.crud.ProductService;
import pe.edu.upc.trabajo.models.entities.Producer;
import pe.edu.upc.trabajo.models.entities.Product;
import pe.edu.upc.trabajo.models.entities.ShipmentStatus;
import pe.edu.upc.trabajo.models.entities.Detail;
import pe.edu.upc.trabajo.models.entities.Order;
import pe.edu.upc.trabajo.utils.Carrito;
import pe.edu.upc.trabajo.utils.ProductSearch;

@Controller
@RequestMapping("/mayorista")
/*
 * es la carpeta raiz, si se crea otra carpeta de de escribe
 * "/nombreDeLaCarpeta "
 */
public class MayoristaController {

	@Autowired
	private ProductService productService; // postService;

	@Autowired
	private OrderService orderService;

//	@Autowired
//	private DetailService orderDetailService;
//	
//	@Autowired 
//	private ShipmentStatusService shipmentStatusService;
	

	/*
	 * 
	 * @GetMapping("producerView") // request public String dashboard(Model model) {
	 * ProductSearch productSearch = new ProductSearch();
	 * 
	 * try { List<Producer> producers = producerService.getAll();
	 * model.addAttribute("producer",producers); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * model.addAttribute("productSearch", productSearch); return
	 * "productores/producerView"; }
	 */

	List<Carrito> listarCarrito = new ArrayList<>();
	Carrito car;

	int item;
	double totalPagar = 0;
	int cantidad = 1;

	@GetMapping("order") // request
	public String order(Model model/* , @PathVariable("id")Integer id */) {
		// id=Integer.parseInt(id);
		ProductSearch productSearch = new ProductSearch();
		/*
		 * try { totalPagar=0; Optional<Product> productOptional =
		 * productService.findById(id); Product product=productOptional.get();
		 * item=item+1; car=new Carrito(); car.setItem(item);
		 * car.setIdProducto(product.getProduct()); car.setNombre(product.getName());
		 * car.setDescription(product.getDescription());
		 * car.setPrecio(product.getPrice()); car.setCantidad(cantidad);
		 * car.setMonto(cantidad*product.getPrice()); listarCarrito.add(car); for(int
		 * i=0;i>listarCarrito.size();i++ ) {
		 * totalPagar+=listarCarrito.get(i).getPrecio(); }
		 * model.addAttribute("totalPagar",totalPagar);
		 * model.addAttribute("listarCarrito",listarCarrito);
		 * model.addAttribute("listarCarrito",listarCarrito.size());
		 * //model.addAttribute("producers", producers); } catch (Exception e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		model.addAttribute("productSearch", productSearch);
		return "mayorista/order";
	}

	@GetMapping("{id}/compra") // request
	public String compra(Model model, @PathVariable("id") Integer id) {
		ProductSearch productSearch = new ProductSearch();
		model.addAttribute("productSearch", productSearch);
		try {
			Optional<Product> product = productService.findById(id);
			// List<Review> reviews = reviewService.getAll();
			model.addAttribute("compra", product.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "mayorista/compra";
	}
	
	/*
	@GetMapping("shipment")
	public String shipmentList(Model model) {
		ProductSearch productSearch = new ProductSearch();
		model.addAttribute("productSearch", productSearch);
		try {
			List<ShipmentStatus> shipmentStatuses= shipmentStatusService.getAll();
			model.addAttribute("shipmentStatuses", shipmentStatuses);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "mayorista/view-shipment";
	}*/
	

	
/*
	@PostMapping("calculoPrecio")
	public String save(Model model, @ModelAttribute("compra") Product product,
			@PathVariable("cantidadProduct")Integer cantidad ) {
		Integer montototal=0;
		ProductSearch productSearch = new ProductSearch();
		model.addAttribute("productSearch", productSearch);
	
		//System.out.println(post.getName());
		//System.out.println(post.getDescription());
		//System.out.println(post.getDate());
		//System.out.println(post.getProduct());
		//System.out.println(post.getUser());
		montototal=(int) (cantidad*product.getPrice());
		try {				
			//Post postSave = postService.update(post);		
			model.addAttribute("montoTotal",montototal);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/mayorista/compra";
	}*/
	
	@GetMapping("{id}/detail") // request
	public String compraDetail(Model model, @PathVariable("id") Integer id) {
		ProductSearch productSearch = new ProductSearch();
		model.addAttribute("productSearch", productSearch);
		try {
			//List<Order> orders = orderService.getAll();
			//model.addAttribute("orders", orders);
			Optional<Product> product = productService.findById(id);
			Product products=product.get();
			
			//Optional<Detail> detail = orderDetailService.findById(products.getProduct());
			//model.addAttribute("detail", detail.get());
			
			//Optional<Product> product = productService.findById(id);
			// List<Review> reviews = reviewService.getAll();
			//model.addAttribute("compra", product.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "mayorista/view-order";
	}
	
	
	/*@GetMapping("Detail") // request
	public String orderDetail(Model model) {
		ProductSearch productSearch = new ProductSearch();
		try {
			List<Order> orders = orderService.getAll();
			model.addAttribute("orders", orders);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("productSearch", productSearch);
		return "mayorista/view-order";
	}*/

	@GetMapping("status") // request
	public String Status(Model model) {
		ProductSearch productSearch = new ProductSearch();

		model.addAttribute("productSearch", productSearch);
		return "mayorista/shipmentStatus";
	}
	
//	@GetMapping("error")
//	public String index2(Model model) {
//		ProductSearch productSearch = new ProductSearch();
//		model.addAttribute("productSearch", productSearch);
//		return "error";
//	}
	
	
	/*
	@GetMapping("viewShipment/{id}")	// request
	public String Shipment(Model model, @PathVariable("id") ShipmentStatusId id) {
		ProductSearch productSearch = new ProductSearch();
		
		try {
			Optional<ShipmentStatus> shipmentStatuses= shipmentStatusService.findById(id);
			//List<Review> reviews = reviewService.getAll();
			model.addAttribute("shipmentStatuses",shipmentStatuses.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("productSearch", productSearch);
		return "mayorista/view-error";
	}*/

}

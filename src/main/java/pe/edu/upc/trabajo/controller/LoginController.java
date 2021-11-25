package pe.edu.upc.trabajo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.trabajo.business.crud.OrderService;
import pe.edu.upc.trabajo.business.crud.UserService;
import pe.edu.upc.trabajo.models.entities.Order;
import pe.edu.upc.trabajo.models.entities.User;

@Controller
@SessionAttributes("userSession")
public class LoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/")
	public String goLogin(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(@ModelAttribute User user,
			BindingResult binRes, HttpServletRequest request,
			Model model) {
		User userAux = userService.findByUsername(user.getUsername());
		model.addAttribute("userSession", userAux);
		
		if(orderService.listOrdersByUserId(userAux.getId()).isEmpty()) {
			Order orderAux = new Order();
			orderAux.setPaid(false);
			orderAux.setUser(userAux);
			orderService.createFirstOrder(orderAux);
			System.out.print("Llegó a crear");
		}
				
		return "redirect:/product/listProducts";
	}
}

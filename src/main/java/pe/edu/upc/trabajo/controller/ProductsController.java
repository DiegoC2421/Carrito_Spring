package pe.edu.upc.trabajo.controller;
/*
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.trabajo.business.crud.CategoryService;
import pe.edu.upc.trabajo.business.crud.ProductService;
import pe.edu.upc.trabajo.business.crud.UserService;
import pe.edu.upc.trabajo.models.entities.Category;
import pe.edu.upc.trabajo.models.entities.Product;
import pe.edu.upc.trabajo.models.entities.User;


@Controller
@SessionAttributes("product")
@RequestMapping("/productor")// es la carpeta raiz, si se crea otra carpeta
//de de escribe "/nombreDeLaCarpeta "/
public class ProductsController {

	@Autowired 
	private ProductService productService;
	@Autowired 
	private CategoryService categoryService;
	@Autowired 
	private UserService userService;
	
	@GetMapping("product-list")	// request
	public String productlist(Model model) {	
		try {
			List<Product> products=productService.getAll();
			model.addAttribute("productos",products);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "productor/product-list";
	}
	
	@GetMapping("{id}/productedit")
	public String editProduct(Model model, @PathVariable("id") Integer id) {
		try {
			if(productService.existsById(id)) {
				Optional<Product> optional = productService.findById(id);
				List<Category> categories = categoryService.getAll();
				List<User> users= userService.getAll();
				model.addAttribute("product", optional.get());
				model.addAttribute("category", categories);
				model.addAttribute("users", users);
			} else {
				return "redirect:/productor";
			}		
		} catch (Exception e) {
			// TODO: handle exception
		}	
		return "productor/productedit";
	}
	@GetMapping("{id}/delete")
	public String deleteProduct(Model model, @PathVariable("id") Integer id) {
		try {
			if(productService.existsById(id)) {
				productService.deleteById(id);
			} else {
				return "redirect:/productor/product-list";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		return "redirect:/productor/product-list";
		
	}
	
	
	@PostMapping("saveProduct")
	public String saveProduct(Model model, @ModelAttribute("product") Product product ) {
		
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		System.out.println(product.getStock());
		System.out.println(product.getCategory().getName());
		System.out.println(product.getUser().getCompany());
		try {				
			Product productSave = productService.update(product);		
			model.addAttribute("product", productSave);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/productor/product-list";
	}
	
	
	
	@GetMapping("newProduct")	// request
	public String newProduct(Model model) {
		try {	
				List<Category> categories = categoryService.getAll();
				List<User> users= userService.getAll();
				model.addAttribute("category", categories);
				model.addAttribute("users", users);
				model.addAttribute("product",new Product());
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return "productor/newProduct";
	}
	

	@PostMapping("saveNewProduct")
	public String saveNew(Model model, @Valid @ModelAttribute("product") Product product, 
			BindingResult result) {
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		System.out.println(product.getStock());
		System.out.println(product.getCategory().getName());
		System.out.println(product.getUser().getCompany());
		try {
			Product productSave = productService.create(product);		
			model.addAttribute("product", productSave);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/productor/product-list";
	}

	
}*/
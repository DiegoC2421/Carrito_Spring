package pe.edu.upc.trabajo.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.trabajo.business.crud.ProducerService;
import pe.edu.upc.trabajo.business.crud.ProductService;
import pe.edu.upc.trabajo.models.entities.Category;
import pe.edu.upc.trabajo.models.entities.Producer;
import pe.edu.upc.trabajo.models.entities.Product;
import pe.edu.upc.trabajo.utils.ProductSearch;

/*
@Controller
@RequestMapping("/")// es la carpeta raiz, si se crea otra carpeta
//de de escribe "/nombreDeLaCarpeta "/
@SessionAttributes("{productSearch}")

public class FrontController {

	@Autowired 
	private ProductService productService; //postService;
	
	@Autowired 
	private ProducerService producerService;
	
	
	@GetMapping
	public String index(Model model) {
	ProductSearch productSearch = new ProductSearch();
		try {
			List<Product> products = productService.getAll();
			List<Producer> producers=producerService.getAll();
			model.addAttribute("producers",producers);
			model.addAttribute("products",products);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("productSearch", productSearch);
		return "index";
	}

	@GetMapping("team")	// request
	public String team(Model model) {
		ProductSearch productSearch = new ProductSearch();
		model.addAttribute("productSearch", productSearch);
		return "team";
	}
	
	@GetMapping("productos")	// request
	public String ProducerView(Model model) {
		//ProductSearch productSearch = new ProductSearch();
		try {
			List<Product> products= productService.getAll();
			model.addAttribute("products",products);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//model.addAttribute("productSearch", productSearch);
		return "productos";
	}
}
*/

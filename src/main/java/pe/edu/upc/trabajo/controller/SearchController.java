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

import pe.edu.upc.trabajo.business.crud.CategoryService;
import pe.edu.upc.trabajo.business.crud.ProductService;
import pe.edu.upc.trabajo.models.entities.Category;
import pe.edu.upc.trabajo.models.entities.Detail;
import pe.edu.upc.trabajo.models.entities.Product;
import pe.edu.upc.trabajo.utils.ProductSearch;

@Controller
@RequestMapping("/searches")
public class SearchController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("product")
	public String searchEmployees(Model model, @ModelAttribute("productSearch") ProductSearch productSearch) {

		List<Product> products = new ArrayList<>();

		try {
			products = productService.findByNameContaining(productSearch.getName());
			List<Category> category = categoryService.getAll();
			model.addAttribute("category", category);

		} catch (Exception e) {
			// TODO: handle exception
		}

		model.addAttribute("products", products);

		return "searches/productsView";
	}


	@GetMapping("{name}/searchCategory") // request
	public String Busqueda(Model model, @PathVariable("name") String name) {
		ProductSearch productSearch = new ProductSearch();
		List<Product> products = new ArrayList<>();
		try {
			Optional<Category> category = categoryService.findByName(name);
			Category categories = category.get();
			products = productService.findByName(categories.getName());
			// Optional<Review> reviews = reviewService.findByNme();
			// List<Review> reviews = reviewService.getAll();
			model.addAttribute("products", products);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("productSearch", productSearch);
		return "redirect:/searches/productsView";

	}
	/*
	 * @GetMapping("{}/detail") // request public String compraDetail(Model
	 * model, @PathVariable("id") Integer id) { ProductSearch productSearch = new
	 * ProductSearch(); model.addAttribute("productSearch", productSearch); try {
	 * 
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return "mayorista/view-order"; }
	 */

}

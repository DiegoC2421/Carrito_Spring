package pe.edu.upc.trabajo.controller;

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

import pe.edu.upc.trabajo.business.crud.ProducerService;
import pe.edu.upc.trabajo.business.crud.ProductService;
import pe.edu.upc.trabajo.models.entities.Producer;
import pe.edu.upc.trabajo.models.entities.Product;
import pe.edu.upc.trabajo.utils.ProductSearch;


@Controller
@SessionAttributes("post")
@RequestMapping("/productores")// es la carpeta raiz, si se crea otra carpeta
//de de escribe "/nombreDeLaCarpeta "/
public class ProducerController {

	

	@Autowired 
	private ProductService productService;
	
	@Autowired 
	private ProducerService producerService; //postService;

	
	
	@GetMapping("producerView")	// request
	public String ProducerView(Model model) {
		ProductSearch productSearch = new ProductSearch();
		
		try {
			List<Producer> producers = producerService.getAll();
			model.addAttribute("producers",producers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("productSearch", productSearch);
		return "productores/producerView";
	}
	
//	@GetMapping("{id}/viewReview")	// request
//	public String Comentario(Model model, @PathVariable("id") Integer id) {
//		ProductSearch productSearch = new ProductSearch();
//		
//		try {
//			Optional<Review> reviews = reviewService.findById(id);
//			//List<Review> reviews = reviewService.getAll();
//			model.addAttribute("review",reviews.get());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		model.addAttribute("productSearch", productSearch);
//		return "productores/viewReview";
//	}	
	
//	@GetMapping("upgrade/{id}")	// request
//	public String upgrade(Model model, @PathVariable("id") Integer id) {
//		ProductSearch productSearch = new ProductSearch();
//		
//		try {
//			Optional<Review> reviews = reviewService.findById(id);
//			//List<Review> reviews = reviewService.getAll();
//			model.addAttribute("review",reviews.get());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		model.addAttribute("productSearch", productSearch);
//		return "productores/upgrade";
//	}	
//	
//	@GetMapping("downgrade/{id}")	// request
//	public String downgrade(Model model, @PathVariable("id") Integer id) {
//		ProductSearch productSearch = new ProductSearch();
//		
//		try {
//			Optional<Review> reviews = reviewService.findById(id);
//			//List<Review> reviews = reviewService.getAll();
//			model.addAttribute("review",reviews.get());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		model.addAttribute("productSearch", productSearch);
//		return "productores/downgrade";
//	}	
/*	
 * @GetMapping("{id}/postedit")
	public String edit(Model model, @PathVariable("id") Integer id) {
		try {
			if(postService.existsById(id)) {
				Optional<Post> optional = postService.findById(id);
				List<Product> products = productService.getAll();
				List<User> users= userService.getAll();
				model.addAttribute("post", optional.get());
				model.addAttribute("products", products);
				model.addAttribute("users", users);
			} else {
				return "redirect:/productor";
			}		
		} catch (Exception e) {
			// TODO: handle exception
		}	
		return "productor/postedit";
	}
	@GetMapping("publication")	// request
	public String publication(Model model) {	
		try {
			List<Post> posts=postService.getAll();
			model.addAttribute("posts",posts);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "productor/publication";
	}
	

	
	
	@GetMapping("{id}/del")
	public String delete(Model model, @PathVariable("id") Integer id) {
		try {
			if(postService.existsById(id)) {
				postService.deleteById(id);
			} else {
				return "redirect:/productor/publication";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		return "redirect:/productor/publication";
	}
	
	
	@PostMapping("save")
	public String save(Model model, @ModelAttribute("post") Post post ) {
		
		System.out.println(post.getId());
		System.out.println(post.getName());
		System.out.println(post.getDescription());
		System.out.println(post.getDate());
		System.out.println(post.getProduct());
		System.out.println(post.getUser());
		try {				
			Post postSave = postService.update(post);		
			model.addAttribute("post", postSave);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/productor/publication";
	}
	
	@GetMapping("newPost")	// request
	public String newPost(Model model) {
		try {	
				List<Product> products = productService.getAll();
				List<User> users= userService.getAll();
				model.addAttribute("products", products);
				model.addAttribute("users", users);
				model.addAttribute("post",new Post());
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return "productor/newPost";
	}

	@PostMapping("saveNew")
	public String saveNew(Model model, @Valid @ModelAttribute("post") Post post, 
			BindingResult result) {
		System.out.println(post.getId());
		System.out.println(post.getName());
		System.out.println(post.getDescription());
		System.out.println(post.getDate());
		System.out.println(post.getProduct().getPrice());
		System.out.println(post.getUser().getCompany());
		try {
			Post postSave = postService.update(post);		
			model.addAttribute("post", postSave);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/productor/publication";
	}
*/
	
}
package pe.edu.upc.trabajo.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Categories",
	indexes= {@Index(columnList="category_name",name="categories_index_category_name")})
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id", columnDefinition = "NUMERIC(4)")
	private Integer id;
	
	@Column(name = "category_name", length = 30)
	private String name;
	
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Product> products;

	public Category() {
		super();
		products=new ArrayList<Product>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}

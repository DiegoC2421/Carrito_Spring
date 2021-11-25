package pe.edu.upc.trabajo.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Producers",
	indexes= {@Index(columnList="producer_first_name",name="producers_index_producer_name")})
public class Producer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "producer_id", columnDefinition = "NUMERIC(4)")
	private Integer id;

	@Column(name = "producer_first_name", length = 30)
	private String name;
	
	@Column(name = "producer_last_name", length = 30)
	private String lastName;

	@Column(name = "phone", columnDefinition = "NUMERIC(9)")
	private Integer phone;

	@Column(name = "email", length = 30)
	private String email;

	@ManyToOne
	@JoinColumn(name = "district_id", nullable = false)
	private District district;
	
	@OneToMany(mappedBy = "producer", fetch = FetchType.LAZY)
	private List<Product> products;
	

	public Producer() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	
}

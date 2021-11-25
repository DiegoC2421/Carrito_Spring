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
@Table(name = "Wholesalers",
	indexes= {@Index(columnList="wholesaler_name",name="wholesalers_index_wholesaler_name")})
public class Wholesaler {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wholesaler_id", columnDefinition = "NUMERIC(4)")
	private Integer id;

	//@transiet sirve para especificar que el atributo no se guarda en la base de datos, no se hace persistente
	
	@Column(name = "wholesaler_name", length = 30)
	private String name;

	@Column(name = "phone", columnDefinition = "NUMERIC(9)")
	private Integer phone;

	@Column(name = "email", length = 30)
	private String email;
	
	@Column(name = "ruc", columnDefinition = "NUMERIC(11)")
	private Double ruc;
	
	@ManyToOne
	@JoinColumn(name = "district_id", nullable = false)
	private District district;
	
//	@OneToMany(mappedBy = "wholesaler", fetch = FetchType.LAZY)
//	private List<Order> orders;
	
	public Wholesaler() {
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

	public Double getRuc() {
		return ruc;
	}

	public void setRuc(Double ruc) {
		this.ruc = ruc;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

//	public List<Order> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(List<Order> orders) {
//		this.orders = orders;
//	}
	
}

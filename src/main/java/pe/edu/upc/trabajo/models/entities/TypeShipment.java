package pe.edu.upc.trabajo.models.entities;

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
@Table(name = "Type_shipments",
	indexes= {@Index(columnList="typeShipment_name",name="type_shipments_index_typeShipment_name")})

public class TypeShipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "typeShipment_id", columnDefinition = "NUMERIC(4)")
	private Integer id;
	
	@Column(name = "typeShipment_name", length = 30)
	private String name;
	
	@OneToMany(mappedBy = "typeShipment", fetch = FetchType.LAZY)
	private List<Order> orders;

	
	public TypeShipment() {
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


	public List<Order> getOrders() {
		return orders;
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}

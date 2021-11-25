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
@Table(name = "Type_payments",
	indexes= {@Index(columnList="payment_name",name="type_payments_index_payment_name")})
public class TypePayment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id", columnDefinition = "NUMERIC(4)")
	private Integer id;
	
	@Column(name = "payment_name", length = 30)
	private String name;
	
	@OneToMany(mappedBy = "typePayment", fetch = FetchType.LAZY)
	private List<Order> orders;

	public TypePayment() {
		super();
		orders = new ArrayList<Order>();
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

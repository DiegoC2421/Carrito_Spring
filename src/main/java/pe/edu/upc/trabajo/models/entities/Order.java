package pe.edu.upc.trabajo.models.entities;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", columnDefinition = "NUMERIC(4)")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
//	@ManyToOne
//	@JoinColumn(name = "wholesaler_id")
//	private Wholesaler wholesaler;
	
	/*@Column(name = "amount", columnDefinition = "DECIMAL(8,2)")
	private Float amount;*/
	
	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "payment_id")
	private TypePayment typePayment; 
	
	@ManyToOne
	@JoinColumn(name = "typeShipment_id")
	private TypeShipment typeShipment; 
	
	@OneToMany(mappedBy = "order")
	private List<Detail> details;
	
	@OneToMany(mappedBy = "order")
	private List<ShipmentStatus> shipmentStatus;
	
	@Column(name = "paid")
	private boolean paid;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int id, User user, Date date, TypePayment typePayment, TypeShipment typeShipment, List<Detail> details,
			List<ShipmentStatus> shipmentStatus, boolean paid) {
		super();
		this.id = id;
		this.user = user;
		this.date = date;
		this.typePayment = typePayment;
		this.typeShipment = typeShipment;
		this.details = details;
		this.shipmentStatus = shipmentStatus;
		this.paid = paid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TypePayment getTypePayment() {
		return typePayment;
	}

	public void setTypePayment(TypePayment typePayment) {
		this.typePayment = typePayment;
	}

	public TypeShipment getTypeShipment() {
		return typeShipment;
	}

	public void setTypeShipment(TypeShipment typeShipment) {
		this.typeShipment = typeShipment;
	}

	public List<Detail> getDetails() {
		return details;
	}

	public void setDetails(List<Detail> details) {
		this.details = details;
	}

	public List<ShipmentStatus> getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(List<ShipmentStatus> shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}
}

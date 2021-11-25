package pe.edu.upc.trabajo.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Statuses")

public class Status {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "status_id", columnDefinition = "NUMERIC(4)")
	private Integer id;
	
	@Column(name = "status_name", length = 30)
	private String name;
	
	@OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
	private List<ShipmentStatus> shipmentStatus;

	public Status() {
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

	public List<ShipmentStatus> getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(List<ShipmentStatus> shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}
}

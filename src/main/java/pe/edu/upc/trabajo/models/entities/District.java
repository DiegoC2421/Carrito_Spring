package pe.edu.upc.trabajo.models.entities;

//import java.util.ArrayList;
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
@Table(name = "Districts",
	indexes= {@Index(columnList="district_name",name="district_index_district_name")})
public class District {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "district_id", columnDefinition = "NUMERIC(4)")
	private Integer id;
	
	@Column(name = "district_name", length = 30)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department ;
	
	@OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
	private List<Producer> producers;
	
	@OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
	private List<Wholesaler> wholesalers;

	public District() {
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Producer> getProducers() {
		return producers;
	}

	public void setProducers(List<Producer> producers) {
		this.producers = producers;
	}

	public List<Wholesaler> getWholesalers() {
		return wholesalers;
	}

	public void setWholesalers(List<Wholesaler> wholesalers) {
		this.wholesalers = wholesalers;
	}
	
	

}

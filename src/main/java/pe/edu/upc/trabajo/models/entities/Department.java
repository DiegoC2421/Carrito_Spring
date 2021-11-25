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
@Table(name = "Departments",
	indexes= {@Index(columnList="department_name",name="departments_index_department_name")})
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id", columnDefinition = "NUMERIC(4)")
	private Integer id;
	
	@Column(name = "department_name", length = 30)
	private String name;
	
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	private List<District> districts;
	
	public Department() {
		districts =new ArrayList<District>();
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

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

	

}

package practica1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "areas")
public class Area {
	@Id
	private String name;
	@Column(nullable=false)
	private float length;
	private String details;
	
	public Area() {
	}	
	
	public Area(String name, float length, String details) {
		super();
		this.name = name;
		this.length = length;
		this.details = details;
	}

	@Column(name="area_name")  
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return name;
	}
}
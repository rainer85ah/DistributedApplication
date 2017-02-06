package practica1.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "species")
public class Specie {
	@Id
	private String name;
	@Column(unique=true, nullable=false)
	private String scientificName;
	@Column(nullable=false)
	private Type type;
	private String image_url;	
	
	@ManyToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="species_areas", joinColumns=@JoinColumn(name="specie_name"), inverseJoinColumns=@JoinColumn(name="area_name"))
	private Set<Area> areas;
	
	public enum Type{
					    ANIMAL("Animal"), PLANTA("Planta"), HONGO("Hongo");
					    private String value;
					    private Type (String value) { this.value = value; }
						public String getValue() { return value; }
					}
	
	public Specie() {
	}

	public Specie(String name, String scientificName, Type  type, String image_url, Set<Area> areas) {
		this.name = name;
		this.scientificName = scientificName;
		this.type = type;
		this.image_url = image_url;
		this.areas = areas;
	}
	
	@Column(name="specie_name") 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public String getImage() {
		return image_url;
	}
	
	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	
	public Set<Area> getAreas() {
		return areas;
	}

	public void setAreas(Set<Area> areas) {
		this.areas = areas;
	}

	@Override
	public String toString() {
		return name + ", Nombre Cientifico=" + scientificName + ", Areas=" + areas.toString();
	}
}

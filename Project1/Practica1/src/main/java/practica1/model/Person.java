package practica1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
public class Person {
	@Id
	private String name;
	@Column(nullable=true)
	private String lastname;
	private String email;
	private String telephone;
	private String mobile;
	private Job job;
	private String image_url;

	public enum Job{
						ADMINISTRACION("Administracion"), VIGILANCIA("Vigilancia"), PRESERVACION("Preservacion"), INVESTIGACION("Investigacion");
						private String value;
						private Job (String value) { this.value = value; }
						public String getValue() { return value; }
					}

	public Person() {
	}

	public Person(String name, String lastname, String email, String telephone, String mobile, Job job, String image_url) {
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.telephone = telephone;
		this.mobile = mobile;
		this.image_url = image_url;
		this.job = job;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}	

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
	
	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	
	@Override
	public String toString() {
		return name + ", Apellido=" + lastname + ", Email=" + email + 
				", Fijo=" + telephone + ", Movil=" + mobile + ", Puesto=" + job;
	}
}
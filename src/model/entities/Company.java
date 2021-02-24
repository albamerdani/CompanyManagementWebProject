package model.entities;
import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company {
	
	@Id @GeneratedValue
	@Column(name = "IdCompany")
	private int idCompany;
	
	@Column(name = "Name")
	private String nameOfCompany;
	
	@Column(name = "Nipt")
	private String nipt;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "Description")
	private String descriptionCompany;
	
	@Column(name = "Validity")
	private boolean validityCompany;

	
	
	public Company() {

	}
	
	public int getIdCompany() {
		return idCompany;
	}
	
	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}
	
	public String getNameOfCompany() {
		return nameOfCompany;
	}
	
	public void setNameOfCompany(String nameOfCompany) {
		this.nameOfCompany = nameOfCompany;
	}
	
	public String getNipt() {
		return nipt;
	}
	
	public void setNipt(String nipt) {
		this.nipt = nipt;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescriptionCompany() {
		return descriptionCompany;
	}

	public void setDescriptionCompany(String descriptionCompany) {
		this.descriptionCompany = descriptionCompany;
	}

	public boolean isValidityCompany() {
		return validityCompany;
	}

	public void setValidityCompany(boolean validityCompany) {
		this.validityCompany = validityCompany;
	}

}

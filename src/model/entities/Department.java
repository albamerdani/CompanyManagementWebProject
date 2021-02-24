package model.entities;
import javax.persistence.*;

@Entity
@Table(name = "department")

public class Department {

	@Id @GeneratedValue
	@Column(name = "IdDep")
	private int idDep;
	
	@Column(name = "Name")
	private String nameOfDep;
	
	@Column(name = "Description")
	private String descriptionDep;
	
	@Column(name = "Validity")
	private boolean validityDep;
	
	@Column(name = "IdCompany")
	private int idCompany;

	
	public Department() {

	}
	
	public int getIdDep() {
		return idDep;
	}
	
	public void setIdDep(int idDep) {
		this.idDep = idDep;
	}
	
	public String getNameOfDep() {
		return nameOfDep;
	}
	
	public void setNameOfDep(String nameOfDep) {
		this.nameOfDep = nameOfDep;
	}


	public String getDescriptionDep() {
		return descriptionDep;
	}


	public void setDescriptionDep(String descriptionDep) {
		this.descriptionDep = descriptionDep;
	}


	public boolean isValidityDep() {
		return validityDep;
	}


	public void setValidityDep(boolean validityDep) {
		this.validityDep = validityDep;
	}

	public int getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}
	
	
}

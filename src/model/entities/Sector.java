package model.entities;
import javax.persistence.*;

@Entity
@Table(name = "sector")
public class Sector {
	
	@Id @GeneratedValue
	@Column(name = "IdSector")
	private int idSector;
	
	@Column(name = "Name")
	private String nameOfSector;
	
	@Column(name = "Description")
	private String descriptionSector;
	
	@Column(name = "Validity")
	private boolean validitySector;
	
	@Column(name = "IdDep")
	private int idDep;
	
	public Sector() {
		
	}

	public int getIdSector() {
		return idSector;
	}

	public void setIdSector(int idSector) {
		this.idSector = idSector;
	}

	public String getNameOfSector() {
		return nameOfSector;
	}

	public void setNameOfSector(String nameOfSector) {
		this.nameOfSector = nameOfSector;
	}

	public String getDescriptionSector() {
		return descriptionSector;
	}

	public void setDescriptionSector(String descriptionSector) {
		this.descriptionSector = descriptionSector;
	}

	public boolean isValiditySector() {
		return validitySector;
	}

	public void setValiditySector(boolean validitySector) {
		this.validitySector = validitySector;
	}

	public int getIdDep() {
		return idDep;
	}

	public void setIdDep(int idDep) {
		this.idDep = idDep;
	}
	
	
}

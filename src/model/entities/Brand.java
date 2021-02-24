package model.entities;
import javax.persistence.*;

@Entity
@Table(name = "brands")
public class Brand {
	
	@Id @GeneratedValue
	@Column(name = "IdBrand")
	private int idBrand;
	
	@Column(name = "Name")
	private String nameOfBrand;
	
	@Column(name = "Description")
	private String descriptionBrand;
	
	@Column(name = "Validity")
	private boolean validityBrand;
	
	@Column(name = "IdShop")
	private int idShop;
	
	public Brand() {

	}
	
	public int getIdBrand() {
		return idBrand;
	}
	
	public void setIdBrand(int idBrand) {
		this.idBrand = idBrand;
	}
	
	public String getNameOfBrand() {
		return nameOfBrand;
	}
	
	public void setNameOfBrand(String nameOfBrand) {
		this.nameOfBrand = nameOfBrand;
	}

	public String getDescriptionBrand() {
		return descriptionBrand;
	}

	public void setDescriptionBrand(String descriptionBrand) {
		this.descriptionBrand = descriptionBrand;
	}

	public boolean isValidityBrand() {
		return validityBrand;
	}

	public void setValidityBrand(boolean validityBrand) {
		this.validityBrand = validityBrand;
	}

	public int getIdShop() {
		return idShop;
	}

	public void setIdShop(int idShop) {
		this.idShop = idShop;
	}
	
	

	/*public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}	
*/
	
}

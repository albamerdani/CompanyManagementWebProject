package model.entities;
import javax.persistence.*;

@Entity
@Table(name = "shops")
public class Shop {

	@Id @GeneratedValue
	@Column(name = "IdShop")
	private int idShop;
	
	@Column(name = "IdCountry")
	private int idCountry;
	
	/*
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "IdCountry")
	private Country country;
	*/
	
	@Column(name = "Quantity")
	private int quantity;
	
	@Column(name = "Price")
	private double price;
	
	@Column(name = "Description")
	private String descriptionShop;
	
	@Column(name = "Validity")
	private boolean validityShop;
	
	@Column(name = "IdSector")
	private int idSector;
	
	public Shop() {
	
	}

	public int getIdShop() {
		return idShop;
	}
	
	public void setIdShop(int idShop) {
		this.idShop = idShop;
	}
	
	public int getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(int idCountry) {
		this.idCountry = idCountry;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDescriptionShop() {
		return descriptionShop;
	}

	public void setDescriptionShop(String descriptionShop) {
		this.descriptionShop = descriptionShop;
	}

	public boolean isValidityShop() {
		return validityShop;
	}

	public void setValidityShop(boolean validityShop) {
		this.validityShop = validityShop;
	}

	public int getIdSector() {
		return idSector;
	}

	public void setIdSector(int idSector) {
		this.idSector = idSector;
	}

	
	
}

package model.entities;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {

	@Id @GeneratedValue
	@Column(name = "IdCountry")
	private int idCountry;
	
	@Column(name = "Country")
	private String country;
	
	@Column(name = "Currency")
	private String currency;
	
	@OneToMany(mappedBy="idCountry",cascade=CascadeType.ALL)
	private List<Shop> shops;
	
	public Country(){
	
	}

	public int getIdCountry() {
		return idCountry;
	}
	
	public void setIdCountry(int idCountry) {
		this.idCountry = idCountry;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public List<Shop> getShops() {
		return shops;
	}

	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}
	
	
	
}

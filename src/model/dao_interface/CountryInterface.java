package model.dao_interface;

import java.util.List;

import model.entities.Country;

public interface CountryInterface {

	public void addCountry(Country country);
	
	public List<Country> listCountry();
	
	public void updateCountry(Country country);
	
	public void deleteCountry(Country country);

}

package controller;

import model.dao.CountryDAO;
import model.entities.Country;
import model.entities.User;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="countryBean")
@SessionScoped
public class CountryBean implements Serializable{
	
	private static final long serialVersionUID = -1086855020561152108L;

	private Country country = new Country();
	
	private static CountryDAO countryDAO = new CountryDAO();
	
	public CountryBean(){
		
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public CountryDAO getCountryDAO() {
		return countryDAO;
	}

	public void setCountryDAO(CountryDAO countryDAO) {
		CountryBean.countryDAO = countryDAO;
	}


	// Method To Add New country Details In Database
	public void saveCountryRecord() {
		System.out.println("Calling saveCountryRecord() Method To Save Country Record");
		countryDAO.addCountry(country);
	}

	// Method To Delete A Particular country Record From The Database
	public void deleteCountryRecord() {
		System.out.println("Calling deleteCountryRecord() Method To Delete Country Record");
		countryDAO.deleteCountry(country);
	}

	// Method To Fetch Particular country Details From The Database
	public String selectCountryById(int id){
		System.out.println("Calling selectCountryById() Method To Update Country Record");
		String name = countryDAO.selectCountryById(id);
		return name;
	}

	// Method To Update Particular country Details In Database
	public void updateCountryDetails() {
		System.out.println("Calling updateCountryDetails() Method To Update Country Record");
		countryDAO.updateCountry(country);
	}

	// Method To Fetch All Records From The Database
	public List<Country> allCountryRecords() {
		System.out.println("Calling allCountryRecords() Method To Fetch Country Record");
		List<Country> countryList = countryDAO.listCountry();
		return countryList;
	}
	
	
	public String reloadPage(){
		return "admin.xhtml?faces-redirect=true";
	}
	
	
	public String turnBack(){
		User user = new model.entities.User();	
		return "admin.xhtml?faces-redirect=true";
	}
		
	
}

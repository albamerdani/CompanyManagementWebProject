package model.dao_interface;

import java.util.List;

import model.entities.Company;

public interface CompanyInterface {

	public void addCompany(Company company);
	
	public List<Company> listCompany();
	
	public Company getCompanyByName(String name);
	
	public String getCompanyById(int id);
	
	public void updateCompany(Company company);
	
	public void deleteCompany(Company company);
	
}

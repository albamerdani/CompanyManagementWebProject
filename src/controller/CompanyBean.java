package controller;

import java.io.Serializable;
import java.util.List;

import model.dao.CompanyDAO;
import model.dao_interface.CompanyInterface;
import model.entities.Company;
import model.entities.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="companyBean")
@SessionScoped
public class CompanyBean implements Serializable{

	private static final long serialVersionUID = -1086855020561152108L;
	
	private Company company = new Company();
	
	private CompanyDAO companyDAO = new CompanyDAO();
	
	public CompanyBean(){
		
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public CompanyDAO getCompanyDAO() {
		return companyDAO;
	}

	public void setCompanyDAO(CompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}
	
	
	
	// Method To Add New company Details In Database
	public void saveCompanyRecord() {
		System.out.println("Calling saveCompanyRecord() Method To Save Company Record");
		//companyDAO.addCompany(company);
		CompanyInterface cif = null; 
		cif.addCompany(company);
	}

	// Method To Delete A Particular company Record From The Database
	public void deleteCompanyRecord() {
		System.out.println("Calling deleteCompanyRecord() Method To Delete Company Record");
		CompanyInterface cif = null; 
		cif.deleteCompany(company);
		//companyDAO.deleteCompany(company);
	}

	// Method To Fetch Particular company Details From The Database
	public String selectCompById(int id){
		System.out.println("Calling getCompanyById() Method To Fetch Company Record");
		String name = companyDAO.getCompanyById(id);
		return name;
	}

	// Method To Update Particular company Details In Database
	public void updateCompanyDetails() {
		System.out.println("Calling updateCompanyDetails() Method To Update Company Record");
		companyDAO.updateCompany(company);
	}

	// Method To Fetch All Records From The Database
	public List<Company> allCompanyRecords() {
		System.out.println("Calling getAllCompanyRecords() Method To Fetch Company Record");
		List<Company> companyList = companyDAO.listCompany();
		return companyList;
	}
	
	
	public String turnBack(){
		User user = new model.entities.User();		
		return "admin.xhtml?faces-redirect=true";
	}
		
		
		public String getPage(){
		User user = new model.entities.User();
			return "adminCompany.xhtml?faces-redirect=true";
		}
		
	
	
	
}

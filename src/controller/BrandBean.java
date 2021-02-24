package controller;

import java.io.Serializable;
import java.util.List;

import model.dao.BrandDAO;
import model.entities.Brand;
import model.entities.Shop;
import model.entities.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="brandBean")
@SessionScoped
public class BrandBean implements Serializable{
	
	private static final long serialVersionUID = -1086855020561152108L;

	private Brand brand = new Brand();
	private BrandDAO brandDAO = new BrandDAO();
	
	public BrandBean(){
		
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public BrandDAO getBrandDao() {
		return brandDAO;
	}

	public void setBrandDao(BrandDAO brandDAO) {
		this.brandDAO = brandDAO;
	}
	
	
	// Method To Add New brand Details In Database
	public void saveBrandRecord() {
		System.out.println("Calling saveBrandRecord() Method To Save Brand Record");
		brandDAO.addBrand(brand);
	}

	// Method To Delete A Particular brand Record From The Database
	public void deleteBrandRecord() {
		System.out.println("Calling deleteBrandRecord() Method To Delete Brand Record");
		//int countryID = brand.getIdBrand();
		brandDAO.deleteBrand(brand);
	}


	// Method To Update Particular brand Details In Database
	public void updateBrandDetails() {
		System.out.println("Calling updateBrandDetails() Method To Update Brand Record");
		brandDAO.updateBrand(brand);
	}

	// Method To Fetch All Records From The Database
	public List<Brand> allBrandRecords() {
		System.out.println("Calling getAllBrandRecords() Method To Fetch Brand Record");	
		List<Brand> brandList = brandDAO.listBrand();
		return brandList;
	}
	
	
	public List<Brand> selectBrandByShop(Shop shop){
		List<Brand> brandList = brandDAO.getBrandByShop(shop);
		return brandList;
	}
	
	public String turnBack(){	
		User user = new model.entities.User();
		return "adminBrand.xhtml?faces-redirect=true";
	}
	
	
	public String getPage(){
		User user = new model.entities.User();
		return "adminBrand.xhtml?faces-redirect=true";
	}
	

}

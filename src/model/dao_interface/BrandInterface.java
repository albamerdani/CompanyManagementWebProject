package model.dao_interface;

import java.util.List;

import model.entities.Brand;
import model.entities.Shop;

public interface BrandInterface {

	public void addBrand(Brand brand);
	
	public List<Brand> listBrand();
	
	public Brand getBrandByName(String name);
	
	public List<Brand> getBrandByShop(Shop sh);
	
	public void updateBrand(Brand brand);
	
	public void deleteBrand(Brand brand);
}

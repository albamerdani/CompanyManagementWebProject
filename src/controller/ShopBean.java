package controller;

import java.io.Serializable;
import java.util.List;

import model.dao.ShopDAO;
import model.dao.UserDAO;
import model.entities.Sector;
import model.entities.Shop;
import model.entities.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="shopBean")
@SessionScoped
public class ShopBean implements Serializable{

	private static final long serialVersionUID = -1086855020561152108L;
	
	private Shop shop = new Shop();
	private static ShopDAO shopDAO = new ShopDAO();
	
	public ShopBean(){
		
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public ShopDAO getShopDAO() {
		return shopDAO;
	}

	public void setShopDAO(ShopDAO shopDAO) {
		this.shopDAO = shopDAO;
	}
	
	
	
	// Method To Add New shop Details In Database
	public void saveShopRecord() {
		System.out.println("Calling saveShopRecord() Method To Save Shop Record");
		shopDAO.addShop(shop);
	}

	
	// Method To Delete A Particular shop Record From The Database
	public void deleteShopRecord() {
		System.out.println("Calling deleteShopRecord() Method To Delete Shop Record");
		shopDAO.deleteShop(shop);
	}


	// Method To Update Particular shop Details In Database
	public void updateShopDetails() {
		System.out.println("Calling updateShopDetails() Method To Update Shop Record");
		shopDAO.updateShop(shop);
	}

	// Method To Fetch All Records From The Database
	public List<Shop> getAllShopRecords() {
		System.out.println("Calling getAllShopRecords() Method To Fetch Shop Record");
		List<Shop> shopList = shopDAO.listShop();
		return shopList;
	}
	
	public Shop selectShopById(int id){
		System.out.println("Calling getAllShopRecords() Method To Fetch Shop Record");
		Shop sh = shopDAO.getShopById(id);
		return sh;
		
	}
	public List<Shop> selectShopBySector(Sector sect){
		List<Shop> shopList = shopDAO.getShopBySector(sect);
		return shopList;
	}
	
	
	public double buy(){
		UserDAO udao = new UserDAO();
		double payment = udao.buy(shop);
		return payment;
	}
	
	
	public String turnBack(){
		User user = new model.entities.User();			
		return "admin.xhtml?faces-redirect=true";
	}
		
		
	public String getPage(){
		User user = new model.entities.User();
		return "adminShop.xhtml?faces-redirect=true";
	}
		
	
}

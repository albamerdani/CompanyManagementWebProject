package model.dao_interface;

import java.util.List;

import model.entities.Sector;
import model.entities.Shop;

public interface ShopInterface {

	public void addShop(Shop shop);
	
	public List<Shop> listShop();
	
	public Shop getShopById(int id);
	
	public List<Shop> getShopBySector(Sector sect);
	
	public void updateShop(Shop shop);
	
	public void deleteShop(Shop shop);
}

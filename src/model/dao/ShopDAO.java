package model.dao;
import java.util.Iterator;
import java.util.List;

import model.dao_interface.ShopInterface;
import model.entities.Department;
import model.entities.Sector;
import model.entities.Shop;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class ShopDAO implements ShopInterface{

	
	private static HibernateUtil hutil = new HibernateUtil();
	
	private static SessionFactory factory = hutil.getSessionFactory();

	
	/* Method to CREATE a Shop in the database */
	@Override
	   public void addShop(Shop shop){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         session.save(shop); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   
	   
	   /* Method to  READ all the Shops */
	@SuppressWarnings("unchecked")
	@Override
	   public List<Shop> listShop(){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      List<Shop> shops = null;
	      
	      try {
	         tx = session.beginTransaction();
	         shops = session.createQuery("FROM Shop").list(); 
	         for (Iterator<Shop> iterator = shops.iterator(); iterator.hasNext();){
	            Shop shop = (Shop) iterator.next();
	            System.out.print("Id of Shop: " + shop.getIdShop()); 
	            System.out.print("Quantity: " + shop.getQuantity());
	            System.out.print("Price: " + shop.getPrice());
	            System.out.print("Description: " + shop.getDescriptionShop());
	            System.out.print("Validity: " + shop.isValidityShop());
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return shops;
	   }
	   
	   
	@Override
	   public Shop getShopById(int id){
		   Session session = factory.openSession();
		   Transaction tx = null;
		   Shop sh = null;
		   try {
		         tx = session.beginTransaction();
		         Query q = session.createQuery("FROM Shop sh WHERE sh.idShop = " + id);
		         sh = (Shop)q.uniqueResult();
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		   return sh;
	   }
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	   public List<Shop> getShopBySector(Sector sect){
		   Session session = factory.openSession();
		   Transaction tx = null;
		   List<Shop> sh = null;
		   try {
		         tx = session.beginTransaction();
		         sh = session.createQuery("FROM Shop sh WHERE sh.idSector = " + sect.getIdSector()).list();
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		   return sh;
	   }
	   
	   
	   
	   /* Method to UPDATE a Shop */
	@Override
	   public void updateShop(Shop shop){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Integer shopID = shop.getIdShop();
	         shop = (Shop)session.get(Shop.class, shopID);
			 session.update(shop); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   
	   /* Method to DELETE an Shop from the records */
	@Override
	   public void deleteShop(Shop shop){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Integer shopID = shop.getIdShop();
	         shop = (Shop)session.get(Shop.class, shopID); 
	         session.delete(shop); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }

}

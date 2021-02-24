package model.dao;
import java.util.Iterator;
import java.util.List;

import model.dao_interface.BrandInterface;
import model.entities.Brand;
import model.entities.Sector;
import model.entities.Shop;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class BrandDAO implements BrandInterface{
	
	private static HibernateUtil hutil = new HibernateUtil();
	
	private static SessionFactory factory = hutil.getSessionFactory();

	
	/* Method to CREATE a brand in the database */
	@Override
	   public void addBrand(Brand brand){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         session.save(brand); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   
	   
	   /* Method to  READ all the brands */
	@SuppressWarnings("unchecked")
	@Override
	   public List<Brand> listBrand(){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      List<Brand> brands = null;
	      
	      try {
	         tx = session.beginTransaction();
	         brands = session.createQuery("FROM Brand").list(); 
	         
	            System.out.print("Name of Brand: "); 
	          
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return brands;
	   }
	   
	   
	@Override
	   public Brand getBrandByName(String name){
		   Session session = factory.openSession();
		   Transaction tx = null;
		   Brand brand = null;
		   try {
		         tx = session.beginTransaction();
		         brand = (Brand)session.createQuery("FROM Brand b WHERE b.nameOfBrand = " + name);
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		   return brand;
	   }
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	   public List<Brand> getBrandByShop(Shop sh){
		   Session session = factory.openSession();
		   Transaction tx = null;
		   List<Brand> b = null;
		   try {
		         tx = session.beginTransaction();
		         b = session.createQuery("FROM Brand b WHERE b.idShop = " + sh.getIdShop()).list();
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		   return b;
	   }
	   
	   
	   
	   /* Method to UPDATE a brand */
	@Override
	   public void updateBrand(Brand brand){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Integer brandID = brand.getIdBrand();
	         brand = (Brand)session.get(Brand.class, brandID); 
	         /*System.out.print("Name of Brand: ");
	         String name = input.nextLine();
	         System.out.println("Validity: ");
	         boolean val = input.nextBoolean();
	         brand.setNameOfBrand(name);
	         brand.setValidityBrand(val);*/
			 session.update(brand); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   
	   /* Method to DELETE a brand from the records */
	@Override
	   public void deleteBrand(Brand brand){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Integer brandID = brand.getIdBrand();
	         brand = (Brand)session.get(Brand.class, brandID); 
	         session.delete(brand); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
}

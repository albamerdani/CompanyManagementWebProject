package model.dao;

import java.util.Iterator;
import java.util.List;

import model.dao_interface.CountryInterface;
import model.entities.Country;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class CountryDAO implements CountryInterface{
	
	private static HibernateUtil hutil = new HibernateUtil();
	
	private static SessionFactory factory = hutil.getSessionFactory();

	/* Method to CREATE an Country in the database */
	@Override
	   public void addCountry(Country country){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         session.save(country); 
	         tx.commit();
	         System.out.println("Record is saved in Database!");
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   
	   
	   /* Method to  READ all the Countries */
	
	@SuppressWarnings("unchecked")
	@Override
	   public List<Country> listCountry(){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      List<Country> countries = null;
	     
	         tx = session.beginTransaction();
	         Query query = session.createQuery("FROM Country");
	         //countries = (List<Country>)session.createQuery("FROM Country");
	         countries = (List<Country>)query.list();
	        
	            System.out.print("Currency: " );
	         
	         tx.commit();
	      return countries;
	   }
	
	
	
	public String selectCountryById(int id) {
		Session session = factory.openSession();
		Query criteria = session.createQuery("FROM Country c where c.idCountry = " + id);
		Country c = (Country)criteria.uniqueResult();
		String nameCountry = c.getCountry();
		session.close();
		return nameCountry;

	}
	
	
	public Country selectCountryByName(Country country) {
		Session session = factory.openSession();
		Query criteria = session.createQuery("FROM Country c where c.country = " + country.getCountry());
		Country c = (Country) criteria.uniqueResult();
		session.close();
		return c;

	}
	   
	   
	   /* Method to UPDATE phone number for a Country */
	@Override
	   public void updateCountry(Country country){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         //Integer countryID = country.getIdCountry();
	         //country = (Country)session.get(Country.class, countryID);
			 session.update(country); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   
	   /* Method to DELETE a Country from the records */
	@Override
	   public void deleteCountry(Country country){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         session.delete(country); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }

}

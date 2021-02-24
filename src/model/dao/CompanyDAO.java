package model.dao;

import java.util.Iterator;
import java.util.List;

import model.dao_interface.CompanyInterface;
import model.entities.Company;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class CompanyDAO implements CompanyInterface{
	
	private static HibernateUtil hutil = new HibernateUtil();
	
	private static SessionFactory factory = hutil.getSessionFactory();

	/* Method to CREATE an Company in the database */
	@Override
	   public void addCompany(Company company){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         session.save(company); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   
	   
	   /* Method to  READ all the Companies */
	@SuppressWarnings("unchecked")
	@Override
	   public List<Company> listCompany(){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      List<Company> companies = null;
	      
	      try {
	         tx = session.beginTransaction();
	         companies = session.createQuery("FROM Company").list(); 
	         for (Iterator<Company> iterator = companies.iterator(); iterator.hasNext();){
	            Company company = (Company) iterator.next();
	            System.out.print("Id of Company: " + company.getIdCompany()); 
	            System.out.print("Name of Company: " + company.getNameOfCompany()); 
	            System.out.print("Nipt of Company: " + company.getNipt()); 
	            System.out.print("Address of Company: " + company.getAddress()); 
	            System.out.print("Description: " + company.getDescriptionCompany()); 
	            System.out.println("Validity: " + company.isValidityCompany());
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return companies;
	   }
	   
	   
	@Override
	   public Company getCompanyByName(String name){
		   Session session = factory.openSession();
		   Transaction tx = null;
		   Company comp = null;
		   try {
		         tx = session.beginTransaction();
		         comp = (Company)session.createQuery("FROM Company c WHERE c.nameOfCompany = " + name);
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		   return comp;
	   }
	
	
	@Override
	   public String getCompanyById(int id){
		   Session session = factory.openSession();
		   Transaction tx = null;
		   Company comp = null;
		   try {
		         tx = session.beginTransaction();
		         Query q = session.createQuery("FROM Company c WHERE c.idCompany = " + id);
		         comp = (Company)q.uniqueResult();
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		   return comp.getNameOfCompany();
	   }
	   
	   
	   /* Method to UPDATE phone number for an Company */
	@Override
	   public void updateCompany(Company company){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer companyID = company.getIdCompany();
	      try {
	         tx = session.beginTransaction();
	         company = (Company)session.get(Company.class, companyID);
			 session.update(company); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   
	   /* Method to DELETE an Company from the records */
	@Override
	   public void deleteCompany(Company company){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer companyID = company.getIdCompany(); 
	      try {
	         tx = session.beginTransaction();
	         company = (Company)session.get(Company.class, companyID); 
	         session.delete(company); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
}

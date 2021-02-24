package model.dao;
import java.util.Iterator;
import java.util.List;

import model.dao_interface.SectorInterface;
import model.entities.Department;
import model.entities.Sector;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class SectorDAO implements SectorInterface{
	
	private static HibernateUtil hutil = new HibernateUtil();
	
	private static SessionFactory factory = hutil.getSessionFactory();

	
	/* Method to CREATE a Sector in the database */
	@Override
	   public void addSector(Sector sector){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         session.save(sector); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   
	   
	   /* Method to  READ all the Sectors */
	@SuppressWarnings("unchecked")
	@Override
	   public List<Sector> listSector(){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      List<Sector> sectors = null;
	      
	      try {
	         tx = session.beginTransaction();
	         sectors = session.createQuery("FROM Sector").list(); 
	         for (Iterator<Sector> iterator = sectors.iterator(); iterator.hasNext();){
	            Sector sector = (Sector) iterator.next();
	            System.out.print("Id of Sector: " + sector.getIdSector()); 
	            System.out.print("Sector: " + sector.getNameOfSector());
	            System.out.print("Description: " + sector.getDescriptionSector());
	            System.out.print("Validity: " + sector.isValiditySector());
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return sectors;
	   }
	   
	
	@Override
	   public String getSectorById(int id){
		   Session session = factory.openSession();
		   Transaction tx = null;
		   Sector sect = null;
		   String name = null;
		   try {
		         tx = session.beginTransaction();
		         Query q = session.createQuery("FROM Sector s WHERE s.idSector = " + id);
		         sect = (Sector)q.uniqueResult();
		         name = sect.getNameOfSector();
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		   return name;
	   }
	
	   
	@Override
	   public Sector getSectorByName(String name){
		   Session session = factory.openSession();
		   Transaction tx = null;
		   Sector sect = null;
		   try {
		         tx = session.beginTransaction();
		         sect = (Sector)session.createQuery("FROM Sector s WHERE s.nameOfSector = " + name);
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		   return sect;
	   }
	   
	
	@SuppressWarnings("unchecked")
	@Override
	   public List<Sector> getSectorByDep(Department dep){
		   Session session = factory.openSession();
		   Transaction tx = null;
		   List<Sector> sector = null;
		   try {
		         tx = session.beginTransaction();
		         sector = session.createQuery("FROM Sector s WHERE s.idDep = " + dep.getIdDep()).list();
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		   return sector;
	   }
	   
	   
	   /* Method to UPDATE a Sector */
	@Override
	   public void updateSector(Sector sector){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Integer sectorID = sector.getIdSector();
	         sector = (Sector)session.get(Sector.class, sectorID);
			 session.update(sector); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   
	   /* Method to DELETE an Sector from the records */
	@Override
	   public void deleteSector(Sector sector){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Integer sectorID = sector.getIdSector();
	         sector = (Sector)session.get(Sector.class, sectorID); 
	         session.delete(sector); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
}

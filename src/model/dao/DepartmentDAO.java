package model.dao;

import java.util.Iterator;
import java.util.List;

import model.dao_interface.DepInterface;
import model.entities.Company;
import model.entities.Department;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class DepartmentDAO implements DepInterface{
	
	private static HibernateUtil hutil = new HibernateUtil();
	
	private static SessionFactory factory = hutil.getSessionFactory();

	
	/* Method to CREATE a Department in the database */
	@Override
	   public void addDepartment(Department department){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         session.save(department);
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   
	   
	   /* Method to  READ all the Departments */
	@SuppressWarnings("unchecked")
	@Override
	   public List<Department> listDepartment(){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      List<Department> departments = null;
	      
	      try {
	         tx = session.beginTransaction();
	         departments = session.createQuery("FROM Department").list(); 
	         for (Iterator<Department> iterator = departments.iterator(); iterator.hasNext();){
	            Department department = (Department) iterator.next();
	            System.out.print("Id of Department: " + department.getIdDep()); 
	            System.out.print("Name of Department: " + department.getNameOfDep()); 
	            System.out.print("Description of Department: " + department.getDescriptionDep());
	            System.out.print("Validity of Department: " + department.isValidityDep());
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return departments;
	   }
	   
	   
	@Override
	   public Department getDepByName(String name){
		   Session session = factory.openSession();
		   Transaction tx = null;
		   Department dep = null;
		   try {
		         tx = session.beginTransaction();
		         dep = (Department)session.createQuery("FROM Department d WHERE d.nameOfDep = " + name);
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		   return dep;
	   }
	
	
	@Override
	   public String getDepById(int id){
		   Session session = factory.openSession();
		   Transaction tx = null;
		   Department dep = null;
		   String name = null;
		   try {
		         tx = session.beginTransaction();
		         Query q = session.createQuery("FROM Department d WHERE d.idDep = " + id);
		         dep = (Department)q.uniqueResult();
		         name = dep.getNameOfDep();
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		   return name;
	   }
	   
	
	@SuppressWarnings("unchecked")
	@Override
	   public List<Department> getDepByComp(Company comp){
		   Session session = factory.openSession();
		   Transaction tx = null;
		   List<Department> dep = null;
		   try {
		         tx = session.beginTransaction();
		         dep = session.createQuery("FROM Department d WHERE d.idCompany = " + comp.getIdCompany()).list();
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		   return dep;
	   }
	   
	   
	   /* Method to UPDATE a Department */
	@Override
	   public void updateDepartment(Department dep){
	      Session session = factory.openSession();
	      Transaction tx = null;
	     // Integer depID = dep.getIdDep();
	      try {
	         tx = session.beginTransaction();
	       //  dep = (Department)session.get(Department.class, depID); 
	         /*String name = input.next();
	         dep.setNameOfDep(name);*/
			 session.update(dep); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   
	   /* Method to DELETE a Department from the records */
	@Override
	   public void deleteDepartment(Department dep){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Integer depID = dep.getIdDep();
	         dep = (Department)session.get(Department.class, depID); 
	         session.delete(dep); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }

}

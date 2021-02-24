package model.dao;
import java.util.Iterator;
import java.util.List;

import model.dao_interface.RoleInterface;
import model.entities.Role;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class RoleDAO implements RoleInterface{
	
	private static HibernateUtil hutil = new HibernateUtil();
	
	private static SessionFactory factory = hutil.getSessionFactory();

	
	/* Method to CREATE a Role in the database */
	@Override
	   public void addRole(Role role){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         session.save(role); 
	         tx.commit();
	         System.out.println("Record is saved!");
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   
	@Override
	   public String getRoleById(Role r){
		   Session session = factory.openSession();
		      Transaction tx = null;
		      Integer roleID = 0;
		      String role = null;
		      try {
		         tx = session.beginTransaction();
		         roleID = r.getIdRole();
		         Query q = session.createQuery("SELECT * FROM Role r WHERE r.idRole=:roleID");
		         q.setInteger("roleID", roleID);
		         role = q.uniqueResult().toString();
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		      return role;
	   }
	   
	   
	   
	   /* Method to  READ all the Roles */
	@SuppressWarnings("unchecked")
	@Override
	   public List<Role> listRole(){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      List<Role> roles = null;
	      
	      try {
	         tx = session.beginTransaction();
	         roles = session.createQuery("FROM Role").list(); 
	         for (Iterator<Role> iterator = roles.iterator(); iterator.hasNext();){
	            Role role = (Role) iterator.next();
	            System.out.print("Id of Role: " + role.getIdRole()); 
	            System.out.print("Role: " + role.getRole());
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return roles;
	   }
	   
	   
	   /* Method to UPDATE phone number for an Role */
	@Override
	   public void updateRole(Role role){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Integer roleID = role.getIdRole();
	         role = (Role)session.get(Role.class, roleID);
			 session.update(role); 
	         tx.commit();
	         System.out.println("Record is updated!");
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   
	   /* Method to DELETE an Role from the records */
	@Override
	   public void deleteRole(Role role){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Integer roleID = role.getIdRole();
	         role = (Role)session.get(Role.class, roleID); 
	         session.delete(role); 
	         tx.commit();
	         System.out.println("Record is deleted!");
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }

	
}
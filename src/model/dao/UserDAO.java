package model.dao;

import model.dao_interface.UserInterface;
import model.entities.Role;
import model.entities.Shop;
import model.entities.User;

import java.util.List; 
import java.util.Iterator; 

import org.hibernate.HibernateException; 
import org.hibernate.Query;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class UserDAO implements UserInterface{

	
	private static SessionFactory factory = HibernateUtil.getSessionFactory();

	/* Method to CREATE an user in the database */
	
	@Override
	   public void addUser(User user){

	    Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         //Role userRole = new Role();
	         //user.setIdRole(7);
	         session.save(user); 
	         tx.commit();
	         System.out.println("Record is saved!");
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   
	   
	   /* Method to  READ all the users */
	@SuppressWarnings("unchecked")
	@Override
	   public List<User> listUser(){
	      Session session = factory.openSession();
	  	System.out.println(" " + factory);
	      Transaction tx = null;
	      List<User> users = null;
	      
	      try {
	         tx = session.beginTransaction();
	         users = session.createQuery("FROM User").list(); 
	         for (Iterator<User> iterator = users.iterator(); iterator.hasNext();){
	            User user = (User) iterator.next();
	            System.out.print("Id User: " + user.getIdUser());
	            System.out.print("First Name: " + user.getFirstName()); 
	            System.out.print("Last Name: " + user.getLastName()); 
	            System.out.println("Gender: " + user.getGender());
	            System.out.println("Email: " + user.getEmail());
	            System.out.println("Cel:" + user.getCel()); 
	            System.out.println("Address: " + user.getAddressUser());
	            System.out.println("Username: " + user.getUsername());
	            System.out.println("Password: " + user.getPassword());
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return users;
	   }
	   
	   
	   
	   
	   /* Method to  SEARCH an users */
	@Override
	   public User searchUser(User user){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Integer userID = user.getIdUser();
	         user = (User)session.get(User.class, userID);
	         Query query = session.createQuery("SELECT * FROM User u WHERE u.idUser=:idUser");
	         query.setInteger("idUser", userID);
	         user = (User)query.uniqueResult();
	            System.out.print("Id User: " + user.getIdUser());
	            System.out.print("First Name: " + user.getFirstName()); 
	            System.out.print("Last Name: " + user.getLastName()); 
	            System.out.println("Gender: " + user.getGender());
	            System.out.println("Email: " + user.getEmail());
	            System.out.println("Cel:" + user.getCel()); 
	            System.out.println("Address: " + user.getAddressUser());
	            System.out.println("Username: " + user.getUsername());
	            System.out.println("Password: " + user.getPassword());
	            
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return user;
	   }
	   
	   
	   
	   /* Method to UPDATE phone number for an user */
	@Override
	   public void updateUser(User user){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         //Integer userID = user.getIdUser();
	         //user = (User)session.get(User.class, userID);
			 session.update(user); 
	         tx.commit();
	         System.out.println("Record is updated!");
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   
	   /* Method to DELETE an user from the records */
	@Override
	   public void deleteUser(User user){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Integer userID = user.getIdUser();
	         user = (User)session.get(User.class, userID); 
	         session.delete(user); 
	         tx.commit();
	         System.out.println("Record is deleted!");
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	
	
	//Method to login an user if he is registered in database and use a correct username and password
	public User login(String username, String password){
		try{
			System.out.println("You are loged in");

			Query query = factory.openSession().createQuery("FROM User u WHERE u.username=:username and u.password=:password");
			query.setString("username", username);
			query.setString("password", password);
			User user = (User)query.uniqueResult();
			//String r = user.getUserRole().getRole();
			return user;
		}catch(Exception e){
			System.out.println("Error  "+ e.getMessage());

			return null;
		}
	}
	
	
	public double buy(Shop shop){
		Session session = factory.openSession();
	      Transaction tx = null;
	      Shop shopBuy = null;
	      int count = 0;
	      double total = 0;
	      try {
	         tx = session.beginTransaction();
	         Query query = factory.getCurrentSession().createQuery("SELECT * FROM Shop sh where sh.idShop = " + shop.getIdShop());
	         shopBuy = (Shop)query.uniqueResult();
	         if(shopBuy.isValidityShop() && (shopBuy.getQuantity()>0)){
	        	 shopBuy.setQuantity(shopBuy.getQuantity() - 1);
	        	 count++;
	        	 total = total + count*shopBuy.getPrice();
	        	 session.update(shopBuy);
	         }
	         tx.commit();
	         System.out.println("You bought online!");
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		return total;
	}
	
	   
}

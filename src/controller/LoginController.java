package controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

import org.hibernate.Session;

//import util.AuthenticationUser;
import util.HibernateUtil;
import model.dao.UserDAO;
import model.entities.User;

//import org.hibernate.SessionFactory;

@ManagedBean(name = "loginController")
@RequestScoped
public class LoginController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1086855020561152108L;

	/*
	@ManagedProperty("#{userController}")
	private UserController userController;
	*/
	private  UserDAO userDAO = new UserDAO();
	
	private  User user = new User();

	
	public  UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	 public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	/*
	 * public UserController getUserController() {
		return userController;
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
	} 
	 * 
	 */

	public LoginController() {

	}
	
	
	public String login() throws ServletException {
		
		if (userDAO.login(this.getUser().getUsername(), 
				this.getUser().getPassword()).getIdRole() == 7) {
			System.out.println("Welcome User "+ getUser().getUsername());
			return "home.xhtml?faces-redirect=true";
		} else if (userDAO.login(this.getUser().getUsername(),
						this.getUser().getPassword()).getIdRole() == 1) {
			System.out.println("Welcome Admin " + getUser().getUsername());
			return "admin.xhtml?faces-redirect=true";
		} else if (userDAO.login(this.getUser().getUsername(),
						this.getUser().getPassword()).getIdRole() == 2) {
			System.out.println("Welcome Admin " + getUser().getUsername());
			return "adminCompany.xhtml?faces-redirect=true";
		} else if (userDAO.login(this.getUser().getUsername(),
						this.getUser().getPassword()).getIdRole() == 3) {
			System.out.println("Welcome Admin " + getUser().getUsername());
			return "adminDepartment.xhtml?faces-redirect=true";
		} else if (userDAO.login(this.getUser().getUsername(),
						this.getUser().getPassword()).getIdRole() == 4) {
			System.out.println("Welcome Admin " + getUser().getUsername());
			return "adminSector.xhtml?faces-redirect=true";
		} else if (userDAO.login(this.getUser().getUsername(),
						this.getUser().getPassword()).getIdRole() == 5) {
			System.out.println("Welcome Admin " + getUser().getUsername());
			return "adminShop.xhtml?faces-redirect=true";
		} else if (userDAO.login(this.getUser().getUsername(),
						this.getUser().getPassword()).getIdRole() == 6) {
			System.out.println("Welcome Admin " + getUser().getUsername());
			return "adminBrand.xhtml?faces-redirect=true";
		} else {
			return "index.xhtml?faces-redirect=true";
		}
	}

	
	public String logout() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.close();
		System.out.println("You loged out!");
		return "index.xhtml?faces-redirect=true";
	}
	
	
	private String password;
	
	public String deactivateAccount(){
		if(user.getPassword().equals(password)){
			userDAO.deleteUser(user);
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.disconnect();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Your account was sucessfully deactivated!"));
			
			return "index.xhtml?faces-redirect=true";
	}
		else
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Please enter you password"));
		return null;
		
	}
	
}

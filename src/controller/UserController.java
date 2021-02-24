package controller;

import java.io.Serializable;
import java.util.List;

import model.dao.UserDAO;
import model.entities.User;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "userController")
@RequestScoped
public class UserController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID =  -1086855020561152116L;
	
	
	private  UserDAO userDAO = new UserDAO();
	
	private  User user = new User();
	
	private String password;
	
	private  String newPassword;
	
	
	@ManagedProperty(value = "#{loginController}")
	private LoginController loginController;
	
	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}
	
	public UserController(){
		
	}
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
	public  String getPassword() {
		return password;
	}

	public  void setPassword(String password) {
		this.password = password;
	}

	public  String getNewPassword() {
		return newPassword;
	}

	public  void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	// Method To Add New country Details In Database
	public String saveUserRecord() {
		System.out.println("Calling saveUserRecord() Method To Save User Record");
		userDAO.addUser(user);
		
		return "index.xhtml?faces-redirect=true";
	}

	// Method To Delete A Particular country Record From The Database
	public void deleteUserRecord() {
		System.out.println("Calling deleteUserRecord() Method To Delete User Record");
		userDAO.deleteUser(user);
	}


	// Method To Update Particular country Details In Database
	public void updateUserDetails() {
		System.out.println("Calling updateUserDetails() Method To Update User Record");
		userDAO.updateUser(user);
	}

	// Method To Fetch All Records From The Database
	public List<User> allUserRecords() {
		System.out.println("Calling getAllUserRecords() Method To Fetch Users Record");	
		List<User> userList = userDAO.listUser();
		return userList;
	}
	
	public User getUserById() {
		System.out.println("Calling getUserById() Method To Fetch User Record");	
		user = userDAO.searchUser(user);
		return user;
	}
	
	
	
	public void changePassword(){
		
		if((loginController.getUser().getPassword().equals(this.password)))
		{	
			if((newPassword.length()<=6)||(newPassword.equals("password")||(newPassword.equals(loginController.getUser().getUsername())))){
				FacesContext.getCurrentInstance().addMessage(" ", new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn", "The password you set is not allowed or too weak, please try another! "));
				
			}
			else{
				loginController.getUser().setPassword(newPassword);
				    
				userDAO.updateUser(loginController.getUser());
				FacesContext.getCurrentInstance().addMessage(" ", new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "The password was sucessfully changed! "));
				newPassword = null;
			
				}
		}
		else
			FacesContext.getCurrentInstance().addMessage(" ", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "The Old password you enter doesnt match the password"));
	}
	
	
	
	public String turnBack(){
		
		return "admin.xhtml?faces-redirect=true";
	}
	
	
	public String getPage(){
		user = new model.entities.User();
		return "user?faces-redirect=true";
	}
	

}

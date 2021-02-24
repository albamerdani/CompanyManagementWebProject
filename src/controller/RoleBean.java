package controller;

import java.io.Serializable;
import java.util.List;

import model.dao.RoleDAO;
import model.entities.Role;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="roleBean")
@SessionScoped
public class RoleBean implements Serializable{
	
	private static final long serialVersionUID = -1086855020561152108L;
	
	private Role role = new Role();
	private RoleDAO roleDAO = new RoleDAO();
	
	public RoleBean(){
		
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}
	
	
	// Method To Add New role Details In Database
	public void saveRoleRecord() {
		System.out.println("Calling saveRoleRecord() Method To Save Role Record");
		roleDAO.addRole(role);
	}

	// Method To Delete A Particular role Record From The Database
	public void deleteRoleRecord() {
		System.out.println("Calling deleteRoleRecord() Method To Delete Role Record");
		roleDAO.deleteRole(role);
	}


	// Method To Update Particular role Details In Database
	public void updateRoleDetails() {
		System.out.println("Calling updateRoleDetails() Method To Update Role Record");
		roleDAO.updateRole(role);
	}

	// Method To Fetch All Records From The Database
	public List<Role> allRoleRecords() {
		System.out.println("Calling getAllRoleRecords() Method To Fetch Role Record");	
		List<Role> roleList = roleDAO.listRole();
		return roleList;
	}

}

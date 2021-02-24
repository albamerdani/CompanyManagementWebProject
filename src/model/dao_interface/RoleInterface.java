package model.dao_interface;

import java.util.List;

import model.entities.Role;

public interface RoleInterface {
	
	public void addRole(Role role);
	
	public String getRoleById(Role r);
	 
	public List<Role> listRole();
	 
	public void updateRole(Role role);
	 
	public void deleteRole(Role role);

}

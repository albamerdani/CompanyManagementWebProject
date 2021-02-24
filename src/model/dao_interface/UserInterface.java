package model.dao_interface;

import java.util.List;

import model.entities.User;

public interface UserInterface {
	
	public void addUser(User user);
	
	public List<User> listUser();
	
	public User searchUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(User user);

}

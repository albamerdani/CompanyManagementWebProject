package model.entities;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "role")

public class Role {
	
	@Id @GeneratedValue
	@Column(name = "IdRole")
	private int idRole;
	
	@Column(name = "Role")
	private String role;

	/*
	@OneToMany(mappedBy="idRole",cascade=CascadeType.ALL)
	private List<User> user;
	*/
	
	public Role() {}
	
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	/*
	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}
	*/
	
}

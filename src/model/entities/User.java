package model.entities;
import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
	
	@Id @GeneratedValue
	@Column(name = "IdUser")
	private int idUser;
	
	@Column(name = "Firstname")
	private String firstName;
	
	@Column(name = "Lastname")
	private String lastName;
	
	@Column(name = "Gender")
	private String gender;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Cel")
	private String cel;
	
	@Column(name = "Address")
	private String addressUser;
	
	@Column(name = "Username")
	private String username;
	
	@Column(name = "Password")
	private String password;
	
	/*
	 @ManyToOne
	    @JoinColumns({
	        @JoinColumn(
	            name = "idRole",
	            referencedColumnName = "IdRole"),
	    })
	    private Role userRole;

	    public Role getUserRole() {
	        return userRole;
	    }

	    public void setUserRole(Role userRole) {
	        this.userRole = userRole;
	    }

	*/
	@Column(name = "IdRole")
	private int idRole;
	
	public User() {
		
	}
	
	
	public int getIdUser() {
		return idUser;
	}
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCel() {
		return cel;
	}
	
	public void setCel(String cel) {
		this.cel = cel;
	}
	
	public String getAddressUser() {
		return addressUser;
	}
	
	public void setAddressUser(String addressUser) {
		this.addressUser = addressUser;
	}
	
	public int getIdRole() {
		return idRole;
	}
	
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
package bootJPA.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userName;
	private String userStreet;
	private String userCity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserStreet() {
		return userStreet;
	}
	public void setUserStreet(String userStreet) {
		this.userStreet = userStreet;
	}
	public String getUserCity() {
		return userCity;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userStreet=" + userStreet + ", userCity=" + userCity
				+ "]";
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String userName, String userStreet, String userCity) {
		super();
		this.id = id;
		this.userName = userName;
		this.userStreet = userStreet;
		this.userCity = userCity;
	}
	
}

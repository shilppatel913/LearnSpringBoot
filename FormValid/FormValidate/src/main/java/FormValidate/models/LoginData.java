package FormValidate.models;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

// we will apply all the required annotations
public class LoginData {
	@NotBlank(message="Username cannot be empty")
	@Size(min = 3,max=12,message = "Username should be in between 3 to 12 characters")
	private String userName;
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	private String userEmail;
	@AssertTrue(message = "Please whoosh it off to proceed further")
	private boolean userAgreed;
	public boolean isUserAgreed() {
		return userAgreed;
	}
	public void setUserAgreed(boolean userAgreed) {
		this.userAgreed = userAgreed;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public LoginData(
			@NotBlank(message = "Username cannot be empty") @Size(min = 3, max = 12, message = "Username should be in between 3 to 12 characters") String userName,
			@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$") String userEmail, @AssertTrue boolean userAgreed) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userAgreed = userAgreed;
	}
	public LoginData() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LoginData [userName=" + userName + ", userEmail=" + userEmail + ", userAgreed=" + userAgreed + "]";
	}
	
	
}

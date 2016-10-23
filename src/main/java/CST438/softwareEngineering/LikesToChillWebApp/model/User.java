package CST438.softwareEngineering.LikesToChillWebApp.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private int userId;

	private String fName;
	private String lName;

	private String userLocation;
	private String userEmail;
	private String userGender;
	private String userAge;
	
	public User() {
		
	}
	
	public User(int userId, String fName, String lName, String userLocation, String userEmail, String userGender,
			String userAge) {
		super();
		this.userId = userId;
		this.fName = fName;
		this.lName = lName;
		this.userLocation = userLocation;
		this.userEmail = userEmail;
		this.userGender = userGender;
		this.userAge = userAge;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getfName() {
		return fName;
	}
	
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	public String getlName() {
		return lName;
	}
	
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public String getUserLocation() {
		return userLocation;
	}
	
	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getUserGender() {
		return userGender;
	}
	
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	
	public String getUserAge() {
		return userAge;
	}
	
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", fName=" + fName + ", lName=" + lName + ", userLocation=" + userLocation
				+ ", userEmail=" + userEmail + ", userGender=" + userGender + ", userAge=" + userAge + "]";
	}
}

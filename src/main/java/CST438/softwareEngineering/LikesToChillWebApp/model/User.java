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
	private String userDOB;
	private String userAbout;
	private String userSignupDate;
	
	
	
	public User() {
		
	}
	
	public User(String fName, String lName, String userLocation, String userEmail, String userGender,
			String userDOB, String userAbout) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.userLocation = userLocation;
		this.userEmail = userEmail;
		this.userGender = userGender;
		this.userDOB = userDOB;
		this.userAbout = userAbout;
	}
	
	public User(int userId, String fName, String lName, String userLocation, String userEmail, String userGender,
			String userDOB, String userAbout, String userSignupDate) {
		super();
		this.userId = userId;
		this.fName = fName;
		this.lName = lName;
		this.userLocation = userLocation;
		this.userEmail = userEmail;
		this.userGender = userGender;
		this.userDOB = userDOB;
		this.userAbout = userAbout;
		this.userSignupDate = userSignupDate;
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

	public String getUserDOB() {
		return userDOB;
	}

	public void setUserDOB(String userDOB) {
		this.userDOB = userDOB;
	}

	public String getUserAbout() {
		return userAbout;
	}

	public void setUserAbout(String userAbout) {
		this.userAbout = userAbout;
	}

	public String getUserSignupDate() {
		return userSignupDate;
	}

	public void setUserSignupDate(String userSignupDate) {
		this.userSignupDate = userSignupDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fName=" + fName + ", lName=" + lName + ", userLocation=" + userLocation
				+ ", userEmail=" + userEmail + ", userGender=" + userGender + ", userDOB=" + userDOB + ", userAbout="
				+ userAbout + ", userSignupDate=" + userSignupDate + "]";
	}
}

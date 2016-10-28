package CST438.softwareEngineering.LikesToChillWebApp.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import CST438.softwareEngineering.LikesToChillWebApp.model.User;


public class UserDAO {
	
	private Connection connection;
	
	public UserDAO () {
		
	}
		
	public void getConnection() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	
		connection = DriverManager.getConnection(
				"jdbc:mysql://likestochill.c2xl5ywnufyt.us-west-1.rds.amazonaws.com:3306/LikesToChill", "ChillAdmin",
				"Chill438");
		
	}
	
	public List<User> findAll() throws SQLException, ClassNotFoundException {

		List<User> myUser = new ArrayList<User>();
		String selectTableSQL = "SELECT * from Users";
		java.sql.Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(selectTableSQL);

		while (rs.next()) {
			int userId = rs.getInt("UserId");
			String firstName = rs.getString("FirstName");
			String lastName = rs.getString("LastName");
			String userEmail = rs.getString("UserEmail");
			String userGender = rs.getString("UserGender");
			String userZipcode = rs.getString("UserZipcode");
			String userAbout = rs.getString("UserAbout");
			String userDOB = rs.getString("UserDOB");
			String userSignupDate = rs.getString("SignupDate");
			myUser.add(new User(userId, firstName, lastName, userZipcode, userEmail, userGender, userDOB, userAbout, userSignupDate));
		}
		return myUser;
	}
	
	public List<User> findById(int userId) throws SQLException {
    	
		List<User> myUser = new ArrayList<User>();
		String selectTableSQL = "SELECT * from Users WHERE UserId = "+ userId +"";
		java.sql.Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(selectTableSQL);
	
		while (rs.next()) {
			
			String firstName = rs.getString("FirstName");
			String lastName = rs.getString("LastName");
			String userEmail = rs.getString("UserEmail");
			String userGender = rs.getString("UserGender");
			String userZipcode = rs.getString("UserZipcode");
			String userAbout = rs.getString("UserAbout");
			String userDOB = rs.getString("UserDOB");
			String userSignupDate = rs.getString("SignupDate");
			myUser.add(new User(userId, firstName, lastName, userZipcode, userEmail, userGender, userDOB, userAbout, userSignupDate));
		}
		return myUser;
    	
	}
	
//    public List<User> findById(int userId) throws SQLException {
//    	
//    	List<User> myUser = new ArrayList<User>();
//		String selectTableSQL = "SELECT * from users where userid = "+ userId +" ";
//		java.sql.Statement statement = connection.createStatement();
//		ResultSet rs = statement.executeQuery(selectTableSQL);
//		
//		while (rs.next()) {
//			userId = rs.getInt("userid");
//			String userName = rs.getString("username");
//			String phoneNumber = rs.getString("phonenumber");
//			String userPic = rs.getString("userpicture");
//			String realName = rs.getString("realname");
//			String modTime = rs.getString("modtime");
//			myUser.add(new User(userId, userName, phoneNumber, realName));
//		}
//		return myUser;
//    	
//	}
//    
//    public List<User> findByName(String userName) throws SQLException {
//    	
//    	List<User> myUser = new ArrayList<User>();
//		String selectTableSQL = "SELECT * from users where username = '"+ userName +"' ";
//		java.sql.Statement statement = connection.createStatement();
//		ResultSet rs = statement.executeQuery(selectTableSQL);
//		
//		while (rs.next()) {
//			int userId = rs.getInt("userid");
//			userName = rs.getString("username");
//			String phoneNumber = rs.getString("phonenumber");
//			String userPic = rs.getString("userpicture");
//			String realName = rs.getString("realname");
//			String modTime = rs.getString("modtime");
//			myUser.add(new User(userId, userName, phoneNumber, realName));
//		}
//		return myUser;
//		
//	}
//    
    public boolean insertUser(User user) throws SQLException {
 

    	
		String selectTableSQL = "INSERT INTO Users "
				+ "VALUES (" + user.getUserId() + ", '" + user.getfName() + "', '" 
				+ user.getlName() + "', '" + user.getUserEmail() 
				+ "', '"+ user.getUserGender() + "', " + user.getUserLocation() 
				+ ", '" + user.getUserAbout() + "', '"+ user.getUserDOB() +"',CURRENT_DATE )";
    	
		java.sql.Statement statement = connection.createStatement();
		statement.executeUpdate(selectTableSQL);
		return true;

	}
 
    public boolean updateUser(User user) throws SQLException {

    	
		String selectTableSQL = "UPDATE Users SET (FirstName, LastName, UserEmail,"
				+ "UserGender, UserZipcode, UserAbout, UserDOB)"
				+ "VALUES ('" + user.getfName() + "', '" 
				+ user.getlName() + "', '" + user.getUserEmail() 
				+ "', '"+ user.getUserGender() + "', " + user.getUserLocation() 
				+ ", '" + user.getUserAbout() + "', '"+ user.getUserDOB() +"')";
		
		java.sql.Statement statement = connection.createStatement();
		statement.executeUpdate(selectTableSQL);
		return true;
				
				
	}
//    
//    
//    boolean deleteUser(User use) {
//		
//    	return false;
//    	
//	}
    
}

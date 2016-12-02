package CST438.softwareEngineering.LikesToChillWebApp.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import CST438.softwareEngineering.LikesToChillWebApp.model.User;


public class UserDAO {
	
	private Connection connection;
	
	public UserDAO () {
		
	}
		
	public void getConnectionToAws() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	
		connection = DriverManager.getConnection(
				"jdbc:mysql://likestochill.c2xl5ywnufyt.us-west-1.rds.amazonaws.com:3306/LikesToChill", "ChillAdmin", 
				"Chill438");
		
	}
	
	public List<User> findAllUserData() throws SQLException, ClassNotFoundException {

		List<User> myUser = new ArrayList<User>();
		String selectTableSQL = "SELECT * from Users";
		java.sql.Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(selectTableSQL);

		while (rs.next()) {
			String userId = rs.getString("UserId");
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
	
	public List<User> findById(String userId) throws SQLException {
    	
		List<User> myUser = new ArrayList<User>();
		String selectTableSQL = "SELECT * from Users WHERE UserId = '"+ userId +"'";
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
	

    public boolean addNewUser(User user) throws SQLException {
 

//    	INSERT INTO Users VALUES ("5", "John", "Smith", "something@email.com", "M",
//    			"12345", "About User", '2016-10-20', CURRENT_DATE);
    	
		String selectTableSQL = "INSERT INTO Users "
				+ "VALUES ('" + user.getUserId() + "', '" + user.getfName() + "', '" 
				+ user.getlName() + "', '" + user.getUserEmail() 
				+ "', '"+ user.getUserGender() + "', " + user.getUserLocation() 
				+ ", '" + user.getUserAbout() + "', '"+ user.getUserDOB() +"',CURRENT_DATE )";
    	
		java.sql.Statement statement = connection.createStatement();
		statement.executeUpdate(selectTableSQL);
		return true;

	}
 
    public boolean updateUserInfo(String userId, User user) throws SQLException {

		String selectTableSQL = "UPDATE Users SET FirstName ='" + user.getfName() 
				+ "', LastName = '" + user.getlName() + "', UserEmail = '" + user.getUserEmail() 
				+ "', UserGender = '"+ user.getUserGender() + "', "
				+ "UserZipcode = "+ user.getUserLocation() + ", UserAbout = '"+ user.getUserAbout() + "', "
				+ "UserDOB = '"+ user.getUserDOB() +"' " 
				+ "WHERE UserId = '"+ userId +"'";
	
		java.sql.Statement statement = connection.createStatement();
		statement.executeUpdate(selectTableSQL);
		return true;				
				
	}
    
    public boolean deleteUser(String userId) throws SQLException {
    	
    	String selectTableSQL = "DELETE FROM Users WHERE UserId = '"+ userId +"'";
    	
    	java.sql.Statement statement = connection.createStatement();
		statement.executeUpdate(selectTableSQL);
		return true;
    }
    
}

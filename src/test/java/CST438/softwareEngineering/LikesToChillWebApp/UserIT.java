package CST438.softwareEngineering.LikesToChillWebApp;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import static org.junit.Assert.*;
import org.junit.Test;

public class UserIT{
	
	@Test
	public void apiTestGetAllUsers() throws Exception {
		
		JSONParser parser = new JSONParser();

        try {         
            URL oracle = new URL("http://likestochill.heidyzqyc2.us-west-2.elasticbeanstalk.com/webapi/users"); // URL to Parse
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            
            String inputLine;
            while ((inputLine = in.readLine()) != null) { 
            	
                JSONArray array = (JSONArray) parser.parse(inputLine);
                
                String[] expectedResult = {"Sean","Arash","Brian","Peter","Ben"};
                
                // Loop through each item
                int i = 0;
                for (Object obj : array) {

                    JSONObject result = (JSONObject) obj;

                    String fName = (String) result.get("fName");
                    System.out.println("f NAME : " + fName);
                    
                    String lName = (String) result.get("lName");
                    System.out.println("l NAME : " + lName);

                    assertEquals(fName, expectedResult[i]);
                    i++;
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }   
		
	}
	
	@Test
	public void apiTestgetOneUser() throws Exception {
		
		JSONParser parser = new JSONParser();

        try {         
            URL oracle = new URL("http://likestochill.heidyzqyc2.us-west-2.elasticbeanstalk.com/webapi/users/2"); // URL to Parse
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            
            String inputLine;
            while ((inputLine = in.readLine()) != null) { 
            	
                JSONArray array = (JSONArray) parser.parse(inputLine);
                
                String[] expectedResult = {"Arash"};
                
                // Loop through each item

                for (Object obj : array) {

                    JSONObject result = (JSONObject) obj;

                    String fName = (String) result.get("fName");
                    System.out.println("f NAME : " + fName);
                    
                    String lName = (String) result.get("lName");
                    System.out.println("l NAME : " + lName);
                    
                    assertEquals(fName, expectedResult[0]);
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }   
		
	}

}
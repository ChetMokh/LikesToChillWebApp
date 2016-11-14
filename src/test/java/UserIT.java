import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Reporter;
import org.testng.annotations.Test;

import bsh.ParseException;

public class UserIT{

//	@Test
//	public void apiTesting1() throws Exception {
//		
//		try {
//
//				URL url = new URL("http://likestochill.heidyzqyc2.us-west-2.elasticbeanstalk.com/webapi/users");
//				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//				conn.setRequestMethod("GET");
//				conn.setRequestProperty("Accept", "application/json");
//	
//				if (conn.getResponseCode() != 200) {
//					throw new RuntimeException(" HTTP error code : "+ conn.getResponseCode());
//				}
//	
//				Scanner scan = new Scanner(url.openStream());
//				String entireResponse = new String();
//				while (scan.hasNext()) {
//					entireResponse += scan.nextLine();
//				}
//				System.out.println("Response : "+ entireResponse);
//	
//				scan.close();
//	
//
//				
////				JSONObject obj = new JSONObject(entireResponse);
//				
//				JSONArray obj1 = new JSONArray(entireResponse);
//
////				String responseCode = obj.getString(0);
////				System.out.println("status : " + responseCode);
//	
////				JSONArray arr = obj1.getJSONArray("results");
//				
//				String[] expectedResult = {"John","Sean","Arash","Brian","Peter","Ben"};
//				
//				for (int i = 0; i < 5; i++) {
//					String firstName = arr.getJSONObject(i).getString("fName");
//					System.out.println("fName : " + firstName);
//					String secondName = arr.getJSONObject(i).getString("lName");
//					System.out.println("lName : " + secondName);
//	
//					//validating Address as per the requirement
//					if(firstName.equalsIgnoreCase(expectedResult[i]))
//					{
//						System.out.println("Address is as Expected");
//					}
//					else
//					{
//						System.out.println("Address is not as Expected");
//					}
//				}
//	
//				conn.disconnect();
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//	
//		} catch (IOException e) {
//	
//			e.printStackTrace();
//	
//		}
//	
//	}
	
	@Test
	public void apiTestIT() throws Exception {
		
		JSONParser parser = new JSONParser();

        try {         
            URL oracle = new URL("http://likestochill.heidyzqyc2.us-west-2.elasticbeanstalk.com/webapi/users"); // URL to Parse
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            
            String inputLine;
            while ((inputLine = in.readLine()) != null) { 
            	
                JSONArray array = (JSONArray) parser.parse(inputLine);
                
                
                
                // Loop through each item
                for (int i = 0; i < array.length(); i++) {
                	
                    JSONObject result = array.getJSONObject(i);

                    String fName = (String) result.get("fName");
                    System.out.println("f NAME : " + fName);
                    
                    String lName = (String) result.get("lName");
                    System.out.println("l NAME : " + lName);

                    System.out.println("\n");
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }   
		
	}

//	
//	@Test
//	public void apiTesting2() throws Exception {
//	
//		try {
//				URL url = new URL("view-source:http://likestochill.heidyzqyc2.us-west-2.elasticbeanstalk.com/webapi/users/1");
//				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//				conn.setRequestMethod("GET");
//				conn.setRequestProperty("Accept", "application/json");
//	
//				if (conn.getResponseCode() != 200) {
//					throw new RuntimeException(" HTTP error code : "+ conn.getResponseCode());
//				}
//	
//				Scanner scan = new Scanner(url.openStream());
//				String entireResponse = new String();
//				while (scan.hasNext())
//					entireResponse += scan.nextLine();
//	
//				System.out.println("Response : "+entireResponse);
//	
//				scan.close();
//	
//				JSONObject obj = new JSONObject(entireResponse );
//				String responseCode = obj.getString("status");
//				System.out.println("status : " + responseCode);
//	
//				JSONArray arr = obj.getJSONArray("results");
//				
//				
//				
//				
//				String firstName = arr.getJSONObject(0).getString("fName");
//				System.out.println("fName : " + firstName);
//				
//				String secondName = arr.getJSONObject(0).getString("lName");
//				System.out.println("lName : " + secondName);
//
//				//validating Address as per the requirement
//				if(firstName.equalsIgnoreCase("John"))
//				{
//					System.out.println("Address is as Expected");
//				}
//				else
//				{
//					System.out.println("Address is not as Expected");
//				}
//				
//	
//				conn.disconnect();
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//	
//		} catch (IOException e) {
//	
//			e.printStackTrace();
//	
//		}
//	
//	}
}
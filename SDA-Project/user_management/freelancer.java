package user_management;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import booking_history.BookingHistory;

import java.io.*;
import java.sql.*;

public class freelancer extends User 
{
           private String username;
           private String skills;
           ArrayList<services> Service;
           BookingHistory booking = new BookingHistory();
          
           
         public freelancer(String fname, String lname, String address, int number, String Password, String email, String Username)
      	 {
      	        super.setFName(fname);
      	        super.setLName(lname);
      	        super.setAddress(address);
      	        super.setPhone_number(number);
      	        this.setUsername("F" + Username);
      	        super.setPassword(Password);
      	        super.setEmail(email);
     	        
      	 }
           
         public freelancer(String username)
         {       
      	        this.setUsername(username);
      	 }
         
        public freelancer() 
 	    {
 	        Service = new ArrayList<>();
 	    }

      	 
      	/*public String getUserId()
      	{
      		return UserId;
      	}*/
      	
      	public String getUsername()
      	{
      		return username;
      	}
      	
      	public String getSkills()
      	{
      		return skills;
      	}
      	
      	
      	
      	/*public void setUserId(String userId)
      	{
      		this.UserId = userId;
      	}*/
      	
      	public void setSkills(String skil)
      	{
      		this.skills = skil;
      	}
      	
      	
    	
      	public void setUsername(String username)
      	{
      		this.username = "F" + username;
      	}
      
      	public boolean addSkills(String skillsToAdd, String username)
      	{
    		//boolean previous_skill = false;
    		System.out.println("Adding new Skill for Freelancer");
    		System.out.println(skills);
    		
    		
    		  boolean skillExists = checkIfExists(skillsToAdd, username);

    	        if (skillExists) {
    	            System.out.println("Skill already exists. No insertion was performed.");
    	            return false;
    	        }
    		
    	            // Store data in the database if it doesn't already exist
    	         String url = "jdbc:mysql://localhost:3306/project";
    	         String u_n = "root";
    	         String p = "210936"; 
                    
                    try (Connection con = DriverManager.getConnection(url, u_n, p))
                    {
                        
                            // Account number doesn't exist, so insert the data
                            String sql = "INSERT INTO profile (skills, username) VALUES (?, ?)";
                            PreparedStatement preparedStatement = con.prepareStatement(sql);
                            preparedStatement.setString(1, skillsToAdd); 
                            preparedStatement.setString(2, username); 
                 	       
                	         
                	        int rowsInserted = preparedStatement.executeUpdate();
                           if (rowsInserted > 0) 
                           {
                                System.out.println("Data inserted successfully!");
                            }
                            preparedStatement.close();
                        } 
                      
                     
                    catch (SQLException e)
                    {
                        e.printStackTrace();
                    }
    		 return true;
        }
        
      	
      	
      	private boolean checkIfExists(String skillsToCheck, String username)
      	{
      		
      		String url = "jdbc:mysql://localhost:3306/project";
            String u_n = "root";
            String p = "210936";
          
            try (Connection con = DriverManager.getConnection(url, u_n, p)) {
                String checkIfExistsQuery = "SELECT COUNT(*) FROM profile WHERE skills = ? AND username = ?";
                try (PreparedStatement pstmt = con.prepareStatement(checkIfExistsQuery)) {
                    pstmt.setString(1, skillsToCheck);
                    pstmt.setString(2, username);
                    try (ResultSet resultSet = pstmt.executeQuery()) {
                        resultSet.next();
                        int rowCount = resultSet.getInt(1);
                        return rowCount > 0;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();  // Handle exceptions appropriately
                return false;
            }
        }
      	
        public boolean deleteSkills(String skillsToDelete, String username)
        {
        	System.out.println("Deleting Skill for Freelancer");
    		System.out.println(skills);
    		
    		
    		  boolean skillExists = checkIfExists(skillsToDelete, username);

    	        if (!skillExists) {
    	            System.out.println("Skill does not exist. No deletion was performed.");
    	            return false;
    	        }
    		
    	            // Store data in the database if it doesn't already exist
    	        String url = "jdbc:mysql://localhost:3306/project";
    	         String u_n = "root";
    	         String p = "210936";
                    
                    try (Connection con = DriverManager.getConnection(url, u_n, p))
                    {
                        
                            // Account number doesn't exist, so insert the data
                            String sql = "DELETE FROM profile WHERE skills=? AND username=?";
                            PreparedStatement preparedStatement = con.prepareStatement(sql);
                            preparedStatement.setString(1, skillsToDelete);
                            preparedStatement.setString(2, username);
                 	       
                	         
                	        int rowsDeleted = preparedStatement.executeUpdate();
                           if (rowsDeleted > 0) 
                           {
                                System.out.println("Data deleted successfully!");
                            }
                            preparedStatement.close();
                        } 
                      
                     
                    catch (SQLException e)
                    {
                        e.printStackTrace();
                    }
    		 return true;
        }
        
        
      	public void logout()   //ya phir in admin 
      	{
      		System.out.println("Loging out account with user id: ");
      		System.out.print(username);
      	}
           
      	
      	public ArrayList<String> getSkill(String username) {
            ArrayList<String> skils = new ArrayList<>();
            
            String url = "jdbc:mysql://localhost:3306/project";
            String u_n = "root";
            String p = "210936";
            
            String selectQuery = "SELECT skills FROM profile WHERE username = ?";
           
            try (Connection con = DriverManager.getConnection(url, u_n, p);
                 PreparedStatement preparedStatement = con.prepareStatement(selectQuery)) {

                preparedStatement.setString(1, username);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    skils.add(resultSet.getString("skills"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(skils + "_________");
            return skils;
        }
      	
      	
      	
      	public boolean addServiceToDatabase(String title, String description, String username, int price) 
      	{
      		
      		System.out.println("Adding new Service for Freelancer");
      		services newService = null;
      		boolean serviceExists = checkIfExists_S(title, username);

	        if (serviceExists) {
	            System.out.println("Service already exists. No insertion was performed.");
	            return false;
	        }
    		
	        if (newService == null)
            {
                newService = new services(title, description, price);
            }
      	    // Add the service details to the database
	        String url = "jdbc:mysql://localhost:3306/project";
	         String u_n = "root";
	         String p = "210936";
      	    
      	    try (Connection con = DriverManager.getConnection(url, u_n, p)) {
      	        // Insert service details into the database
      	        String sql = "INSERT INTO services (Title, Description, Price, Freelancer) VALUES (?, ?, ?, ?)";
      	        PreparedStatement preparedStatement = con.prepareStatement(sql);
      	        //preparedStatement.setInt(1, id);
      	        preparedStatement.setString(1, title);
      	        preparedStatement.setString(2, description);
      	        preparedStatement.setString(4, username);
      	        preparedStatement.setInt(3, price);

      	        int rowsInserted = preparedStatement.executeUpdate();

      	        
      	        if (rowsInserted > 0) 
      	        {
      	            // If service added to the database successfully, update the ArrayList
      	            
      	            System.out.println("Service added to the database and ArrayList successfully!");
      	            //Service.add(newService);
            	    return true;      	           
      	        } 
      	        else
      	        {
      	            System.out.println("Failed to add service to the database.");
      	            return false;
      	        }
      	    } 
      	    catch (SQLException e)
      	    {
      	        e.printStackTrace();
      	        return false;
      	    }
      	   
      	}
      	    
  	
      	
    	private boolean checkIfExists_S(String servicesToCheck, String username) {
      		
    		String url = "jdbc:mysql://localhost:3306/project";
            String u_n = "root";
            String p = "210936";
            
              try (Connection con = DriverManager.getConnection(url, u_n, p)) {
                  String checkIfExistsQuery = "SELECT COUNT(*) FROM services WHERE Title = ? AND Freelancer = ?";
                  try (PreparedStatement pstmt = con.prepareStatement(checkIfExistsQuery)) {
                      pstmt.setString(1, servicesToCheck);
                      pstmt.setString(2, username);
                      try (ResultSet resultSet = pstmt.executeQuery()) {
                          resultSet.next();
                          int rowCount = resultSet.getInt(1);
                          return rowCount > 0;
                      }
                  }
              } catch (SQLException e) {
                  e.printStackTrace();  // Handle exceptions appropriately
                  return false;
              }
              
          }

    	public boolean deleteServices(String servicesToDelete, String username) {
        	System.out.println("Deleting Service for Freelancer");
    		
    		
    		
    		  boolean serviceExists = checkIfExists_S(servicesToDelete, username);

    	        if (!serviceExists) {
    	            System.out.println("Service does not exist. No deletion was performed.");
    	            return false;
    	        }
    		
    	            // Store data in the database if it doesn't already exist
    	        String url = "jdbc:mysql://localhost:3306/project";
    	         String u_n = "root";
    	         String p = "210936";
                    
                    try (Connection con = DriverManager.getConnection(url, u_n, p))
                    {
                        
                            // Account number doesn't exist, so insert the data
                            String sql = "DELETE FROM services WHERE Title=? AND Freelancer=?";
                            PreparedStatement preparedStatement = con.prepareStatement(sql);
                            preparedStatement.setString(1, servicesToDelete);
                            preparedStatement.setString(2, username);
                 	       
                	         
                	        int rowsDeleted = preparedStatement.executeUpdate();
                           if (rowsDeleted > 0) 
                           {
                                System.out.println("Data deleted successfully!");
                            }
                            preparedStatement.close();
                        } 
                      
                     
                    catch (SQLException e)
                    {
                        e.printStackTrace();
                    }
    		 return true;
        }
    	
    	
    	public ArrayList<services> getServices(String username) 
    	{
    	    ArrayList<services> serv = new ArrayList<>();

    	    String url = "jdbc:mysql://localhost:3306/project";
            String un = "root";
            String p = "210936";

    	    String selectQuery = "SELECT * FROM services WHERE Freelancer = ?";

    	    try (Connection con = DriverManager.getConnection(url, un, p);
    	         PreparedStatement preparedStatement = con.prepareStatement(selectQuery)) {

    	        preparedStatement.setString(1, username);
    	        ResultSet resultSet = preparedStatement.executeQuery();

    	        while (resultSet.next()) {
    	            int id = resultSet.getInt("ServiceID");
    	            String title = resultSet.getString("Title");
    	            String description = resultSet.getString("Description");
    	            int price = resultSet.getInt("Price");

    	            // Assuming services class has a constructor that takes these parameters
    	            services service = new services(id, title, description, price);      //, title, description, price

    	            // Add the service to the ArrayList
    	            serv.add(service);
    	        }

    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }

    	    // Print the services (modify this part based on how you want to display the services)
    	    for (services service : serv) {
    	        System.out.println("Service ID: " + service.getID());
    	        System.out.println("Title: " + service.getTitle());
    	        System.out.println("Description: " + service.getDescription());
    	        System.out.println("Price: " + service.getPrice());
    	        System.out.println("-------------");
    	    }

    	    return serv;
    	}
    	
    	
    	public boolean F_ViewHistory(String f_username)
    	{
    		
    		  String url = "jdbc:mysql://localhost:3306/project";
              String un = "root";
              String p = "210936";
    		
            try (Connection con = DriverManager.getConnection(url, un, p)) 
    			 {
            	System.out.println("Insertion made" + f_username);
    				 String insertquery = "SELECT a.Customer as Customer, a.Freelancer as Freelancer, a.Service as Service, p.amount as Amount, p.PaymentMethod as PaymentMethod FROM applications a JOIN payment p ON a.Customer = p.Customer AND a.Freelancer = p.freelancer;";
    				
    				 PreparedStatement selectStatement = con.prepareStatement(insertquery);
    			   
    				 ResultSet selectResultSet = selectStatement.executeQuery();

    					while(selectResultSet.next())
    					{
    						String q = "SELECT COUNT(*) FROM bookinghistory WHERE Cusername = ? AND Fusername = ? AND service = ? AND payment = ? AND method = ?;";
    						 PreparedStatement qq = con.prepareStatement(q);
    		                 qq.setString(1, selectResultSet.getString("Customer"));
    		                 qq.setString(2, selectResultSet.getString("Freelancer"));
    		                 qq.setString(3, selectResultSet.getString("Service"));
    		                 qq.setDouble(4, selectResultSet.getDouble("Amount"));
    		                 qq.setString(5, selectResultSet.getString("PaymentMethod"));
    		                 ResultSet resultSet = qq.executeQuery();
    		                 resultSet.next();
    		                 int rowCount = resultSet.getInt(1);
    		                  
    		                    if (rowCount == 0)
    		                    {
    		                    	String customer = selectResultSet.getString("Customer");
    	    						String freelancer = selectResultSet.getString("Freelancer");
    	    						String s_er = selectResultSet.getString("Service");
    	    						double a = selectResultSet.getDouble("Amount");
    	    						String method = selectResultSet.getString("PaymentMethod");
    	    						System.out.println("Insertion made" + f_username );
    	    						booking.displayHistory(customer, freelancer, s_er, a,method);
    	    						 return true;
    		                    }
    						
    						
    						 			       
    					}

    					selectStatement.close();
    				 
    				
    				
    					 
    				 
    		      }
    			 catch (SQLException e)
                 {
                     e.printStackTrace();
                 }
            
    	return true;
    	
    	}
    	
    	
    	
}


package user_management;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;


public class Register    //admin class
{
	ArrayList<Customer> Customer;
	ArrayList<freelancer> Freelancer;
	
	/*public Register() 
	{
	    Customer = new ArrayList<>();
	    Freelancer = new ArrayList<>();
	}*/
	
	private static Register uniqueIns;

	private Register()
	{
		Customer = new ArrayList<>();
	    Freelancer = new ArrayList<>();
	}; //private

	public static Register getInstance()
	{

		if(uniqueIns==null)
		{
			uniqueIns = new Register();
		}
		return uniqueIns;
	}

	public boolean search(String search)
	{
		Customer customer = new Customer();
	    return customer.SearchServices(search);
	}
	
	/*public boolean signup_Customer(String Fname, String Lname, String address,int phoneNumber,String username, String email, String password)
	{
		Customer existing = null;
		boolean previous_customer = false;
		
		System.out.println("Signing Up for Customer");
		System.out.println(Fname + " " + Lname + " "+ address + " "+ phoneNumber+ " " + username + " "+ email + " "+ password);
		
		 for (Customer customer : Customer)
	        {
			 System.out.println("for loop");
	            if (customer.getFName().equals(Fname) && customer.getLName().equals(Lname) && customer.getAddress().equals(address)) 
	            {
	            	
	                	System.out.println("Customer already has an account. Sign in instead");
	                    previous_customer = true;    
	                    return false;
	                    //break;
	            }
	            
	         }
		 
		 if ( previous_customer == false) 
	        {
	        	
	            if (existing == null)
	            {
	                existing = new Customer(Fname,Lname,address, phoneNumber, username,email,password);
	            }
	            
	            // Store data in the database if it doesn't already exist
                String url = "jdbc:mysql://localhost:3306/project";
                String un = "root";
                String p = "210936";
                
                try (Connection con = DriverManager.getConnection(url, un, p))
                {
                    String checkIfExistsQuery = "SELECT COUNT(*) FROM user WHERE Username = ?";
                    PreparedStatement checkIfExistsStatement = con.prepareStatement(checkIfExistsQuery);
                    checkIfExistsStatement.setString(1, username);
                    ResultSet resultSet = checkIfExistsStatement.executeQuery();
                    resultSet.next();
                    int rowCount = resultSet.getInt(1);
                    
                    if (rowCount == 0) 
                    {
                        // Account number doesn't exist, so insert the data
                        String sql = "INSERT INTO user (Username, FirstName, LastName, Address, PhoneNumber, Email, Password) VALUES (?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement preparedStatement = con.prepareStatement(sql);
                         preparedStatement.setString(1, username); 
             	         preparedStatement.setString(2, Fname);
             	         preparedStatement.setString(3, Lname); 
             	         preparedStatement.setString(4, address); 
            	         preparedStatement.setInt(5,phoneNumber); 
            	         preparedStatement.setString(6, email);
            	         preparedStatement.setString(7, password);
            	         
            	        int rowsInserted = preparedStatement.executeUpdate();
                       if (rowsInserted > 0) 
                       {
                            System.out.println("Data inserted successfully!");
                            Customer.add(existing);
                        }
                        preparedStatement.close();
                    } 
                    else
                    {
                        System.out.println("Data already exists. No insertion was performed.");
                        return false;
                    }
                } 
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
     	      
	            
	            //Customer.add(existing);
	          
	   
	        } 
		 return true;
	}*/
	
	public boolean signup_Customer(String Fname, String Lname, String address,int phoneNumber,String username, String email, String password) {
		//boolean previous_skill = false;
		
		  boolean customerExists = checkIfCustomerExists(username);

	        if (customerExists) {
	            System.out.println("Customer already exists. No insertion was performed.");
	            return false;
	        }
		
	            // Store data in the database if it doesn't already exist
	        String url = "jdbc:mysql://localhost:3306/project";
            String un = "root";
            String p = "210936";
            
                
                try (Connection con = DriverManager.getConnection(url, un, p))
                {
                    
                        String sql = "INSERT INTO user (Username, FirstName, LastName, Address, PhoneNumber, Email, Password) VALUES (?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement preparedStatement = con.prepareStatement(sql);
                        preparedStatement.setString(1, username); 
             	         preparedStatement.setString(2, Fname);
             	         preparedStatement.setString(3, Lname); 
             	         preparedStatement.setString(4, address); 
            	         preparedStatement.setInt(5,phoneNumber); 
            	         preparedStatement.setString(6, email);
            	         preparedStatement.setString(7, password);
             	       
            	         
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


private boolean checkIfCustomerExists(String username) {
		
	 String url = "jdbc:mysql://localhost:3306/project";
     String un = "root";
     String p = "210936";
     
      try (Connection con = DriverManager.getConnection(url, un, p)) {
          String checkIfExistsQuery = "SELECT COUNT(*) FROM user WHERE username = ?";
          try (PreparedStatement pstmt = con.prepareStatement(checkIfExistsQuery)) {
              pstmt.setString(1, username);
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


public ArrayList<Customer> getCustomers(String username) {
    ArrayList<Customer> cust = new ArrayList<>();

    String url = "jdbc:mysql://localhost:3306/project";
    String un = "root";
    String p = "210936";
    

    String selectQuery = "SELECT * FROM user WHERE username = ?";

    try (Connection con = DriverManager.getConnection(url, un, p);
         PreparedStatement preparedStatement = con.prepareStatement(selectQuery)) {

        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            
            String f_name = resultSet.getString("Firstname");
            String l_name = resultSet.getString("Lastname");
            String add = resultSet.getString("Address");
            int num = resultSet.getInt("PhoneNumber");
            String pass = resultSet.getString("password");
            String em = resultSet.getString("Email");
            String usern = resultSet.getString("Username");
           

            // Assuming services class has a constructor that takes these parameters
            Customer customer = new Customer(f_name, l_name, add, num, pass, em, usern);      //, title, description, price

            // Add the service to the ArrayList
            cust.add(customer);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

   

    return cust;
}

	
	public boolean signup_freelancer(String Fname, String Lname, String address,int phoneNumber,String username, String email, String password)
	{
		freelancer existing = null;
		boolean previous_freelancer = false;
		
		System.out.println("Signing Up for Freelancer");
		System.out.println(Fname + " " + Lname + " "+ address + " "+ phoneNumber+ " " + username + " "+ email + " "+ password);
		
		 for (freelancer Freelancer : Freelancer)
	        {
	            if (Freelancer.getFName().equals(Fname) && Freelancer.getLName().equals(Lname) && Freelancer.getAddress().equals(address)) 
	            {
	                
	                	System.out.println("Freelancer already has an account. Sign in instead");
	                    previous_freelancer = true;    
	                    return false;
	                    //break;
	            }
	            
	         }
		 
		 if ( previous_freelancer == false) 
	        {
	        	
	            if (existing == null)
	            {
	                existing = new freelancer(Fname,Lname,address, phoneNumber, username,email,password);
	            }
	            
	            // Store data in the database if it doesn't already exist
	            String url = "jdbc:mysql://localhost:3306/project";
                String un = "root";
                String p = "210936";
                
                try (Connection con = DriverManager.getConnection(url, un, p))
                {
                    String checkIfExistsQuery = "SELECT COUNT(*) FROM user WHERE Username = ?";
                    PreparedStatement checkIfExistsStatement = con.prepareStatement(checkIfExistsQuery);
                    checkIfExistsStatement.setString(1, username);
                    ResultSet resultSet = checkIfExistsStatement.executeQuery();
                    resultSet.next();
                    int rowCount = resultSet.getInt(1);
                    
                    if (rowCount == 0) 
                    {
                        // Account number doesn't exist, so insert the data
                        String sql = "INSERT INTO user (Username, FirstName, LastName, Address, PhoneNumber, Email, Password) VALUES (?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement preparedStatement = con.prepareStatement(sql);
                        preparedStatement.setString(1, username); 
             	         preparedStatement.setString(2, Fname);
             	         preparedStatement.setString(3, Lname); 
             	         preparedStatement.setString(4, address); 
            	         preparedStatement.setInt(5,phoneNumber); 
            	         preparedStatement.setString(6, email);
            	         preparedStatement.setString(7, password);
            	         
            	        int rowsInserted = preparedStatement.executeUpdate();
                       if (rowsInserted > 0) 
                       {
                            System.out.println("Data inserted successfully!");
                        }
                        preparedStatement.close();
                    } 
                    else
                    {
                        System.out.println("Data already exists. No insertion was performed.");
                        return false;
                    }
                } 
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
     	      
	            
	            Freelancer.add(existing);
	          
	   
	        } 
		 return true;
	}
	
	public boolean login(String username, String password)
	{
		 // Store data in the database if it doesn't already exist
        String url = "jdbc:mysql://localhost:3306/project";
        String un = "root";
        String p = "210936";
		
		if(username.charAt(0) == 'C' || username.charAt(0) == 'F')
		{			 
			 try (Connection con = DriverManager.getConnection(url, un, p)) 
			 {
				 String checkIfExistsQuery = "SELECT COUNT(*) FROM user WHERE Username = ? and Password = ?";
				 PreparedStatement checkIfExistsStatement = con.prepareStatement(checkIfExistsQuery);
				 checkIfExistsStatement.setString(1, username);
				 checkIfExistsStatement.setString(2, password);
				 
				 ResultSet resultSet = checkIfExistsStatement.executeQuery();
				 resultSet.next();
				 int rowCount = resultSet.getInt(1);

				 if (rowCount == 0) 
				 {
					 System.out.println("Account not found");
					 return false;
				 }
				 else
				 {
					 System.out.println("Account found");
					 return true;
				 }
		      }
			 catch (SQLException e)
             {
                 e.printStackTrace();
             }
  	      

		}
		
		
		return false;
	}
	
	public void manage_account(int option, String username, String old, String newp, String address, int number)
	{
		
		Customer c = new Customer(username);
		
		if(option == 1 && username.charAt(0) == 'C')
		{
			c.changepassword(username, old, newp);
		}
		else if(option == 2 && username.charAt(0) == 'C')
		{
			c.updateinfo(username,address,number);
		}
		

		freelancer f = new freelancer(username);
		if(option == 1 && username.charAt(0) == 'F')
		{
			f.changepassword(username, old, newp);
		}
		else if(option == 2 && username.charAt(0) == 'F')
		{
			f.updateinfo(username,address,number);
		}
	}
	
	public boolean send_app( String c_username, String f_username, String service, int p, LocalDate localDate, boolean stat)
	{
		/*boolean previous_customer = false;
		//Customer cd = new Customer("Shaiza", "Rashid", "abc", 123, "123", "bhsd", "Fshaiza"); 
		//Customer.add(cd);

		int matchIndex = -1; // Initialize with a value that indicates no match
		for (int i = 0; i < Customer.size(); i++) 
		{
		    Customer customer = Customer.get(i);
            System.out.println("Cusername : " + c_username + customer.getUsername());
		    if (customer.getUsername().equals(f_username.trim()))
		    {
		        System.out.println("Customer already has an account. Sign in instead");
		        previous_customer = true;
		        matchIndex = i; 
		         
		    }
		}
		
		System.out.println("previous customer " + previous_customer);
		if(previous_customer == true)
		{
		    Customer matchingCustomer = Customer.get(matchIndex);
		    boolean c = matchingCustomer.HireFreelancer( c_username, f_username, service, p, localDate, stat);
		    System.out.println("Final step: " + c);
	        return c;
	    }
	
	return false;*/
		
		Customer c = new Customer(c_username);
		boolean check;
		check = c.HireFreelancer(c_username, f_username, service, p, localDate, stat);
		return check;
		
		/*boolean previous_customer = false;
		ArrayList<Customer> customerList = getCustomers(c_username);
		int matchIndex = -1; // Initialize with a value that indicates no match
		
		// Convert ArrayList to an array for JList
		System.out.println("Array Size: " + customerList.size());

		String[] customersArray = new String[customerList.size()];
		for (int i = 0; i < customerList.size(); i++) {
			
		    customersArray[i] = customerList.get(i).toString(); // Adjust this based on your services class
		    System.out.println(customersArray[i]);
		    Customer customer = customerList.get(i);
		   // System.out.println("++++++++" + customer);
		   // System.out.println("--------" + customer.getUsername());
		   // System.out.println("********" + c_username);
		   // System.out.println("9899889" + f_username.trim());
		    if (customer.getUsername().trim().equals(c_username.trim())) {
		     //   System.out.println("Customer already has an account. Sign in instead");
		        previous_customer = true;
		        matchIndex = i;
		    }
		}
		

		System.out.println("previous customer " + previous_customer);
		if(previous_customer == true)
		{
		    Customer matchingCustomer = customerList.get(matchIndex);
		    boolean c = matchingCustomer.HireFreelancer( c_username, f_username, service, p, localDate, stat);
		    System.out.println("Final step: " + c);
	        return c;
	    }
	
	return false;*/
	
	}
	
	public void storeInFile(String fname, String lname, String address, String username, String email, int num, String password)
	{
		try
	        {
			  String data = "\nUsername: " + username + "\nFirst Name: "+ fname + "\nLast Name: "+ lname + "\nAddress: " + address + "\nPhone: " + num + "\nEmail: " + email + "\nPassword: " + password ;
			 		      				  
			 // Set the true parameter to append data to the file
	        BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/Dell/Desktop/Users.txt", true));

	        // Write the data and add a newline character
	        writer.write(data);
	        writer.newLine();

	        // Close the writer
	        writer.close();

	        }
	        catch (IOException e3)
	        {
	            // TODO Auto-generated catch block
	            e3.printStackTrace();
	        }
	}
	
	public void storeNotifications(int option, String cuser, String fuser, String service)
	{
		if(option == 1)
		{
			try
			{
				String data =  "\n" + cuser + "sent a hiring application for " + service + " to  " + fuser ;

				BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/Dell/Desktop/Notifications.txt", true));
				writer.write(data);
				writer.newLine();

				writer.close();

			}	
			catch (IOException e3)
			{
				e3.printStackTrace();
			}
		}
		else
		{
			try
			{
				String data =  "\n" + fuser + "accepted the application for " + service + " from " + cuser ;
                System.out.println(data);
				BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/Dell/Desktop/Notifications.txt", true));
				writer.write(data);
				writer.newLine();

				writer.close();

			}	
			catch (IOException e3)
			{
				e3.printStackTrace();
			}
		}

	}
	
	public ArrayList<services> getServicess(String username) 
	{
		ArrayList<services> serv = new ArrayList<>();
		boolean prev = false;
		int index = 0;
		freelancer f = new freelancer(username);
		serv = f.getServices(username);
		return serv;
	}
	
	public ArrayList<services> getServices(String username) 
	{
		ArrayList<services> serv = new ArrayList<>();
		boolean prev = false;
		int index = 0;
		for (int i = 0; i < Freelancer.size(); i++)
	        {
	            if (Freelancer.get(i).getFName().equals(username)) 
	            {              	
	                    prev = true;
	                    index = i;
	                    System.out.println("Prev" + prev);
	                    break;
	            }
	            
	         }
		serv = Freelancer.get(index).getServices(username);
		return serv;
	}
	
	public boolean ViewHistory(int option, String username)
	{	if(option == 1)
	   {
		freelancer f = new freelancer();
	    return f.F_ViewHistory(username);	
	   }
	else
	{
		Customer c = new Customer();

	    return c.C_ViewHistory(username);	
	}
	}
	
}

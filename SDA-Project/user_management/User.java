package user_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class User implements manage_interface
{
	private String FirstName;
	private String LastName;
	private String address;
	private int Phonenumber;
	private String password;
	private String email;
	
	 public User()
	 {
	        this.setFName("");
	        this.setLName("");
	        this.setAddress("");
	        this.setPassword("");
	        this.setEmail("");
	        this.setPhone_number(0);
	 }
	
	 public User(String fname, String lname, String address, int number, String password, String email)
	 {
	        this.setFName(fname);
	        this.setLName(lname);
	        this.setAddress(address);
	        this.setPassword(password);
	        this.setEmail(email);
	        this.setPhone_number(number);
	 }
	 
	 public String getPassword()
		{
			return password;
		}
		
		public String getEmail()
		{
			return email;
		}
		
		public void setPassword(String password)
		{
			this.password = password;
		}
		
		public void setEmail(String email)
		{
			this.email = email;
		}
	 public String getFName()
		{
			return FirstName;
		}
	 
	 public String getLName()
		{
			return LastName;
		}
		

		public String getAddress()
		{
			return address;
		}
        
		 public void setFName(String fname)
			{
				this.FirstName = fname;
			}
		 
		 public void setLName(String lname)
			{
				this.LastName = lname;
			}
		
		public void setAddress(String address) 
		{
			this.address = address;
		}

		public int getPhone_number()
		{
			return Phonenumber;
		}

		public void setPhone_number(int phone_number) 
		{
			this.Phonenumber = phone_number;
		}
		
		public void changepassword (String username, String old, String newp)
		{
			String url = "jdbc:mysql://localhost:3306/project";
            String u_n = "root";
            String p = "210936";
            
    		
            try(Connection con = DriverManager.getConnection(url, u_n, p)) 
    		{
            	          		         		
    			String selectQuery = "SELECT * FROM user WHERE Username = ? and Password = ?";
    			PreparedStatement selectStatement = con.prepareStatement(selectQuery);
    			selectStatement.setString(1, username);
    			selectStatement.setString(2, old);
    			ResultSet selectResultSet = selectStatement.executeQuery();

    			if (selectResultSet.next())
    			{
    				String updateQuery = "UPDATE user SET Password = ? WHERE Username = ?";
    				PreparedStatement updateStatement = con.prepareStatement(updateQuery);
    				updateStatement.setString(1, newp);
    				updateStatement.setString(2, username);
        			
    				int rowsUpdated = updateStatement.executeUpdate();

    				if (rowsUpdated > 0)
    				{
    					System.out.println("Password has been changed");
    				}
    				
    			}
    			selectStatement.close();
    		}
    		 catch (SQLException e2)
             {
                 e2.printStackTrace();
             }
		}
		
		
	
	 public void updateinfo(String username, String address, int number)
	 {
		 String url = "jdbc:mysql://localhost:3306/project";
         String u_n = "root";
         String p = "210936";
 		
         try(Connection con = DriverManager.getConnection(url, u_n, p)) 
 		{       	
   			String selectQuery = "SELECT * FROM user WHERE Username = ?";
 			PreparedStatement selectStatement2 = con.prepareStatement(selectQuery);
 			selectStatement2.setString(1, username);
 			ResultSet selectResultSet = selectStatement2.executeQuery();

 			if (selectResultSet.next())
 			{
 				String updateQuery = "UPDATE user SET Address = ?, PhoneNumber = ? WHERE Username = ?";
 				PreparedStatement updateStatement = con.prepareStatement(updateQuery);
 				updateStatement.setString(1, address);
 				updateStatement.setInt(2, number);
 				updateStatement.setString(3, username);
     			
 				int rowsUpdated = updateStatement.executeUpdate();

 				if (rowsUpdated > 0)
 				{
 					System.out.println("Information has been updated");
 				}
 				updateStatement.close();
 			}
 			selectStatement2.close();
 		}
 		 catch (SQLException e2)
          {
              e2.printStackTrace();
          }
	 }
		
	
}

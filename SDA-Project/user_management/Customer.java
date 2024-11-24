package user_management;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import booking_history.BookingHistory;
import service_management.Bank;
import service_management.Paypal;
import service_management.hireFreelancer;


public class Customer extends User 
{ 
	
	private String username;
	hireFreelancer application = new hireFreelancer();	
	BookingHistory book = new BookingHistory();
	
	 public Customer(String fname, String lname, String address, int number, String Password, String email, String username)
	 {
	        super.setFName(fname);
	        super.setLName(lname);
	        super.setAddress(address);
	        super.setPhone_number(number);
	        this.setUsername(username);
	        super.setPassword(Password);
	        super.setEmail(email);
	 }

	
	public Customer() 
	{
		username = "";
	}

	public Customer(String username) 
	{
		this.username = username;
	}

	public String getUsername()
	{
		return username;
	}
	
	
	public void setUsername(String username)
	{
		this.username = "C" + username;
	}
	
	public String toString() 
	{
        return   getUsername();
	}
	
	
	public void logout()   //ya phir in admin 
	{
		System.out.println("Loging out account with user id: ");
		System.out.print(username);
	}
	
	public boolean SearchServices(String service) //return type service 
	{
		String url = "jdbc:mysql://localhost:3306/project";
        String un = "root";
        String p = "210936";
        try (Connection connection = DriverManager.getConnection(url, un, p))
	    {
	        String query = "SELECT * FROM services WHERE Title LIKE ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query))
	        {
	            preparedStatement.setString(1, "%" + service + "%");

	            try (ResultSet resultSet = preparedStatement.executeQuery())
	            {
	               return true;
	            }
	        }
	    } 
	    catch (SQLException e) 
	    {
	        e.printStackTrace(); // Handle the exception according to your application's needs
	    }
	    
	    return false;
	}
	
	public void ViewHistory()
	{
	}
	
	public boolean HireFreelancer( String c_username, String f_username, String service, int price, LocalDate localDate, boolean stat)
	{
		boolean check = false;
		check = application.send_application(c_username, f_username, service, price, localDate, stat);
		if (check == true)
		{
			return true;
		}
		return false;
		
	}


	public boolean makePayment(int option, String username, String fusername,double amount,String account_number, Date date2, int ssn, String secretkey) 
	{
		boolean check;
		if(option == 1)
		{
			Bank bank = new Bank(account_number, date2, ssn, amount);
			check = bank.make_payment(username, fusername, amount, account_number, date2, ssn);
		}
		else
		{
			Paypal paypal = new Paypal( account_number, secretkey, amount);
			check = paypal.make_payment(username, fusername, amount, account_number, secretkey);
		}
	  return check;
	}
	
	public boolean C_ViewHistory(String c_username)
	{
		String url = "jdbc:mysql://localhost:3306/project";
    String un = "root";
    String p = "210936";
	
  try (Connection con = DriverManager.getConnection(url, un, p)) 
		 {
  	System.out.println("Insertion made" + c_username);
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
  						System.out.println("Insertion made" + c_username );
  						book.displayHistory(customer, freelancer, s_er, a,method);
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

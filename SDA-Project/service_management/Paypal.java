package service_management;

import java.sql.*;

public class Paypal extends Payment
{
	String account_number;
	String secretkey;
	
	public Paypal()
	{
		account_number = "";
		secretkey = "";
		super.amount = 0;
	}
	
	public Paypal(String num, String key, double amount)
	{
		account_number = num;
		secretkey = key;
		super.amount = amount;
	}
		
	public void setAccountnumber(String num)
	{
		account_number = num;
	}
	
	public String getAccountnumber()
	{
		return account_number;
	}
	
	public void setSecretkey(String key)
	{
		secretkey = key;
	}
	
	public String getSecretkey()
	{
		return secretkey;
	}
	
	public boolean make_payment(String c_user, String f_user, double amount, String num, String key)
	{
		    String url = "jdbc:mysql://localhost:3306/project";
	        String un = "root";
	        String p = "210936";
			
	        try (Connection con = DriverManager.getConnection(url, un, p)) 
				 {
					 String insertquery = "INSERT INTO payment (Customer, Freelancer,Amount,PaymentMethod) VALUES (?,?,?,?)";
					 PreparedStatement preparedStatement = con.prepareStatement(insertquery);
					 preparedStatement.setString(1, c_user);
					 preparedStatement.setString(2, f_user);
					 preparedStatement.setDouble(3,amount);
					 preparedStatement.setString(4, "Paypal");
					 int rowsInserted = preparedStatement.executeUpdate();
		             if (rowsInserted > 0) 

					 if (rowsInserted == 0) 
					 {
						 System.out.println("Payment cannot be madde");
						 return false;
					 }
					 else
					 {
						 System.out.println("Payment made");
						 return true;
					 }
			      }
				 catch (SQLException e)
	             {
	                 e.printStackTrace();
	             }
	        
	  	      return false;
	}
}

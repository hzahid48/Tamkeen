package service_management;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bank extends Payment
{
	String account_number;
	Date expirydate;
	int SSN;
	
	public Bank()
	{
		account_number = "";
		expirydate = null;
		SSN = 0;
	}
	
	public Bank(String num, Date date, int ssn, double amount)
	{
		account_number = num;
		expirydate = date;
		SSN = ssn;
		super.amount = amount;
	}
	
	public void setExpiryDate(Date date)
	{
		expirydate = date;
	}
	
	public Date getExpiryDate()
	{
		return expirydate;
	}
	
	public void setAccountnumber(String num)
	{
		account_number = num;
	}
	
	public String getAccountnumber()
	{
		return account_number;
	}
	public void setSSN(int ssn)
	{
		SSN = ssn;
	}
	
	public int getSSN()
	{
		return SSN;
	}
	
	public boolean make_payment(String c_user, String f_user, double amount, String num, Date expiry, int SSN)
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
					 preparedStatement.setInt(3, (int) Math.round(amount));
					 preparedStatement.setString(4, "Bank Transfer");
					 int rowsInserted = preparedStatement.executeUpdate();
					 
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

package booking_history;
import java.sql.*;
import java.time.LocalDate;


public class BookingHistory 
{
         
	public boolean displayHistory(String c_user, String f_user, String serv, double am, String method) {
		
		
	     
	     String url = "jdbc:mysql://localhost:3306/project";
	        String un = "root";
	        String p = "210936";
	        
	        try (Connection con = DriverManager.getConnection(url, un, p)) 
				 {
	        	
	        	 /*String checkIfExistsQuery = "SELECT COUNT(*) FROM bookinghistory WHERE Cusername = ? and Fusername = ?";
                 PreparedStatement checkIfExistsStatement = con.prepareStatement(checkIfExistsQuery);
                 checkIfExistsStatement.setString(1, c_user);
                 checkIfExistsStatement.setString(2, f_user);
                 ResultSet resultSet = checkIfExistsStatement.executeQuery();
                 resultSet.next();
                 int rowCount = resultSet.getInt(1);
                 
                 if (rowCount == 0) 
                 {*/
					 String insertquery = "INSERT INTO bookinghistory (Cusername, Fusername, service, payment, method) VALUES (?,?,?,?,?)";
					 PreparedStatement preparedStatement = con.prepareStatement(insertquery);
					 preparedStatement.setString(1, c_user);
					 preparedStatement.setString(2, f_user);
					 preparedStatement.setString(3, serv);
					 preparedStatement.setInt(4, (int) Math.round(am));
					 preparedStatement.setString(5,method);
					 //preparedStatement.setDate(5, Date.valueOf(date));
					 int rowsInserted = preparedStatement.executeUpdate();
					 
					 if (rowsInserted == 0) 
					 {
						
						 return false;
					 }
					 else
					 {
						 System.out.println("Insertion made");
						 return true;
					 }
			     /* }
                 else
                 {
                     System.out.println("Data already exists. No insertion was performed.");
                     return false;
                 }*/
				 }
				 catch (SQLException e)
	             {
	                 e.printStackTrace();
	             }
	        
		return true;
		
	}
}


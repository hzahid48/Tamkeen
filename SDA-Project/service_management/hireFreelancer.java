package service_management;

import java.sql.*;
import java.time.LocalDate;

public class hireFreelancer 
{
	private String freelancerId;
	private boolean status;
	private Date date;
	private String app_id;
	
	public hireFreelancer()
	{
		freelancerId = "";
		status = false;
		date = null;
		app_id = "";		
	}
	
	public hireFreelancer(String id, boolean Status, Date date, String a_id)
	{
		freelancerId = id;
		status = Status;
		date = getCurrentDate();
		app_id = a_id;		
	}
	
	public String getFreelancerId() {
		return freelancerId;
	}
	public void setFreelancerId(String freelancerId) {
		this.freelancerId = freelancerId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getApp_id() {
		return app_id;
	}
	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}
	
	private Date getCurrentDate() 
	{
        java.util.Date utilDate = new java.util.Date();
        return new Date(utilDate.getTime());
    }
	
	public boolean send_application( String c_username, String f_username, String service, int price, LocalDate localDate, boolean stat)
	{
		System.out.println("IN HIRE FREELANCER " );
		 // Store data in the database if it doesn't already exist
        String url = "jdbc:mysql://localhost:3306/project";
        String un = "root";
        String p = "210936";
        
        try (Connection con = DriverManager.getConnection(url, un, p))
        {
            String checkIfExistsQuery = "SELECT COUNT(*) FROM applications WHERE Customer = ? AND Freelancer = ? AND Service = ?";
            PreparedStatement checkIfExistsStatement = con.prepareStatement(checkIfExistsQuery);
            checkIfExistsStatement.setString(1, c_username);
            checkIfExistsStatement.setString(2, f_username);
            checkIfExistsStatement.setString(3, service);
            ResultSet resultSet = checkIfExistsStatement.executeQuery();
            resultSet.next();
            int rowCount = resultSet.getInt(1);

            if (rowCount == 0) 
            {
                // Account number doesn't exist, so insert the data
                String sql = "INSERT INTO applications (Customer, Freelancer, Service, Price, Date, Status) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                 //preparedStatement.setString(1, id); 
     	         preparedStatement.setString(1, c_username);
     	         preparedStatement.setString(2, f_username); 
     	         preparedStatement.setString(3, service); 
    	         preparedStatement.setInt(4,price); 
    	         preparedStatement.setDate(5, Date.valueOf(localDate));
    	         preparedStatement.setBoolean(6, stat);
    	         
    	        int rowsInserted = preparedStatement.executeUpdate();
               if (rowsInserted > 0) 
               {
                    System.out.println("Data inserted successfully!");
                    preparedStatement.close();
                    return true;
               }
                
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
        
        return true;
	}
	
}

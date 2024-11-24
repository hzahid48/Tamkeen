package user_management;

import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.*;
import java.sql.*;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class services {
           private int service_id;
           private String title;
           private String description;
           private int price;
           
           public services(int id, String t, String des, int p)
      	 {    
      	        this.setID(id); 
      	        this.setTitle(t);
      	        this.setDescription(des);
      	        this.setPrice(p);     
      	 }
           
           public services(String t, String des, int p)
        	 {    
        	        this.setTitle(t);
        	        this.setDescription(des);
        	        this.setPrice(p);     
        	 }
           
           public services(int id)
        	 {    
        	        this.setID(id); 
        	 }
           
           public services(String title)
      	 {    
      	        
      	        this.setTitle(title);
      	        
      	 }
           
           
          /* public services(String des)
      	 {    
      	        
      	        this.setDescription(des);
      	        
      	 }
           
           public services(int p)
      	 {    
      	        
      	        this.setPrice(p);     
      	 }*/
           
           
        public int getID()
       	{
       		return service_id;
       	}
        
        public void setID(int id)
    	{
    		this.service_id = id;
    	}
        
        
        public void setTitle(String title)
    	{
    		this.title = title;
    	}
        
        public String getTitle()
       	{
       		return title;
       	}
        
        
        public void setDescription(String des)
    	{
    		this.description = des;
    	}
        
        public String getDescription()
       	{
       		return description;
       	}
        
        
        public int getPrice()
       	{
       		return price;
       	}
        
        public void setPrice(int p)
    	{
    		this.price = p;
    	}
        
        
        public String toString() {
            return getID() + "  " + getTitle() + "  " + getDescription() + "  " + getPrice() ;
        }
        
        /*public String toString() {
            return String.valueOf(getID());
        }
        
        public String toString2() {
            return String.valueOf(getTitle());
        }
        
        public String toString3() {
            return String.valueOf(getDescription());
        }
        
        public String toString4() {
            return String.valueOf(getPrice());
        }*/
        
        
}

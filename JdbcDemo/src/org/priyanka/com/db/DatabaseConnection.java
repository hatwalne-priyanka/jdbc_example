package org.priyanka.com.db;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.StringTokenizer;

public class DatabaseConnection {
	private Connection myConn;
	private static  String DB_NAME ;
	private static  String DB_USERNAME;
	private static  String DB_PASSWORD;
	private static  String DB_HOST;
	private static  String DB_PORT;
	
	//makes database connection
	protected DatabaseConnection() throws SQLException, IOException{
		System.out.println("Working Directory = " +
	              System.getProperty("user.dir"));
		FileInputStream fis=new FileInputStream("dbconfig"); 
		
	      BufferedReader br=new BufferedReader(new InputStreamReader(fis));  
	      String str;  
	      while((str =  br.readLine())!=null){  
	    	  String [] parts = str.split(":");
	    	  if(parts[0].equals("DB_NAME") ){
	    		  DB_NAME = parts[1].trim(); 
	    	  }
	    	  else if(parts[0].equals("DB_USERNAME")){
	    		  DB_USERNAME = parts[1].trim();
	    	  }
	    	  else if(parts[0].equals("DB_PASSWORD")){
	    		  DB_PASSWORD = parts[1].trim();
	    	  }
	    	  else if(parts[0].equals("DB_HOST")){
	    		  DB_HOST = parts[1].trim();
	    	  }
	    	  else if(parts[0].equals("DB_PORT")){
	    		  DB_PORT = parts[1].trim();
	    	  }
	      }   
	      br.close();  
	      fis.close();
	      System.out.println("Db host = " + DB_HOST);
	      if(DB_NAME == null){
		   		throw new NullPointerException("Database name missing in db config file!!");
	    	  }
	    	  else if(DB_USERNAME == null){
	    		  throw new NullPointerException("Database user name missing in db config file!!");
	    	  }
	    	  else if(DB_PASSWORD == null){
	    		  throw new NullPointerException("Database password missing in db config file!!");
	    	  }
	    	  else if(DB_HOST == null){
	    		  throw new NullPointerException("Database host missing in db config file!!");
	    	  }
	    	  else if(DB_PORT == null){
	    		  throw new NullPointerException("Database PORT missing in db config file!!");
	    	  }
	    
		  myConn = DriverManager.getConnection("jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME, DB_USERNAME, DB_PASSWORD);
	
	}

	public Connection getMyConn() {
		return myConn;
	}
	
	

}

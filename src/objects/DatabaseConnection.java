package objects;
import java.sql.*;

public class DatabaseConnection {
	// JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/HERMES";
	   
	// Database credentials
   static final String USER = "root";
   static final String PASS = "tw3ntyon3";
	   
   private static Connection conn = null;
   private static Statement stmt = null;
	   
   public DatabaseConnection() {
	   
   }
   
   
	/**
	 * Starts the database connection.    
	 */
   public void startDB() {
	   try{
	      //Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
	   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
	   }
   }

   public void closeDB() {
      //used to close resources
      try {
         if(stmt!=null)
            stmt.close();
      } catch(SQLException se2){
      }// nothing we can do
      try {
         if(conn!=null)
            conn.close();
      } catch(SQLException se){
         se.printStackTrace();
      }//end try
      System.out.println("Closed database!");
   }
   
   public boolean searchDB(String user, String pword) {
	   boolean access = false;
	   try{
		      //Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT id, password "
		      		+ "FROM Users "
		      		+ "WHERE id = \'" + user + "\' AND password = \'" 
		      		+ pword + "\';";
		      ResultSet rs = stmt.executeQuery(sql);

		      if(rs.next() == false) {
		    	  System.out.println("Sorry please try again.");
		    	  access = false;
		      }
		      else {
		    	  System.out.println("Time to go to the next phase");
		    	  access = true;
		      }
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
	   return access;
   }
   
   public ResultSet showJobs() {
	   ResultSet rs = null;
	   try {
		  stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT * from jobs";
	      rs = stmt.executeQuery(sql);
	      
	   } catch(SQLException se) {
		   se.printStackTrace();
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   
	   return rs;
   }

   public int getNumOfJobs() {
	   ResultSet rs = null;
	   int numOfRows = 0;
	   try {
			  stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT COUNT(*)\r\n" + 
		      		"FROM jobs;";
		      rs = stmt.executeQuery(sql);
		      while(rs.next()) {
				   numOfRows = rs.getInt("COUNT(*)");
			   }
		      
		      System.out.println("The number of rows in jobs table is: " + numOfRows);
		      
	   } catch(SQLException se) {
		   se.printStackTrace();
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   return numOfRows;
	  
   }
   public void addJob(int j, String p, String d, String pNum, String cName, Double price, String date, int com, int driver) {
	   try {
		   stmt = conn.createStatement();
		   String sql;
		   sql = "INSERT INTO jobs " + 
		   		 "VALUES (" + j + ", "
		   		 + "\'" + p + "\', "
		   		 + "\'" + d + "\', "
		   		 + "\'" + pNum + "\', "
		   		 + "\'" + cName + "\', "
		   		 + price + ", "
		   		 + "\'" + date + "\', "
		   		 + com + ", "
		   		 + driver 
		   		 + ");";
		   System.out.println(sql);
		   stmt.executeUpdate(sql);
		   
	   }catch(SQLException se) {
		   se.printStackTrace();
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   public static void main(String[] args) {
		  

   }
}

 
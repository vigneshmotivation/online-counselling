package com.inautix.training.counselling.dao;
import java.sql.*;
public class DbConnection {
	/**
	 * THIS CLASS CONTAINS A CONSTRUCTOR WHICH CONNECTS TO THE DATABASE..
	 * PLEASE EXTEND THIS CLASS AND CALL THE CONSTRUCTOR IN ALL OTHER DAO CLASSES
	 */
	public String host = "java sun.jdbc.odbc.jdbcodbcdriver";
	 
	public String user = "shobana";
	public String pwd = "shobana";
	public DbConnection()throws SQLException, ClassNotFoundException
	{
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
		
	}
	

}

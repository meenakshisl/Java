package core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Properties;
import java.sql.Statement;

public class DataObject{
	
	private static  Connection connection;
	//private static Properties props;
	String url = "jdbc:mysql://127.0.0.1:3306/project";
	String user = "admin";
	String pass = "admin";

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		try
		{
			connection = DriverManager.getConnection(url,user,pass);
			System.out.println("Connection successful");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return connection;
	}
	public static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}

	public void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);		
	}


	/**
	 * @param connection the connection to set
	 */
/*	public void setConnection(Connection connection) {
		DataObject.connection = connection;
	}

	
	 * @return the props
	
	public Properties getProperties() {
		return props;
	}

	/**
	 * @param props the props to set
	
	public void setProperties(Properties props) {
		DataObject.props = props;
	}
	*/
	/*public static void main(String[] args)
	{
		DataObject d = new DataObject();
		d.getConnection();
	}*/

}
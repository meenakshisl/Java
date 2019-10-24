package core.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*import java.util.Properties;
*import javax.naming.InitialContext;
*import javax.naming.NamingException;
*import javax.sql.DataSource;
*/

import core.util.*;


public class DbCon extends DataObject implements DbInterface
{
    
    Connection con;
    public DbCon() {
    }

    public Connection getConnection() 
    {
        try
        {
            if(con==null)
            {
                try 
                {
                	Class.forName("java.sql.Driver");
            		String url,user,pass;
            		url = "jdbc:mysql://127.0.0.1:3306/project";
            		user = "admin";
            		pass = "admin";
            		con = DriverManager.getConnection(url,user,pass);
            		System.out.println("Connection established");
                }
                catch (ClassNotFoundException cnf)
                {
                	LoggerManager.writeLogWarning(cnf);
                }
            }
        }
        catch (SQLException sqlex) 
        {
        	
        	sqlex.printStackTrace();
        	LoggerManager.writeLogSevere(sqlex);
        }  
        return con;
    }
    public void close()
    {
        if(con!=null)
        {
            try {
                con.close();
            } catch (SQLException sqlex) {
            	LoggerManager.writeLogSevere(sqlex);
            }
        }
    }
}
/*    public static void main(String[] args)
 *  {
 *   	new DbCon().getConnection();
 *  }
}*/

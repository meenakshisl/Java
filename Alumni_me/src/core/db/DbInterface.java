package core.db;


import java.sql.Connection;

public interface DbInterface 
{
    public Connection getConnection();   
    public void close();
}
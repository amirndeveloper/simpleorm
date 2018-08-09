package ir.amnoori.simpleorm.orm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoManager {

    // JDBC Driver Name & Database URL
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_DB_URL = "jdbc:mysql://localhost:3306/?useSSL=false";
    // JDBC Database Credentials
    private static final String JDBC_USER = "newuser";
    private static final String JDBC_PASS = "pc4jWnbD^W9V4y&W";

    public static DaoManager getInstance() {
        return DAOManagerSingleton.INSTANCE;
    }

    public void open() throws SQLException {
        try
        {
            if(this.con==null || this.con.isClosed())
                this.con = DriverManager
                        .getConnection(JDBC_DB_URL,JDBC_USER, JDBC_PASS);
        }
        catch(SQLException e) { throw e; }
    }

    public void close() throws SQLException {
        try
        {
            if(this.con!=null && !this.con.isClosed())
                this.con.close();
        }
        catch(SQLException e) { throw e; }
    }

    //Private

    private Connection con;

    public DaoManager() throws Exception {
        try
        {
            Class.forName(JDBC_DRIVER);
            con = DriverManager
                    .getConnection(JDBC_DB_URL,JDBC_USER, JDBC_PASS);

        }
        catch(Exception e) { throw e; }
    }

    private static class DAOManagerSingleton {

        static final DaoManager INSTANCE;
        static
        {
            DaoManager dm;
            try
            {
                dm = new DaoManager();
            }
            catch(Exception e)
            {
                dm = null;
            }
            INSTANCE = dm;
        }

    }

}
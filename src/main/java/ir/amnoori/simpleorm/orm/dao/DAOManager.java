package ir.amnoori.simpleorm.orm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOManager {

    private static volatile DAOManager instance ;

    private static Object mutex = new Object();

    // JDBC Driver Name & Database URL
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String JDBC_DB_URL = "jdbc:mysql://localhost:3306/temp?useSSL=false";

    // JDBC Database Credentials
    private static final String JDBC_USER = "newuser";

    private static final String JDBC_PASS = "pc4jWnbD^W9V4y&W";

    public static DAOManager  getInstance() {

        DAOManager  result = instance;

        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null) {
                    try {
                        instance = result = new DAOManager ();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return result;
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

    private Connection con;

    private DAOManager() throws Exception {
        try
        {
            Class.forName(JDBC_DRIVER);
           con = DriverManager
                   .getConnection(JDBC_DB_URL,JDBC_USER, JDBC_PASS);
        }
        catch(Exception e) { throw e; }
    }
}
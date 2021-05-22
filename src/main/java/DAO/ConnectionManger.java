package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManger {

    private static final String dbURL = "jdbc:mysql://localhost:3306/lms";
    private static final String dbUserName = "hbstudent";
    private static final String dbUserPass = "hbstudent";

    public static Connection getConnection(){
        try {
            Connection conn = DriverManager.getConnection(dbURL,dbUserName,dbUserPass);
            return conn;
        }
        catch (SQLException sqlExc){
            System.err.println("SQLexce: "+sqlExc.getMessage());
            return null;
        }
    }



}

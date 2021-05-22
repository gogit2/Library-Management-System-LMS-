package DAO;

import DataAccess.ConnectionManger;
import entities.Admin;

import java.sql.*;
import java.util.ArrayList;

public class AdminDA implements BaseDA<Admin> {

    @Override
    public ArrayList<Admin> FindAll() throws SQLException{

        ArrayList<Admin> adminList = new ArrayList<>();

        // db connection
        Connection conn = null;
        Statement stm = null;
        ResultSet resSet = null;

        try {
            // get db connection
            conn = ConnectionManger.getConnection();
            stm = conn.createStatement();
            String sqlStrQuery = "select * from lib_admin";
            resSet = stm.executeQuery(sqlStrQuery);

            // getting admin list data
            while (resSet.next()) {
                int id = resSet.getInt("admin_id");
                String full_name = resSet.getString("full_name");
                String phone = resSet.getString("phone");
                // String nm = resSet.getString(2);
                Admin tempAdmin = new Admin(id, full_name, phone);
                adminList.add(tempAdmin);
                // System.out.println(tempAdmin.toString());
            }
            return adminList;
        } finally {
            // start closing JDBC objects
            Close(conn, stm, resSet);
        }
    }

    @Override
    public Admin FindById(int req_id) throws SQLException {
        Admin tempAdmin = null;

        // db connection
        Connection conn = null;
        Statement stm = null;
        ResultSet resSet = null;

        try {
            // get db connection
            conn = ConnectionManger.getConnection();
            stm = conn.createStatement();
            String sqlStrQuery = "select * from lib_admin where admin_id="+req_id;
            resSet = stm.executeQuery(sqlStrQuery);

            // getting admin list data
            while (resSet.next()) {
                int id = resSet.getInt("admin_id");
                String full_name = resSet.getString("full_name");
                String phone = resSet.getString("phone");
                // String nm = resSet.getString(2);
                tempAdmin = new Admin(id, full_name, phone);
                // System.out.println(tempAdmin.toString());
            }
            return tempAdmin;
        } finally {
            // start closing JDBC objects
            Close(conn, stm, resSet);
        }
    }

    @Override
    public Admin FindByName(String name) throws SQLException {
        Admin tempAdmin = null;

        // db connection
        Connection conn = null;
        Statement stm = null;
        ResultSet resSet = null;

        try {
            // get db connection
            conn = ConnectionManger.getConnection();
            stm = conn.createStatement();
            String sqlStrQuery = "select * from lib_admin where full_name like '%"+name+"%'";
            resSet = stm.executeQuery(sqlStrQuery);

            // getting admin list data
            while (resSet.next()) {
                int id = resSet.getInt("admin_id");
                String full_name = resSet.getString("full_name");
                String phone = resSet.getString("phone");
                // String nm = resSet.getString(2);
                tempAdmin = new Admin(id, full_name, phone);
                // System.out.println(tempAdmin.toString());
            }
            return tempAdmin;
        } finally {
            // start closing JDBC objects
            Close(conn, stm, resSet);
        }
    }

    @Override
    public void Save (Admin admin) throws SQLException{

        Connection conn = null;
        PreparedStatement prStmt = null;

        try {
            conn = ConnectionManger.getConnection();
            String sqlQuery = "insert into lib_admin "
                    + "(full_name, phone) "
                    + "values (?, ?)";
            prStmt = conn.prepareStatement(sqlQuery);
            prStmt.setString(1, admin.getName());
            prStmt.setString(2, admin.getPhone());
            prStmt.executeUpdate();
            System.out.println("done ........ executed");
        }
        finally {
            Close(conn,prStmt,null);
        }
    }

    @Override
    public void Update (Admin admin) throws SQLException{

        // db connection
        Connection conn = null;
        PreparedStatement prStmt = null;

        try {
            conn = ConnectionManger.getConnection();
            String sqlQuery = "update lib_admin set full_name=?"
                    + ",phone=?"
                    + " where admin_id=?";
            prStmt = conn.prepareStatement(sqlQuery);
            prStmt.setString(1, admin.getName());
            prStmt.setString(2, admin.getPhone());
            prStmt.setInt(3, admin.getId());
            prStmt.executeUpdate();
            System.out.println("done ........ executed updated");
        }
        finally {
            Close(conn,prStmt,null);
        }
    }

    @Override
    public boolean Delete(int req_id) throws SQLException {
        // db connection
        Connection conn = null;
        Statement stm = null;

        try {
            conn = ConnectionManger.getConnection();
            stm = conn.createStatement();
            String sqlQuery = "delete from lib_admin where admin_id="+req_id;
            boolean result = stm.execute(sqlQuery);
            return result;
        }
        finally {
            Close(conn,stm,null);
        }

    }


    private void Close(Connection mConnection, Statement mStatement, ResultSet mResultSet) {
        try {
            if (mConnection != null) {
                mConnection.close();
            }
            if (mStatement != null) {
                mStatement.close();
            }
            if (mResultSet != null) {
                mResultSet.close();    // doesn't really close it ..just put it pack in connection pool
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

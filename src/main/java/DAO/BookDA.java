package DAO;

import DataAccess.ConnectionManger;
import entities.Book;
import entities.Member;

import java.sql.*;
import java.util.ArrayList;

public class BookDA implements BaseDA<Book> {

    @Override
    public ArrayList<Book> FindAll() throws SQLException{

        ArrayList<Book> bookList = new ArrayList<>();

        // db connection
        Connection conn = null;
        Statement stm = null;
        ResultSet resSet = null;

        try {
            // get db connection
            conn = ConnectionManger.getConnection();
            stm = conn.createStatement();
            String sqlStrQuery = "select * from book";
            resSet = stm.executeQuery(sqlStrQuery);

            // getting admin list data
            while (resSet.next()) {
                int id = resSet.getInt("book_id");
                String book_name = resSet.getString("book_name");
                int isbn = resSet.getInt("ISBN");
                String category = resSet.getString("category");
                // String nm = resSet.getString(2);
                Book tempBook = new Book(id, book_name,isbn,category);
                bookList.add(tempBook);
                // System.out.println(tempAdmin.toString());
            }
            return bookList;
        } finally {
            // start closing JDBC objects
            Close(conn, stm, resSet);
        }
    }

    @Override
    public Book FindById(int req_id) throws SQLException {
        Book tempBook = null;

        // db connection
        Connection conn = null;
        Statement stm = null;
        ResultSet resSet = null;

        try {
            // get db connection
            conn = ConnectionManger.getConnection();
            stm = conn.createStatement();
            String sqlStrQuery = "select * from book where book_id="+req_id;
            resSet = stm.executeQuery(sqlStrQuery);

            // getting admin list data
            while (resSet.next()) {
                int id = resSet.getInt("book_id");
                String book_name = resSet.getString("book_name");
                int isbn = resSet.getInt("ISBN");
                String category = resSet.getString("category");
                // String nm = resSet.getString(2);
                tempBook = new Book(id, book_name,isbn,category);
            }
            return tempBook;
        } finally {
            // start closing JDBC objects
            Close(conn, stm, resSet);
        }
    }

    @Override
    public Book FindByName(String name) throws SQLException {
        Book tempBook = null;

        // db connection
        Connection conn = null;
        Statement stm = null;
        ResultSet resSet = null;

        try {
            // get db connection
            conn = ConnectionManger.getConnection();
            stm = conn.createStatement();
            String sqlStrQuery = "select * from book where book_name like '%"+name+"%'";
            resSet = stm.executeQuery(sqlStrQuery);

            // getting admin list data
            while (resSet.next()) {
                int id = resSet.getInt("book_id");
                String book_name = resSet.getString("book_name");
                int isbn = resSet.getInt("ISBN");
                String category = resSet.getString("category");
                // String nm = resSet.getString(2);
                tempBook = new Book(id, book_name,isbn,category);
            }
            return tempBook;
        } finally {
            // start closing JDBC objects
            Close(conn, stm, resSet);
        }
    }

    @Override
    public void Save (Book book) throws SQLException{

        Connection conn = null;
        PreparedStatement prStmt = null;

        try {
            conn = ConnectionManger.getConnection();
            String sqlQuery = "insert into book "
                    + "(book_name, ISBN, category) "
                    + "values (?, ?, ?)";
            prStmt = conn.prepareStatement(sqlQuery);
            prStmt.setString(1, book.getName());
            prStmt.setInt(2, book.getIsbn());
            prStmt.setString(3, book.getCategory());
            prStmt.executeUpdate();
            System.out.println("done ........ executed");
        }
        finally {
            Close(conn,prStmt,null);
        }
    }

    @Override
    public void Update (Book book) throws SQLException{

        // db connection
        Connection conn = null;
        PreparedStatement prStmt = null;

        try {
            conn = ConnectionManger.getConnection();
            String sqlQuery = "update book set book_name=?"
                    + ",ISBN=?,category=?"
                    + " where book_id=?";
            prStmt = conn.prepareStatement(sqlQuery);
            prStmt.setString(1, book.getName());
            prStmt.setInt(2, book.getIsbn());
            prStmt.setString(3, book.getCategory());
            prStmt.setInt(4, book.getId());
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
            String sqlQuery = "delete from book where book_id="+req_id;
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

package DAO;

import Business.BookService;
import DataAccess.ConnectionManger;
import entities.Book;
import entities.Member;

import java.sql.*;
import java.util.ArrayList;

public class MemberDA implements BaseDA<Member> {

    @Override
    public ArrayList<Member> FindAll() throws SQLException{

        ArrayList<Member> memberList = new ArrayList<>();

        // db connection
        Connection conn = null;
        Statement stm = null;
        ResultSet resSet = null;

        try {
            // get db connection
            conn = ConnectionManger.getConnection();
            stm = conn.createStatement();
            String sqlStrQuery = "select * from member_lib";
            resSet = stm.executeQuery(sqlStrQuery);

            // getting admin list data
            while (resSet.next()) {
                int id = resSet.getInt("member_id");
                String full_name = resSet.getString("full_name");
                String phone = resSet.getString("phone");
                String email = resSet.getString("email");
                // String nm = resSet.getString(2);
                Member tempMember = new Member(id, full_name, phone,email);
                memberList.add(tempMember);
                // System.out.println(tempAdmin.toString());
            }
            return memberList;
        } finally {
            // start closing JDBC objects
            Close(conn, stm, resSet);
        }
    }

    @Override
    public Member FindById(int req_id) throws SQLException {
        Member tempMember = null;

        // db connection
        Connection conn = null;
        Statement stm = null;
        ResultSet resSet = null;

        try {
            // get db connection
            conn = ConnectionManger.getConnection();
            stm = conn.createStatement();
            String sqlStrQuery = "select * from member_lib where member_id="+req_id;
            resSet = stm.executeQuery(sqlStrQuery);

            // getting admin list data
            while (resSet.next()) {
                int id = resSet.getInt("member_id");
                String full_name = resSet.getString("full_name");
                String phone = resSet.getString("phone");
                String email = resSet.getString("email");

                // String nm = resSet.getString(2);
                tempMember = new Member(id, full_name, phone, email);
                // System.out.println(tempAdmin.toString());
            }
            return tempMember;
        } finally {
            // start closing JDBC objects
            Close(conn, stm, resSet);
        }
    }

    @Override
    public Member FindByName(String name) throws SQLException {
        Member tempMember = null;

        // db connection
        Connection conn = null;
        Statement stm = null;
        ResultSet resSet = null;

        try {
            // get db connection
            conn = ConnectionManger.getConnection();
            stm = conn.createStatement();
            String sqlStrQuery = "select * from member_lib where full_name like '%"+name+"%'";
            resSet = stm.executeQuery(sqlStrQuery);

            // getting admin list data
            while (resSet.next()) {
                int id = resSet.getInt("member_id");
                String full_name = resSet.getString("full_name");
                String phone = resSet.getString("phone");
                String email = resSet.getString("email");

                // String nm = resSet.getString(2);
                tempMember = new Member(id, full_name, phone,email);
                // System.out.println(tempAdmin.toString());
            }
            return tempMember;
        } finally {
            // start closing JDBC objects
            Close(conn, stm, resSet);
        }
    }

    @Override
    public void Save (Member member) throws SQLException{

        Connection conn = null;
        PreparedStatement prStmt = null;

        try {
            conn = ConnectionManger.getConnection();
            String sqlQuery = "insert into member_lib "
                    + "(full_name, phone, email) "
                    + "values (?, ?, ?)";
            prStmt = conn.prepareStatement(sqlQuery);
            prStmt.setString(1, member.getName());
            prStmt.setString(2, member.getPhone());
            prStmt.setString(3, member.getEmail());
            prStmt.executeUpdate();
            System.out.println("done ........ executed");
        }
        finally {
            Close(conn,prStmt,null);
        }
    }

    @Override
    public void Update (Member member) throws SQLException{

        // db connection
        Connection conn = null;
        PreparedStatement prStmt = null;

        try {
            conn = ConnectionManger.getConnection();
            String sqlQuery = "update member_lib set full_name=?"
                    + ",phone=?,email=?"
                    + " where member_id=?";
            prStmt = conn.prepareStatement(sqlQuery);
            prStmt.setString(1, member.getName());
            prStmt.setString(2, member.getPhone());
            prStmt.setString(3, member.getEmail());
            prStmt.setInt(4, member.getId());
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
            String sqlQuery = "delete from member_lib where member_id="+req_id;
            boolean result = stm.execute(sqlQuery);
            return result;
        }
        finally {
            Close(conn,stm,null);
        }

    }

    public void addFavBooks(int mem_id, int book_id)throws SQLException {
//        ArrayList<Book> booksList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement prStmt = null;

        try {
            conn = ConnectionManger.getConnection();
            String sqlQuery = "insert into member_book "
                    + "(MemberID, BookId) "
                    + "values (?, ?)";
            prStmt = conn.prepareStatement(sqlQuery);
            prStmt.setInt(1, mem_id);
            prStmt.setInt(2, book_id);
            prStmt.executeUpdate();
            System.out.println("done ........ executed");
        }
        finally {
            Close(conn,prStmt,null);
        }

//        return booksList;
    }

    public ArrayList<Book> showFavBooks(int mem_id)throws SQLException {

//        Member mem = new Member();
        ArrayList<Book> bookList = new ArrayList<>();
        BookService bookService = new BookService();

        // db connection
        Connection conn = null;
        Statement stm = null;
        ResultSet resSet = null;

        try {
            // get db connection
            conn = ConnectionManger.getConnection();
            stm = conn.createStatement();
            String sqlStrQuery = "select * from member_book where MemberID="+mem_id;
            resSet = stm.executeQuery(sqlStrQuery);

            // getting admin list data
            while (resSet.next()) {
                int id = resSet.getInt("BookId");
                // String nm = resSet.getString(2);
                Book tempBook = bookService.FindBookByIdServ(id);
                bookList.add(tempBook);
//                System.out.println(">::: "+tempBook.getName());
            }
//            mem.setBooks(bookList);
            return bookList;
        } finally {
            // start closing JDBC objects
            Close(conn, stm, resSet);
        }
    }

    public void deleteBooks(int mem_id, int book_id)throws SQLException {

        // db connection
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = ConnectionManger.getConnection();
            String sqlQuery = "delete from member_book where MemberID=? and BookId=?";
            stm = conn.prepareStatement(sqlQuery);
            stm.setInt(1,mem_id);
            stm.setInt(2,book_id);
            stm.executeUpdate();
            System.out.println("deleted........successfully");
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

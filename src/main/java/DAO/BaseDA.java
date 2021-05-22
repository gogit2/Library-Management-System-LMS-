package DAO;

import entities.Admin;

import java.sql.*;
import java.util.ArrayList;

public interface BaseDA<E> {

    ArrayList<E> FindAll() throws SQLException;

    E FindById(int req_id) throws SQLException;

    E FindByName(String name)throws SQLException;

    void Save (E admin) throws SQLException;

    void Update (E admin) throws SQLException;

    boolean Delete (int req_id) throws SQLException;


}

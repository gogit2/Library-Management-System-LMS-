package Business;

import DAO.BookDA;
import DAO.MemberDA;
import entities.Book;
import entities.Member;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookService {

    private final BookDA bookDA;

    public BookService() {
        bookDA = new BookDA();
    }

    public ArrayList<Book> FindAllServ() throws SQLException{
        return  bookDA.FindAll();
    }

    public Book FindByIdServ(int req_id) throws SQLException{
        return  bookDA.FindById(req_id);
    }

    public Book FindByNameServ(String name) throws SQLException{
        return bookDA.FindByName(name);
    }

    public void SaveServ (Book book) throws SQLException{
        bookDA.Save(book);
    }

    public void UpdateServ (Book book) throws SQLException{
        bookDA.Update(book);
    }

    public boolean Delete(int req_id) throws SQLException{
        return bookDA.Delete(req_id);
    }


}

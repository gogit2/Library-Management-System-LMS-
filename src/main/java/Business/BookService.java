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

    public ArrayList<Book> FindAllBookServ() throws SQLException{
        return  bookDA.FindAll();
    }

    public Book FindBookByIdServ(int req_id) throws SQLException{
        return  bookDA.FindById(req_id);
    }

    public Book FindBookByNameServ(String name) throws SQLException{
        return bookDA.FindByName(name);
    }

    public void SaveBookServ(Book book) throws SQLException{
        bookDA.Save(book);
    }

    public void UpdateBookServ(Book book) throws SQLException{
        bookDA.Update(book);
    }

    public boolean DeleteBook (int req_id) throws SQLException{
        return bookDA.Delete(req_id);
    }


}

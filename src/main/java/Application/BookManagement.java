package Application;

import Business.BookService;
import Business.MemberService;
import entities.Book;
import entities.Member;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookManagement {
    public static void main(String[] args) throws SQLException{
        BookService bookServ = new BookService();
        // Find All
        ArrayList<Book> bookList = bookServ.FindAllServ();
        System.out.println("FindALL:>>");
        for (Book book: bookList){
            System.out.println("\t\t"+book.toString());
        }
        // Find by id
        System.out.println("FindByID:>> "+bookServ.FindByIdServ(14).toString());
        // Find by name
        System.out.println("FindByName:>> "+bookServ.FindByNameServ("book4").toString());
        // Save to db
//        bookServ.SaveServ(new Book(3,"book4",293728229,"Sport"));
        // Delete from db
//        bookServ.Delete(3);
        Book tempBook = new Book(2,"book25",1245430322,"Since");
        bookServ.UpdateServ(tempBook);
//
//        bookServ.SaveServ(new Book(3,"book6",384593296,"Since"));

    }

}

package Application;

import Business.BookService;
import entities.Book;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookManagement {
    public static void main(String[] args) throws SQLException{
        BookService bookServ = new BookService();
        // Find All
        ArrayList<Book> bookList = bookServ.FindAllBookServ();
        System.out.println("FindALL:>>");
        for (Book book: bookList){
            System.out.println("\t\t"+book.toString());
        }
        // Find by id
        System.out.println("FindByID:>> "+bookServ.FindBookByIdServ(14).toString());
        // Find by name
        System.out.println("FindByName:>> "+bookServ.FindBookByNameServ("book4").toString());
        // Save to db
//        bookServ.SaveServ(new Book(3,"book4",293728229,"Sport"));
        // Delete from db
//        bookServ.Delete(3);
        Book tempBook = new Book(2,"book25",1245430322,"Since");
        bookServ.UpdateBookServ(tempBook);
//
//        bookServ.SaveServ(new Book(3,"book6",384593296,"Since"));

    }

}

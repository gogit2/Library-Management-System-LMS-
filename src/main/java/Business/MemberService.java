package Business;

import DAO.MemberDA;
import entities.Book;
import entities.Member;

import java.sql.SQLException;
import java.util.ArrayList;

public class MemberService {

    private final MemberDA memberDA;

    public MemberService() {
        memberDA = new MemberDA();
    }

    public ArrayList<Member> FindAllServ() throws SQLException{
        return  memberDA.FindAll();
    }

    public Member FindByIdServ(int req_id) throws SQLException{
        return  memberDA.FindById(req_id);
    }

    public Member FindByNameServ(String name) throws SQLException{
        return memberDA.FindByName(name);
    }

    public void SaveServ (Member member) throws SQLException{
        memberDA.Save(member);
    }

    public void UpdateServ (Member m) throws SQLException{
        memberDA.Update(m);
    }

    public boolean Delete(int req_id) throws SQLException{
        return memberDA.Delete(req_id);
    }

    public void addFavBooksServ (int mem_id, int book_id)throws SQLException{
        memberDA.addFavBooks(mem_id, book_id);
    }

    public ArrayList<Book> showFavBooks(int mem_id)throws SQLException{
        return memberDA.showFavBooks(mem_id);
    }

    public void showFavBooksServPrinted(int mem_id) throws SQLException {
        ArrayList<Book> books = showFavBooks(mem_id);
        System.out.println("Fav books for "+FindByIdServ(mem_id).getName()+" is: ");
        for(Book book: books){
            System.out.println("\t\t"+book.toString());
        }
    }

    public void deleteBooksServ (int mem_id, int book_id)throws SQLException{
        memberDA.deleteBooks(mem_id, book_id);
    }


}

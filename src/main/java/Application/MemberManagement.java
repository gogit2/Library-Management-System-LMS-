package Application;

import Business.AdminService;
import Business.MemberService;
import DAO.MemberDA;
import entities.Admin;
import entities.Member;

import java.sql.SQLException;
import java.util.ArrayList;

public class MemberManagement {
    public static void main(String[] args) throws SQLException{
        MemberService memServ = new MemberService();
        // Find All
        ArrayList<Member> membrList = memServ.FindAllServ();
        System.out.println("FindALL:>>");
        for (Member member: membrList){
            System.out.println("\t\t"+member.toString());
        }
        // Find by id
        System.out.println("FindByID:>> "+memServ.FindByIdServ(1).toString());
        // Find by name
        System.out.println("FindByName:>> "+memServ.FindByNameServ("Mohamed ElSayed").toString());
        // Save to db
//        memServ.SaveServ(new Member(3,"Abdullah Zaki","+201189476395","abdulzki26@gmail.com"));
        // Delete from db
//        memServ.Delete(3);
        Member tempMember = new Member(2,"Mohamed ElSayed","+021280971648","mohsay728@gmail.com");
        memServ.UpdateServ(tempMember);
//
//        memServ.SaveServ(new Member(3,"Mohamed Hassan","+201294702744","mohhass543n@yahoo.com"));

        // Adding books to member
        memServ.addFavBooksServ(4,12);
//        memServ.addFavBooksServ(2,13);
        // show fav Books for required member
        memServ.showFavBooksServPrinted(2);
        // Delete a fav book for member
//        memServ.deleteBooksServ(1,14);


    }

}

package Application;

import Business.AdminService;
import DAO.AdminDA;
import entities.Admin;

import java.sql.SQLException;
import java.util.ArrayList;

public class AdminManagement {
    public static void main(String[] args) throws SQLException{
        AdminDA ada = new AdminDA();
        // Find All
        ArrayList<Admin> adList = ada.FindAll();
        System.out.println("FindALL:>>");
        for (Admin admin: adList){
            System.out.println("\t\t"+admin.toString());
        }
        // Find by id
        System.out.println("FindByID:>> "+ada.FindById(1).toString());
        // Find by name
        System.out.println("FindByName:>> "+ada.FindByName("Ahmed Mohamed").toString());
        // Save to db
//        ada.Save(new Admin(3,"Abdullah Zaki","+201189476395"));
        // Delete from db
//        ada.Delete(2);
        Admin admin = new Admin(3,"Mohamed ElSayed","+021582931204");
        ada.Update(admin);

        // working with Business layer
        AdminService adServ = new AdminService();
//        adServ.SaveServ(new Admin(4,"Mohamed Hassan","+2012947027449"));
        ada.Update(new Admin(4,"Mohamed Hassan","+201294702744"));
    }

}

package Business;

import DAO.AdminDA;
import entities.Admin;

import java.sql.SQLException;
import java.util.ArrayList;

public class AdminService {

    private final AdminDA adminDA;

    public AdminService() {
        adminDA = new AdminDA();
    }

    public ArrayList<Admin> FindAllServ() throws SQLException{
        return  adminDA.FindAll();
    }

    public Admin FindByIdServ(int req_id) throws SQLException{
        return  adminDA.FindById(req_id);
    }

    public Admin FindByNameServ(String name) throws SQLException{
        return adminDA.FindByName(name);
    }

    public void SaveServ (Admin admin) throws SQLException{
        adminDA.Save(admin);
    }

    public void UpdateServ (Admin admin) throws SQLException{
        adminDA.Update(admin);
    }

    public boolean Delete(int req_id) throws SQLException{
        return adminDA.Delete(req_id);
    }


}

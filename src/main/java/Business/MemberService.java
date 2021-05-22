package Business;

import DAO.MemberDA;
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


}

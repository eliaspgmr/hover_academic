package test;

import sample.model.DAO.UserDAO;
import sample.model.bean.ServerSession;
import sample.model.bean.Usuario;

public class TestUserDAO {

    public static void main(String args[]){
        ServerSession.update();

        UserDAO dao = new UserDAO();
        Usuario user = new Usuario();
        user = dao.select("root");

        System.out.println(user.getNome());


    }

}

package test;

import sample.model.DAO.ResponsavelDAO;
import sample.model.bean.Responsavel;
import sample.model.bean.ServerSession;

import javax.swing.*;

public class TestResponsavelDAO {

    public static void main(String args[]) {
        ServerSession.update();

        testSelectById(2);

    }

    public static void testSelectById(int id){
        ResponsavelDAO dao = new ResponsavelDAO();
        Responsavel responsavel = dao.selectById(id);
        JOptionPane.showMessageDialog(null, responsavel.getId()+"\n"+responsavel.getNome()+"\n"+responsavel.getDataNascimento()+"\n"+responsavel.getRg()+"\n"+responsavel.getCpf());
    }
}

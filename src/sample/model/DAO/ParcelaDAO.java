package sample.model.DAO;

import sample.connection.ConnectionHover;
import sample.model.bean.Parcela;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParcelaDAO {

    //Create a new parcela on the system
    public void create(Parcela parcela) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement(
                    "INSERT INTO parcelas (" +
                            "financeiro_id_financeiro," +
                            " numero," +
                            " valor," +
                            " juros," +
                            " multa," +
                            " data_pagamento) VALUES (?,?,?,?,?,?)"
            );
            statement.setInt(1, parcela.getIdFinanceiro());
            statement.setInt(2, parcela.getNumero());
            statement.setDouble(3, parcela.getValor());
            statement.setDouble(4, parcela.getJuros());
            statement.setDouble(5, parcela.getMulta());
            statement.setString(6, parcela.getDataPagamento());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao salvar!"+ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }

    //Delete a specific parcela
    public void delete(Parcela parcela) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement("DELETE FROM parcelas WHERE financeiro_id_financeiro = ? AND numero = ?");
            statement.setInt(1, parcela.getIdFinanceiro());
            statement.setInt(2, parcela.getNumero());


            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao excluir!"+ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }

    //Delete all parcelas
    public void deleteAll(Parcela parcela) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement("DELETE FROM parcelas WHERE financeiro_id_financeiro = ?");
            statement.setInt(1, parcela.getIdFinanceiro());


            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao excluir!"+ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ConnectionHover.closeConnection(connection, statement);
        }

    }

    //Select a parcela
    public Parcela select(int id_financeiro, int numero) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Parcela parcela = new Parcela();

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement("SELECT * FROM parcelas WHERE financeiro_id_financeiro = ? AND numero = ?");
            statement.setInt(1, id_financeiro);
            statement.setInt(2, numero);
            result = statement.executeQuery();

            if(result.next()) {

                parcela.setIdFinanceiro(result.getInt("financeiro_id_financeiro"));
                parcela.setNumero(result.getInt("numero"));
                parcela.setValor(result.getDouble("valor"));
                parcela.setJuros(result.getDouble("juros"));
                parcela.setMulta(result.getDouble("multa"));
                parcela.setDataPagamento(result.getString("data_pagamento"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ConnectionHover.closeConnection(connection, statement, result);
        }

        return parcela;
    }

    //Select all parcelas
    public List<Parcela> selectAll(int id_financeiro) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        List<Parcela> parcelas = new ArrayList<>();

        try {

            connection = ConnectionHover.getConnection();

            statement = connection.prepareStatement("SELECT * FROM parcelas WHERE financeiro_id_financeiro = ?");
            statement.setInt(1, id_financeiro);
            result = statement.executeQuery();

            while(result.next()) {

                Parcela parcela = new Parcela();
                parcela.setIdFinanceiro(result.getInt("financeiro_id_financeiro"));
                parcela.setNumero(result.getInt("numero"));
                parcela.setValor(result.getDouble("valor"));
                parcela.setJuros(result.getDouble("juros"));
                parcela.setMulta(result.getDouble("multa"));
                parcela.setDataPagamento(result.getString("data_pagamento"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ConnectionHover.closeConnection(connection, statement, result);
        }

        return parcelas;
    }
}

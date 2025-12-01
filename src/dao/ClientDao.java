package dao;

import database.DataBase;
import domain.Client;
import java.sql.*;

public class ClientDao implements IDefaultDao<Client>{
    @Override
    public void saveInDataBase(Client entry) throws SQLException {
        String SQL = "INSERT INTO tb_client (name,cpf,yers) values (?,?,?)";

        try(Connection conn = DataBase.getConnection()) {
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setString(1, entry.getName());
            stm.setString(2, entry.getCpf());
            stm.setFloat(3, entry.getYers());

            stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Boolean deleteInDataBase(int key) {
        String SQL = "DELETE FROM tb_client WHERE id = ?";

        try(
            Connection conn = DataBase.getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL)
        ) {

            stm.setInt(1, key);
            int rows = stm.executeUpdate();

            System.out.println("deleteInDataBase (ClientDao) :: SUCCESS");
            return rows > 0;
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean searchEntryInDataBase(int key) {
        String SQL = ("SELECT * FROM tb_client WHERE id =" + key);

        try(
            Connection conn = DataBase.getConnection();
            Statement stm = conn.createStatement();
            ResultSet ress = stm.executeQuery(SQL))
        {
            while(ress.next()) {
                System.out.println("ID: " + ress.getInt("id"));
                System.out.println("Nome: " + ress.getString("name"));
                System.out.println("CPF: " + ress.getString("cpf"));
                System.out.println("Anos: " + ress.getInt("yers"));
                System.out.println("--------");
            }

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void searchAllEntryInDataBase() throws SQLException {

        String SQL = "SELECT * FROM tb_client";

        try(Connection conn = DataBase.getConnection()){
           Statement stm = conn.createStatement();
           ResultSet ress = stm.executeQuery(SQL);

            while (ress.next()) {
                System.out.println("ID: " + ress.getInt("id"));
                System.out.println("Nome: " + ress.getString("name"));
                System.out.println("CPF: " + ress.getString("cpf"));
                System.out.println("Anos: " + ress.getInt("yers"));
                System.out.println("--------");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

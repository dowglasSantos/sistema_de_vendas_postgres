package dao.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.postgres.Postgres;
import domain.Client;

public class ClientDao implements IClientDao{
    @Override
    public Boolean saveClient(Client client) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        Postgres postgres = Postgres.getInstance();
        try{
            conn = postgres.getConnection();
            String deafultSQL =
                "INSERT INTO tb_client (id, name, cpf, yers) values(nextval('seq_tb_client '),?,?,?)"
            ;

            stm = conn.prepareStatement(deafultSQL);
            stm.setString(1, client.getName());
            stm.setString(2, client.getCpf());
            stm.setInt(3, client.getYers());

            int saveDataBase = stm.executeUpdate();

            if(saveDataBase > 0) {
                System.out.println("data save of dataBase || saveClient");
            } else {
                System.out.println("Erro in save of dataBase || saveClient");
            }
        } catch(Exception e){
            throw e;
        } finally {
            if(stm != null) stm.close();
            if(conn != null) conn.close();
        }


        return null;
    }

    @Override
    public Boolean deleteClient(Integer id) {
        return null;
    }

    @Override
    public Boolean searchClient() {
        return null;
    }

    @Override
    public Boolean serachAll() {
        return null;
    }
}

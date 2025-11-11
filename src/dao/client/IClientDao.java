package dao.client;

import domain.Client;

import java.sql.SQLException;

public interface IClientDao {
    Boolean saveClient(Client client) throws SQLException;
    Boolean deleteClient(Integer id) throws SQLException;
    Boolean searchClient() throws SQLException;
    Boolean serachAll() throws SQLException;
}

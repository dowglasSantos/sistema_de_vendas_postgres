import dao.client.ClientDao;
import domain.Client;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Sistema de Vendas");

        Client client = new Client("primary update in data base", "78945879516", 22);

        ClientDao clientDao = new ClientDao();

        clientDao.saveClient(client);
    }
}
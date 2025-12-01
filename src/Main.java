import dao.ClientDao;
import dao.ProductDao;
import dao.PurchaseNoteDao;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ClientDao clientDao = new ClientDao();
        ProductDao productDao = new ProductDao();
        PurchaseNoteDao purchaseNoteDao = new PurchaseNoteDao();

        System.out.println("CLIENT");
        System.out.println(" ");
        clientDao.searchAllEntryInDataBase();
        System.out.println(" ");
        System.out.println("-------------------------------");

        System.out.println("PRODUCT");
        System.out.println(" ");
        productDao.searchAllEntryInDataBase();
        System.out.println(" ");
        System.out.println("-------------------------------");

        System.out.println("NOTES");
        System.out.println(" ");
        purchaseNoteDao.searchAllEntryInDataBase();
    }
}
package dao;

import database.DataBase;
import domain.PurchaseNote;

import java.sql.*;

public class PurchaseNoteDao implements IDefaultDao<PurchaseNote>{
    @Override
    public void saveInDataBase(PurchaseNote entry) {
        String SQL = "INSERT INTO tb_sale (client_id, product_ean, sale_value) VALUES(?,?,?)";
        try(Connection conn = DataBase.getConnection()) {
            PreparedStatement stt = conn.prepareStatement(SQL);
            stt.setFloat(1, entry.getClientID());
            stt.setFloat(2, entry.getProductEAN());
            stt.setFloat(3, entry.getSaleValue());
            stt.executeUpdate();

            System.out.println("saveInDataBase (PurchaseNoteDao) :: saved in the database");
        } catch(SQLException e) {
            System.out.println("saveInDataBase (PurchaseNoteDao) :: not saved in the database");
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean deleteInDataBase(int key) {
        String SQL = "DELETE FROM tb_sale WHERE id = ?";
        try(
                Connection conn = DataBase.getConnection();
                PreparedStatement stm = conn.prepareStatement(SQL)
        ) {

            stm.setInt(1, key);
            int rows = stm.executeUpdate();

            System.out.println("deleteInDataBase (PurchaseNoteDao) :: SUCCESS");
            return rows > 0;
        } catch (Exception e) {
            System.out.println("deleteInDataBase (PurchaseNoteDao) :: NOT SUCCESS");
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean searchEntryInDataBase(int key) {
        return null;
    }

    @Override
    public void searchAllEntryInDataBase() {
        String SQL = "select * from tb_sale;";

        try(Connection conn = DataBase.getConnection()) {
            Statement stt = conn.createStatement();
            ResultSet rss = stt.executeQuery(SQL);

            while(rss.next()) {
                System.out.println("ID: " + rss.getInt("id"));
                System.out.println("CLIENT ID: " + rss.getInt("client_id"));
                System.out.println("PRODUCT EAN: " + rss.getInt("product_ean"));
                System.out.println("SALE VALUE: " + rss.getFloat("sale_value"));
                System.out.println("------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}

package dao;

import database.DataBase;
import domain.Product;
import java.sql.*;

public class ProductDao implements IDefaultDao<Product>{
    @Override
    public void saveInDataBase(Product entry) throws SQLException {
        String SQL = "INSERT INTO tb_product (ean,name,value) values (?,?,?)";

        try(
            Connection conn = DataBase.getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
        ) {
            stm.setFloat(2, entry.getEan());
            stm.setString(1, entry.getName());
            stm.setFloat(3, entry.getValue());

            stm.executeUpdate();

            System.out.println("saveInDataBase (ProductDao) :: SUCCESS");
        } catch (Exception e) {
            System.out.println("saveInDataBase (ProductDao) :: NOT SUCCESS");
            throw new RuntimeException(e);
        }

    }

    @Override
    public Boolean deleteInDataBase(int key) {
        String SQL = "DELETE FROM tb_product WHERE ean = ?";

        try(
                Connection conn = DataBase.getConnection();
                PreparedStatement stm = conn.prepareStatement(SQL)
        ) {

            stm.setInt(1, key);
            int rows = stm.executeUpdate();
            System.out.println("deleteInDataBase (ProductDao) :: SUCCESS");
            return rows > 0;
        } catch (Exception e) {

            System.out.println("deleteInDataBase (ProductDao) :: NOT SUCCESS");
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean searchEntryInDataBase(int key) {
        String SQL = ("SELECT * FROM tb_product WHERE ean = ?");

        try(Connection conn = DataBase.getConnection()) {
            PreparedStatement stm = conn.prepareStatement(SQL);
            stm.setInt(1, key);
            ResultSet ress = stm.executeQuery();

            while(ress.next()) {
                System.out.println("EAN: " + ress.getInt("ean"));
                System.out.println("NAME: " + ress.getString("name"));
                System.out.println("VALUE: " + ress.getFloat("value"));
                System.out.println("--------");
            }

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void searchAllEntryInDataBase() throws SQLException {

        String SQL = "SELECT * FROM tb_product";

        try(Connection conn = DataBase.getConnection()){
            Statement stm = conn.createStatement();
            ResultSet ress = stm.executeQuery(SQL);

            while (ress.next()) {
                System.out.println("EAN: " + ress.getInt("ean"));
                System.out.println("NAME: " + ress.getString("name"));
                System.out.println("VALUE: " + ress.getFloat("value"));
                System.out.println("--------");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

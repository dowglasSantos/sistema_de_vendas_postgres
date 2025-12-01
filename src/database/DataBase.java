package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
    public static Connection getConnection() {
        KeyLoginDataBase keyLoginDataBase = new KeyLoginDataBase();

        try {

            return DriverManager.getConnection(
                    keyLoginDataBase.getUrl(),
                    keyLoginDataBase.getUser(),
                    keyLoginDataBase.getPassword()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

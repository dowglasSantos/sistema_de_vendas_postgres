package dao;

import java.sql.SQLException;

public interface IDefaultDao<U> {
    void saveInDataBase(U entry) throws SQLException;
    Boolean deleteInDataBase(int key) throws SQLException;
    Boolean searchEntryInDataBase(int key) throws SQLException;
    void searchAllEntryInDataBase() throws SQLException;
}

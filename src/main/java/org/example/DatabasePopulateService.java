package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.example.DbUtil.readSqlFile;

public class DatabasePopulateService {
    public static void main(String[] args) {
        DatabasePopulateService populateService = new DatabasePopulateService();
        populateService.executeSqlFile(DatabaseProperty.populateDb());
    }

    public void executeSqlFile(String filePath) {
        String sqlQuery = readSqlFile(filePath);
        Connection connection = Database.getInstance().getConnection();
        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    private final Connection connection;
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl(DatabaseProperty.getDbUrl());
        config.setUsername(DatabaseProperty.getDbUser());
        config.setPassword(DatabaseProperty.getDbPassword());
        ds = new HikariDataSource( config );
    }

    private Database() {
        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    private static final class InstanceHolder {
        private static final Database instance = new Database();
    }

    public static Database getInstance() {
        return InstanceHolder.instance;
    }
}

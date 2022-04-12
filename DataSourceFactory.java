package dao;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public class DataSourceFactory {
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setDriverClassName("org.postgresql.Driver");
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        config.setUsername("postgres");
        config.setPassword("11110");
        config.addDataSourceProperty("cachePrepStmts" , "true" );
        config.addDataSourceProperty("prepStmtCacheSize" , "250" );
        config.addDataSourceProperty("prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource(config);
    }

    private DataSourceFactory() {}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }


}

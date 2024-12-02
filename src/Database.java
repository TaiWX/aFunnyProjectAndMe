import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Database {

    // read from system.properties to set up the db
    static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources\\system");
    static String url = resourceBundle.getString("url");
    static String username = resourceBundle.getString("username");
    static String password = resourceBundle.getString("password");

    static Connection connection;

    // configuration of connection pooling
    static HikariConfig hikariConfig = new HikariConfig();

    static DataSource ds;

    static {
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        // optimization of MySQL
        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        hikariConfig.addDataSourceProperty("useServerPrepStmts", "true");

        ds = new HikariDataSource(hikariConfig);
    }


    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void closeConnection(){
        ((HikariDataSource)ds).close();
    }

}

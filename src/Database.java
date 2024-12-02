import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.*;
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


    public static void getConnection() {
        try {
            connection = ds.getConnection();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void closeConnection(){
        ((HikariDataSource)ds).close();
    }

    // select
    public static void select(String tableName){
        //TODO: validation of tableName

        String query = "SELECT * FROM " + tableName;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            ResultSet rs = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = rs.getMetaData();

            int columnCount = resultSetMetaData.getColumnCount();
            while(rs.next()){
                for (int i = 1; i <= columnCount; i++){
                    System.out.print(rs.getString(i) + " ");
                }
                System.out.println();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void getCategory(CategoryList l){
        try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM category")){

            ResultSet rs = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = rs.getMetaData();

            int columnCount = resultSetMetaData.getColumnCount();
            while(rs.next()){
                for (int i = 2; i <= columnCount; i++){ // skip the id
                    String name = rs.getString(i);
                    l.addCategory(new Category(name));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }



}

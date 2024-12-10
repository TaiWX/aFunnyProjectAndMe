import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
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

    public static TaskList getTask(){
        String query = "SELECT * FROM task LEFT JOIN recurring_date ON task.task_id = recurring_date.task_id";
        TaskList list = new TaskList();
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                int task_id = rs.getInt("task_id");
                String title = rs.getString("title");
                String description = rs.getString("descr");
                LocalDate date = rs.getObject("due_date", LocalDate.class);
                int completionStatus = rs.getInt("completion_id");
                int category = rs.getInt("category_id");
                int priority = rs.getInt("priority_id");
                int recurring = rs.getInt("recurring_id");
                LocalDate startDate = rs.getObject("start_date", LocalDate.class);
                LocalDate endDate = rs.getObject("end_date", LocalDate.class);
                Integer dependency_taskId = rs.getObject("dependency_task_id", Integer.class);
                list.addTask(new Task(task_id, title, description, date, completionStatus, category, priority, recurring, startDate, endDate, dependency_taskId));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }

    public static <T> void getSubList(SubList<T> l, String tableName){
        String query = "SELECT * FROM " + tableName; // TODO: handling exception of table name
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);

                l.addItemByName(name, id);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }



}

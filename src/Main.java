import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Database.getConnection();
        Database.select("task");
        Database.select("category");
        Database.select("completion_status");
        Database.select("priority");

        CategoryList l = new CategoryList();
        Database.getCategory(l);
        for (int i = 0; i < l.len(); i++) {
            System.out.println(l.getCategory(i).toString());
        }

        Database.closeConnection();
    }
}

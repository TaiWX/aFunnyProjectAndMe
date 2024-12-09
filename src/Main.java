import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // just test
        Database.getConnection();
        Database.select("task");
        Database.select("category");
        Database.select("completion_status");
        Database.select("priority");

        CategoryList l = new CategoryList();
        Database.getSubList(l, "category");
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.getItem(i).toString());
        }

        PriorityList l1 = new PriorityList();
        Database.getSubList(l1, "priority");
        for (int i = 0; i < l1.size(); i++) {
            System.out.println(l1.getItem(i).toString());
        }

        CompletionStatusList l2 = new CompletionStatusList();
        Database.getSubList(l2, "completion_status");
        for (int i = 0; i < l2.size(); i++) {
            System.out.println(l2.getItem(i).toString());
        }

        RecurringList l3 = new RecurringList();
        Database.getSubList(l3, "recurring");
        for (int i = 0; i < l3.size(); i++) {
            System.out.println(l3.getItem(i).toString());
        }

        Database.closeConnection();
    }
}

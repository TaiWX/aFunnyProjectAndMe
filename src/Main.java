import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // just test
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

        TaskList taskList = Database.getTask();

        Task t = new Task("test1", "descr", LocalDate.parse("2024-12-14"), 2, 2, 2, 1, null, null, null);
        taskList.addTask(t);
        taskList.displayAll();
        taskList.removeTask(4);
        System.out.println();
        taskList.displayAll();
        Database.closeConnection();
    }
}

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskList {
    List<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<>();
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void addTaskByAll(int task_id, String title, String description, Date date, CompletionStatus completionStatus, Category category, Priority priority, Recurring recurring, Date startDate, Date endDate, Task dependency_task) {
        taskList.add(new Task(task_id, title, description, date, completionStatus, category, priority, recurring, startDate, endDate, dependency_task));
    }

    public int size() {
        return taskList.size();
    }

    public Task getTask(int index) {
        return taskList.get(index);
    }
}

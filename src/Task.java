import java.util.Date;

// Object Task is used for demonstration
public class Task {
    int task_id;
    String title;
    String description;
    Date date;
    CompletionStatus completionStatus;
    Category category;
    Priority priority;
    Recurring recurring;
    Date startDate;
    Date endDate;
    Task dependency_task;

    public Task(int task_id, String title, String description, Date date, CompletionStatus completionStatus, Category category, Priority priority, Recurring recurring, Date startDate, Date endDate, Task dependency_task) {
        this.task_id = task_id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.completionStatus = completionStatus;
        this.category = category;
        this.priority = priority;
        this.recurring = recurring;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dependency_task = dependency_task;

    }
}

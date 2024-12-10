import java.time.LocalDate;

// Object Task is used for demonstration
public class Task {
    int task_id;
    String title;
    String description;
    LocalDate date;
    int completionStatusId;
    int categoryId;
    int priorityId;
    int recurringId;
    LocalDate startDate;
    LocalDate endDate;
    Integer dependency_taskId;

    public Task(int task_id, String title, String description, LocalDate date, int completionStatusId, int categoryId, int priorityId, int recurringId, LocalDate startDate, LocalDate endDate, Integer dependency_taskId) {
        this.task_id = task_id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.completionStatusId = completionStatusId;
        this.categoryId = categoryId;
        this.priorityId = priorityId;
        this.recurringId = recurringId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dependency_taskId = dependency_taskId;

    }
}

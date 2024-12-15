import java.time.LocalDate;

// Object Task is used for demonstration
public class Task {
    int task_id;
    String title;
    String description;
    LocalDate date;
    int completionId;
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
        this.completionId = completionStatusId;
        this.categoryId = categoryId;
        this.priorityId = priorityId;
        this.recurringId = recurringId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dependency_taskId = dependency_taskId;

    }

    public Task(String title, String description, LocalDate date, int completionStatusId, int categoryId, int priorityId, int recurringId, LocalDate startDate, LocalDate endDate, Integer dependency_taskId) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.completionId = completionStatusId;
        this.categoryId = categoryId;
        this.priorityId = priorityId;
        this.recurringId = recurringId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dependency_taskId = dependency_taskId;

    }

    @Override
    public String toString() {
        return "Task{" +
                "task_id=" + task_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", completionStatusId=" + completionId +
                ", categoryId=" + categoryId +
                ", priorityId=" + priorityId +
                ", recurringId=" + recurringId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", dependency_taskId=" + dependency_taskId +
                '}';
    }

    public void insertId(int task_id){
        this.task_id = task_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setCompletionId(int completionId) {
        this.completionId = completionId;
    }
}

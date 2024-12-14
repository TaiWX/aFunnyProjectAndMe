import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskList{
    List<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<>();
    }

    public void addTask(Task task) {
        taskList.add(task);

        Database.insertTask(task);
    }

    public void removeTask(int task_id) {
        taskList.remove(task_id); //TODO

        Database.deleteTask(task_id);
    }

    public void fetchTask(Task task) {
        taskList.add(task);
    }

    public void addTaskByAll(int task_id, String title, String description, LocalDate date, int completionStatusId, int categoryId, int priorityId, int recurringId, LocalDate startDate, LocalDate endDate, Integer dependency_taskId) {
        taskList.add(new Task(task_id, title, description, date, completionStatusId, categoryId, priorityId, recurringId, startDate, endDate, dependency_taskId));
    }

    public int size() {
        return taskList.size();
    }

    public Task getTask(int index) {
        return taskList.get(index);
    }

    public void displayAll(){
        int size = taskList.size();
        for (Task task : taskList) {
            System.out.println(task.toString());
        }
    }
}

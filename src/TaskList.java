import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    List<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<>();
    }

    public void addTask(Task task) {
        taskList.add(task);

        Database.insertTask(task);
    }

    // Remove a task from list and db through task_id
    public void removeTask(int task_id) {
        // search index of the task in arrayList
        int index = searchIndex(task_id);
        if (index < 0 || index >= size())
            throw new IllegalArgumentException();

        taskList.remove(index);

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

    public void displayAll() {
        int size = taskList.size();
        for (Task task : taskList) {
            System.out.println(task.toString());
        }
    }

    // Return index through binary search of task_id in list, if not found return -1
    private int searchIndex(int task_id) {
        int l = 0;
        int r = size();

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int id = taskList.get(mid).getTask_id();
            if (id == task_id)
                return mid;

            if (id > task_id)
                r = mid - 1;
            else
                l = mid + 1;
        }

        return -1;
    }

    // Update completionId of a task
    public void updateCompletionStatus(int task_id, int completionId){
        int index = searchIndex(task_id);
        if (index < 0 || index >= size())
            throw new IllegalArgumentException();
        taskList.get(index).setCompletionId(completionId);

        Database.updateCompletion(task_id, completionId);
    }
}

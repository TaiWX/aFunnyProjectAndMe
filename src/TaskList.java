import java.util.ArrayList;
import java.util.List;

public class TaskList {
    List<Task> taskList;

    public TaskList(){
        taskList = new ArrayList<>();
    }

    public void addTask(Task task){
        taskList.add(task);
    }

    public int len(){
        return taskList.size();
    }

    public Task getTask(int index){
        return taskList.get(index);
    }
}

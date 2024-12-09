public class Priority {
    String priority_name;
    int priority_id;

    public Priority(String name, int id){
        priority_name = name;
        priority_id = id;
    }

    public String toString() {
        return priority_name;
    }
}

public class CompletionStatus {
    String completion_name;
    int completion_id;

    public CompletionStatus(String name, int id) {
        completion_name = name;
        completion_id = id;
    }

    public void setCompletion_name(String name){
        completion_name = name;
    }

    @Override
    public String toString() {
        return completion_name;
    }
}

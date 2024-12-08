public class CompletionStatus {
    String completion_name;

    public CompletionStatus(String name) {
        completion_name = name;
    }

    public void setCompletion_name(String name){
        completion_name = name;
    }

    @Override
    public String toString() {
        return completion_name;
    }
}

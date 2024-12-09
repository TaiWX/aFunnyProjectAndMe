public class Recurring {
    String recurring_name;
    int recurring_id;

    public Recurring(String name, int id) {
        recurring_name = name;
        recurring_id = id;
    }

    public void setRecurring_name(String name){
        recurring_name = name;
    }

    @Override
    public String toString() {
        return recurring_name;
    }
}

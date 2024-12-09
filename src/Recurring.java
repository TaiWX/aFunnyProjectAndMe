public class Recurring {
    String recurring_name;

    public Recurring(String name) {
        recurring_name = name;
    }

    public void setRecurring_name(String name){
        recurring_name = name;
    }

    @Override
    public String toString() {
        return recurring_name;
    }
}

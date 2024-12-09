public class RecurringList extends SubList<Recurring>{
    public void addItemByName(String name, int id){
        list.add(new Recurring(name, id));
    };
}

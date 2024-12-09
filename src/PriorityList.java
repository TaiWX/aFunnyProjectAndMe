public class PriorityList extends SubList<Priority>{
    public void addItemByName(String name, int id){
        list.add(new Priority(name, id));
    };
}

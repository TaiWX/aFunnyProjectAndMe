public class CompletionStatusList extends SubList<CompletionStatus>{
    public void addItemByName(String name, int id){
        list.add(new CompletionStatus(name, id));
    };
}

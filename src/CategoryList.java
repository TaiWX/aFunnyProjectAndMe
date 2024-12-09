public class CategoryList extends SubList<Category>{
    public void addItemByName(String name, int id){
        list.add(new Category(name, id));
    };
}

public class Category {
    String category_name;
    int category_id;

    public Category(String name, int id) {
        category_name = name;
        category_id = id;
    }

    public void setCategory_name(String name){
        category_name = name;
    }

    @Override
    public String toString() {
        return category_name;
    }
}

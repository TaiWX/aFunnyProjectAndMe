public class Category {
    String category_name;

    public Category(String name) {
        category_name = name;
    }

    public void setCategory_name(String name){
        category_name = name;
    }

    @Override
    public String toString() {
        return category_name;
    }
}

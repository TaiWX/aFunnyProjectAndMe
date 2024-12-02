import java.util.ArrayList;
import java.util.List;

public class CategoryList {
    List<Category> categoryList;

    public CategoryList(){
        categoryList = new ArrayList<>();
    }

    public void addCategory(Category category){
        categoryList.add(category);
    }

    public int len(){
        return categoryList.size();
    }

    public Category getCategory(int index){
        return categoryList.get(index);
    }
}

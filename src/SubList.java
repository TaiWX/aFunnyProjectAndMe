import java.util.ArrayList;
import java.util.List;

public abstract class SubList<T> {
    List<T> list;

    public SubList(){
        list = new ArrayList<>();
    }

    public void addItem(T t) {
        list.add(t);
    }

    public abstract void addItemByName(String name, int id);

    public int size(){
        return list.size();
    }

    public T getItem(int index){
        if (index < 0 || index >= list.size())
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        return list.get(index);
    }
}

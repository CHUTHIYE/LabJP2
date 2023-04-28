package Lab6_slot8.Past4;

import java.util.LinkedList;
import java.util.List;

public class GenericCar<T> {
    private List<T> list = new LinkedList<>();

    public void add(T t) {
        list.add(t);
    }

    public void display() {
        for (T t : list) {
            System.out.println(t);
        }
    }

    public int getSize() {
        return list.size();
    }

    public boolean checkEmpty() {
        return list.isEmpty();
    }

    public void delete(T t) {
        list.remove(t);
    }
}

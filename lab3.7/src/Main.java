import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;

class Array<E> extends AbstractList<E> {
    ArrayList<Object> arr = new ArrayList<>();

    int from, to;

    public Array(int from, int to){
        this.from = from;
        this.to = to;
    }

    @Override
    public E get(int index) {
        return (E)arr.get(index - from);
    }

    @Override
    public int size() {
        return arr.size();
    }

    @Override
    public void add(int index, E element) {
        if (index >= from && index <= to)
            arr.add(index - from, element);
    }

    @Override
    public boolean add(E e) {
        return arr.add(e);
    }

    @Override
    public E set(int index, E element) {
        return (E)arr.set(index - from, element);
    }

    @Override
    public E remove(int index) {
        return (E)arr.remove(index - from);
    }

    @Override
    public int indexOf(Object o) {
        return arr.indexOf(o) + from;
    }

    @Override
    public int lastIndexOf(Object o) {
        return arr.lastIndexOf(o) + from;
    }

    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>)arr.iterator();
    }
}

public class Main {
    public static void main(String[] args) {
        Array<Integer> a = new Array<>(-1, 1);
        a.add(1);
        a.add(2);
        a.add(3);
        System.out.print("Elements: ");
        for (Integer k : a) {
            System.out.print(k + " ");
        }
        System.out.println("\nIndex of(2): " + a.indexOf(2));
        a.set(-1, 5);
        a.set(0, 6);
        a.set(1, 7);
        System.out.print("Set new elements 5, 6, 7: ");
        for (Integer k : a) {
            System.out.print(k + " ");
        }
        System.out.println();
        a.remove(-1);
        System.out.println("Remove(indx -1): " + a);
    }
}

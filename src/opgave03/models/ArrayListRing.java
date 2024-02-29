package opgave03.models;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

class Program {
    public static void main(String[] args) {
        ArrayListRing<String> ringOfStrings = new ArrayListRing<String>();
        ringOfStrings.add("Frodo");
        ringOfStrings.add("Samwise");
        ringOfStrings.add("Pippin");
        ringOfStrings.add("Aragon");
        ringOfStrings.add("Legolas");
        ringOfStrings.add("Gandalf");
        ringOfStrings.add("Gimli");
        ringOfStrings.add("Peregrin");
        ringOfStrings.add("Mariadoc");
        ringOfStrings.add("Boromir");
        //ringOfStrings.map(a -> "Mr. " + a);
        System.out.println(ringOfStrings.getCurrentItem());
        ringOfStrings.advance();
        System.out.println(ringOfStrings.getCurrentItem());
        ringOfStrings.removeItem("Samwise");
        System.out.println(ringOfStrings.getCurrentItem());
        System.out.println(ringOfStrings.size());
        ringOfStrings.removeCurrentItem();
        System.out.println(ringOfStrings.getCurrentItem());
        System.out.println(ringOfStrings.size());
        System.out.println(ringOfStrings.isEmpty());
        ArrayListRing<String> ringOfStringsv02 = new ArrayListRing<String>();
        Ring<String> ringB = ringOfStrings.where(a -> a.startsWith("G"));
        System.out.println(ringB.size());
        // Test of the EmptyRingException:
        //ringOfStringsv02.getCurrentItem();
    }
}
public class ArrayListRing<T> implements Ring<T>{

    private final ArrayList<T> ringItems = new ArrayList<T>();
    // Check
    public T getCurrentItem() {
        if(!isEmpty()) {
            return ringItems.getFirst();
        }
        else {
            throw new EmptyRingException();
        }
    }
    // Check
    @Override
    public void add(T item) {
        ringItems.addFirst(item);
    }
    // Check
    @Override
    public boolean removeItem(T item) {
        return ringItems.remove(item);
    }
    // Check
    @Override
    public T removeCurrentItem() {
        T item = ringItems.getFirst();
        ringItems.remove(ringItems.getFirst());
        return item;
    }
    // Check
    @Override
    public int size() {
        return ringItems.size();
    }

    @Override
    public boolean isEmpty() {
        return ringItems.isEmpty();
    }

    public void advance() {
        T item = ringItems.getFirst();
        removeCurrentItem();
        ringItems.add(item);
    }

    public void map(Function<T, T> function) {
        for(int i = 0; i < ringItems.size(); i++) {
            ringItems.set(i,function.apply(ringItems.get(i)));
        }
    }

    @Override
    public Ring<T> where(Predicate<T> predicate) {
        Ring<T> ring = new ArrayListRing<T>();
        for (T ringItem : ringItems) {
            if(predicate.test(ringItem)) {
                ring.add(ringItem);
            }
        }
        return ring;
    }

}

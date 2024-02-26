package opgave03.models;

import java.util.ArrayList;
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
        ringItems.add(item);
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
}
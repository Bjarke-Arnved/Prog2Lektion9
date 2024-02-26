package opgave02.models;

public class ArrayBag<E> implements Bag<E> {
    // the array to hold the items
    private final E[] items;
    // current number of items in the bag,
    // items are at index 0..size-1
    private int size;

    /** Create a bag with the given capacity. */
    public ArrayBag(int capacity) {
        @SuppressWarnings("unchecked")
        E[] empty = (E[]) new Object[capacity];
        items = empty;
        size = 0;
    }

    /** Create a bag with capacity 10. */
    public ArrayBag() {
        this(10);
    }

    @Override
    public int getCurrentSize() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == items.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(E newEntry) {
        boolean itemAdded = false;
        int i = 0;
        if(!isFull()) {
            while(i <= items.length - 1 && !itemAdded) {
                if(items[i] == null) {
                    items[i] = newEntry;
                    itemAdded = true;
                    size++;
                }
                else {
                    i++;
                }
            }
        }
        return itemAdded;
    }

    @Override
    public E remove() {
        E item = null;
        int i = items.length - 1;
        while(i >= 0 && item == null) {
            if(items[i] != null) {
                item = items[i];
                items[i] = null;
                size--;
            }
            i--;
        }
        return item;
    }

    @Override
    public boolean remove(E anEntry) {
        boolean isThere = false;
        for(int i = 0; i < items.length - 1; i++) {
            if(items[i] == anEntry) {
                items[i] = null;
                isThere = true;
                size--;
            }
        }
        return isThere;
    }

    @Override
    public void clear() {
        for(int i = 0; i < items.length - 1; i++) {
            items[i] = null;
        }
        size = 0;
    }

    @Override
    public int getFrequencyOf(E anEntry) {
        int count = 0;
        for(int i = 0; i < items.length - 1; i++) {
            if(items[i] == anEntry) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean contains(E anEntry) {
        boolean isFound = false;
        for(int i = 0; i < items.length - 1; i++) {
            if(items[i] == anEntry) {
                isFound = true;
                i = items.length;
            }
        }
        return isFound;
    }

    @Override
    public E[] toArray() {
        int count = 0;
        E[] newBag;
        if(!isFull()) {
            for(int i = 0; i < items.length - 1; i++) {
                if(items[i] == null) {
                }
                count++;
            }
        }
        else {
            count = size;
        }
        newBag = (E[])new Object[count];
        int eIndex = 0;
        for(int i = 0; i < items.length - 1; i++) {
            if(items[i] != null) {
                newBag[eIndex] = items[i];
                eIndex++;
            }
        }
        return newBag;
    }

}
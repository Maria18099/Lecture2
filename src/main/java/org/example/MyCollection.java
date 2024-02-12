package org.example;

import java.util.Iterator;

public class MyCollection<T> implements Iterable<T>{
    private T[] elements;
    private int last;
    public MyCollection(int size){
        elements = (T[])new Object[size];
        last = -1;
    }
    public void add(T element) {
        if (last < elements.length) {
            elements[++last] = element;
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }
    private class MyIterator implements Iterator<T>{
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index<=last;
        }

        @Override
        public T next() {
            if(hasNext()){
                T item = elements[index++];
                return item;
            }
            return null;
        }
    }
}

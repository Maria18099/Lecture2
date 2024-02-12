package org.example;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{
    class Node<T>{
        T data;
        Node<T> next;
        Node(T data){
            this.data = data;
        }
    }
    private Node<T> head;
    public void add(T data){
        Node<T> newNode = new Node<>(data);
        if(head==null){
            head = newNode;
            return;
        }
        Node<T> current = head;
        while (current.next!=null){
            current=current.next;
        }
        current.next = newNode;
    }
    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }
    private class MyLinkedListIterator implements Iterator<T>{
        Node<T> current = head;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public T next() {
            if (hasNext()){
                T element = current.data;
                current = current.next;
                return element;
            }
            return null;
        }
    }
}

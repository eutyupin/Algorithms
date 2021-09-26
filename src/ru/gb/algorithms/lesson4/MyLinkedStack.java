package ru.gb.algorithms.lesson4;

public class MyLinkedStack<T> {
    private MyLinkedList list;

    public MyLinkedStack() {
        list = new MyLinkedList();
    }

    public void push(T item) {
        list.insertFirst(item);
    }

    public T pop() {
        return (T) list.removeFirst();
    }

    public T peek() {
        return (T) list.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
    public int size() {
        return list.size();
    }
}

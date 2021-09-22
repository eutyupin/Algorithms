package ru.gb.algorithms.lesson4;

import java.util.ArrayList;

public class MyLinkedQueue<T> {
    private MyLinkedList list;

    public MyLinkedQueue() {
        list = new MyLinkedList();
    }

    public void insert(T item) {
        list.insertLast(item);
    }

    public T peekFront() {
        return (T) list.getFirst();
    }

    public T remove() {
        return (T) list.removeFirst();
    }

}



package ru.gb.algorithms.lesson3;

public class MyDeQueue<T> {
    private  T[] deQueueList;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

    public MyDeQueue(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity: " + capacity);
        }
        deQueueList = (T[]) new Object[capacity];
    }

    public MyDeQueue() {
        deQueueList = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void insertLeft(T item) {
        if (isFull()) {

        }

    }

    public void insertRight(T item) {
        if (isFull()) {

        }

    }

    public T peekLeft() {
        if (isEmpty()) {
            throw new RuntimeException("Queue  is empty!");
        }
        return deQueueList[0];
    }

    public T peekRight() {
        if (isEmpty()) {
            throw new RuntimeException("Queue  is empty!");
        }
        return deQueueList[size - 1];
    }

    public T removeLeft() {
//        T tempItem = peekFront();
//        queueList[begin] = null;
//        size--;
//        begin = nextIndex(begin);
//        return tempItem;
        return null;
    }

    public T removeRight() {
//        T tempItem = peekFront();
//        queueList[begin] = null;
//        size--;
//        begin = nextIndex(begin);
//        return tempItem;
        return null;
    }


    private int previousIndex(int index) {
        return (index + 1) % deQueueList.length;
    }

    private int nextIndex(int index) {
        return (index + 1) % deQueueList.length;
    }

    public int size() {
        return  size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == deQueueList.length;
    }
}

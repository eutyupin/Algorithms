package ru.gb.algorithms.lesson3;

import java.util.Arrays;

public class MyQueue<T> {
    private  T[] queueList;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int firstElement;
    private int lastElement;

    public MyQueue(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity: " + capacity);
        }
        queueList = (T[]) new Object[capacity];
    }

    public MyQueue() {
        queueList = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void insert(T item) {
        if (isFull()) {
            extendQueueListSize();
        }
        queueList[lastElement] = item;
        size++;
        lastElement = nextIndex(lastElement);
    }

    private void extendQueueListSize() {
        int newSize = (int) (size * 1.5) + 1;
        T[] tempQueueContainer = (T[]) new Object[newSize];
        System.out.println("firstElement: " + firstElement);
        System.out.println();
        if (firstElement < lastElement) {
            System.arraycopy(queueList,firstElement,tempQueueContainer,0,lastElement - firstElement);
        }
        if (lastElement == 0 && firstElement == 0) {
            System.arraycopy(queueList,0,tempQueueContainer,0,size);
        }

        if (firstElement > lastElement) {
            System.arraycopy(queueList,firstElement,tempQueueContainer,0,size - firstElement);
            System.arraycopy(queueList,0,tempQueueContainer,size - firstElement,lastElement);
        }
        firstElement = 0;
        lastElement = size;
        System.out.println("lastElement: " + lastElement);
        System.out.println("Size: " + size);

        queueList = tempQueueContainer;
    }

    private int nextIndex(int index) {
        return (index + 1) % queueList.length;
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new RuntimeException("Queue  is empty!");
        }
        return queueList[firstElement];
    }

    public T remove() {
        if (isEmpty()) {
            throw new RuntimeException("Queue  is empty!");
        }
        T tempItem = peekFront();
        queueList[firstElement] = null;
        size--;
        firstElement = nextIndex(firstElement);
        return tempItem;
    }

    public int size() {
        return  size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queueList.length;
    }
}

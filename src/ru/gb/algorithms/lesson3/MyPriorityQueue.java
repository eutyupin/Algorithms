package ru.gb.algorithms.lesson3;

import java.util.EmptyStackException;

public class MyPriorityQueue<T extends Comparable<T>> {
    private  T[] priorityQueueList;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyPriorityQueue(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity: " + capacity);
        }
        priorityQueueList = (T[]) new Comparable[capacity];
    }

    public MyPriorityQueue() {
        priorityQueueList = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    public int size () {
        return  size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == priorityQueueList.length;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return priorityQueueList[size - 1];
        }
    }

    public void insert(T item) {
        if (isFull()) {
            extendStackListSize();
        }
        priorityQueueList[size] = item;
        size++;
        int i = size - 1;
        while (i > 0 && priorityQueueList[i].compareTo(priorityQueueList[i - 1]) > 0) {
            swap(i, i - 1);
            i--;
        }

    }

    public T remove() {
        T tempItem = peek();
        priorityQueueList[size - 1] = null;
        size--;
        return tempItem;
    }

    private void extendStackListSize() {
        int newSize = (int) (size * 1.5) + 1;
        T[] tempQueueContainer = (T[]) new Object[newSize];
        System.arraycopy(priorityQueueList,0,tempQueueContainer,0,size);
        priorityQueueList = tempQueueContainer;
    }

    private void swap(int index1, int index2) {
        T tempValue = priorityQueueList[index1];
        priorityQueueList[index1] = priorityQueueList[index2];
        priorityQueueList[index2] = tempValue;
    }

}

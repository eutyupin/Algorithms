package ru.gb.algorithms.lesson3;

import java.util.Arrays;

public class MyDeQueue<T> {
    private  T[] deQueueList;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int leftElement;
    private int rightElement;

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
            extendDeQueueListSize();
        }
        if (deQueueList[leftElement] == null) {
            deQueueList[leftElement] = item;
            size++;
        }
        else {
            leftElement = previousIndex(leftElement);
            deQueueList[leftElement] = item;
            size++;
        }
    }

    public void insertRight(T item) {
        if (isFull()) {
            extendDeQueueListSize();
        }
        if (deQueueList[rightElement] == null) {
            deQueueList[rightElement] = item;
            size++;
        }
        else {
            rightElement = nextIndex(rightElement);
            deQueueList[rightElement] = item;
            size++;
        }
    }

    public T peekLeft() {
        if (isEmpty()) {
            throw new RuntimeException("Queue  is empty!");
        }
        return deQueueList[leftElement];
    }

    public T peekRight() {
        if (isEmpty()) {
            throw new RuntimeException("Queue  is empty!");
        }
        if ((rightElement - 1) == -1) return deQueueList[ size - 1];
        else return deQueueList[rightElement];
    }

    public T removeLeft() {
        T tempItem = peekLeft();
        deQueueList[leftElement] = null;
        size--;
        leftElement = nextIndex(leftElement);
        return tempItem;
    }

    public T removeRight() {
        T tempItem = peekRight();
        deQueueList[rightElement] = null;
        size--;
        rightElement = previousIndex(rightElement);
        return tempItem;
    }


    private int previousIndex(int index) {
        if(index == 0) {
            return deQueueList.length - 1;
        } else {
            return (index - 1) % deQueueList.length;
        }
    }

    private int nextIndex(int index) {
        return (index + 1) % deQueueList.length;
    }

    private void extendDeQueueListSize() {
        int newSize = (int) (size * 1.5) + 1;
        T[] tempDeQueueContainer = (T[]) new Object[newSize];
        if (leftElement < rightElement) {
            System.arraycopy(deQueueList,leftElement,tempDeQueueContainer,0,size);
        }
        if (rightElement == 0 && leftElement == 0) {
            System.arraycopy(deQueueList,0,tempDeQueueContainer,0,size);
        }

        if (leftElement > rightElement) {
            System.arraycopy(deQueueList,leftElement,tempDeQueueContainer,0,size - leftElement);
            System.arraycopy(deQueueList,0,tempDeQueueContainer,size-leftElement,rightElement + 1);
        }
        leftElement = 0;
        rightElement = size - 1;
        deQueueList = tempDeQueueContainer;
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

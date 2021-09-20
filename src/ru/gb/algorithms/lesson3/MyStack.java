package ru.gb.algorithms.lesson3;

import java.util.EmptyStackException;

public class MyStack<T> {
    private  T[] stackList;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyStack(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity: " + capacity);
        }
        stackList = (T[]) new Object[capacity];
    }

    public MyStack() {
        stackList = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public int size () {
        return  size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == stackList.length;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stackList[size - 1];
        }
    }

    public void push(T item) {
        if (isFull()) {
            extendStackListSize();
        }
        stackList[size] = item;
        size++;

    }

    public T pop() {
        T tempItem = peek();
        stackList[size - 1] = null;
        size--;
        return tempItem;
    }

    private void extendStackListSize() {
        int newSize = (int) (size * 1.5) + 1;
        T[] tempStackContainer = (T[]) new Object[newSize];
        System.arraycopy(stackList,0,tempStackContainer,0,size);
        stackList = tempStackContainer;
    }

}

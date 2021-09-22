package ru.gb.algorithms.lesson4;

public class MyLinkedList<T> {
    private Node first;
    private Node last;
    private int size;

    public void insertFirst(T item) {
        Node newNode = new Node(item, first);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.setPrev(newNode);
        }
        first = newNode;
        size++;
    }

    public void insertLast(T item) {
        Node newNode = new Node(last, item,null);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    public T removeFirst() {
//        if(isEmpty()) {
//            throw new RuntimeException("List is empty");
//        }
        T temp = getFirst();
        first = first.getNext();
        if (isEmpty()) {
            last = null;
        } else {
            first.setPrev(null);
        }
        size--;
        return temp;
    }

    public T removeLast() {
        T temp = getLast();
        if (last.getPrev() != null) {
            last.getPrev().setNext(null);
        } else {
            last = last.getPrev();
        }
        last = last.getPrev();
        size--;
        return  temp;
    }

    public void insert(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + " size: " + size);
        }
        if (index == 0) {
            insertFirst(item);
            return;
        }
        if (index == size) {
            insertLast(item);
            return;
        }
        Node current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        Node newNode = new Node(current, item, current.getNext());
        current.getNext().setPrev(newNode);
        current.setNext(newNode);
        size++;
    }

    public boolean remove(T item){
        if (isEmpty()) {
            return false;
        }
        if (getFirst().equals(item)) {
            removeFirst();
            return true;
        }
        Node current = first;
        while (current != null && !current.getValue().equals(item)) {
            current = current.getNext();
        }
        if(current == null) {
            return false;
        }
        current.getNext().setPrev(current.getPrev());
        current.getPrev().setNext(current.getNext());
        size--;
        return true;
    }

    public  int indexOf(T item) {
        int index = 0;
        Node current = first;
       while (current.getNext() != null) {
           if (current.getValue().equals(item)) {
               return index;
           }
           current = current.getNext();
           index++;
       }
       return -1;
    }
    @Override
    public String toString() {
        Node current = first;
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(current.getValue()).append(",");
            current = current.getNext();
        }
        if(size > 0) {
            sb.setLength(sb.length() - 1);
        }
        sb.append("]");
        return sb.toString();
    }

    public final T getFirst() {
        if(isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        return first.getValue();
    }

    public final T getLast() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        return last.getValue();

    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }



    private class Node {
        T value;
        Node next;
        Node prev;

        public Node(Node prev, T value, Node next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}


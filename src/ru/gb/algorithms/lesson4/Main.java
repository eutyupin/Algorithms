package ru.gb.algorithms.lesson4;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLL = new MyLinkedList<>();

        myLL.insertFirst(5);
        myLL.insertFirst(15);
        myLL.insertFirst(25);
        myLL.insertFirst(35);
        myLL.insertFirst(45);
        myLL.insertFirst(55);
        myLL.insert(1, 77);
        myLL.insert(1, 77);
        System.out.println(myLL);
        System.out.println(myLL.remove(77));
        System.out.println(myLL);
        System.out.println(myLL.indexOf(77));
        System.out.println(myLL.indexOf(45));
        System.out.println(myLL.indexOf(15));
        System.out.println(myLL.indexOf(55));
    }
}

package ru.gb.algorithms.lesson3;

public class Main {
    public static void main(String[] args) {
        System.out.println(WordsReverse.returnReverseWord("Hello World!"));

        MyDeQueue<Integer> deQueue = new MyDeQueue<>();
        deQueue.insertRight(65);
        deQueue.insertRight(65);
        deQueue.insertRight(65);
        deQueue.insertRight(65);
        deQueue.insertRight(45);
        deQueue.insertLeft(11);
        deQueue.insertLeft(17);
        System.out.println("remove left: " + deQueue.removeLeft());
        System.out.println("remove right: " + deQueue.removeRight());
        System.out.println(deQueue.peekLeft());
        System.out.println(deQueue.peekRight());

    }
}

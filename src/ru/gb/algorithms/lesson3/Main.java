package ru.gb.algorithms.lesson3;

public class Main {
    public static void main(String[] args) {
        System.out.println(WordsReverse.returnReverseWord("Hello World!"));



       ////
        MyQueue<Integer> queue = new MyQueue<>();
        for (int i = 0; i < 15; i++) {
            queue.insert(i);
        }

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        queue.insert(77);
        queue.insert(99);
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }

    }
}

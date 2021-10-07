package ru.gb.algorithms.lesson8;

public class Main {
    public static void main(String[] args) {
        ChainingHashMap<Integer, String> chm = new ChainingHashMap<>(7);
        chm.put(1,"one");
        chm.put(2,"two");
        chm.put(3,"three");
        chm.put(4,"four");
        System.out.println(chm.toString());
        chm.remove(1);
        System.out.println(chm.toString());
    }
}

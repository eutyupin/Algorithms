package ru.gb.algorithms.lesson6;

import java.util.Random;

public class MainTree {
    private static int tempInt;
    private static final int TREES_COUNT = 200;
    private static final int TREES_DEPTH = 6;


    public static void main(String[] args) {
        fillTrees();
    }

    private static int rand(int min, int max){
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    private static void fillTrees() {
        double balanced = 0;
        double disbalanced = 0;
        MyTreeMap<Integer, String>[] mtm = new  MyTreeMap[TREES_COUNT];
        for (int i = 0; i < TREES_COUNT; i++) {
            mtm[i] = new MyTreeMap<>();
            while (mtm[i].height() <= TREES_DEPTH) {
            tempInt = rand(-100, 100);
            mtm[i].put(tempInt, String.valueOf(tempInt));
             }
            System.out.println(mtm[i]);
            if (mtm[i].isBalanced()) balanced++;
            else disbalanced++;
            System.out.println(mtm[i].isBalanced());
        }
        double percentage = (disbalanced / (balanced + disbalanced)) * 100;
        System.out.println("Disbalanced trees is: " + percentage + "%");
    }
}

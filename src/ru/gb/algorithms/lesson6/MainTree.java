package ru.gb.algorithms.lesson6;

import java.util.Random;

public class MainTree {
    private static int tempInt;

    public static void main(String[] args) {
        fillTrees();
    }

    private static int rand(int min, int max){
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    private static void fillTrees() {
        MyTreeMap<Integer, String>[] mtm = new  MyTreeMap[50];
        for (int i = 0; i < 50; i++) {
            mtm[i] = new MyTreeMap<>();
            while (mtm[i].height() <= 6) {
            tempInt = rand(100, -100);
            mtm[i].put(tempInt, String.valueOf(tempInt));
             }
            System.out.println(mtm[i]);
            System.out.println(mtm[i].isBalanced());
        }
    }
}

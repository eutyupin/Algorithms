package ru.gb.algorithms;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final int CAPACITY = 100000;
    private static int[] bubbleSortArr = new int[CAPACITY];
    private static int[] selectionSortArray = new int[CAPACITY];
    private static int[] insertionSortArray = new int[CAPACITY];

    public static void main(String[] args) {
        fillArray();
        bubbleSort();
        selectionSort();
        insertionSort();
    }

    private static void fillArray() {
        Random random = new Random();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < CAPACITY; i++) {
            bubbleSortArr[i] = random.nextInt(100);
        }
        System.arraycopy(bubbleSortArr,0,selectionSortArray,0,CAPACITY);
        System.arraycopy(bubbleSortArr,0,insertionSortArray,0,CAPACITY);
        long endTime = System.currentTimeMillis();
        System.out.println("Arrays creating time: " + (endTime - startTime) + " millis");
    }

    private static void bubbleSort() {
        long startTime = System.currentTimeMillis();
        System.out.println("Bubble sort in progress. Wait...");
        for (int i = CAPACITY - 1; i >= 1 ; i--) {
            for (int j = 0; j < i; j++) {
                if (bubbleSortArr[j] > bubbleSortArr[j + 1]) {
                    int tmpValue = bubbleSortArr[j];
                    bubbleSortArr[j] = bubbleSortArr[j + 1];
                    bubbleSortArr[j + 1] = tmpValue;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Arrays bubble sorting time: " + (endTime - startTime) + " millis" + System.lineSeparator());
    }

    private static void selectionSort() {
        long startTime = System.currentTimeMillis();
        System.out.println("Selection sort in progress. Wait...");
        int pos;
        for (int i = 0; i < CAPACITY; i++) {
            pos = i;
            for (int j = i + 1; j < CAPACITY; j++) {
                if (selectionSortArray[j] < selectionSortArray[pos]) {
                    pos = j;
                }
            }
            int tmpValue = selectionSortArray[i];
            selectionSortArray[i] = selectionSortArray[pos];
            selectionSortArray[pos] = tmpValue;
        }


        long endTime = System.currentTimeMillis();
        System.out.println("Arrays selection sorting time: " + (endTime - startTime) + " millis" + System.lineSeparator());
    }

    private static void insertionSort() {
        long startTime = System.currentTimeMillis();
        System.out.println("Insertion sort in progress. Wait...");
        for (int i = 1; i < CAPACITY; i++) {
            int tmpValue = insertionSortArray[i];
            int j = i;
            while(j > 0 && insertionSortArray[j - 1] >= tmpValue){
                insertionSortArray[j] = insertionSortArray[j - 1];
                --j;
            }
            insertionSortArray[j] = tmpValue;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Arrays insertion sorting time: " + (endTime - startTime) + " millis" + System.lineSeparator());
        System.out.println(Arrays.toString(insertionSortArray));
    }
}

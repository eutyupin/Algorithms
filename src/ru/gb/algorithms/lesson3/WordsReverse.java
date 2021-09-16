package ru.gb.algorithms.lesson3;

public class WordsReverse {
    private static MyStack<Character> myStack = new MyStack<>();
    private static char[] tempCharArray;


    public static String returnReverseWord(String word) {
        tempCharArray = word.toCharArray();
        String outputString = "";
        for (int i = 0; i < tempCharArray.length; i++) {
            myStack.push(tempCharArray[i]);
        }
        while (!myStack.isEmpty()) {
            outputString += myStack.pop();
        }

        return outputString;
    }






}

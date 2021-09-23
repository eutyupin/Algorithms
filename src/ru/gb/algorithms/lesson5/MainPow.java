package ru.gb.algorithms.lesson5;

public class MainPow {

    public static void main(String[] args) {
        System.out.println(firstPowerMethod(2,31));
        System.out.println(secondPowerMethod(2,31));
        System.out.println(firstPowerMethod(2,30));
        System.out.println(secondPowerMethod(2,30));
    }

    public static long firstPowerMethod(int number, int powNumber) {
        if(powNumber != 0) {
            return (number) * firstPowerMethod(number,powNumber - 1);
        }
        else return 1;
    }

    public static long secondPowerMethod(int number, int powNumber) {
        long halfPowValue;
        if( powNumber == 0) return 1;
        halfPowValue = secondPowerMethod(number, powNumber/2);
        if (powNumber % 2 == 0) return halfPowValue * halfPowValue;
        else return number * halfPowValue * halfPowValue;
    }
}

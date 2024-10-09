package week1;

import java.util.Arrays;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
    public int factorial(int factorial){
        if (factorial < 0) {
            throw new IllegalArgumentException("Cannot calculate factorial of a negative number");
        }
        if (factorial == 0) {
            return 1;
        }
        return factorial * factorial(factorial - 1);
    }
    public String[] stringToArray(String s) {
        if(s == null) {
            return null;
        }
        else{
            return s.split(" ");
        }
    }
    public int[] sort(int[] array) {
        if(array.length == 0){
            return new int[0];
        }
        Arrays.sort(array);
        return array;
    }
}

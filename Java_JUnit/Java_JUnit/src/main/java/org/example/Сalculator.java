package org.example;


public class Сalculator {
    /**
     * division two numbers
     * @param a number
     * @param b number
     * @return double - the result of dividing two numbers
     */
    public double division(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("it is impossible to divide by zero");

        }
        return (double) a / b;
    }

    /**
     * adding two numbers
     * @param a number
     * @param b number
     * @return int - the result of adding two numbers
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * subtract two numbers
     * @param a number
     * @param b number
     * @return int - the result of subtract two numbers
     */
    public double subtract(int a, int b) {
        return a - b;
    }

    /**
     * multiply two numbers
     * @param a number
     * @param b number
     * @return int - the result of multiply two numbers
     */
    public int multiply(int a, int b){
        return a * b;
    }
}

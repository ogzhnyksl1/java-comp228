package exercise3;

//I implemented a class with overloaded static methods named calculate()
//to demonstrate method overloading using different parameters.

public class OverloadedMethods {

    public static int calculate(int a, int b) {
        return a + b;
    }

    public static double calculate(double a, double b) {
        return a + b;
    }

    public static int calculate(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        System.out.println("Sum of two integers: " + calculate(5, 10));
        System.out.println("Sum of two doubles: " + calculate(5.5, 10.2));
        System.out.println("Sum of three integers: " + calculate(1, 2, 3));
    }
}

package isp.lab2.Exercise2PrimeProduct;

import java.util.Scanner;

public class Exercise2PrimeProduct {

    /**
     * This method should return the product of the first n prime numbers
     *
     * @param n
     * @param m
     * @return
     */
    public static String isPrime(int num) {
        if (num <= 1) {
            return "no";
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return "no";
            }
        }
        return "OK";
    }

    public static long getPrimeProduct(int x, int y) {
        long product = 1;
        for (int i = x; i <= y; i++) {
            if (isPrime(i).equals("OK")) {
                product = product * i;
            }
        }
        return product;
    }
    /**
     * This method should read from the console a number
     *
     * @return the number read from the console
     */
    public static int readfromConsoleInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        return number;
    }

    public static void main(String[] args) {

        String OK = "OK";
        String no = "no";
        int x = readfromConsoleInt();
        int y = readfromConsoleInt();
        boolean ok = false;
        System.out.print("Prime numbers between " + x + " and " + y + ": ");
        for (int i = x; i <= y; i++) {
            ok = isPrime(i).equals(OK);
            System.out.print(ok ? i + " " : "");
        }
        System.out.println();
        if (!ok) {
            System.out.println(no);
        }


        System.out.println("The product of the first 10 prime numbers is: " + getPrimeProduct(1, 10));
        System.out.println("The product of prime numbers between x and y: " + x + "and " + y + "is:" + getPrimeProduct(x, y));
    }
}
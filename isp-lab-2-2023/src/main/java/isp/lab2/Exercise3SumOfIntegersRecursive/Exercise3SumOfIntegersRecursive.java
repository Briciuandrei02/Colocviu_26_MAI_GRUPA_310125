package isp.lab2.Exercise3SumOfIntegersRecursive;

public class Exercise3SumOfIntegersRecursive {
    public static void main(String[] args) {
        int n = 5;
        int sum = sumOfIntegers(n);
        System.out.println("Suma numerelor de la 1 la " + n + " este " + sum);
    }

    /**
     * This method will return the sum of the first n integers
     * @param n
     * @return
     */
    public static int sumOfIntegers(int n) {
        return Suma(n, 0);
    }

    public static int Suma(int n, int acc) {
        if (n == 0) {
            return acc;
        } else {
            return Suma(n - 1, acc + n);
        }
    }
}
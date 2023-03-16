package isp.lab2.Exercise5EvenOddSearch;

public class Exercise5EvenOddSearch {

    public static int[] findEvenOdd(String input) {
        int[] numar = new int[4];
        int max = 0;
        int min = 999;
        int numar1;
        String[] impartit = input.split(",");
        for (int i = 0; i < impartit.length; i++) {
            numar1 = Integer.parseInt(impartit[i]);
            if (numar1 > max) {
                max = numar1;
                numar[0] = max;
                numar[1] = i;
            } if (numar1 < min) {
                min = numar1;
                numar[2] = min;
                numar[3] = i;
            }
        }
        return numar;
    }

    public static void main(String[] args) {
        String input = "1,2,3,4,5,6,7,8,9,10";
        int[] result = findEvenOdd(input);
        for (int i : result) {
            System.out.println(i);
        }
    }
}

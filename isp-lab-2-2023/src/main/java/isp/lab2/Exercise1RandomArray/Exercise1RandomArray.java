package isp.lab2.Exercise1RandomArray;
import java.util.Arrays;
import java.util.Random;

public class Exercise1RandomArray {

    public static int[] getArrayOfRandomNumbers(int n) {
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(91)+10;
        }
        return array;
    }

    public static int[] findMaxAndMin(int[] array) {
        if(array==null || array.length==0){
            throw new IllegalArgumentException("Matricea este goala");}
        int[] result = new int[2];
        result[0] = array[0];
        result[1] = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < result[0]) {
                result[0] = array[i];
            }
            if (array[i] > result[1]) {
                result[1] = array[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Random random = new Random();

        //genereaza numar random intre 10 si 100
        int size = random.nextInt(91) + 10;
        int[] a = getArrayOfRandomNumbers(size);
        System.out.println("Generated array size:"+a.length);
        int[] mm = findMaxAndMin(a);
        System.out.println("Min is:" + mm[0] + " Max is:" + mm[1]);
    }
}

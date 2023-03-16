package isp.lab2.Exercise6WordGuess;

import java.util.Set;

public class Exercise6WordGuess {

    /**
     * This method will return the number of occurrences of a character in a word
     * @param c
     * @param cuv
     * @return
     */
    public static int countOccurence(char c, char[] cuv) {
        int k = 0;
        for (int i = 0; i < cuv.length; i++) {
            if (cuv[i] == c) {
                k++;
            }
        }
        return k;
    }
    }

    public static void main(String[] args) {
      Set<String> dictionary=loadDictionary("dictionary.txt")/*incarcam un dictionar dintr-un fisier*/
        String word=getRandomWord(dictionary)/*generam un cuvant random*/
    }

    private static String getRandomWord(Set<String> dictionary) {
    return null;
    }

    private static Set<String> loadDictionary(String s) {
    return null;
    }

}

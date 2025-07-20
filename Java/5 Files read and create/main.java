import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class main {

    public static void main(String[] args) {
        int i = 0, j, q;
        String line = null;
        BufferedReader reader = null;

        // SAFETY CHECK: Avoid crash if no filename is given
        if (args.length == 0) {
            System.out.println("Please provide an input file as an argument.");
            return;
        }

        try {
            reader = new BufferedReader(new FileReader(args[0]));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        try {
            while ((line = reader.readLine()) != null) {
                String[] words = new String[tokenize(line).length];
                words = tokenize(line).clone();

                for (j = 0; j < words.length; j++) {
                    String[] anagrams = new String[factorial(words[j].length())];
                    anagrams = generateAnagrams(words[j]).clone();

                    while (i != anagrams.length) {
                        FileWriter fstream = new FileWriter(words[j] + ".txt");
                        BufferedWriter out = new BufferedWriter(fstream);
                        for (q = 0; q < anagrams.length; q++) {
                            out.write(anagrams[q] + " ");
                        }
                        out.close();
                        fstream.close();
                        i++;
                    }
                    i = 0;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Tokenizes a sentence into words and stores them in an array
    public static String[] tokenize(String sentence) {
        int i = 0;
        StringTokenizer tokenizer = new StringTokenizer(sentence);
        String[] words = new String[tokenizer.countTokens()];
        while (tokenizer.hasMoreTokens()) {
            words[i] = tokenizer.nextToken();
            i++;
        }
        return words;
    }

    // Calculates the factorial of a number
    public static int factorial(int a) {
        int i, result = 1;
        for (i = 1; i <= a; i++) {
            result *= i;
        }
        return result;
    }

    // Generates all anagrams of a word and returns them in an array
    public static String[] generateAnagrams(String word) {
        int i, j, k = 0, z = 0, l = 0;
        char[] characters = word.toCharArray();
        String[] anagrams = new String[factorial(word.length())];

        if (word.length() > 1) {
            for (i = 0; i <= factorial(word.length()) - 1; i++) {
                j = i;
                l++;
                if (j >= word.length() - 1) {
                    if (l >= word.length()) {
                        z = z + (word.length() - 1);
                        l = 1;
                    }
                    j = j - z;
                }

                characters = swapAdjacent(characters, j);
                anagrams[k] = new String(characters);
                k++;
            }
        } else {
            anagrams[0] = new String(characters);
        }

        return anagrams;
    }

    // Swaps character at index j with character at index j+1
    public static char[] swapAdjacent(char[] array, int j) {
        char temp;
        temp = array[j + 1];
        array[j + 1] = array[j];
        array[j] = temp;
        return array;
    }
}
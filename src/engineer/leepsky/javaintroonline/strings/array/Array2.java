package engineer.leepsky.javaintroonline.strings.array;

import java.util.Arrays;

public class Array2 {

    /* Замените в строке все вхождения 'word' на 'letter'. */

    public static char[] addWord(char[] array, char[] word) {

        char[] result = Arrays.copyOf(array, array.length + word.length);

        for (int i = 0; i < word.length; i++)
            result = Array1.addSymbol(result, word[i]);

        return result;

    }

    public static char[] replace(char[] phrase, char[] ol, char[] nw) {

        char[] result = new char[0];

        for (int i = 0; i < phrase.length; i++) {

            boolean found = phrase.length - i > ol.length ? true : false;

            if (found)
                for (int j = 0; j < ol.length; j++)
                    if (phrase[i + j] != ol[j])
                        found = false;

            if (found) {

                result = addWord(result, nw);
                i += ol.length - 1;

            } else {
                
                result = Array1.addSymbol(result, phrase[i]);

            }

        }

        return result;

    }

    public static void main(String[] args) {

        char[] phrase = "A phrase with a word to be replaced. And once again, word!".toCharArray();

        System.out.println(
            replace(phrase, "word".toCharArray(), "letter".toCharArray())
        );

    }
    
}

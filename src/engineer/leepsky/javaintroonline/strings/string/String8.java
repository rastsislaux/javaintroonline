package engineer.leepsky.javaintroonline.strings.string;

public class String8 {

    /* Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. Случай, когда самых
       длинных слов может быть несколько, не обрабатывать. */

    public static String getLongestWord(String s) {

        String[] words = s.trim().split("\\s+");

        String max = "";
        for (String word : words)
            if (word.length() > max.length()) max = word;

        return max;

    }

    public static void main(String[] args) {

        String str = "A string where the longest word will be found.";

        System.out.println(
            getLongestWord(str)
        );

    }
    
}

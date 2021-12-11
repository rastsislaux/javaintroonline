package engineer.leepsky.javaintroonline.strings.string;

import java.util.regex.Pattern;

public class String10 {

    /* Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным
       знаком. Определить количество предложений в строке X. */

    public static long getSentencesNumber(String str) {

        return Pattern
                .compile("\\.|\\!|\\?")
                .matcher(str)
                .results()
                .count();

    }

    public static void main(String[] args) {

        String str = "It is a string. This string has sentences! How much of them?";

        System.out.println(
            getSentencesNumber(str)
        );

    }
    
}

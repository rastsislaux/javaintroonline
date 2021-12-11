package engineer.leepsky.javaintroonline.strings.string;

public class String1 {

    /* Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем. */

    public static int maxConsecutiveChars(String str) {

        int max = 1;
        for (int i = 1, t = 1; i < str.length(); i++)
            if ( str.charAt(i) == str.charAt(i - 1) ) t++;
            else {
                if (t > max) max = t;
                t = 1;
            }

        return max;

    }

    public static void main(String[] args) {

        String str = "aaabbbbcccccdd";

        System.out.println(
            maxConsecutiveChars(str)
        );

    }
    
}

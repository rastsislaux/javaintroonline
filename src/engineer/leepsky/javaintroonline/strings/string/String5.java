package engineer.leepsky.javaintroonline.strings.string;

public class String5 {

    /* Подсчитать, сколько раз среди символов заданной строки встречается буква “а”. */

    public static int countChar(String str, char a) {

        int count = 0;

        for (int i = 0; i < str.length(); i++)
            if ( str.charAt(i) == a ) count++;

        return count;
        
    }

    public static void main(String[] args) {

        String str = "That's a string with a symbol to find.";

        System.out.println(
            countChar(str, 'a')
        );

    }
    
}

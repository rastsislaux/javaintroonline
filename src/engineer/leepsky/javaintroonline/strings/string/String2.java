package engineer.leepsky.javaintroonline.strings.string;

public class String2 {

    /* В строке вставить после каждого символа 'a' символ 'b'. */

    public static String insertAfter(String s, char a, char b) {

        StringBuilder builder = new StringBuilder(s);
        int length = s.length();

        for (int i = 0; i < length; i++)
            if ( builder.charAt(i) == a ) { builder.insert(i + 1, b); i++; length++; }

        return builder.toString();

    }

    public static void main(String[] args) {

        String str = "A string where b will be placed after a.";

        System.out.println(
            insertAfter(str, 'a', 'b')
        );

    }
    
}

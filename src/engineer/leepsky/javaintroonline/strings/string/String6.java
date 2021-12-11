package engineer.leepsky.javaintroonline.strings.string;

public class String6 {

    /* Из заданной строки получить новую, повторив каждый символ дважды. */

    public static String doubleChars(String s) {

        StringBuilder bld = new StringBuilder();

        for (int i = 0; i < s.length(); i++) { bld.append(s.charAt(i)); bld.append(s.charAt(i)); };

        return bld.toString();

    }

    public static void main(String[] args) {

        String str = "All symbols in this string will be doubled.";

        System.out.println(
            doubleChars(str)
        );

    }
    
}

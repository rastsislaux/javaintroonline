package engineer.leepsky.javaintroonline.strings.array;

public class Array5 {

    /* Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
       Крайние пробелы в строке удалить. */

    public static char[] stripCharArray(char[] s) {

        int f, l;

        for (f = 0; s[f] == ' '; f++);
        for (l = s.length - 1; s[l] == ' '; l--);
        l = s.length - l - 1;

        char[] result = new char[s.length - f - l];

        System.arraycopy(s, f, result, 0, s.length - f - l);

        return result;

    }

    public static char[] removeExtraSpaces(char[] s) {

        char[] stripped = stripCharArray(s);
        
        char[] result = new char[0];
        boolean extraSpace = false;

        for (char c : stripped) {

            if ( c != ' ' ) {

                extraSpace = false;
                result = Array1.addSymbol(result, c);

            } else {

                if ( extraSpace ) continue;
                result = Array1.addSymbol(result, c);
                extraSpace = true;

            }

        }

        return result;

    }

    public static void main(String[] args) {

        char[] str = "   This   string has      extra spaces.      ".toCharArray();

        System.out.println(
            removeExtraSpaces(str)
        );

    }
    
}

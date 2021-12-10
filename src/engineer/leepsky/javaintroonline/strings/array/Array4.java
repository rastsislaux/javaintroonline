package engineer.leepsky.javaintroonline.strings.array;

import java.util.Arrays;

public class Array4 {

    /* В строке найти количество чисел. */

    public static int countNumbers(char[] array) {

        boolean isNumber = true;
        int     count = 0;
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = ' '; 

        for (int i = 0; i < array.length; i++) {

            if ( array[i] == ' ' ) {

                if ( isNumber ) count++;
                isNumber = true;

            } else if ( !Character.isDigit(array[i]) ) isNumber = false;

        }

        return count;

    }

    public static void main(String[] args) {

        char[] array = "123 12a b35 453".toCharArray();

        System.out.println(array);

        System.out.println( countNumbers(array) );

    }
    
}

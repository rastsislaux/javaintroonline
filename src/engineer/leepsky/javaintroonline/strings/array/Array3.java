package engineer.leepsky.javaintroonline.strings.array;

public class Array3 {

    /* В строке найти количество цифр. */

    public static int countNumbers(char[] str) {

        int count = 0;

        for (char x : str)
            if ( Character.isDigit(x) ) count++;

        return count;

    }

    public static void main(String[] args) {

        char[] array = "2, 4, 6, 8 are even numbers and 1, 3, 5, 7 are uneven.".toCharArray();

        System.out.println(
            countNumbers(array)
        );

    }
    
}

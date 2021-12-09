package engineer.leepsky.javaintroonline.strings.array;

import java.util.Arrays;

public class Array1 {

    public static char[] addSymbol(char[] array, char symbol) {

        char[] result = Arrays.copyOf(array, array.length + 1);
        result[result.length - 1] = symbol;
        return result;

    }

    /* Дан массив названий переменных в camelCase. Преобразовать названия в snake_case. */

    public static char[] camelToSnake(char[] source) {

        char[] result = new char[0];

        for (int i = 0; i < source.length; i++) {

            if (Character.isUpperCase(source[i])) {

                result = addSymbol(result, '_');
                result = addSymbol(result, Character.toLowerCase(source[i]));

            } else {

                result = addSymbol(result, source[i]);

            }

        }

        return result;

    }    

    public static void main(String[] args) {

        char[][] array = {
            "someMethodName".toCharArray(),
            "otherMethodName".toCharArray(),
            "thirdMethodName".toCharArray()
        };

        for (char[] method : array)
            System.out.println(
                camelToSnake(method)
            );

    }
    
}

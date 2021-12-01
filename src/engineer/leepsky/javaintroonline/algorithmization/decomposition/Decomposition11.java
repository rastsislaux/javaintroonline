package engineer.leepsky.javaintroonline.algorithmization.decomposition;

public class Decomposition11 {

    /* Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр. */
        
    public static int compareDigitsCount(int a, int b) {

        return Decomposition10.getCountOfDigits(a) - Decomposition10.getCountOfDigits(b);

    }

    public static void main(String[] args) {

        System.out.println(

            compareDigitsCount(1234, 12) + "\n" +
            compareDigitsCount(123, 454) + "\n" +
            compareDigitsCount(36, 8343)

        );

    }
    
}

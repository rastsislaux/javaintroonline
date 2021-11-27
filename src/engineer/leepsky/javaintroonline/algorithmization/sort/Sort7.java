package engineer.leepsky.javaintroonline.algorithmization.sort;

public class Sort7 {

    /* Пусть даны две неубывающие последовательности действительных чисел a1  a2    an и b1  b2    bm .
       Требуется указать те места, на которые нужно вставлять элементы последовательности b1  b2    bm в первую
       последовательность так, чтобы новая последовательность оставалась возрастающей. */

    public static int[] insertIntoArray(int[] array, int index, int value) {

        int[] result = new int[array.length + 1];

        for (int i = 0; i < index; i++) {

            result[i] = array[i];

        }

        result[index] = value;

        for (int i = index + 1; i < result.length; i++) {

            result[i] = array[i-1];

        }

        return result;

    }

    public static void main(String[] args) {

        int[] a = {-5, -1, 2, 4, 6, 8, 12, 21};
        int[] b = {-6, 0, 5, 6, 8, 12, 22};

        for (int i = 0; i < b.length; i++) {

            int index = Sort5.binarySearch(a, a.length - 1, b[i]);
            System.out.print("b[" + i + "] = " + index + "\n");
            a = insertIntoArray(a, index, b[i]);

        }

    }
    
}

package engineer.leepsky.javaintroonline.algorithmization.arrays;

import java.util.Scanner;

public class Arrays9 {

    /* В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких
       чисел несколько, то определить наименьшее из них. */
    
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("n: ");
        int n = in.nextInt();
        int[] a = new int[n];

        System.out.print("a[0-n]: ");
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        // Отсортируем массив по возрастанию

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        // Находим длину наибольшей последовательности повторяющихся чисел.

        int length = 1;
        for (int i = 1; i < n; i++) {
            if (a[i] == a[i - length]) {
                length++;
            }
        }

        // Найдём, какому именно числу соответствует последовательность.
        // Массив отсортирован, следовательно ответом будет наименьшее из возможных.

        int result = 0;
        for (int i = length - 1; i < n; i++) {
            if (a[i] == a[i - length + 1]) {
                result = a[i];
                break;
            }
        }

        System.out.println("result: " + result);

        in.close();
    }

}

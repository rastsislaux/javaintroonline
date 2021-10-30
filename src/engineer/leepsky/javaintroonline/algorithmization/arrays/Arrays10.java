package engineer.leepsky.javaintroonline.algorithmization.arrays;

import java.util.Scanner;

public class Arrays10 {

    /* Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив из него каждый второй
       элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать. */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        
        System.out.print("n: ");
        int n = in.nextInt();
        int[] a = new int[n];

        System.out.print("a[0-n]: ");
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            if (i % 2 == 1) a[i] = 0; 
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        in.close();

    }
    
}
package engineer.leepsky.javaintroonline.algorithmization.decomposition;

public class Decomposition8 {
    
    /* Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
       Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов
       массива с номерами от k до m. */

    public static int tripleSum(int[] array, int start) { return array[start] + array[start + 1] + array[start + 2]; }

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6};

        System.out.println(tripleSum(array, 0) + " " + tripleSum(array, 2) + " " + tripleSum(array, 3));

    }

}

package engineer.leepsky.javaintroonline.algorithmization.sort;

public class Sort6 {

    /* Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
       Делается это следующим образом: сравниваются два соседних элемента ai и ai +1 . Если ai  ai +1 , то продвигаются
       на один элемент вперед. Если ai  ai +1 , то производится перестановка и сдвигаются на один элемент назад.
       Составить алгоритм этой сортировки. */

    public static void sortShell(int[] array) {

        int i = 0;

        while (i < array.length - 1) {

            if (array[i] > array[i+1]) {

                Sort2.swap(array, i, i+1);
                if (i > 0) {
                    i--;
                }

            } else {

                i++;

            }

        }

    }

    public static void main(String[] args) {

        int[] array = {2, 4, 6, -1, 8, 12, 21, -5};

        sortShell(array);

        Sort1.printArray(array);

    }
    
}

package engineer.leepsky.javaintroonline.algorithmization.sort;

public class Sort5 {

    /* Сортировка вставками. Дана последовательность чисел a1 , a2 , ... , an . Требуется переставить числа в порядке
       возрастания. Делается это следующим образом. Пусть a1 , a2 , ... , ai - упорядоченная последовательность, т. е.
       a1 <= a2 <= ... <= an . Берется следующее число ai +1 и вставляется в последовательность так, чтобы новая
       последовательность была тоже возрастающей. Процесс производится до тех пор, пока все элементы от i +1 до n
       не будут перебраны. Примечание. Место помещения очередного элемента в отсортированную часть производить
       с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции. */

    public static int binarySearch(int[] array, int end, int info) {

        int first = 0;
        int last = end;
        int middle;

        if (info < array[first]) {

            return first;

        }

        if (info > array[last]) {

            return last + 1;

        }

        while (first <= last) {

            middle = (first + last) / 2;

            if (info > array[middle] && info <= array[middle + 1]) {

                return middle + 1;

            }

            if (array[middle] < info) {

                first = middle;

            } else {

                last = middle;

            }

        }

        return -1;

    }
    
    public static void insertSort(int[] array) {

        int last = 0;

        while (last < array.length && array[last] < array[last + 1]) {

            last++;

        }

        for (int i = last + 1; i < array.length; i++) {

            int index = binarySearch(array, last, array[i]);
            int info = array[i];
            if (i - index >= 0) {

                System.arraycopy(array, index, array, index + 1, i - index);

            }
            array[index] = info;
            last++;

        }

    }

    public static void main(String[] args) {

        int[] array = {2, 4, 6, -1, 8, 12, 21, -5};

        insertSort(array);
        Sort1.printArray(array);

    }
    
}

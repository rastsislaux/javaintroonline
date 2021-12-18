package engineer.leepsky.javaintroonline.classes.simple.simple5;

public class Simple5 {

    /* Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение
       на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и
       произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния, и метод
       позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса. */

    public static void printCounterInfo(Counter c) { System.out.println(c.getLowerFace() + " >= " + c.get() + " <= " + c.getUpperFace()); }

    public static void main(String[] args) {

        Counter c1 = new Counter();     // Counter with default params.
        printCounterInfo(c1);

        c1 = new Counter(5);            // Counter with custom value.
        printCounterInfo(c1);

        c1 = new Counter(12, 4, 16);    // Counter with custom value and faces.
        printCounterInfo(c1);

        try {
            c1 = new Counter(150);              // Counter with custom value exceeding default upper face.
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            c1 = new Counter(5, 10, 5);         // Counter with custom lower face greater than upper face.
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(
            c1.increase() + ", value: " + c1.get()  // Increase a counter by 1. Returns true, as upper face is not exceeded.
        );

        System.out.println(
            c1.increase(3) + ", value: " + c1.get() // Increase a counter by 3. Returns true, as upper face is not exceeded.
        );

        System.out.println(
            c1.increase() + ", value: " + c1.get()  // Increase a counter by 1. Returns false and value is not changed,
                                                    // upper face is exceeded.
        );

        // The same with decrease
        System.out.println(
            c1.decrease() + ", value: " + c1.get()
        );

        System.out.println(
            c1.decrease(5) + ", value: " + c1.get()
        );

        System.out.println(
            c1.decrease(20) + ", value: " + c1.get()
        );

    }
}

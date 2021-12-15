package engineer.leepsky.javaintroonline.classes.simple.simple1;

public class Simple1 {

    /* Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих
       переменных. Добавьте метод, который находит сумму значений этих переменных, и метод, который находит
       наибольшее значение из этих двух переменных. */

    public static void main(String[] args) {

        Test1 obj = new Test1();

        obj.setI(3);
        obj.setJ(4);

        obj.printI();
        obj.printJ();

        System.out.println(obj.max());

        System.out.println(obj.sum());

    }
    
}

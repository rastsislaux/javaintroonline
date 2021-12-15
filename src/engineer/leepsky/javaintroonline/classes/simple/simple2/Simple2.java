package engineer.leepsky.javaintroonline.classes.simple.simple2;

public class Simple2 {

    /* Создйте класс Test2 двумя переменными. Добавьте конструктор с входными параметрами. Добавьте
       конструктор, инициализирующий члены класса по умолчанию. Добавьте set- и get- методы для полей экземпляра
       класса. */

    public static void main(String[] args) {

        Test2 obj = new Test2(3, 4);

        System.out.println(obj.getI() + " " + obj.getJ());

        obj.setI(5);
        obj.setJ(7);

        System.out.println(obj.getI() + " " + obj.getJ());

    }
    
}

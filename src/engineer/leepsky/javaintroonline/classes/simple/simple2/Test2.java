package engineer.leepsky.javaintroonline.classes.simple.simple2;

public class Test2 {

    /* Создйте класс Test2 двумя переменными. Добавьте конструктор с входными параметрами. Добавьте
       конструктор, инициализирующий члены класса по умолчанию. Добавьте set- и get- методы для полей экземпляра
       класса. */

    int i, j;

    public Test2(int i, int j) {

        this.i = i;
        this.j = j;

    }
 
    public int getI() { return i; }

    public int getJ() { return j; }

    public void setI(int i) { this.i = i; }
    
    public void setJ(int j) { this.j = j; }
    
}

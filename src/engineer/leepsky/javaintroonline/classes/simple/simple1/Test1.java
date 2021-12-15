package engineer.leepsky.javaintroonline.classes.simple.simple1;

public class Test1 {

    /* Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих
       переменных. Добавьте метод, который находит сумму значений этих переменных, и метод, который находит
       наибольшее значение из этих двух переменных. */

    int i, j;

    public void printI() { System.out.println(i); }

    public void printJ() { System.out.println(j); }

    public void setI(int i) { this.i = i; }
    
    public void setJ(int j) { this.j = j; }

    public int sum() { return i + j; }

    public int max() { return i > j ? i : j; }
    
}

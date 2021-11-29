package engineer.leepsky.javaintroonline.algorithmization.decomposition;

public class Decomposition3 {

    /* Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади
       треугольника. */

    public static double regularTriangleArea(int a) {

        return a * a * Math.sqrt(3) / 4;

    }

    public static void main(String[] args) {

        System.out.println(regularTriangleArea(4));

    }
    
}

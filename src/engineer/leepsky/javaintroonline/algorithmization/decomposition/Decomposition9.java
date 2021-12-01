package engineer.leepsky.javaintroonline.algorithmization.decomposition;

public class Decomposition9 {

    /* Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы) вычисления его площади,
       если угол между сторонами длиной X и Y— прямой. */

    public static double findArea(int x, int y, int z, int t) {

        double area = 0.5 * x * y;                      // Найдём площадь прямоугольного треугольника со сторонами X, Y.
        double thirdSide = Math.sqrt(x*x + y*y);        // По теореме Пифагора найдём третью сторону этого треугольника.
        double hp = (z + t + thirdSide) / 2;            // Найдём полупериметр треугольника, составлящего оставшуюся часть четырехугольника.
        area += Math.sqrt(
            hp * (hp - z) * (hp - t) * (hp - thirdSide) // По формуле Герона найдём плошадь этого треугольника.
        );                                              // И добавим её к ранее найденной.

        return area;

    }

    public static void main(String[] args) {

        double area = findArea(6, 6, 6, 6);

        if (Double.isNaN(area)) {

            System.out.println("Такой четырехугольник невозможен.");

        } else {

            System.out.println(area);

        }

    }
    
}

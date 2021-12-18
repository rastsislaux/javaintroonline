package engineer.leepsky.javaintroonline.classes.simple.simple7;

public class Triangle {

    /* Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления
       площади, периметра и точки пересечения медиан. */

    private double aSide, bSide, cSide;

    private Triangle(double a, double b, double c) {
        aSide = a;
        bSide = b;
        cSide = c;
    }

    public double perimeter() {

        return aSide + bSide + cSide;

    }

    public double area() {
        
        double p = perimeter()/2;
        return Math.sqrt(p * (p - aSide) * (p - bSide) * (p - cSide));

    }

    public double medianIntersectionPoint() {

        double m = Math.sqrt(2*cSide*cSide+2*bSide*bSide-aSide*aSide) / 2; // Length of median
        return m / 1.5; // Distance from A point to the median intersection point

    }

    public static Triangle createTriangleByThreeSides(double a, double b, double c) {
        return new Triangle(a, b, c);
    }

    public static Triangle createTriangleByTwoSides(double a, double b, double angle) {
        
        double c = Math.sqrt(a*a + b*b - 2*a*b*Math.cos(angle));
        return new Triangle(a, b, c);
    }


}

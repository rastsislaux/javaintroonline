package engineer.leepsky.javaintroonline.classes.simple.simple7;

public class Simple7 {

    /* Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления
       площади, периметра и точки пересечения медиан. */

    public static void printTriangleInfo(Triangle myTriangle) {

        System.out.println(
            "Area: " + myTriangle.area() +
            ", perimeter: " + myTriangle.perimeter() +
            ", distance from A point to median intersection point: " +
            myTriangle.medianIntersectionPoint()
        );

    }

    public static void main(String[] args) {

        Triangle myTriangle = Triangle.createTriangleByThreeSides(3, 3, 3);
        printTriangleInfo(myTriangle);

        myTriangle = Triangle.createTriangleByTwoSides(3, 3, Math.PI/2);
        printTriangleInfo(myTriangle);

    }
    
}

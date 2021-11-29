package engineer.leepsky.javaintroonline.algorithmization.decomposition;

public class Decomposition4 {
    
    /* На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие, между какими
       из пар точек самое большое расстояние. Указание. Координаты точек занести в массив. */

    public static double[][] mostDistantPoints(double[][] points) {

        double[][] results = new double[2][2];

        double distance = 0;
        
        for (double[] i : points) {

            for (double[] j : points) {

                double temp = Math.sqrt(
                    Math.pow(j[0] - i[0], 2) + Math.pow(j[1] - i[1], 2)
                );

                if (temp > distance) {

                    distance = temp;
                    results[0] = i;
                    results[1] = j;
                    
                }

            }

        }

        return results;

    } 
    
    public static void printPointsArray(double[][] points) {

        for (double[] point : points) {

            System.out.printf("%f, %f\n", point[0], point[1]);

        }

    }

    public static void main(String[] args) {

        double[][] points = new double[5][2];
        
        points[0][0] = 5; points[0][1] = 3;
        points[1][0] = 1; points[1][1] = 6;
        points[2][0] = 4; points[2][1] = 2;
        points[3][0] = 3; points[3][1] = 3;
        points[4][0] = 0; points[4][1] = 5;

        printPointsArray(
            mostDistantPoints(points)
        );

    }

}

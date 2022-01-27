package engineer.leepsky.javaintroonline.classes.aggregation.aggregation2;

/* Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
менять колесо, вывести на консоль марку автомобиля. */

public class Aggregation2 {

    public static void main(String[] args) {

        Automobile BMW;

        try {
            BMW = new Automobile("BMW",
                    new Engine("BMW Engine"),
                    new Wheel[]{
                            new Wheel("BMW Wheel"),
                            new Wheel("BMW Wheel"),
                            new Wheel("BMW Wheel"),
                            new Wheel("BMW Wheel"),
                            new Wheel("Fifth Wheel")
                    });
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        BMW = new Automobile("BMW",
                new Engine("BMW Engine"),
                new Wheel[]{
                        new Wheel("BMW Wheel"),
                        new Wheel("BMW Wheel"),
                        new Wheel("BMW Wheel"),
                        new Wheel("BMW Wheel")
                });

        BMW.fill();
        BMW.drive();
        BMW.drive();
        BMW.changeWheel(1, new Wheel("Audi Wheel"));
        BMW.printBrand();

        try {
            BMW.drive();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

}

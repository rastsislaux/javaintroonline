package engineer.leepsky.javaintroonline.classes.aggregation.aggregation2;

/* Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
менять колесо, вывести на консоль марку автомобиля. */

import java.util.Arrays;

public class Automobile {

    private int fuelLevel = 0;
    private Engine engine;
    private Wheel[] wheels;
    private String brandName;

    Automobile(String brandName, Engine engine, Wheel[] wheels) {

        if (wheels.length != 4) {
            throw new IllegalArgumentException("Wheels array must be of size 4.");
        }

        this.brandName = brandName;
        this.wheels = Arrays.copyOf(wheels, wheels.length);
        this.engine = new Engine(engine);

    }

    void fill() {
        fuelLevel = 100;
    }

    void drive() {
        if (fuelLevel >= 50) {
            fuelLevel -= 50;
        } else {
            throw new RuntimeException("Not enough fuel.");
        }
    }

    void printBrand() {
        System.out.println(brandName);
    }

    void changeWheel(int index, Wheel wheel) {
        wheels[index] = wheel;
    }

}

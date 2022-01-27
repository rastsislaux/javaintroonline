package engineer.leepsky.javaintroonline.classes.aggregation.aggregation2;

/* Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
менять колесо, вывести на консоль марку автомобиля. */

public class Engine {

    private String name;

    public Engine(String name) {
        this.name = name;
    }

    public Engine(Engine original) {
        this.name = original.name;
    }

}

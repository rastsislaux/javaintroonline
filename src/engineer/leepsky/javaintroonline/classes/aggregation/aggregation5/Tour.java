package engineer.leepsky.javaintroonline.classes.aggregation.aggregation5;

/* Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать
возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок. */

public class Tour {

    enum Type {
        CRUISE,
        SHOPPING,
        REST,
        EXCURSION,
        TREATMENT
    }

    enum Transport {
        BUS,
        PLANE,
        NO,
        LINER
    }

    enum Food {
        FULL,
        ONCE,
        TWICE,
        NO
    }

    private Type type;
    private Transport transport;
    private Food food;
    private int length;

    Tour(Type type, Transport transport, Food food, int length) {

        this.type = type;
        this.transport = transport;
        this.food = food;
        this.length = length;

    }

    public Type getType() {
        return type;
    }

    public Food getFood() {
        return food;
    }

    public Transport getTransport() {
        return transport;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "type=" + type +
                ", transport=" + transport +
                ", food=" + food +
                ", length=" + length +
                '}';
    }
}

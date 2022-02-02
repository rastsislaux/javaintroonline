package engineer.leepsky.javaintroonline.oop.oop5;

public class Flower extends CompositionItem {

    Flower(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Flower{name='" + getName() + "'}";
    }

}

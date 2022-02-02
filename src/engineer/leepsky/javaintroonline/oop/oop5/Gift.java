package engineer.leepsky.javaintroonline.oop.oop5;

public class Gift extends CompositionItem {

    Gift(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Gift{name='" + getName() + "'}";
    }

}

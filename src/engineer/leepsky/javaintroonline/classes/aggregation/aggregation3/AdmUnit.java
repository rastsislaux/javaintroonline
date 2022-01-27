package engineer.leepsky.javaintroonline.classes.aggregation.aggregation3;

public class AdmUnit {

    protected String name;
    protected int area = 0;
    protected City capital;

    AdmUnit(String name, City capital) {
        this.name = name;
        this.capital = capital;
    }

    int getArea() { return area; }

    String getCapitalName() { return capital.getName(); }

    String getName() { return name; }

}

package engineer.leepsky.javaintroonline.classes.aggregation.aggregation3;

/* Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль
столицу, количество областей, площадь, областные центры. */

public class Aggregation3 {

    public static void main(String[] args) {

        City London = new City("London");
        City Manchester = new City("Manchester");
        City Edinburgh = new City("Edinburgh");
        City Aberdeen = new City("Aberdeen");

        State UK = new State(
                "United Kingdom",
                new Region[]{
                        new Region("England",
                                new District[]{
                                        new District("Southern England",
                                                new City[]{
                                                        London,
                                                        new City("Canterbury"),
                                                        new City("Plymouth")
                                                },
                                                100,
                                                London),
                                        new District("Nothern England",
                                                new City[]{
                                                        Manchester,
                                                        new City("Liverpool"),
                                                        new City("Leeds")
                                                },
                                                150,
                                                Manchester)
                                },
                                London),
                        new Region("Scotland",
                                new District[]{
                                        new District("Southern Scotland",
                                                new City[]{
                                                        Edinburgh,
                                                        new City("Glasgow"),
                                                        new City("Livingstone")
                                                },
                                                75,
                                                Edinburgh),
                                        new District("Northern Scotland",
                                                new City[]{
                                                        Aberdeen,
                                                        new City("Inverness"),
                                                        new City("Dundee")
                                                },
                                                125,
                                                Aberdeen)
                                },
                                Edinburgh)
                },
                London
        );

        System.out.println(UK.name);
        System.out.println(UK.area);
        UK.printRegionsCount();
        System.out.println(UK.getCapitalName());
        UK.printRegionCapitals();

    }

}

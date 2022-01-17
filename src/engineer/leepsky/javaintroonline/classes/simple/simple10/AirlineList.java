package engineer.leepsky.javaintroonline.classes.simple.simple10;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Iterator;

import engineer.leepsky.javaintroonline.classes.simple.simple6.Time;

public class AirlineList implements Iterable<Airline> {

    /* Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
       и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и
       методами. Задать критерии выбора данных и вывести эти данные на консоль.
       Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
       Найти и вывести:
       a) список рейсов для заданного пункта назначения;
       b) список рейсов для заданного дня недели;
       c) список рейсов для заданного дня недели, время вылета для которых больше заданного. */

    private ArrayList<Airline> airlines = new ArrayList<>();

    public AirlineList() {}

    public AirlineList(AirlineList orig) {
        airlines = new ArrayList<>(orig.airlines);
    }

    public void add(Airline airline) {
        airlines.add(new Airline(airline));
    }

    public Airline get(int i) {
        return airlines.get(i);
    }

    public int size() {
        return airlines.size();
    }

    public AirlineList getFlightsByDestination(String destination) {
        AirlineList result = new AirlineList();
        for (Airline airline : airlines) {
            if (airline.getDestination().equals(destination)) {
                result.add(airline);
            }
        }
        return result;
    }
    
    public AirlineList getFlightsByDay(DayOfWeek day) {
        AirlineList result = new AirlineList();
        for (Airline airline : airlines) {
            if (airline.getDaysOfFlight().contains(day)) {
                result.add(airline);
            }
        }
        return result;
    }
    
    public AirlineList getFlightByTime(Time time) {
        AirlineList result = new AirlineList();
        for (Airline airline : airlines) {
            if (airline.getDepartureTime().toInt() > time.toInt()) {
                result.add(airline);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AirlineList{");
        sb.append("airlines=").append(airlines);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Iterator<Airline> iterator() {
        return airlines.iterator();
    }

}

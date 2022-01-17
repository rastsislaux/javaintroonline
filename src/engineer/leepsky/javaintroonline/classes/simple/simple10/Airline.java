package engineer.leepsky.javaintroonline.classes.simple.simple10;

import java.time.DayOfWeek;
import java.util.ArrayList;

import engineer.leepsky.javaintroonline.classes.simple.simple6.Time;

public class Airline {

    /* Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
       и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и
       методами. Задать критерии выбора данных и вывести эти данные на консоль.
       Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.

       Найти и вывести:
       a) список рейсов для заданного пункта назначения;
       b) список рейсов для заданного дня недели;
       c) список рейсов для заданного дня недели, время вылета для которых больше заданного. */

    private String destination;
    private int flightNumber, planeType;
    private Time departureTime;
    private ArrayList<DayOfWeek> daysOfFlight;

    Airline(String destination, int flightNumber, int planeType, Time departureTime, ArrayList<DayOfWeek> daysOfFlight) {

        this.destination = destination;
        this.flightNumber = flightNumber;
        this.planeType = planeType;
        this.departureTime = new Time(departureTime);
        this.daysOfFlight = new ArrayList<>(daysOfFlight);

    }

    Airline(Airline orig) {

        this.destination = orig.destination;
        this.flightNumber = orig.flightNumber;
        this.planeType = orig.planeType;
        this.departureTime = new Time(orig.departureTime);
        this.daysOfFlight = new ArrayList<>(orig.daysOfFlight);

    }

    public ArrayList<DayOfWeek> getDaysOfFlight() {
        return new ArrayList<>(daysOfFlight);
    }

    public Time getDepartureTime() {
        return new Time(departureTime);
    }

    public String getDestination() {
        return destination;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public int getPlaneType() {
        return planeType;
    }
    
    public void setDestination(String newDestination) {
        this.destination = newDestination;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setDaysOfFlight(ArrayList<DayOfWeek> daysOfFlight) {
        this.daysOfFlight = new ArrayList<>(daysOfFlight);
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = new Time(departureTime);
    }

    public void setPlaneType(int planeType) {
        this.planeType = planeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airline airline = (Airline) o;

        if (flightNumber != airline.flightNumber) return false;
        if (planeType != airline.planeType) return false;
        if (!destination.equals(airline.destination)) return false;
        if (!departureTime.equals(airline.departureTime)) return false;
        return daysOfFlight.equals(airline.daysOfFlight);
    }

    @Override
    public int hashCode() {
        return flightNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Airline{");
        sb.append("destination='").append(destination).append('\'');
        sb.append(", flightNumber=").append(flightNumber);
        sb.append(", planeType=").append(planeType);
        sb.append(", departureTime=").append(departureTime);
        sb.append(", daysOfFlight=").append(daysOfFlight);
        sb.append('}');
        return sb.toString();
    }
}

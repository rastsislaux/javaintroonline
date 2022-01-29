package engineer.leepsky.javaintroonline.classes.aggregation.aggregation5;

/* Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать
возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок. */

import java.util.ArrayList;

public class TourList {

    private final ArrayList<Tour> tourList;

    TourList(ArrayList<Tour> tourArrayList) {

        tourList = new ArrayList<>(tourArrayList);

    }

    public TourList select(Tour.Type type) {

        ArrayList<Tour> list = new ArrayList<>();
        for (Tour tour : tourList) {
            if (tour.getType() == type) {
                list.add(tour);
            }
        }
        return new TourList(list);

    }

    public TourList select(Tour.Food food) {

        ArrayList<Tour> list = new ArrayList<>();
        for (Tour tour : tourList) {
            if (tour.getFood() == food) {
                list.add(tour);
            }
        }
        return new TourList(list);

    }

    public TourList select(Tour.Transport transport) {

        ArrayList<Tour> list = new ArrayList<>();
        for (Tour tour : tourList) {
            if (tour.getTransport() == transport) {
                list.add(tour);
            }
        }
        return new TourList(list);

    }

    public TourList select(int length, boolean bigger) {

        ArrayList<Tour> list = new ArrayList<>();
        for (Tour tour : tourList) {
            if (tour.getLength() > length && bigger) {
                list.add(tour);
            } else if (tour.getLength() < length && !bigger) {
                list.add(tour);
            }
        }
        return new TourList(list);

    }

    public void print() {

        int i = 0;
        for (Tour tour : tourList) {
            System.out.println(++i + ". " + tour);
        }

    }

    public void sortByLength() {

        for (int i = 0; i < tourList.size(); i++) {
            for (int j = i + 1; j < tourList.size(); j++) {

                if (tourList.get(i).getLength() > tourList.get(j).getLength()) {
                    Tour temp = tourList.get(i);
                    tourList.set(i, tourList.get(j));
                    tourList.set(j, temp);
                }

            }
        }

    }

}

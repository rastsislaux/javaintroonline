package engineer.leepsky.javaintroonline.classes.simple.simple8;

public class Simple8 {

    /* Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
       и метод toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
       и методами. Задать критерии выбора данных и вывести эти данные на консоль.
       Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
       Найти и вывести:
       a) список покупателей в алфавитном порядке;
       b) список покупателей, у которых номер кредитной карточки находится в заданном интервале */

    public static void main(String[] args) {

        CustomerList customerList = new CustomerList();

        customerList.add("Firstman", "A.", "A.", "Downing St.", 1, 6);
        customerList.add("Secondman", "B.", "B.", "Upper St.", 2, 7);
        customerList.add("Thirdman", "C.", "C.", "Washington St.", 3, 8);
        customerList.add("Fourthman", "D.", "D.", "Jersey St.", 4, 9);
        customerList.add("Fifthman", "E.", "E.", "4-th Avenue", 5, 10);

        CustomerList alphabetically = customerList.getCustomersAlphabetically();

        System.out.println("Customers in alphabetical order:");
        for (int i = 0; i < alphabetically.size(); i++)
            System.out.println(alphabetically.get(i).toString());

        System.out.println();

        CustomerList cardsInRange = customerList.getCustomersInRange(2, 4);
        System.out.println("Customers with credit cards in range from 2 to 4:");
        for (int i = 0; i < cardsInRange.size(); i++)
            System.out.println(cardsInRange.get(i).toString());


    }
    
}

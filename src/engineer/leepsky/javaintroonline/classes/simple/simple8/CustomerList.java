package engineer.leepsky.javaintroonline.classes.simple.simple8;

import java.util.ArrayList;

public class CustomerList {

    /* Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
    и метод toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
    и методами. Задать критерии выбора данных и вывести эти данные на консоль.
    Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
    Найти и вывести:
    a) список покупателей в алфавитном порядке;
    b) список покупателей, у которых номер кредитной карточки находится в заданном интервале */

    private int lastID;

    private ArrayList<Customer> customers;

    CustomerList() {

        lastID = 0;
        customers = new ArrayList<Customer>();

    }

    public Customer get(int i) { return customers.get(i); }

    public void add(String surname, String name, String patronim, String address, int creditCard, int bankAccount) {

        Customer newCustomer = new Customer(
            ++lastID,
            surname,
            name,
            patronim,
            address,
            creditCard,
            bankAccount
        );

        customers.add(newCustomer);

    }

    public void add(Customer cust) {

        Customer newCustomer = new Customer(
            ++lastID,
            cust.getSurname(),
            cust.getName(),
            cust.getPatronim(),
            cust.getAddress(),
            cust.getCreditCard(),
            cust.getBankAccount()
        );

        customers.add(newCustomer);

    }

    public CustomerList clone() {

        CustomerList clone = new CustomerList();

        for (Customer item : this.customers)
            clone.add(item);

        return clone;

    }

    public int size() {

        return customers.size();

    }

    public CustomerList getCustomersAlphabetically() {

        CustomerList result = this.clone();

        for (int i = 0; i < result.customers.size(); i++)
            for (int j = i + 1; j < result.customers.size(); j++)
                if (result.customers.get(i).toString().compareTo(result.customers.get(j).toString()) > 0) {

                    Customer temp = result.get(i);
                    result.customers.set(i, result.get(j));
                    result.customers.set(j, temp);

                }

        return result;

    }

    public CustomerList getCustomersInRange(int s, int f) {

        CustomerList result = new CustomerList();

        for (int i = 0; i < customers.size(); i++)
            if ( customers.get(i).getCreditCard() >= s && customers.get(i).getCreditCard() <= f )
                result.add(customers.get(i));

        return result;

    }

    
}

package engineer.leepsky.javaintroonline.classes.simple.simple8;

public class Customer {

    /* Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
       и метод toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
       и методами. Задать критерии выбора данных и вывести эти данные на консоль.
       Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
       Найти и вывести:
       a) список покупателей в алфавитном порядке;
       b) список покупателей, у которых номер кредитной карточки находится в заданном интервале */
    
    private int id, creditCard, bankAccount;
    private String surname, name, patronim, address;

    Customer(int id, String surname, String name, String patronim, String address, int creditCard, int bankAccount) {

        this.id             =   id;
        this.surname        =   surname;
        this.name           =   name;
        this.patronim       =   patronim;
        this.address        =   address;
        this.creditCard     =   creditCard;
        this.bankAccount    =   bankAccount;

    }

    // Getters
            
    public int getID() { return id; }

    public int getCreditCard() { return creditCard; }

    public int getBankAccount() { return bankAccount; }

    public String getSurname() { return surname; }

    public String getName() { return name; }

    public String getPatronim() { return patronim; }

    public String getAddress() { return address; }

    // Setters

    public void setID(int id) { this.id = id; }

    public void setCreditCard(int cc) { this.creditCard = cc; }

    public void setBankAccount(int ba) { this.bankAccount = ba; }

    public void setSurname(String s) { this.surname = s; }
    
    public void setName(String n) { this.name = n; }

    public void setPatronim(String p) { this.patronim = p; }

    public void setAddress(String a) { this.address = a; }

    // toString

    @Override
    public String toString() { return String.format("%s %s %s", surname, name, patronim); }

    @Override
    public boolean equals(Object o) {

        if (o == this)
            return true;

        if (o == null || o.getClass() != this.getClass())
            return false;

        Customer customer = (Customer)o;
        return
            this.name       ==  customer.name       &&
            this.surname    ==  customer.surname    &&
            this.patronim   ==  customer.patronim   &&
            this.address    ==  customer.address;

    }

    @Override
    public int hashCode() {

        final int prime = 31;

        int result = 1;

        result *= prime * ((this.name       == null) ? 0 : this.name.hashCode());
        result *= prime * ((this.surname    == null) ? 0 : this.surname.hashCode());
        result *= prime * ((this.patronim   == null) ? 0 : this.patronim.hashCode());
        result *= prime * ((this.address    == null) ? 0 : this.address.hashCode());

        return result;

    }

}

package engineer.leepsky.javaintroonline.oop.oop2;

public class PaymentApp {

    /* Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
       нескольких товаров. */

    public static void main(String[] args) {

        Payment myPayment = new Payment(
                new Payment.Entry("Some product", 100),
                new Payment.Entry("Other product", 200),
                new Payment.Entry("Third product", 300)
        );

        myPayment.printCheck();

    }

}

package engineer.leepsky.javaintroonline.oop.oop5;

/* Создать консольное приложение, удовлетворяющее следующим требованиям:
• Корректно спроектируйте и реализуйте предметную область задачи.
• Для создания объектов из иерархии классов продумайте возможность использования порождающих шаблонов
проектирования.
• Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента.
• для проверки корректности переданных данных можно применить регулярные выражения.
• Меню выбора действия пользователем можно не реализовывать, используйте заглушку.
• Особое условие: переопределите, где необходимо, методы toString(), equals() и hashCode().
Вариант A. Цветочная композиция. Реализовать приложение, позволяющее создавать цветочные композиции
(объект, представляющий собой цветочную композицию). Составляющими цветочной композиции являются цветы
и упаковка.
Вариант B. Подарки. Реализовать приложение, позволяющее создавать подарки (объект, представляющий собой
подарок). Составляющими целого подарка являются сладости и упаковка. */

public class ExampleApp {

    public static void main(String[] args) {

        Compositor<Flower> flowerCompositor = new Compositor<>();

        flowerCompositor.setWrapping(Composition.Wrapping.PAPER);

        flowerCompositor.add(new Flower("Rose"));
        flowerCompositor.add(new Flower("Sunflower"));
        flowerCompositor.add(new Flower("Begonia"));
        flowerCompositor.add(new Flower("Bellflower"));
        flowerCompositor.add(new Flower("Daisy"));

        try {
            flowerCompositor.add(new Flower("Carnation99"));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        Composition<Flower> flowerComposition = flowerCompositor.getResult();
        System.out.println(flowerComposition);

        Compositor<Gift> giftCompositor = new Compositor<>();

        giftCompositor.setWrapping(Composition.Wrapping.BOX);

        giftCompositor.add(new Gift("Camera"));
        giftCompositor.add(new Gift("Bicycle"));
        giftCompositor.add(new Gift("Smartphone"));
        giftCompositor.add(new Gift("Hoodie"));
        giftCompositor.add(new Gift("Money"));


        try {
            giftCompositor.add(new Gift("9034ufhi84"));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        Composition<Gift> giftComposition = giftCompositor.getResult();
        System.out.println(giftComposition);

    }

}

package engineer.leepsky.javaintroonline.classes.aggregation.aggregation1;

/* Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на
    консоль текст, заголовок текста. */

public class Aggregation1 {

    public static void main(String[] args) {

        Text myText = new Text(
                "Lorem Ipsum Dolor Sit Amet",
                new Sentence(
                        '!',
                        new Word("Lorem"),
                        new Word("Ipsum"),
                        new Word("Dolor"),
                        new Word("Sit"),
                        new Word("Amet"),
                        new Word("d*475") // This one will be ignored.
                ),
                new Sentence(
                        '.',
                        new Word("Amet"),
                        new Word("Sit"),
                        new Word("Dolor"),
                        new Word("Ipsum"),
                        new Word("Lorem")
                )
        );

        System.out.println(myText.title);
        System.out.println(myText);

        myText.add(
                new Sentence(
                        '?',
                        new Word("To"),
                        new Word("be"),
                        new Word("or"),
                        new Word("not"),
                        new Word("to"),
                        new Word("be")
                )
        );

        System.out.println("After editing:");
        System.out.println(myText);

    }

}

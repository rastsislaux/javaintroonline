package engineer.leepsky.javaintroonline.classes.aggregation.aggregation1;

/* Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на
    консоль текст, заголовок текста. */

public class Word {

    private String word;

    public Word(String word) {

        if (set(word)) return;
        this.word = "";

    }

    public String get() { return word; }

    public boolean set(String word) {

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) < 'A' || word.charAt(i) > 'z')
                return false;
        }
        this.word = word;
        return true;

    }

    @Override
    public String toString() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return word.equals(word1.word);
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }
}

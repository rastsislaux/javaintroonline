package engineer.leepsky.javaintroonline.classes.aggregation.aggregation1;

import java.util.ArrayList;

/* Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на
    консоль текст, заголовок текста. */

public class Sentence {

    final private char endSign;
    final private ArrayList<Word> words = new ArrayList<>();

    public Sentence(char endSign, Word... words) {
        for (Word word : words) {
            add(word);
        }
        this.endSign = endSign;
    }

    public void add(Word word) {
        if (!word.get().equals("")) words.add(word);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (Word word : words) {
            sb.append(word).append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(endSign);

        return sb.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        return endSign == sentence.endSign && words.equals(sentence.words);
    }

    @Override
    public int hashCode() {
        return 17 * endSign * words.hashCode();
    }
}
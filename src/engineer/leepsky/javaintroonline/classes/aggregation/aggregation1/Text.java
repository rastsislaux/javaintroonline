package engineer.leepsky.javaintroonline.classes.aggregation.aggregation1;

/* Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на
    консоль текст, заголовок текста. */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Text {

    final public String title;
    final private ArrayList<Sentence> sentences = new ArrayList<>();

    public Text(String title, Sentence... sentences) {
        this.title = title;
        Collections.addAll(this.sentences, sentences);
    }

    public void add(Sentence sentence) {
        sentences.add(sentence);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            sb.append(sentence).append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();

    }
}

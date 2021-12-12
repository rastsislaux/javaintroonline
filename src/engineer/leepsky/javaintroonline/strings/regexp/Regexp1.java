package engineer.leepsky.javaintroonline.strings.regexp;

import java.util.regex.Pattern;

public class Regexp1 {

    /* Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных
       операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
       отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по
       алфавиту. */

    public static String concatenateStringArray(String[] array, String delim) {

        StringBuilder result = new StringBuilder();

        for (String str : array)
            result.append(str + delim);

        return result.toString();

    }

    public static void swap(String[] array, int i, int j) {

        String temp = array[i];
        array[i] = array[j];
        array[j] = temp; 

    }

    public static long countSymbols(String str, char ch) {

        return Pattern
                    .compile(ch + "")
                    .matcher(str)
                    .results()
                    .count();

    }

    public static String sortParagraphs(String str) {

        String[] paragraphs = str.split("\\n");

        for (int i = 0; i < paragraphs.length; i++)
            for (int j = i + 1; j < paragraphs.length; j++)
                if (paragraphs[i].split("\\s+").length < paragraphs[j].split("\\s+").length)
                    swap(paragraphs, i, j);

        return concatenateStringArray(paragraphs, "\n");

    }

    public static String sortWordsInSentence(String sentence) {

        String[] words = sentence.split("\\s+");

        for (int i = 0; i < words.length; i++)
            for (int j = i + 1; j < words.length; j++)
                if (words[i].length() > words[j].length())
                    swap(words, i, j);

        StringBuilder result = new StringBuilder(concatenateStringArray(words, " "));
        result.deleteCharAt(result.length() - 1);

        return result.toString();

    }

    public static String sortWordsInSentenceBySymbol(String sentence, char ch) {

        String[] words = sentence.split("\\s+");

        for (int i = 0; i < words.length; i++)
            for (int j = i + 1; j < words.length; j++) {

                    long count_i = countSymbols(words[i], ch),
                         count_j = countSymbols(words[j], ch);

                    if (count_i == count_j) {
                        if (words[i].compareTo(words[j]) > 0)
                            swap(words, i, j);
                    } else if (count_i < count_j)
                        swap(words, i, j);

            }

        StringBuilder result = new StringBuilder(concatenateStringArray(words, " "));
        result.deleteCharAt(result.length() - 1);

        return result.toString();

    }

    public static String sortWords(String str) {

        String[] paragraphs = str.split("\\n");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < paragraphs.length; i++) {

            String[] sentences = paragraphs[i].split("\\.|\\!|\\?");

            for (int j = 0; j < sentences.length; j++)
                sentences[j] = sortWordsInSentence(sentences[j]);

            result.append(
                concatenateStringArray(sentences, ".")
            );

            result.append("\n");

        }

        return result.toString();

    }

    public static String sortWordsBySymbol(String str, char ch) {

        String[] paragraphs = str.split("\\n");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < paragraphs.length; i++) {

            String[] sentences = paragraphs[i].split("\\.|\\!|\\?");

            for (int j = 0; j < sentences.length; j++)
                sentences[j] = sortWordsInSentenceBySymbol(sentences[j], ch);

            result.append(
                concatenateStringArray(sentences, ".")
            );

            result.append("\n");

        }

        return result.toString();

    }

    public static void main(String[] args) {

        String str = "Эта строка содержит текст. В тексте несколько абзацев. В каждом абзаце есть предложения.\n" +
                     "Здесь начинается второй абзац. Весь этот текст нужен для того чтобы программа выполнила несколько действий.\n" +
                     "Выполняются следующие действия. Сортировка абзацев по количеству предложений. Помимо неё есть сортировка слов в предложении " +
                     "по их длине или алфавиту в случае одинаковой длины.";

        System.out.println(
            sortParagraphs(str)
        );

        System.out.println(
            sortWords(str)
        );

        System.out.println(
            sortWordsBySymbol(str, 'о')
        );

    }
    
}

package engineer.leepsky.javaintroonline.strings.regexp;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regexp2 {

    /* Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип (открывающий
       тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML для решения данной задачи
       нельзя. */

    public static String analyzeXML(String xml) {

        Pattern fullTag = Pattern.compile("<([^\\ /<>]+)([^<>]*)>(.*?)<(\\/\\1)>");

        Matcher fullTagMatcher = fullTag.matcher(xml);

        StringBuilder result = new StringBuilder();

        while ( fullTagMatcher.find() ) {

            result.append("Tag:\n\t<");
            result.append(fullTagMatcher.group(1));
            result.append(fullTagMatcher.group(2));
            result.append(">");
            result.append(fullTagMatcher.group(3));
            result.append("<");
            result.append(fullTagMatcher.group(4));
            result.append(">");
            result.append("\n\tOpening tag: <");
            result.append(fullTagMatcher.group(1));
            result.append(fullTagMatcher.group(2));
            result.append(">\n\tInner text: ");
            result.append(fullTagMatcher.group(3));
            result.append("\n\tClosing tag: <");
            result.append(fullTagMatcher.group(4));
            result.append(">\n");

            result.append(
                analyzeXML(fullTagMatcher.group(3))
            );

        }

        return result.toString();

    }

    public static void main(String[] args) {

        String xml = "<notes><note id = \"1\"><to>Вася</to><from>Света</from><heading>Напоминание</heading><body>Позвони мне завтра!</body></note><note id = \"2\"><to>Петя</to><from>Маша</from><heading>Важное напоминание</heading><body/></note></notes>";

        System.out.println(
            analyzeXML(xml)
        );

    }
    
}

package engineer.leepsky.javaintroonline.strings.regexp;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regexp2 {

    /* Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип (открывающий
       тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML для решения данной задачи
       нельзя. */

    public static String analyzeXML(String xml) {

        Pattern fullTag = Pattern.compile("<([^\\ /<>]+)([^<>]*)>(.*?)<(\\/\\1)>|<([^\\ /<>]+)([^<>]*)/>");
        Matcher fullTagMatcher = fullTag.matcher(xml);

        StringBuilder result = new StringBuilder();

        while ( fullTagMatcher.find() ) {

            if ( fullTagMatcher.group(3) != null ) {

                result.append("Tag:\n\t")
                    .append(fullTagMatcher.group(0))
                    .append("\n\tOpening tag: <")
                    .append(fullTagMatcher.group(1))
                    .append(fullTagMatcher.group(2))
                    .append(">\n\tInner text: ")
                    .append(fullTagMatcher.group(3))
                    .append("\n\tClosing tag: <")
                    .append(fullTagMatcher.group(4))
                    .append(">\n")
                    .append(analyzeXML(fullTagMatcher.group(3)));

            } else {

                result.append("Tag:\n\t")
                      .append(fullTagMatcher.group(0))
                      .append("\n\tTag with no body.");

            }

        }

        return result.toString();

    }

    public static void main(String[] args) {

        String xml = "<notes><note id = \"1\"><to>Вася</to><from>Света</from><heading>Напоминание</heading><body>Позвони мне завтра!</body></note>" +
                     "<note id = \"2\"><to>Петя</to><from>Маша</from><heading>Важное напоминание</heading><body/></note></notes>";

        System.out.println(
            analyzeXML(xml)
        );

    }
    
}

package engineer.leepsky.javaintroonline.strings.string;

public class String7 {
    
    /* Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено "abc cde
       def", то должно быть выведено "abcdef". */

    public static String removeRepeatingSymbols(String s) {

        StringBuilder bld = new StringBuilder();

        for (int i = 0; i < s.length(); i++)
            if ( bld.indexOf(s.charAt(i) + "") == -1 && s.charAt(i) != ' ' ) bld.append(s.charAt(i));

        return bld.toString();
            
    }

    public static void main(String[] args) {

        String str = "abc cde def";

        System.out.println(
            removeRepeatingSymbols(str)
        );
                
    }

}

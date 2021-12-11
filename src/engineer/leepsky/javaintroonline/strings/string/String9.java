package engineer.leepsky.javaintroonline.strings.string;

public class String9 {

    /* Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. Учитывать только английские
       буквы. */

    public static int getUpperCaseCount(String str) {

        int count = 0;

        for (char x : str.toCharArray())
            if (x >= 'A' && x <= 'Z') count++;

        return count;

    }

    public static int getLowerCaseCount(String str) {

        int count = 0;

        for (char x : str.toCharArray())
            if (x >= 'a' && x <= 'z') count++;

        return count;

    }

    public static void main(String[] args) {

        String str = "This StRiNg HaS aLmOsT eQuAl AmOuNt Of LowErCaSe AnD uPpErCaSe SyMbOlS";

        System.out.println(
            getLowerCaseCount(str) + " " + getUpperCaseCount(str)  
        );

    }
    
}

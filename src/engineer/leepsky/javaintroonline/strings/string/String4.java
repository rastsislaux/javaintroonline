package engineer.leepsky.javaintroonline.strings.string;

public class String4 {
    
    /* С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”. */

    public static String returnTort() {

        String inf = "информатика";

        StringBuilder bld = new StringBuilder();

        bld
            .append(inf.charAt(7))
            .append(inf.substring(3, 5))
            .append(inf.charAt(7));

        return bld.toString();

    }

    public static void main(String[] args) {

        System.out.println(
            returnTort()
        );

    }

}

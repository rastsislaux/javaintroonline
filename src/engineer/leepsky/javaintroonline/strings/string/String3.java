package engineer.leepsky.javaintroonline.strings.string;

public class String3 {

    /* Проверить, является ли заданное слово палиндромом. */

    public static boolean isPalindrome(String s) {

        for (int i = 0, j = s.length() - 1; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j)) return false;

        return true;

    }

    public static void main(String[] args) {

        String palindrome       =   "SAIPPUAKIVIKAUPPIAS";
        String not_a_palindrome =   "NOTAPALINDROME";

        System.out.println(
            isPalindrome(palindrome) + " " + isPalindrome(not_a_palindrome)
        );

    }
    
}

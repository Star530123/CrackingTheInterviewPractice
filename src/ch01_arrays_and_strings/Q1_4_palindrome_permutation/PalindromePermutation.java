package ch01_arrays_and_strings.Q1_4_palindrome_permutation;

/**
 * @author StarL
 */
public class PalindromePermutation {

    /**
     * String s may contain characters not in [a-zA-z], but ignore them.
     * That is we just consider the case-insensitive english characters whether they are palindrome's permutation.
     * Time complexity is O(n), Space complexity is O(1), where n = s.length()
     */
    public static boolean isPalindromePermutation(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            int index = getCharValueWithoutCase(c);
            if (index == -1) continue;
            arr[index]++;
        }
        boolean hasOddChar = false;
        for (int i: arr) {
            if (i % 2 != 0) {
                if (hasOddChar) return false;
                hasOddChar = true;
            }
        }
        return true;
    }

    private static int getCharValueWithoutCase(char c) {
        int lowercase = c - 'a';
        int uppercase = c - 'A';
        if (0 <= lowercase && lowercase < 26) return lowercase;
        else if (0 <= uppercase && uppercase < 26) return uppercase;
        return -1;
    }

    public static void main(String[] args) {
        String[] strings = {"Rats live on no evil star",
                "A man, a plan, a canal, panama",
                "Lleve",
                "Tacotac",
                "asda"};
        for (String s: strings) {
            System.out.println(s + ":" +isPalindromePermutation(s));
        }
    }
}

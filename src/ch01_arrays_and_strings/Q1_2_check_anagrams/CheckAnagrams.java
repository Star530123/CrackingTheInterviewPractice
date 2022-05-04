package ch01_arrays_and_strings.Q1_2_check_anagrams;

import static util.ValidateUtil.validate;

/**
 * @author StarL
 */
public class CheckAnagrams {

    /**
     * Assume both a and b are composed of ascii code
     */
    public static boolean checkAnagrams(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) return false;
        int[] arr = new int[128];
        for (char c: a.toCharArray()) {
            arr[c]++;
        }
        for (char c: b.toCharArray()) {
            if (--arr[c] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        validate(checkAnagrams("", ""), true);
        validate(checkAnagrams("a", ""), false);
        validate(checkAnagrams("", "a"), false);
        validate(checkAnagrams("abac", "baca"), true);
        validate(checkAnagrams("/c/c/c/a", "///cccb"), false);
        validate(checkAnagrams("/c/c/c/a", "///ccca"), false);
        validate(checkAnagrams("/c/c/c/a", "////ccca"), true);

    }
}

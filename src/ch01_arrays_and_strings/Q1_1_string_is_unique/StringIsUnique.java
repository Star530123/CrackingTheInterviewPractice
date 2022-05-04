package ch01_arrays_and_strings.Q1_1_string_is_unique;

import static util.ValidateUtil.validate;

/**
 * @author StarL
 */
public class StringIsUnique {

    /**
     * Assume the characters in String s are ascii code (value in integer range [0...127])
     * 1. Time complexity is O(n), Space complexity is O(1)
     */
    public static boolean isUnique(String s) {
        if (s == null || s.length() <= 1) return true;
        if (s.length() > 128) return false;
        boolean[] arr = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i)]) return false;
            arr[s.charAt(i)] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        validate(isUnique(""), true);
        validate(isUnique(null), true);
        validate(isUnique("abc"), true);
        validate(isUnique("aba"), false);
    }


}

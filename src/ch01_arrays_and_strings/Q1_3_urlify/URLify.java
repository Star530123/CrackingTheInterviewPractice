package ch01_arrays_and_strings.Q1_3_urlify;

import java.util.Arrays;

import static util.ValidateUtil.validate;

/**
 * @author StarL
 */
public class URLify {

    /**
     * time complexity is O(n), space complexity is O(n), where n = s.length()
     */
    public static String urlify(String s, int realLength) {
        if (s == null || s.length() == 0) return s;
        char[] arr = s.toCharArray();
        int newIndex = s.length() - 1;
        for (int i = realLength - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                arr[newIndex--] = '0';
                arr[newIndex--] = '2';
                arr[newIndex--] = '%';
            }else {
                arr[newIndex--] = arr[i];
            }
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        validate(urlify("Mr John Smith    ", 13), "Mr%20John%20Smith");
        validate(urlify("      ", 2), "%20%20");
        validate(urlify("", 0), "");
        validate(urlify("abc", 3), "abc");
        validate(urlify("abc   ", 4), "abc%20");
        validate(urlify("  a bc      ", 6), "%20%20a%20bc");
    }
}

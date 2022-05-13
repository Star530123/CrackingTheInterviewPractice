package ch01_arrays_and_strings.Q1_6_string_compression;

import com.sun.xml.internal.bind.v2.model.core.ID;

import static util.ValidateUtil.validate;

/**
 * @author StarL
 */
public class StringCompress {

    /**
     *  Time Complexity is O(n), Space Complexity is O(n), where n = s.length()
     */
    public static String compress(String s) {
        if (s.length() < 3) return s;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count++;
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                sb.append(s.charAt(i));
                sb.append(count);
                count = 0;
                if (sb.length() >= s.length()) return s;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        validate(compress("aabcccccaaa"), "a2b1c5a3");
        validate(compress(""), "");
        validate(compress("abcdefg"), "abcdefg");
        validate(compress("aa"),"aa");
        validate(compress("aaaabaaaa"), "a4b1a4");

    }
}

package ch01_arrays_and_strings.Q1_5_one_away;

import static util.ValidateUtil.validate;

/**
 * @author StarL
 */
public class OneEditAway {

    /*
    First we need to check if both strings are null or not.

    Next we can check strings' length.
    If the length difference is greater than 1, means that there are at least 2 edit steps, so return false.

    After ensure Math.abs(a.length(), b.length()) = 1, there is a trick way.
    If b.length > a.length, swap their order and call this method again.
    So we can ensure later process will be a.length >= b.length.
    That means we just consider the situation of replace and delete.

    Then start to check every character in a and b.
    Set a variable isEdit to maintain the status.
    If the characters in a and b is not equal, we need to know which situation it is.
    If a.length != b.length -> delete, so we move a's index(+1) ; a.length == b.length -> replace, skip
     */
    public static boolean isOneEditAway(String a, String b) {
        if (a == null && b == null) return true;
        else if (a == null) return isOneEditAway(b, null);
        else if (b == null) return a.length() == 1;
        if (Math.abs(a.length() - b.length()) > 1) return false;
        else if (a.length() < b.length()) return isOneEditAway(b, a);
        boolean isEdit = false;
        for (int i = 0, j = 0; i < a.length() && j < b.length(); i++, j++) {
            if (a.charAt(i) == b.charAt(j)) continue;
            if (isEdit) return false;
            isEdit = true;
            if (a.length() != b.length()) i++;
        }
        return true;

    }

    public static void main(String[] args) {
        validate(isOneEditAway("pale","ple"), true);
        validate(isOneEditAway("pale","pale"), true);
        validate(isOneEditAway("pales", "pale"), true);
        validate(isOneEditAway("pale", "bale"), true);
        validate(isOneEditAway("pale", "bake"), false);
        validate(isOneEditAway(null, "a"), true);
        validate(isOneEditAway("", "a"), true);
        validate(isOneEditAway("a", null), true);
        validate(isOneEditAway("a", ""), true);
        validate(isOneEditAway("pale","plae"), false);
        validate(isOneEditAway("pale","plle"), true);
        validate(isOneEditAway("palse", "pale"), true);
    }
}

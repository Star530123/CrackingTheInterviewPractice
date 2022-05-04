package util;

import java.util.Objects;

/**
 * @author StarL
 */
public class ValidateUtil {
    public static void validate(boolean result, boolean expectation) {
        System.out.println(result == expectation);
    }

    public static void validate(String result, String expectation) {
        System.out.println(Objects.equals(result, expectation));
    }
}

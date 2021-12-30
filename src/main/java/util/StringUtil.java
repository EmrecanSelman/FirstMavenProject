package util;

public class StringUtil {
    /**
     * Return true if the specified String is empty.
     *
     * @param trim trim the String before doing the empty test
     */
    public static boolean isEmpty(String value, boolean trim) {
        if (value != null) {
            if (trim)
                return value.trim().length() == 0;

            return value.length() == 0;
        }

        return true;
    }

    /**
     * Return true if the specified String is empty.
     * The String is trimed by default before doing the test
     */
    public static boolean isEmpty(String value) {
        return isEmpty(value, true);
    }

}






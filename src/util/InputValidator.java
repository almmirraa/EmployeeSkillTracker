package util;

public class InputValidator {

    public static boolean isValidString(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {
        return email != null &&
                !email.trim().isEmpty() &&
                email.contains("@") &&
                email.contains(".");
    }

    public static boolean isValidLevel(int level) {
        return level >= 1 && level <= 10;
    }

    public static boolean isValidId(int id) {
        return id > 0;
    }
}

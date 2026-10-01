package luhn;

public class Luhn {
    public static boolean isValid(String potentialLuhnNumber) {
        return hasAValidFormat(potentialLuhnNumber);
    }

    private static boolean hasAValidFormat(String potentialLuhnNumber) {
        return potentialLuhnNumber != null
                && !potentialLuhnNumber.isBlank()
                && potentialLuhnNumber.length() > 1;
    }
}

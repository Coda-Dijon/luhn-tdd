package luhn;

public class Luhn {
    public static boolean isValid(String potentialLuhnNumber) {
        return hasAValidFormat(potentialLuhnNumber)
                && checkNumber(potentialLuhnNumber);
    }

    private static boolean checkNumber(String potentialLuhnNumber) {
        return potentialLuhnNumber.chars()
                .map(c -> c - '0')
                .sum() % 10 == 0;
    }

    private static boolean hasAValidFormat(String potentialLuhnNumber) {
        return potentialLuhnNumber != null
                && !potentialLuhnNumber.isBlank()
                && potentialLuhnNumber.length() > 1;
    }
}

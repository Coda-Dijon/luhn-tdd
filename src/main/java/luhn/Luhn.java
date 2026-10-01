package luhn;

public class Luhn {
    public static boolean isValid(String potentialLuhnNumber) {
        return potentialLuhnNumber != null && !potentialLuhnNumber.isEmpty();
    }
}

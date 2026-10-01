package luhn;

import java.util.stream.IntStream;

public class Luhn {
    public static boolean isValid(String potentialLuhnNumber) {
        return hasAValidFormat(potentialLuhnNumber)
                && checkNumber(potentialLuhnNumber);
    }

    private static boolean hasAValidFormat(String potentialLuhnNumber) {
        return potentialLuhnNumber != null
                && !potentialLuhnNumber.isBlank()
                && potentialLuhnNumber.length() > 1;
    }

    private static boolean checkNumber(String potentialLuhnNumber) {
        var digits = new StringBuilder(potentialLuhnNumber).reverse()
                .chars()
                .map(c -> c - '0')
                .toArray();

        return IntStream
                .range(0, digits.length)
                .map(i -> i % 2 == 1 ? doubled(digits[i]) : digits[i])
                .sum() % 10 == 0;
    }

    private static int doubled(int digit) {
        var result = digit * 2;
        return result > 9 ? result - 9 : result;
    }
}

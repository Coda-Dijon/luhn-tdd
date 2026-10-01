package luhn.parse.dont.validate;

import io.vavr.control.Either;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

public class LuhnNumber {
    private static final Pattern regexp = Pattern.compile("^[0-9]+$");
    private final String luhnNumber;

    private LuhnNumber(String luhnNumber) {
        this.luhnNumber = luhnNumber;
    }

    public static Either<LuhnError, LuhnNumber> parse(String potentialLuhnNumber) {
        return isAValidNumber(potentialLuhnNumber)
                ? right(new LuhnNumber(potentialLuhnNumber))
                : left(new LuhnError("Invalid Luhn Number"));
    }

    private static boolean isAValidNumber(String potentialLuhnNumber) {
        return hasAValidFormat(potentialLuhnNumber)
                && checkNumber(sanitize(potentialLuhnNumber));
    }

    private static boolean hasAValidFormat(String potentialLuhnNumber) {
        return potentialLuhnNumber != null
                && regexp.matcher(sanitize(potentialLuhnNumber)).find();
    }

    private static boolean checkNumber(String potentialLuhnNumber) {
        return isMultipleOf10(
                sumDigits(
                        toDigits(potentialLuhnNumber)
                ));
    }

    private static int sumDigits(int[] digits) {
        return IntStream
                .range(0, digits.length)
                .map(i -> i % 2 == 1 ? doubled(digits[i]) : digits[i])
                .sum();
    }

    private static int[] toDigits(String potentialLuhnNumber) {
        return new StringBuilder(potentialLuhnNumber).reverse()
                .chars()
                .map(c -> c - '0')
                .toArray();
    }

    private static int doubled(int digit) {
        var result = digit * 2;
        return result > 9 ? result - 9 : result;
    }

    private static boolean isMultipleOf10(int sum) {
        return sum % 10 == 0;
    }

    private static String sanitize(String potentialLuhnNumber) {
        return potentialLuhnNumber.replace(" ", "");
    }

    public String value() {
        return this.luhnNumber;
    }
}

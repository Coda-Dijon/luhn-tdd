package luhn;

import io.vavr.control.Either;

public class LuhnParser {
    public static Either<LuhnError, LuhnNumber> parse(String potentialLuhnNumber) {
        return Either.left(
                new LuhnError("Invalid Luhn Number")
        );
    }
}
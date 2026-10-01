package luhn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Algo de Luhn")
class LuhnTest {
    public static Stream<Arguments> invalidTestCases() {
        return Stream.of(
                Arguments.of((Object) null),
                Arguments.of(""),
                Arguments.of("9"),
                Arguments.of("10")
        );
    }

    public static Stream<Arguments> validTestCases() {
        return Stream.of(
                Arguments.of("00"),
                Arguments.of("18"),
                Arguments.of("5555 5555 5555 4444"),
                Arguments.of("79927398713"),
                Arguments.of("6011 1111 1111 1117")
        );
    }

    @ParameterizedTest
    @MethodSource("invalidTestCases")
    void fail_for(String invalidLuhnNumber) {
        assertThat(Luhn.isValid(invalidLuhnNumber))
                .isFalse();
    }

    @ParameterizedTest
    @MethodSource("validTestCases")
    void succeed_for(String validLuhnNumber) {
        assertThat(Luhn.isValid(validLuhnNumber))
                .isTrue();
    }
}

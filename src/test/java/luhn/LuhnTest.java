package luhn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @ParameterizedTest
    @MethodSource("invalidTestCases")
    void fail_for_null(String invalidLuhnNumber) {
        assertThat(Luhn.isValid(invalidLuhnNumber))
                .isFalse();
    }

    @Test
    void succeed_for() {
        assertThat(Luhn.isValid("00"))
                .isTrue();
    }
}

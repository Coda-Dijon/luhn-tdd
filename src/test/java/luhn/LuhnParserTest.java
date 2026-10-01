package luhn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.vavr.api.VavrAssertions.assertThat;

@DisplayName("Algo de Luhn")
class LuhnParserTest {
    public static Stream<Arguments> invalidTestCases() {
        return Stream.of(
                Arguments.of((Object) null)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidTestCases")
    void fail_for(String invalidLuhnNumber) {
        assertThat(LuhnParser.parse(invalidLuhnNumber))
                .containsOnLeft(new LuhnError("Invalid Luhn Number"));
    }
}

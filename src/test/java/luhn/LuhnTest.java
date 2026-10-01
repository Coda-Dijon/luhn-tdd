package luhn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Algo de Luhn")
class LuhnTest {
    @Test
    void fail_for_null() {
        assertThat(Luhn.isValid(null))
                .isFalse();
    }
}

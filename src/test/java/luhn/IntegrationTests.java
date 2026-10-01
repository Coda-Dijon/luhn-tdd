package luhn;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTests {
    @Test
    void succeed_for_master_card() {
        assertThat(
                Luhn.isValid("5555 5555 5555 4444")
        ).isTrue();
    }
}

import firststep.StringPlusCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    private final StringPlusCalculator calculator = new StringPlusCalculator();

    private static void assertActual(int actual, int expected) {
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("계산기의 입력값이 null 또는 빈문자가 들어오면 0을 리턴한다.")
    void calculator_insert_null_or_empty_is_zero() {
        int actual = calculator.calculator("");
        int expected = 0;
        assertActual(actual, expected);

        actual = calculator.calculator(null);
        assertActual(actual, expected);
    }

    @Test
    @DisplayName("계산기의 입력값이 숫자하나만 들어온다")
    void calculator_insert_only_one_number() {
        int actual = calculator.calculator("1");
        int expected = 1;
        assertActual(actual, expected);
    }

}

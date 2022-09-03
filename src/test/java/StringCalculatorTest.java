import firststep.StringPlusCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    private final StringPlusCalculator calculator = new StringPlusCalculator();

    @Test
    @DisplayName("계산기 입력값에 null 또는 빈 값이 들어오면 0을 반환한다")
    void calculator_insert_null_or_empty_return_zero() {
        int result = calculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = calculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("계산기 입력값에 숫자하나만 입력이 될 경우")
    void calculator_only_one_number() {
        int result = calculator.splitAndSum("1");

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("계산기 입력값에 쉼표구분자로 덧셈 한다")
    void calculator_comma_separator_sum() {
        int actual = calculator.splitAndSum("1,2");

        assertThat(actual).isEqualTo(3);
    }

    @Test
    @DisplayName("계산기 입력값에 쉼표 또는 콜론 구분자로 덧셈한다")
    void calculator_comma_or_colon_separator_sum() {
        int actual = calculator.splitAndSum("1,2:3");

        assertThat(actual).isEqualTo(6);
    }

    @Test
    @DisplayName("계산기 입력 값에 커스텀 구분자로 덧셈한다")
    void calculator_custom_separator_insert_is_sum() {
        int actual = calculator.splitAndSum("//;\n1;2;3");

        assertThat(actual).isEqualTo(6);
    }
    @Test
    @DisplayName("음수가 입력되면 예외가 발생한다")
    void throw_exception_native_number_insert() {
        assertThatThrownBy(()->calculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수가 발생하면 안됩니다");
    }
}

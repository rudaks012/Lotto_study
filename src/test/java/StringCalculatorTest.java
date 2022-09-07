import firststep.StringPlusCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    private final StringPlusCalculator calculator = new StringPlusCalculator();
    private int actual;
    private int excepted;

    @DisplayName("계산기 입력값에 null 또는 음수가 들어오면 0을 반환한다")
    @ParameterizedTest(name = "계산기 입력값에 null 또는 음수가 들어오면 0을 반환한다")
    @NullAndEmptySource
    void calculator_insert_null_or_empty_return_zero(String input) {
        actual = calculator.splitAndSum(input);

        excepted = 0;

        assertActual(actual, excepted);
    }

    @Test
    @DisplayName("계산기 입력값에 숫자하나만 입력이 될 경우")
    void calculator_only_one_number() {
        actual = calculator.splitAndSum("1");

        excepted = 1;

        assertActual(actual, excepted);
    }

    @DisplayName("계산기 입력값은 쉼표 구분자로 나뉘고 더해진다")
    @ParameterizedTest(name = "계산기 입력값은 쉼표 구분자로 나뉘고 더해진다 : [{index}] : [{arguments}]")
    @ValueSource(strings = {
            "1,2",
            "2,1"
    })
    void calculator_comma_separator_sum(String input) {
        actual = calculator.splitAndSum(input);

        excepted = 3;

        assertActual(actual, excepted);
    }

    @DisplayName("계산기 입력값은 콤마 또는 콜론으로 구분된다.")
    @ParameterizedTest(name = "계산기 입력값은 콤마 또는 콜론으로 구분된다.: [{index}] : [{arguments}]")
    @ValueSource(strings = {
            "1,2:3",
            "1:2,3"
    })
    void calculator_comma_or_colon_separator_sum(String input) {
        actual = calculator.splitAndSum(input);

        excepted = 6;

        assertActual(actual, excepted);
    }

    @DisplayName("계산기 입력 값에 커스텀 구분자로 덧셈한다")
    @ParameterizedTest(name = "계산기 입력 값에 커스텀 구분자로 덧셈한다 : [{index}] : [{arguments}]")
    @ValueSource(strings = {
            "//;\n1;2;3",
            "//-\n1-2-3",
            "//#\n1#2#3"
    })
    void calculator_custom_separator_insert_is_sum(String input) {
        actual = calculator.splitAndSum(input);

        excepted = 6;

        assertActual(actual, excepted);
    }

    @ParameterizedTest(name = "음수가 입력되면 예외가 발생한다.")
    @DisplayName("음수가 입력되면 예외가 발생한다.")
    @ValueSource(strings = {
            "-1,2,3",
            "3,-4,5",
            "6,7,-8"
    })
    void throw_exception_native_number_insert() {
        assertThatThrownBy(() -> calculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수가 발생하면 안됩니다");
    }

    private static void assertActual(int actual, int excepted) {
        assertThat(actual).isEqualTo(excepted);
    }
}

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
}

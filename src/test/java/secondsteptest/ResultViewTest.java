package secondsteptest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import secondstep.LottoNumberException;
import secondstep.ResultView;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultViewTest {
    ResultView resultView = new ResultView();

    @ParameterizedTest(name = "당첨번호 입력값을 숫자로 치환한다. :[{index}] : [{arguments}]")
    @DisplayName("당첨번호 입력값을 숫자로 치환한다.")
    @MethodSource
    void winner_number_input_value_replaced_a_number(String winnerNumber, int[] expected) {
        String[] winnerNumbers = winnerNumber.split(",");

        int[] actual = resultView.getLastWeekWinnerNumbers(winnerNumbers);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> winner_number_input_value_replaced_a_number() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", new int[]{1, 2, 3, 4, 5, 6}),
                Arguments.of("3,4,5,6,7,8", new int[]{3, 4, 5, 6, 7, 8})
        );
    }

    @Test
    @DisplayName("지난 주 당첨 번호가 6개를 넘어서면 예외가 발생한다")
    void throw_exception_list_week_winner_number_more_six() {
        assertThatThrownBy(() -> resultView.lastWeekWinnerNumberValidation(new String[5]))
                .isInstanceOf(LottoNumberException.class)
                .hasMessage("지난 주 당첨 번호는 6개 입니다.");
    }


}

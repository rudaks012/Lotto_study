package secondsteptest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import secondstep.LottoNumberException;
import secondstep.ResultView;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @ParameterizedTest(name = "보너스 번호는 1에서 45 사이의 숫자가 아니면 예외가 발생한다 :[{index}] : [{arguments}]")
    @DisplayName("보너스 번호는 1에서 45 사이의 숫자가 아니면 예외가 발생한다")
    @ValueSource(ints = {
            0, 46
    })
    void throw_exception_bonus_number_is_one_between_forty_five(int bonusNumbers) {
        ResultView resultView = new ResultView();
        assertThatThrownBy(() -> resultView.bonusLottoNumberValidation(bonusNumbers))
                .isInstanceOf(LottoNumberException.class)
                .hasMessage("입력값: " + bonusNumbers + " 번호는 1에서 45 사이의 숫자가 아닙니다");
    }
}

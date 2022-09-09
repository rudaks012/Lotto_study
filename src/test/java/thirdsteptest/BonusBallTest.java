package thirdsteptest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import thirdstep.BounsBall;

public class BonusBallTest {
    @ParameterizedTest(name = "보너스볼은 1에서 45 사이의 값이다.:[{index}] : [{arguments}]")
    @DisplayName("보너스볼은 1에서 45 사이의 값이다.")
    @ValueSource(ints = {
            0, 46
    })
    void throw_exception_bouns_ball_number_one_between_forty_five(int numbers) {
        Assertions.assertThatThrownBy(() -> new BounsBall(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스볼 넘버는 1과 45사이 입니다");
    }
}

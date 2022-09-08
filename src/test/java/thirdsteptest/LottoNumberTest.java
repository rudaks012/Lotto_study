package thirdsteptest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import thirdstep.LottoNumber;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @ParameterizedTest(name = "로또 넘버는 1과 45사이가 아니면 예외가 발생한다 : [{index}] : [{arguments}]")
    @DisplayName("로또 넘버는 1과 45사이가 아니면 예외가 발생한다")
    @ValueSource(ints = {
            0, 46
    })
    void throws_exception_lotto_number_one_between_forty_five(int numbers) {
        assertThatThrownBy(()->new LottoNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 넘버는 1과 45사이 입니다");
    }
}

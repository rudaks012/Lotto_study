package thirdsteptest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import thirdstep.Lotto;
import thirdstep.LottoNumber;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    @DisplayName("로또 번호가 포함되었는지 확인")
    void lotto_number_match() {
        Lotto lotto = getLotto();

        boolean actual = lotto.isContains(new LottoNumber(1));

        assertThat(actual).isTrue();
    }

    private static Lotto getLotto() {
        return getLotto(1, 2, 3, 4, 5, 6);
    }

    private static Lotto getLotto(int... numbers) {
        return new Lotto(Set.of(
                new LottoNumber(numbers[0]),
                new LottoNumber(numbers[1]),
                new LottoNumber(numbers[2]),
                new LottoNumber(numbers[3]),
                new LottoNumber(numbers[4]),
                new LottoNumber(numbers[5])
        ));
    }
}

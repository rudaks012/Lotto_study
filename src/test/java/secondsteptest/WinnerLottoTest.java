package secondsteptest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import secondstep.WinnerLotto;

import java.util.Arrays;
import java.util.List;

public class WinnerLottoTest {

    @Test
    @DisplayName("로또당첨 테스트")
    void lotto_winning() {
        WinnerLotto winnerLotto = new WinnerLotto();
        List<Integer> userLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int[] winnerLottoNumbers = {1, 2, 3, 4, 5, 6};
        int count = 0;
        int winningNumberCount = 6;

        int actual = winnerLotto.getCount(winnerLottoNumbers, userLottoNumber, count);

        Assertions.assertThat(actual).isEqualTo(winningNumberCount);
    }

//    @Test
//    @DisplayName("로또당첨 테스트2")
//    void lotto_winning2() {
//        WinnerLotto winnerLotto = new WinnerLotto();
//        LottoNumber userLottoNumber = new LottoNumber(Arrays.asList(1,2,3,4,5,6));
//        int[] winnerLottoNumbers = {1, 2, 3, 4, 5, 6};
//        int count = 0;
//        int winningNumberCount = 6;
//
//        int actual = winnerLotto.getCount2(winnerLottoNumbers, userLottoNumber, count);
//
//        Assertions.assertThat(actual).isEqualTo(winningNumberCount);
//    }
}

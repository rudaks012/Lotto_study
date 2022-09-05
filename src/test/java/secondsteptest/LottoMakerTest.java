package secondsteptest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import secondstep.LottoMaker;

import java.util.List;

public class LottoMakerTest {

    @Test
    @DisplayName("로또번호생성을 확인한다")
    void lotto_number_generation() {
        LottoMaker lottoMaker = new LottoMaker();
        List<List<Integer>> lotto = lottoMaker.lottoNumberGeneration(1);

        int actual = lotto.size();

        int excepted = 1;

        Assertions.assertThat(actual).isEqualTo(excepted);

    }

}

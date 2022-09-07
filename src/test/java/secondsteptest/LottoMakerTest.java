package secondsteptest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import secondstep.LottoMaker;

import java.util.ArrayList;
import java.util.Collections;
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

    @Test
    @DisplayName("로또 번호가 중복으로 안 만들어지는지 확인")
    void create_not_duplication_lotto_number() {
        List<Integer> actual = new ArrayList<>();
        List<Integer> excepted =new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            actual.add(i);
            excepted.add(i);
        }
        Collections.shuffle(actual);
        Assertions.assertThat(actual).isNotEqualTo(excepted);
    }
}

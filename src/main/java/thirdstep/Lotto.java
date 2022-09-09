package thirdstep;

import java.util.Set;

public class Lotto {

    public static final int LOTTO_TICKET_COUNT = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_TICKET_COUNT) {
            throw new IllegalArgumentException("로또의 수는 6자리가 넘지 않습니다");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

}

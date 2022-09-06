package secondstep;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 1_500_000),
    THIRD(5, false, 50_000),
    FOURTH(4, false, 1_000),
    NONE(0, false, 0);
    private final int matchCount;
    private final int reward;
    private final boolean bonusMatched;

    private static final List<Rank> cachedLottoRank;

    static {
        cachedLottoRank = Arrays.stream(values())
                .collect(Collectors.toList());
    }

    Rank(int matchCount, boolean bonusMatched, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.bonusMatched = bonusMatched;
    }

    public static Rank lottoRank(int matchCount, boolean bonusMatched) {
        Rank rank = getLottoRank(matchCount);
        return rank;
    }

    private static Rank getLottoRank(int matchCount) {
        return cachedLottoRank.stream()
                .filter(rank -> rank.isMatched(matchCount))
                .findFirst()
                .orElse(NONE);
    }

    private boolean isMatched(int matchCount) {
        return this.matchCount == matchCount;
    }
}

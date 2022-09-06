package secondstep;

public enum Rank {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 1_500_000),
    THIRD(5, false, 50_000),
    FOURTH(4, false, 1_000),
    NONE(0, false, 0);
    private final int matchCount;
    private final int reward;
    private final boolean bonusMatched;

    Rank(int matchCount, boolean bonusMatched, int reward ) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.bonusMatched = bonusMatched;
    }
}

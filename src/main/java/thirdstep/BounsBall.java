package thirdstep;

import java.util.Objects;

public class BounsBall {

    private final int bonusBallNumber;
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    public BounsBall(int bonusBallNumber) {
        if (bonusBallNumber < MIN_NUMBER || bonusBallNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("보너스볼 넘버는 1과 45사이 입니다");
        }
        this.bonusBallNumber = bonusBallNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BounsBall bounsBall = (BounsBall) o;
        return bonusBallNumber == bounsBall.bonusBallNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusBallNumber);
    }
}
